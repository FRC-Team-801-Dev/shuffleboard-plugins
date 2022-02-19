package com.shuffleboard.plugins;

import java.util.Map;
import java.util.function.Function;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.data.ComplexDataType;

@Description(group = "com.shuffleboard.plugins", name = "AdvancedFieldPlugin", version = "1.0.0", summary = "Adds a more functional Field widget.")

    public final class AdvancedFieldPlugin extends ComplexDataType<FieldPlugin> {

        private static final String NAME = "FieldPlugin";
        public static final AdvancedFieldPlugin Instance = new AdvancedFieldPlugin();
     
        private AdvancedFieldPlugin() {
           super(NAME, FieldPlugin.class);
        }
     
        @Override
        public Function<Map<String, Object>, FieldPlugin> fromMap() {
           return map -> {
              return new FieldPlugin((double) map.getOrDefault("x", 0.0), (double) map.getOrDefault("y", 0.0), (double) map.getOrDefault("rotation", 0.0));
           };
        }
     
        @Override
        public FieldPlugin getDefaultValue() {
           // use default values of 0 for X and Y coordinates
           return new FieldPlugin(0.0, 0.0, 0.0);
        }
     
     }
