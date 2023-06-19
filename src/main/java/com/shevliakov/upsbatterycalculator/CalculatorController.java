package com.shevliakov.upsbatterycalculator;

import com.shevliakov.upsbatterycalculator.dao.impl.UserDaoImpl;
import com.shevliakov.upsbatterycalculator.entity.User;
import com.shevliakov.upsbatterycalculator.logic.CalculateCapacity;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
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
  public MFXListView BatteryListView;
  public Label ErrorLabel;
  User user = new User();
  private int result;

  public void onCalculateButtonClicked(ActionEvent actionEvent) {
    ErrorLabel.setVisible(false);
    try {
      calculateCapacity();
      try {
        loadBatteries();
      } catch (Exception e) {
        System.out.println(e.getMessage());
        ErrorLabel.setText("Can't load batteries");
        ErrorLabel.setVisible(true);
      }
    } catch (NumberFormatException e) {
      ErrorLabel.setVisible(true);
    }
  }

  public void onHistoryButtonClicked(ActionEvent actionEvent) {
  }

  public void onProfileButtonClicked(ActionEvent actionEvent) {
  }

  private void loadBatteries() {
    BatteryListView.setVisible(true);
    BatteryListView.setItems(FXCollections.observableArrayList(new UserDaoImpl().getAllUsers()));
  }

  private void calculateCapacity() {
    CalculateCapacity calculateCapacity = new CalculateCapacity();
    result = calculateCapacity.calculate(Integer.parseInt(ConsumedPowerTextField.getText()),
        Integer.parseInt(WorkingTimeTextField.getText()),
        Integer.parseInt(BatteryVoltageTexField.getText()),
        Float.parseFloat(InverterEfficiencyTextField.getText()));
    ResultLabel.setText(result + " Ah");
  }

  public void setUser(String username, String password) {
    user.setUsername(username);
    user.setPassword(password);
    if (username.equals("guest")) {
      ProfileButton.setVisible(false);
      HistoryButton.setVisible(false);
    }
  }
}
