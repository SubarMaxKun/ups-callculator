/* (C)2023 */
package com.shevliakov.upsbatterycalculator.logic.controllers;

import com.shevliakov.upsbatterycalculator.dao.impl.UserDaoImpl;
import com.shevliakov.upsbatterycalculator.entity.User;
import com.shevliakov.upsbatterycalculator.logic.Hash;
import com.shevliakov.upsbatterycalculator.logic.authorization.CheckPasswordAvailability;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

/** Controller for ProfileStage */
public class ProfileController {

    public Label UsernameLabel;
    public Label ErrorLabel;
    public MFXPasswordField OldPasswordPasswordField;
    public MFXPasswordField NewPasswordPasswordField;
    public MFXPasswordField RepeatPasswordPasswordField;
    private String username;

    /**
     * Method to change user's password
     *
     * @param actionEvent event
     */
    public void onChangePasswordButtonClicked(ActionEvent actionEvent) {
        try {
            User user = new User();
            UserDaoImpl userDaoImpl = new UserDaoImpl();
            user = (User) userDaoImpl.getUserByUsername(username);

            if (Hash.getHash(OldPasswordPasswordField.getText()).equals(user.getPassword())
                    && Objects.equals(
                            NewPasswordPasswordField.getText(),
                            RepeatPasswordPasswordField.getText())
                    && new CheckPasswordAvailability()
                            .checkPasswordAvailability(NewPasswordPasswordField.getText())) {
                user.setPassword(Hash.getHash(NewPasswordPasswordField.getText()));
                userDaoImpl.updateUserPasswordByUsername(user.getUsername(), user.getPassword());
                ErrorLabel.setText("Password changed successfully");
                ErrorLabel.setVisible(true);
            } else {
                ErrorLabel.setText("Passwords don't match or password is too short");
                ErrorLabel.setVisible(true);
            }
        } catch (Exception e) {
            ErrorLabel.setText("Can't change password");
            ErrorLabel.setVisible(true);
        }
    }

    /**
     * Method to set username
     *
     * @param username username
     */
    public void setUser(String username) {
        this.username = username;
        UsernameLabel.setText(username);
    }
}
