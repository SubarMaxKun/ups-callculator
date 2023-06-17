package com.shevliakov.upsbatterycalculator;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalculatorStage {
  public void open() throws IOException {
    Stage stage = new Stage();
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Views/calculator-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    Image icon = new Image(
        "file:src/main/resources/com/shevliakov/upsbatterycalculator/Images/icon.png");
    stage.getIcons().add(icon);
    stage.setTitle("Calculator");
    stage.setResizable(true);
    stage.setMinWidth(800);
    stage.setMinHeight(600);
    stage.setScene(scene);
    stage.show();
  }
}
