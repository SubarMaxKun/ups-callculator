package com.shevliakov.upsbatterycalculator;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalculatorStage {

  public void open(Stage stage, String username) throws IOException {
    Stage newStage = new Stage();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("views/calculator-view.fxml"));
    Scene scene = new Scene(loader.load());
    Image icon = new Image(
        "file:src/main/resources/com/shevliakov/upsbatterycalculator/Images/icon.png");
    newStage.getIcons().add(icon);
    newStage.setTitle("Calculator");
    newStage.setScene(scene);
    CalculatorController controller = loader.getController();
    controller.setUsername(username);
    stage.close();
    newStage.show();
  }
}
