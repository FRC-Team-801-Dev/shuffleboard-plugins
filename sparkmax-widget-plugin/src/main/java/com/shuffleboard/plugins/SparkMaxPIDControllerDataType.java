package com.shuffleboard.plugins;

import java.util.Map;
import java.util.function.Function;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;

public class SparkMaxPIDControllerDataType extends ComplexDataType<SparkMaxPIDController> {

    private static final String NAME = "SparkMaxPIDController";
    public static final SparkMaxPIDControllerDataType Instance = new SparkMaxPIDControllerDataType();

    private SparkMaxPIDControllerDataType() {
        super(NAME, SparkMaxPIDController.class);
    }

    @Override
    public Function<Map<String, Object>, SparkMaxPIDController> fromMap() {
        return map -> {
            return new SparkMaxPIDController((double) map.getOrDefault("p", 0.0005), (double) map.getOrDefault("i", 0.0), 
            (double) map.getOrDefault("d", 0.0), (double) map.getOrDefault("ff", 0.0), (double) map.getOrDefault("iz", 0.0),
            (double) map.getOrDefault("output_max", 1.0), (double) map.getOrDefault("output_min", -1.0));
        };
    }

    @Override
    public SparkMaxPIDController getDefaultValue() {
        return new SparkMaxPIDController(0.0005, 0.0, 0.0, 0.0, 0.0, 1.0, -1.0);
    }
}