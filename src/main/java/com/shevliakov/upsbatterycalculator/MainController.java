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

public class MainController {

  public MFXButton SignInButton;
  public MFXButton SignUpButton;
  public MFXButton ReturnButton;
  public MFXButton AuthorizeButton;
  public MFXTextField UsernameTextField;
  public MFXTextField PasswordPasswordField;
  public Label ErrorLabel;

  @FXML
  protected void onNavigationButtonClicked(ActionEvent actionEvent) throws IOException {
    String fxmlFileName = "";
    if (actionEvent.getSource() == SignInButton) {
      fxmlFileName = "signIn-view.fxml";
    } else if (actionEvent.getSource() == SignUpButton) {
      fxmlFileName = "signUp-view.fxml";
    } else if (actionEvent.getSource() == ReturnButton) {
      fxmlFileName = "main-view.fxml";
    }
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Views/" + fxmlFileName));
    Scene scene = new Scene(fxmlLoader.load());
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  protected void proceedAuthorization(ActionEvent actionEvent) throws IOException {
    String procedure = AuthorizeButton.getText();
    switch (procedure) {
      case "Sign In" -> proceedSignIn();
      case "Sign Up" -> proceedSignUp();
    }
  }

  private void proceedSignIn() {
    SignIn signIn = new SignIn();
    try {
      if (signIn.signIn(UsernameTextField.getText(), PasswordPasswordField.getText())) {
        openCalculatorStage();
      } else {
        ErrorLabel.setText("Wrong username or password");
        ErrorLabel.setVisible(true);
      }
    } catch (Exception e) {
      ErrorLabel.setText("Connection with database failed");
      ErrorLabel.setVisible(true);
    }
  }

  private void proceedSignUp() {
    SignUp signUp = new SignUp();
    try {
      if (signUp.signUp(UsernameTextField.getText(), PasswordPasswordField.getText())) {
        openCalculatorStage();
      } else {
        ErrorLabel.setText("You have problem with username or password");
        ErrorLabel.setVisible(true);
      }
    } catch (Exception e) {
      ErrorLabel.setText("Connection with database failed");
      ErrorLabel.setVisible(true);
    }
  }

  private void openCalculatorStage() throws IOException {
    Stage stage = (Stage) AuthorizeButton.getScene().getWindow();
    stage.close();
    CalculatorStage calculatorStage = new CalculatorStage();
    calculatorStage.open();
  }
}