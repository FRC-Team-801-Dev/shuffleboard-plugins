package com.shuffleboard.plugins;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Slider;

@Description(name = "SparkMaxPIDController", dataTypes = SparkMaxPIDController.class)
@ParametrizedController("SparkMaxPIDControllerWidget.fxml")
public final class SparkMaxPIDControllerWidget extends SimpleAnnotatedWidget<SparkMaxPIDController> {

   @FXML
   private StackPane root;

   @FXML
   private Slider pSlider;

   @FXML
   private Slider iSlider;

   @FXML
   private Slider dSlider;

   @FXML
   private Slider ffSlider;

   @FXML
   private Slider izSlider;

   @FXML
   private Slider outputmaxSlider;

   @FXML
   private Slider outputminSlider;

   @FXML
   private void initialize() {
      pSlider.valueProperty().bind(dataOrDefault.map(SparkMaxPIDController::getP));
      iSlider.valueProperty().bind(dataOrDefault.map(SparkMaxPIDController::getI));
      dSlider.valueProperty().bind(dataOrDefault.map(SparkMaxPIDController::getD));
      ffSlider.valueProperty().bind(dataOrDefault.map(SparkMaxPIDController::getFF));
      izSlider.valueProperty().bind(dataOrDefault.map(SparkMaxPIDController::getIZ));
      outputmaxSlider.valueProperty().bind(dataOrDefault.map(SparkMaxPIDController::getOutputMax));
      outputminSlider.valueProperty().bind(dataOrDefault.map(SparkMaxPIDController::getOutputMin));
   }

   @Override
   public Pane getView() {
      return root;
   }


}