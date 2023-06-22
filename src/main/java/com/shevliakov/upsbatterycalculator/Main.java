/* (C)2023 */
package com.shevliakov.upsbatterycalculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/** JavaFX App */
public class Main extends Application {

    /**
     * Start application
     *
     * @param stage stage
     * @throws IOException exception
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Views/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon =
                new Image(
                        "file:src/main/resources/com/shevliakov/upsbatterycalculator/Images/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Authorization");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        launch();
    }
}
