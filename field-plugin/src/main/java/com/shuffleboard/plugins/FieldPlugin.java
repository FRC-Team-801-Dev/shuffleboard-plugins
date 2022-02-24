package com.shuffleboard.plugins;

import edu.wpi.first.shuffleboard.api.data.ComplexData;
import java.util.Map;


/**
 * A base plugin for demonstration purposes.
 * 
 * See https://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/custom-widgets/creating-plugins.html for more info.
 */



public final class FieldPlugin extends ComplexData<FieldPlugin> {

   private final double x;
   private final double y;
   private final double rotation;

   // Constructor should take all the different fields needed and assign them to their corresponding instance variables.
   public FieldPlugin(double x, double y, double rotation) {
      this.x = x;
      this.y = y;
      this.rotation = rotation;
   }

   @Override
   public Map<String, Object> asMap() {
      return Map.of("x", this.x, "y", this.y, "rotation", this.rotation);
   }
 }
