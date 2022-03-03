package edu.horsepower801.plugins.hardware.widgets;

import edu.horsepower801.plugins.hardware.data.SparkMaxData;
import edu.wpi.first.shuffleboard.api.components.IntegerField;
import edu.wpi.first.shuffleboard.api.components.NumberField;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;

import org.controlsfx.control.ToggleSwitch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * A widget for controlling SparkMax controllers. This gives control over the PID constants and other
 * parameters on the SparkMax.
 * 
 */
@Description(name = "SparkMax", dataTypes = SparkMaxData.class)
@ParametrizedController("SparkMaxWidget.fxml")
public class SparkMaxWidget extends SimpleAnnotatedWidget<SparkMaxData> {

  @FXML
  private Pane root;

  @FXML
  private ToggleSwitch invertedToggle;
  @FXML
  private ToggleSwitch brakeToggle;
  @FXML
  private IntegerField slotField;
  @FXML
  private NumberField pField;
  @FXML
  private NumberField iField;
  @FXML
  private NumberField dField;
  @FXML
  private NumberField ffField;
  @FXML
  private NumberField izField;

  private boolean togglingFromDataChange = true;

  @FXML
  private void initialize() {
    root.setStyle("-fx-font-size: 10pt;");
    dataProperty().addListener((__, old, newData) -> {
      togglingFromDataChange = true;
      invertedToggle.setSelected(newData.isInverted());
      brakeToggle.setSelected(newData.isBrake());
      togglingFromDataChange = false;
      pField.setNumber(newData.getP(slotField.getNumber()));
      iField.setNumber(newData.getI(slotField.getNumber()));
      dField.setNumber(newData.getD(slotField.getNumber()));
      ffField.setNumber(newData.getFF(slotField.getNumber()));
      izField.setNumber(newData.getIZ(slotField.getNumber()));
    });

    actOnFocusLost(pField);
    actOnFocusLost(iField);
    actOnFocusLost(dField);
    actOnFocusLost(ffField);
    actOnFocusLost(izField);

    invertedToggle.selectedProperty().addListener((__, prev, cur) -> {
      if (!togglingFromDataChange) {
        SparkMaxData data = getData();
        setData(data.withInverted(!data.isInverted()));
      }
    });

    brakeToggle.selectedProperty().addListener((__, prev, cur) -> {
      if (!togglingFromDataChange) {
        SparkMaxData data = getData();
        setData(data.withBrake(!data.isBrake()));
      }
    });

    slotField.numberProperty().addListener((__, prev, cur) -> {
      pField.setNumber(getData().getP(cur));
      iField.setNumber(getData().getI(cur));
      dField.setNumber(getData().getD(cur));
      ffField.setNumber(getData().getFF(cur));
      izField.setNumber(getData().getIZ(cur));
    });
  }

  private void actOnFocusLost(TextField field) {
    field.focusedProperty().addListener((__, was, is) -> {
      if (!is) {
        field.getOnAction().handle(new ActionEvent(this, field));
      }
    });
  }

  @Override
  public Pane getView() {
    return root;
  }

  @FXML
  private void setP() {
    setData(getData().withP(pField.getNumber(), slotField.getNumber()));
  }

  @FXML
  private void setI() {
    setData(getData().withI(iField.getNumber(), slotField.getNumber()));
  }

  @FXML
  private void setD() {
    setData(getData().withD(dField.getNumber(), slotField.getNumber()));
  }

  @FXML
  private void setFF() {
    setData(getData().withFF(ffField.getNumber(), slotField.getNumber()));
  }

  @FXML
  private void setIZ() {
    setData(getData().withIZ(izField.getNumber(), slotField.getNumber()));
  }

}