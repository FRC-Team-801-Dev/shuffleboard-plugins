package com.shuffleboard.plugins;

import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import java.util.List;
import java.util.ArrayList;


import edu.wpi.first.shuffleboard.api.data.DataType;

/**
 * A base plugin for demonstration purposes.
 * 
 * See https://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/custom-widgets/creating-plugins.html for more info.
 */
@Description(group = "com.shuffleboard.plugins", name = "SparkMaxWidgetPlugin", version = "1.0.0", 
    summary = "Creates widgets to be used with 2022 robot constants, including PID controllers.")
public class SparkMaxWidgetPlugin extends Plugin {
    // Use this as a template for how a plugin should be structured.
    public class MyPlugin extends Plugin {

        //@Override
        //public List<DataType> getDataTypes() {
        //   return List.of(SparkMaxPIDControllerDataType.Instance);
        //}

        public List<DataType> getDataTypes() {
            List<DataType> list = new ArrayList<DataType>();
            list.add(SparkMaxPIDControllerDataType.Instance);

            return list;
        }
     
     }
}
