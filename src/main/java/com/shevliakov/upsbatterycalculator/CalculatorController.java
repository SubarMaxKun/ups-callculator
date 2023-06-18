package com.shevliakov.upsbatterycalculator;

import com.shevliakov.upsbatterycalculator.entity.User;
import com.shevliakov.upsbatterycalculator.logic.CalculateCapacity;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class CalculatorController {

  public MFXTextField ConsumedPowerTextField;
  public MFXTextField WorkingTimeTextField;
  public MFXTextField BatteryVoltageTexField;
  public MFXTextField InverterEfficiencyTextField;
  public MFXButton CalculateButton;
  public MFXButton HistoryButton;
  public MFXButton ProfileButton;
  public Label ResultLabel;
  public MFXTableView BatteriesTableView;
  public Label ErrorLabel;
  User user = new User();
  private int Result;

  public void onCalculateButtonClicked(ActionEvent actionEvent) {
    ErrorLabel.setVisible(false);
    CalculateCapacity calculateCapacity = new CalculateCapacity();
    try {
      Result = calculateCapacity.calculate(Integer.parseInt(ConsumedPowerTextField.getText()),
          Integer.parseInt(WorkingTimeTextField.getText()),
          Integer.parseInt(BatteryVoltageTexField.getText()),
          Float.parseFloat(InverterEfficiencyTextField.getText()));
      ResultLabel.setText(Result + " Ah");
    } catch (NumberFormatException e) {
      ErrorLabel.setVisible(true);
    }
  }

  public void onHistoryButtonClicked(ActionEvent actionEvent) {
  }

  public void onProfileButtonClicked(ActionEvent actionEvent) {
  }

  public void setUser(User user) {
    this.user = user;
  }
}
