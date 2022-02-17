package com.shuffleboard.plugins;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import java.util.HashMap;
import java.util.Map;

public class SparkMaxPIDController extends ComplexData<SparkMaxPIDController>{
    private final double p;
    private final double i;
    private final double d;
    private final double ff;
    private final double iz;
    private final double output_max;
    private final double output_min;

    // Constructor should take all the different fields needed and assign them to their corresponding instance variables.
    public SparkMaxPIDController(double p, double i, double d, double ff, double iz, double output_max, double output_min) {
        this.p = p;
        this.i = i;
        this.d = d;
        this.ff = ff;
        this.iz = iz;
        this.output_max = output_max;
        this.output_min = output_min;
    }

    public double getP() {
        return this.p;
    }

    public double getI() {
        return this.i;
    }

    public double getD() {
        return this.d;
    }

    public double getFF() {
        return this.ff;
    }

    public double getIZ() {
        return this.iz;
    }

    public double getOutputMax() {
        return this.output_max;
    }

    public double getOutputMin() {
        return this.output_min;
    }

    @Override
    public Map<String, Object> asMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("p", this.p);
        map.put("i", this.i);
        map.put("d", this.d);
        map.put("ff", this.ff);
        map.put("iz", this.iz);
        map.put("output_max", this.output_max);
        map.put("output_min", this.output_min);
        return map;
    }
}
