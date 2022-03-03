package edu.horsepower801.plugins.hardware.data.types;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import edu.horsepower801.plugins.hardware.data.SparkMaxData;

import java.util.Map;
import java.util.function.Function;

public final class SparkMaxType extends ComplexDataType<SparkMaxData> {

  public static final SparkMaxType Instance = new SparkMaxType();

  private SparkMaxType() {
    super("SparkMax", SparkMaxData.class);
  }

  @Override
  public Function<Map<String, Object>, SparkMaxData> fromMap() {
    return SparkMaxData::new;
  }

  @Override
  public SparkMaxData getDefaultValue() {
    return new SparkMaxData(false, false,
      0.0, 0.0, 0.0, 0.0, 0.0,
      0.0, 0.0, 0.0, 0.0, 0.0,
      0.0, 0.0, 0.0, 0.0, 0.0,
      0.0, 0.0, 0.0, 0.0, 0.0);
  }

}