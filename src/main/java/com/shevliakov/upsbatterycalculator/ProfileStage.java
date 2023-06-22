/* (C)2023 */
package com.shevliakov.upsbatterycalculator;

import com.shevliakov.upsbatterycalculator.logic.controllers.ProfileController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/** ProfileStage class is used to open ProfileStage */
public class ProfileStage {

    /**
     * Method to open ProfileStage
     *
     * @param username user's username
     * @throws IOException exception
     */
    public void open(String username) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/profile-view.fxml"));
        Scene scene = new Scene(loader.load());
        Image icon =
                new Image(
                        "file:src/main/resources/com/shevliakov/upsbatterycalculator/Images/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Profile");
        stage.setScene(scene);
        stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        ProfileController controller = loader.getController();
        controller.setUser(username);
        stage.show();
    }
}
