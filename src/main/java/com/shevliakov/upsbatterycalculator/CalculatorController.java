package com.shevliakov.upsbatterycalculator;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController {

  public MFXTextField ConsumedPowerTextField;
  public MFXTextField WorkingTimeTextField;
  public MFXTextField BatteryVoltageTexField;
  public MFXTextField InverterEfficiencyTextField;
  public MFXButton CalculateButton;
  public MFXButton HistoryButton;
  public MFXButton ProfileButton1;
  public Label ResultLabel;
  public MFXTableView BatteriesTableView;

  public void onCalculateButtonClicked(ActionEvent actionEvent) {
  }

  public void onHistoryButtonClicked(ActionEvent actionEvent) {
  }

  public void onProfileButtonClicked(ActionEvent actionEvent) {
  }
}
