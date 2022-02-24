package com.shuffleboard.plugins;

import java.util.List;
import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;



    public class FieldWidget extends Plugin {

        @Override
        public List<DataType> getDataTypes() {
           return List.of(AdvancedFieldPlugin.Instance);
        }
     
     }


