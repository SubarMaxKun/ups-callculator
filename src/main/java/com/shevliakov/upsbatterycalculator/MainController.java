package com.shevliakov.upsbatterycalculator;

import com.shevliakov.upsbatterycalculator.logic.authorization.SignIn;
import com.shevliakov.upsbatterycalculator.logic.authorization.SignUp;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

  public MFXButton SignInButton;
  public MFXButton SignUpButton;
  public MFXButton ReturnButton;
  public MFXButton AuthorizeButton;
  public MFXTextField UsernameTextField;
  public MFXTextField PasswordPasswordField;

  @FXML
  protected void onSignInButtonClicked() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Views/signIn-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    Stage stage = (Stage) SignInButton.getScene().getWindow();
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  protected void onSignUpButtonClicked() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Views/signUp-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    Stage stage = (Stage) SignUpButton.getScene().getWindow();
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  protected void onReturnButtonClicked() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Views/main-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    Stage stage = (Stage) ReturnButton.getScene().getWindow();
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  protected void proceedAuthorization() throws IOException {
    String procedure = AuthorizeButton.getText();
    if (procedure.equals("Sign In")) {
      // TODO:
      SignIn signIn = new SignIn();
      if (signIn.signIn(UsernameTextField.getText(), PasswordPasswordField.getText())) {
        openCalculatorStage();
      } else {
        System.out.println("Failure");
      }
    } else if (procedure.equals("Sign Up")) {
      // TODO:
      SignUp signUp = new SignUp();
      if (signUp.signUp(UsernameTextField.getText(), PasswordPasswordField.getText())) {
        openCalculatorStage();
      } else {
        System.out.println("Failure");
      }
    }
  }

  private void openCalculatorStage() throws IOException {
    Stage stage = (Stage) AuthorizeButton.getScene().getWindow();
    stage.close();
    CalculatorStage calculatorStage = new CalculatorStage();
    calculatorStage.open();
  }
}