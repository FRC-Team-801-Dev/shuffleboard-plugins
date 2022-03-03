package edu.horsepower801.plugins.hardware;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.horsepower801.plugins.hardware.data.types.SparkMaxType;
import edu.horsepower801.plugins.hardware.widgets.SparkMaxWidget;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

@Description(group = "Horsepower 801", name = "HardwareInterfacePlugin", summary = "A plugin for interacting with motor controllers", version = "1.0.0")
public class HardwarePlugin extends Plugin {
	@Override
	@SuppressWarnings("all")
	public List<ComponentType> getComponents() {
		return ImmutableList.of(WidgetType.forAnnotatedWidget(SparkMaxWidget.class));
	}

	@Override
	@SuppressWarnings("all")
	public List<DataType> getDataTypes() {
		return ImmutableList.of(
			SparkMaxType.Instance
		);
	}

	@Override
	@SuppressWarnings("all")
	public Map<DataType, ComponentType> getDefaultComponents() {
		return ImmutableMap.<DataType, ComponentType>builder()
		.put(SparkMaxType.Instance, WidgetType.forAnnotatedWidget(SparkMaxWidget.class))
		.build();
	}
}
