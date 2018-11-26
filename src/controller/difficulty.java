package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
 
public class difficulty extends LoginPage {

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

        public void easyLevel(ActionEvent actionEvent){
            Window owner = easyButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/PlayGame.fxml"));
            Parent root = null;
            try {
        	      root = loader.load();
            } catch (IOException e) {
               e.printStackTrace();
            }
            Stage stage = (Stage) owner;
            Scene scene = null;
            scene = new Scene(root);
            stage.setScene(scene);
	       }
        
        public void medLevel(ActionEvent actionEvent){
            Window owner = mediumButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/PlayGame.fxml"));
            Parent root = null;
            try {
        	      root = loader.load();
            } catch (IOException e) {
               e.printStackTrace();
            }
            Stage stage = (Stage) owner;
            Scene scene = null;
            scene = new Scene(root);
            stage.setScene(scene);
	       }
        
        public void hardLevel(ActionEvent actionEvent){
            Window owner = hardButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/PlayGame.fxml"));
            Parent root = null;
            try {
        	      root = loader.load();
            } catch (IOException e) {
               e.printStackTrace();
            }
            Stage stage = (Stage) owner;
            Scene scene = null;
            scene = new Scene(root);
            stage.setScene(scene);
	       }

        public void goBack(ActionEvent actionEvent){
            Window owner = backButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/LoginPage.fxml"));
            Parent root = null;
            try {
        	      root = loader.load();
            } catch (IOException e) {
               e.printStackTrace();
            }
            Stage stage = (Stage) owner;
            Scene scene = null;
            scene = new Scene(root);
            stage.setScene(scene);
	       }
}

