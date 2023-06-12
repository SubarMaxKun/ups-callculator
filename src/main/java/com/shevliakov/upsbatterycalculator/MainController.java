package com.shevliakov.upsbatterycalculator;

import io.github.palexdev.materialfx.controls.MFXButton;
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
  protected void proceedAuthorization() {
    String procedure = AuthorizeButton.getText();
    if (procedure.equals("Sign In")) {
      System.out.println("Sign In");
    } else if (procedure.equals("Sign Up")) {
      System.out.println("Sign Up");
    }
  }
}