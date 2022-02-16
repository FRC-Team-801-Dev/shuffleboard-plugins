package com.shuffleboard.plugins;

import java.util.Map;
import java.util.function.Function;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;

public class SparkMaxPIDControllerDataType extends ComplexDataType<NetworkSparkMaxPIDController> {

    private static final String NAME = "NetworkSparkMaxPIDController";
    public static final SparkMaxPIDControllerDataType Instance = new SparkMaxPIDControllerDataType();

    private SparkMaxPIDControllerDataType() {
        super(NAME, NetworkSparkMaxPIDController.class);
    }

    @Override
    public Function<Map<String, Object>, NetworkSparkMaxPIDController> fromMap() {
        return map -> {
            return new NetworkSparkMaxPIDController((double) map.getOrDefault("p", 0.0005), (double) map.getOrDefault("i", 0.0), 
            (double) map.getOrDefault("d", 0.0), (double) map.getOrDefault("ff", 0.0), (double) map.getOrDefault("iz", 0.0),
            (double) map.getOrDefault("output_max", 1.0), (double) map.getOrDefault("output_min", -1.0));
        };
    }

    @Override
    public NetworkSparkMaxPIDController getDefaultValue() {
        return new NetworkSparkMaxPIDController(0.0005, 0.0, 0.0, 0.0, 0.0, 1.0, -1.0);
    }
}