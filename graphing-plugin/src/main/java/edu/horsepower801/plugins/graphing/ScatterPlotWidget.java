package edu.horsepower801.plugins.graphing;

import edu.wpi.first.shuffleboard.api.data.IncompatibleSourceException;
import edu.wpi.first.shuffleboard.api.data.types.NumberArrayType;
import edu.wpi.first.shuffleboard.api.widget.AbstractWidget;
import edu.wpi.first.shuffleboard.api.widget.AnnotatedWidget;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import edu.wpi.first.shuffleboard.api.prefs.Group;
import edu.wpi.first.shuffleboard.api.prefs.Setting;
import edu.wpi.first.shuffleboard.api.sources.DataSource;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Description(dataTypes = { NumberArrayType.class }, name = "Scatter Plot")
@ParametrizedController(value = "ScatterPlotWidget.fxml")
public class ScatterPlotWidget extends AbstractWidget implements AnnotatedWidget {

	@FXML
	private GridPane pane;

	@FXML
	private ScatterChart<Double, Double> chart;

	@FXML
	private NumberAxis xAxis;

	@FXML
	private NumberAxis yAxis;

	private final Map<DataSource<double[]>, Series<Double, Double>> seriesMap = new HashMap<>();

	private final Map<Series<Double, Double>, BooleanProperty> visibleSeries = new IdentityHashMap<>();

	private final Function<Series<Double, Double>, BooleanProperty> createVisibleProperty = s -> {
		SimpleBooleanProperty visible = new SimpleBooleanProperty(this, s.getName(), true);
		visible.addListener((__, was, is) -> {
			if (is) {
				if (!chart.getData().contains(s)) {
					chart.getData().add(s);
				}
			} else {
				chart.getData().remove(s);
			}
		});
		return visible;
	};

	private final ChangeListener<double[]> arrayChangeListener = (property, oldArray, newArray) -> {
		final DataSource<double[]> source = sourceFor(property);
		updateFromArraySource(source);
	};

	@FXML
	@SuppressWarnings("all")
	private void initialize() {
		chart.legendVisibleProperty().bind(Bindings.createBooleanBinding(() -> sources.size() > 1, sources));
		sources.addListener((ListChangeListener<DataSource>) c -> {
			while (c.next()) {
				if (c.wasAdded()) {
					c.getAddedSubList().forEach(source -> {
						if (source.getDataType() == NumberArrayType.Instance) {
							source.dataProperty().addListener(arrayChangeListener);
							if (source.isConnected()) {
								arrayChangeListener.changed(source.dataProperty(), null, (double[]) source.getData());
							}
						} else {
							throw new IncompatibleSourceException(getDataTypes(), source.getDataType());
						}
					});
				} else if (c.wasRemoved()) {
					c.getRemoved().forEach(source -> {
						source.dataProperty().removeListener(arrayChangeListener);
					});
				}
			}
		});
	}

	@SuppressWarnings("all")
	private <T> DataSource<T> sourceFor(ObservableValue<? extends T> property) {
		if (property instanceof Property) {
			Object bean = ((Property) property).getBean();
			if (bean instanceof DataSource) {
				return (DataSource<T>) bean;
			}
		}

		return sources.stream()
				.filter(source -> source.dataProperty() == property)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No source for " + property));
	}

	private void updateFromArraySource(DataSource<double[]> source) {
		final double[] data = source.getData();
		final Series<Double, Double> series = getSeries(source);

		updateSeries(series, data);
	}

	private void updateSeries(Series<Double, Double> series, double[] data) {
		boolean dataVisible = Optional.ofNullable(visibleSeries.get(series)).map(Property::getValue).orElseThrow();
		
		if (dataVisible) {
			series.getData().clear();
			for (int i = 0; i + 1 < data.length; i += 2) {
				series.getData().add(new XYChart.Data<Double, Double>(data[i], data[i + 1]));
			}
		}

		if (!chart.getData().contains(series) && dataVisible) {
			chart.getData().add(series);
		}

		if (chart.getData().contains(series) && !dataVisible) {
			chart.getData().remove(series);
		}
	}

	private Series<Double, Double> getSeries(DataSource<double[]> source) {
		if (!seriesMap.containsKey(source)) {
			Series<Double, Double> series = new Series<Double, Double>();
			series.setName(source.getName());
			seriesMap.put(source, series);
			visibleSeries.computeIfAbsent(series, createVisibleProperty);
		}
		return seriesMap.get(source);
	}

	@Override
	public Pane getView() {
		return pane;
	}

	@Override
	@SuppressWarnings("all")
	public void addSource(DataSource source) throws IncompatibleSourceException {
		if (sources.contains(source)) {
			return;
		}
		super.addSource(source);
	}

	@Override
	public java.util.List<edu.wpi.first.shuffleboard.api.prefs.Group> getSettings() {

		LinkedList<Group> propertyList = new LinkedList<Group>();

		propertyList.add(Group.of("Chart", Setting.of("Title", chart.titleProperty(), String.class)));
		
		propertyList.add(Group.of("X-Axis"
		, Setting.of("Label", xAxis.labelProperty(), String.class)
		, Setting.of("Visible", xAxis.visibleProperty(), Boolean.class)
		, Setting.of("Auto Range", xAxis.autoRangingProperty(), Boolean.class)
		, Setting.of("Min Value", xAxis.lowerBoundProperty(), Double.class)
		, Setting.of("Max Value", xAxis.upperBoundProperty(), Double.class)
		));	

		propertyList.add(Group.of("Y-Axis"
		, Setting.of("Label", yAxis.labelProperty(), String.class)
		, Setting.of("Visible", yAxis.visibleProperty(), Boolean.class)
		, Setting.of("Auto Range", yAxis.autoRangingProperty(), Boolean.class)
		, Setting.of("Min Value", yAxis.lowerBoundProperty(), Double.class)
		, Setting.of("Max Value", yAxis.upperBoundProperty(), Double.class)
		));
		
		return propertyList;
	}
}
