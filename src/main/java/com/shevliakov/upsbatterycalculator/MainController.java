/* (C)2023 */
package com.shevliakov.upsbatterycalculator;

import com.shevliakov.upsbatterycalculator.logic.authorization.SignIn;
import com.shevliakov.upsbatterycalculator.logic.authorization.SignUp;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/** MainController class is used to control main and authorization stages */
public class MainController {

    public MFXButton SignInButton;
    public MFXButton SignUpButton;
    public MFXButton ReturnButton;
    public MFXButton AuthorizeButton;
    public MFXTextField UsernameTextField;
    public MFXTextField PasswordPasswordField;
    public Label ErrorLabel;
    public MFXButton GuestButton;
    private String username;
    private String password;

    /**
     * Method to open stage or scene according to the button which was clicked
     *
     * @param actionEvent event
     * @throws IOException exception
     */
    @FXML
    protected void onNavigationButtonClicked(ActionEvent actionEvent) throws IOException {
        String fxmlFileName = "";
        if (actionEvent.getSource() == SignInButton) {
            fxmlFileName = "signIn-view.fxml";
        } else if (actionEvent.getSource() == SignUpButton) {
            fxmlFileName = "signUp-view.fxml";
        } else if (actionEvent.getSource() == GuestButton) {
            openCalculatorStage("guest");
            return;
        } else if (actionEvent.getSource() == ReturnButton) {
            fxmlFileName = "main-view.fxml";
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/" + fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method to proceed authorization according to the button which was clicked
     *
     * @param actionEvent event
     */
    @FXML
    protected void proceedAuthorization(ActionEvent actionEvent) {
        username = UsernameTextField.getText();
        password = PasswordPasswordField.getText();
        String procedure = AuthorizeButton.getText();
        switch (procedure) {
            case "Sign In" -> proceedSignIn();
            case "Sign Up" -> proceedSignUp();
        }
    }

    /** Method to proceed sign in */
    private void proceedSignIn() {
        SignIn signIn = new SignIn();
        try {
            if (signIn.signIn(username, password)) {
                openCalculatorStage(username);
            } else {
                ErrorLabel.setText("Wrong username or password");
                ErrorLabel.setVisible(true);
            }
        } catch (Exception e) {
            ErrorLabel.setText("Connection with database failed");
            ErrorLabel.setVisible(true);
        }
    }

    /** Method to proceed sign up */
    private void proceedSignUp() {
        SignUp signUp = new SignUp();
        try {
            if (signUp.signUp(username, password)) {
                openCalculatorStage(username);
            } else {
                ErrorLabel.setText("You have problem with username or password");
                ErrorLabel.setVisible(true);
            }
        } catch (Exception e) {
            ErrorLabel.setText("Connection with database failed");
            ErrorLabel.setVisible(true);
        }
    }

    /**
     * Method to open CalculatorStage
     *
     * @param username user's username
     * @throws IOException exception
     */
    private void openCalculatorStage(String username) throws IOException {
        Stage stage;
        if (AuthorizeButton == null) {
            stage = (Stage) GuestButton.getScene().getWindow();
        } else {
            stage = (Stage) AuthorizeButton.getScene().getWindow();
        }
        CalculatorStage calculatorStage = new CalculatorStage();
        calculatorStage.open(stage, username);
    }
}
