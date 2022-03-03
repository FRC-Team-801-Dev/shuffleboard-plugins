package edu.horsepower801.plugins.hardware.data;

import com.google.common.collect.ImmutableMap;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import java.util.Map;
import java.util.Objects;

public final class SparkMaxData extends ComplexData<SparkMaxData> {

  private final boolean inverted;
  private final boolean brake;

  private final double p_0;
  private final double i_0;
  private final double d_0;
  private final double ff_0;
  private final double iz_0;

  private final double p_1;
  private final double i_1;
  private final double d_1;
  private final double ff_1;
  private final double iz_1;

  private final double p_2;
  private final double i_2;
  private final double d_2;
  private final double ff_2;
  private final double iz_2;

  private final double p_3;
  private final double i_3;
  private final double d_3;
  private final double ff_3;
  private final double iz_3;

  /**
   * Creates a new SparkMax data object.
   *
   * @param p        the proportional constant
   * @param i        the integral constant
   * @param d        the derivative constant
   * @param ff       the feedforward constant
   * @param setpoint the controller setpoint
   * @param enabled  whether or not the controller is enabled
   */
  public SparkMaxData(boolean inverted, boolean brake, double p_0, double i_0, double d_0, double ff_0, double iz_0,
      double p_1, double i_1, double d_1, double ff_1, double iz_1, double p_2, double i_2, double d_2, double ff_2,
      double iz_2, double p_3, double i_3, double d_3, double ff_3, double iz_3) {
    this.inverted = inverted;
    this.brake = brake;

    this.p_0 = p_0;
    this.i_0 = i_0;
    this.d_0 = d_0;
    this.ff_0 = ff_0;
    this.iz_0 = iz_0;

    this.p_1 = p_1;
    this.i_1 = i_1;
    this.d_1 = d_1;
    this.ff_1 = ff_1;
    this.iz_1 = iz_1;

    this.p_2 = p_2;
    this.i_2 = i_2;
    this.d_2 = d_2;
    this.ff_2 = ff_2;
    this.iz_2 = iz_2;

    this.p_3 = p_3;
    this.i_3 = i_3;
    this.d_3 = d_3;
    this.ff_3 = ff_3;
    this.iz_3 = iz_3;
  }

  /**
   * Creates a new data object from a map. The map should contain values for all the properties of the data object. If
   * a value is missing, the default value of {@code 0} (for numbers) or {@code false} (for booleans) is used.
   */
  public SparkMaxData(Map<String, Object> map) {
    this(
        (boolean) map.getOrDefault("inverted", false),
        (boolean) map.getOrDefault("brake", false),
        (double) map.getOrDefault("p_0", 0.0),
        (double) map.getOrDefault("i_0", 0.0),
        (double) map.getOrDefault("d_0", 0.0),
        (double) map.getOrDefault("ff_0", 0.0),
        (double) map.getOrDefault("iz_0", 0.0),
        (double) map.getOrDefault("p_1", 0.0),
        (double) map.getOrDefault("i_1", 0.0),
        (double) map.getOrDefault("d_1", 0.0),
        (double) map.getOrDefault("ff_1", 0.0),
        (double) map.getOrDefault("iz_1", 0.0),
        (double) map.getOrDefault("p_2", 0.0),
        (double) map.getOrDefault("i_2", 0.0),
        (double) map.getOrDefault("d_2", 0.0),
        (double) map.getOrDefault("ff_2", 0.0),
        (double) map.getOrDefault("iz_2", 0.0),
        (double) map.getOrDefault("p_3", 0.0),
        (double) map.getOrDefault("i_3", 0.0),
        (double) map.getOrDefault("d_3", 0.0),
        (double) map.getOrDefault("ff_3", 0.0),
        (double) map.getOrDefault("iz_3", 0.0));
  }

  public boolean isInverted() {
    return inverted;
  }

  public boolean isBrake() {
    return brake;
  }

  public double getP(int slot) {
    switch (slot) {
      case 0:
        return p_0;
      case 1:
        return p_1;
      case 2:
        return p_2;
      case 3:
        return p_3;
      default:
        return p_0;
    }
  }

  public double getI(int slot) {
    switch (slot) {
      case 0:
        return i_0;
      case 1:
        return i_1;
      case 2:
        return i_2;
      case 3:
        return i_3;
      default:
        return i_0;
    }
  }

  public double getD(int slot) {
    switch (slot) {
      case 0:
        return d_0;
      case 1:
        return d_1;
      case 2:
        return d_2;
      case 3:
        return d_3;
      default:
        return d_0;
    }
  }

  public double getFF(int slot) {
    switch (slot) {
      case 0:
        return ff_0;
      case 1:
        return ff_1;
      case 2:
        return ff_2;
      case 3:
        return ff_3;
      default:
        return ff_0;
    }
  }

  public double getIZ(int slot) {
    switch (slot) {
      case 0:
        return iz_0;
      case 1:
        return iz_1;
      case 2:
        return iz_2;
      case 3:
        return iz_3;
      default:
        return iz_0;
    }
  }

  @Override
  public Map<String, Object> asMap() {
    return ImmutableMap.<String, Object>builder()
        .put("inverted", inverted)
        .put("brake", brake)
        .put("p_0", p_0)
        .put("i_0", i_0)
        .put("d_0", d_0)
        .put("ff_0", ff_0)
        .put("iz_0", iz_0)
        .put("p_1", p_1)
        .put("i_1", i_1)
        .put("d_1", d_1)
        .put("ff_1", ff_1)
        .put("iz_1", iz_1)
        .put("p_2", p_2)
        .put("i_2", i_2)
        .put("d_2", d_2)
        .put("ff_2", ff_2)
        .put("iz_2", iz_2)
        .put("p_3", p_3)
        .put("i_3", i_3)
        .put("d_3", d_3)
        .put("ff_3", ff_3)
        .put("iz_3", iz_3)
        .build();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SparkMaxData that = (SparkMaxData) obj;
    return this.inverted == that.inverted
        && this.brake == that.brake
        && this.p_0 == that.p_0
        && this.i_0 == that.i_0
        && this.d_0 == that.d_0
        && this.ff_0 == that.ff_0
        && this.iz_0 == that.iz_0
        && this.p_1 == that.p_1
        && this.i_1 == that.i_1
        && this.d_1 == that.d_1
        && this.ff_1 == that.ff_1
        && this.iz_1 == that.iz_1
        && this.p_2 == that.p_2
        && this.i_2 == that.i_2
        && this.d_2 == that.d_2
        && this.ff_2 == that.ff_2
        && this.iz_2 == that.iz_2
        && this.p_3 == that.p_3
        && this.i_3 == that.i_3
        && this.d_3 == that.d_3
        && this.ff_3 == that.ff_3
        && this.iz_3 == that.iz_3;
  }

  @Override
  public int hashCode() {
    return Objects.hash(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
  }

  @Override
  public String toString() {
    return String.format("SparkMaxData(inverted=%s, brake=%s, p=%s, i=%s, d=%s, ff=%s, iz=%s)",
        inverted, brake, p_0, i_0, d_0, ff_0, iz_0);
  }

  @Override
  public String toHumanReadableString() {
    return String.format("inverted=%s, brake=%s, p_0=%.3f, i_0=%.3f, d_0=%.3f, ff_0=%.3f, iz_0=%.3f", inverted, brake, p_0, i_0, d_0, ff_0, iz_0);
  }

  public SparkMaxData withInverted(boolean inverted) {
    return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
  }

  public SparkMaxData withBrake(boolean brake) {
    return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
  }

  public SparkMaxData withP(double p, int slot) {
    switch (slot) {
      case 0:
        return new SparkMaxData(inverted, brake, p, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 1:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 2:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 3:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p, i_3, d_3, ff_3, iz_3);
      default:
        return new SparkMaxData(inverted, brake, p, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
    }
  }

  public SparkMaxData withI(double i, int slot) {
    switch (slot) {
      case 0:
        return new SparkMaxData(inverted, brake, p_0, i, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 1:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_0, i, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 2:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 3:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i, d_3, ff_3, iz_3);
      default:
        return new SparkMaxData(inverted, brake, p_0, i, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
    }
  }

  public SparkMaxData withD(double d, int slot) {
    switch (slot) {
      case 0:
        return new SparkMaxData(inverted, brake, p_0, i_0, d, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 1:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_0, i_1, d, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 2:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 3:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d, ff_3, iz_3);
      default:
        return new SparkMaxData(inverted, brake, p_0, i_0, d, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
    }
  }

  public SparkMaxData withFF(double ff, int slot) {
    switch (slot) {
      case 0:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 1:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_0, i_1, d_1, ff, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 2:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 3:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff, iz_3);
      default:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
    }
  }

  public SparkMaxData withIZ(double iz, int slot) {
    switch (slot) {
      case 0:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 1:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_0, i_1, d_1, ff_1, iz, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
      case 2:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz, p_3, i_3, d_3, ff_3, iz_3);
      case 3:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz_0, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz);
      default:
        return new SparkMaxData(inverted, brake, p_0, i_0, d_0, ff_0, iz, p_1, i_1, d_1, ff_1, iz_1, p_2, i_2, d_2, ff_2, iz_2, p_3, i_3, d_3, ff_3, iz_3);
    }
  }
}