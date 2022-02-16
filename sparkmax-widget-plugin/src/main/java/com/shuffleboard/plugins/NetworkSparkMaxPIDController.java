package com.shuffleboard.plugins;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import java.util.HashMap;
import java.util.Map;

public class NetworkSparkMaxPIDController extends ComplexData<NetworkSparkMaxPIDController>{
    private final Double p;
    private final Double i;
    private final Double d;
    private final Double ff;
    private final Double iz;
    private final Double output_max;
    private final Double output_min;

    // Constructor should take all the different fields needed and assign them to their corresponding instance variables.
    public NetworkSparkMaxPIDController(double p, double i, double d, double ff, double iz, double output_max, double output_min) {
        this.p = p;
        this.i = i;
        this.d = d;
        this.ff = ff;
        this.iz = iz;
        this.output_max = output_max;
        this.output_min = output_min;
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
