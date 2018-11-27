package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
 
public class Difficulty extends LoginPage {

        @FXML
        private Button easyButton;
        @FXML
        private Button mediumButton;
        @FXML
        private Button hardButton;
        @FXML
        private Button backButton;

        /**
         * Menu item for showing assignments due next week
         * @param actionEvent
         */

        public void easyLevel(){
            Window owner = easyButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/PlayGame.fxml"));
            Stage stage = (Stage) owner;
            Scene scene = null;
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(scene);
        }
        
        public void medLevel(){
            Window owner = mediumButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/PlayGame.fxml"));
            Stage stage = (Stage) owner;
            Scene scene = null;
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(scene);
        }
        
        public void hardLevel(){
            Window owner = hardButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/PlayGame.fxml"));
            Stage stage = (Stage) owner;
            Scene scene = null;
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(scene);
        }

        public void goBack(){
            Window owner = backButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/PlayGame.fxml"));
            Stage stage = (Stage) owner;
            Scene scene = null;
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(scene);
        }

}

