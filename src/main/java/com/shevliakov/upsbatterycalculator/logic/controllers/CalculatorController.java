/* (C)2023 */
package com.shevliakov.upsbatterycalculator.logic.controllers;

import com.shevliakov.upsbatterycalculator.HistoryStage;
import com.shevliakov.upsbatterycalculator.Main;
import com.shevliakov.upsbatterycalculator.ProfileStage;
import com.shevliakov.upsbatterycalculator.dao.impl.BatteryDaoImpl;
import com.shevliakov.upsbatterycalculator.dao.impl.HistoryDaoImpl;
import com.shevliakov.upsbatterycalculator.dao.impl.UserDaoImpl;
import com.shevliakov.upsbatterycalculator.entity.History;
import com.shevliakov.upsbatterycalculator.entity.User;
import com.shevliakov.upsbatterycalculator.logic.CalculateCapacity;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/** Controller for CalculatorStage */
public class CalculatorController {

    public MFXTextField ConsumedPowerTextField;
    public MFXTextField WorkingTimeTextField;
    public MFXTextField BatteryVoltageTexField;
    public MFXTextField InverterEfficiencyTextField;
    public MFXButton CalculateButton;
    public MFXButton HistoryButton;
    public MFXButton ProfileButton;
    public MFXButton LogOutButton;
    public Label ResultLabel;
    public MFXListView BatteryListView;
    public Label ErrorLabel;
    private String username;
    private int result;

    /**
     * Method to calculate capacity and load batteries
     *
     * @param actionEvent event
     */
    public void onCalculateButtonClicked(ActionEvent actionEvent) {
        ErrorLabel.setVisible(false);
        try {
            calculateCapacity();
            try {
                loadBatteries(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                ErrorLabel.setText("Can't load batteries");
                ErrorLabel.setVisible(true);
            }
        } catch (NumberFormatException e) {
            ErrorLabel.setText("Entered data is not valid");
            ErrorLabel.setVisible(true);
        }
    }

    /**
     * Method to open history stage
     *
     * @param actionEvent event
     * @throws IOException exception
     */
    public void onHistoryButtonClicked(ActionEvent actionEvent) throws IOException {
        HistoryStage historyStage = new HistoryStage();
        historyStage.open(username);
    }

    /**
     * Method to open profile stage
     *
     * @param actionEvent event
     * @throws IOException exception
     */
    public void onProfileButtonClicked(ActionEvent actionEvent) throws IOException {
        ProfileStage profileStage = new ProfileStage();
        profileStage.open(username);
    }

    /**
     * Method to log out
     *
     * @param actionEvent event
     * @throws IOException exception
     */
    public void onLogOutButtonClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) LogOutButton.getScene().getWindow();
        stage.close();
        Main main = new Main();
        main.start(new Stage());
    }

    /**
     * Method to load battery suggestions based on calculated capacity
     *
     * @param result calculated battery capacity
     */
    private void loadBatteries(int result) {
        BatteryListView.setVisible(true);
        BatteryListView.setItems(
                FXCollections.observableArrayList(
                        new BatteryDaoImpl()
                                .getBatteriesByCapacity(
                                        result,
                                        Integer.parseInt(BatteryVoltageTexField.getText()))));
    }

    /** Method to calculate battery capacity */
    private void calculateCapacity() {
        CalculateCapacity calculateCapacity = new CalculateCapacity();
        if (InverterEfficiencyTextField.getText().isEmpty()) {
            InverterEfficiencyTextField.setText("0.8");
        }
        result =
                calculateCapacity.calculate(
                        Integer.parseInt(ConsumedPowerTextField.getText()),
                        Integer.parseInt(WorkingTimeTextField.getText()),
                        Integer.parseInt(BatteryVoltageTexField.getText()),
                        Float.parseFloat(InverterEfficiencyTextField.getText()));
        ResultLabel.setText(result + " Ah");
        try {
            User user = (User) new UserDaoImpl().getUserByUsername(username);
            History history =
                    History.builder()
                            .capacity(result)
                            .hours(Integer.parseInt(WorkingTimeTextField.getText()))
                            .consumedPower(ConsumedPowerTextField.getText() + "W")
                            .voltage(Integer.parseInt(BatteryVoltageTexField.getText()))
                            .inverterEfficiency(
                                    Float.parseFloat(InverterEfficiencyTextField.getText()))
                            .userId(user.getId())
                            .build();
            new HistoryDaoImpl().addHistory(history);
        } catch (Exception e) {
            ErrorLabel.setText("Can't save history");
            ErrorLabel.setVisible(true);
        }
    }

    /**
     * Method to set user's username
     *
     * @param username user's username
     */
    public void setUsername(String username) {
        this.username = username;
        if (username.equals("guest")) {
            ProfileButton.setVisible(false);
            HistoryButton.setVisible(false);
        }
    }
}
