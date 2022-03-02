package edu.horsepower801.plugins.graphing;

import java.util.List;

import com.google.common.collect.ImmutableList;

import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

@Description(group = "Horsepower 801", name = "GraphingPlugin", summary = "A plugin for adding various plotting capabilities to the RoboRio.", version = "1.0.0")
public class GraphingPlugin extends Plugin {
	@Override
	@SuppressWarnings("all")
	public List<ComponentType> getComponents() {

		return ImmutableList.of(
			WidgetType.forAnnotatedWidget(ScatterPlotWidget.class)
		);
	}
}
