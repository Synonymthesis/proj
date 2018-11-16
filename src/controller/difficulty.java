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
 
public class difficulty extends Application {

        @FXML
        private Button easyButton;
        @FXML
        private Button mediumButton;
        @FXML
        private Button hardButton;
        @FXML
        private Button backButton;

        public static void main(String[] args) {
            launch(args); 
            }

        @Override
        public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("../view/difficulty.fxml"));
            primaryStage.setTitle("FXML Difficulty");
            primaryStage.setScene(new Scene(root, 800, 500));
            primaryStage.show();
        }

        /**
         * Menu item for showing assignments due next week
         * @param actionEvent
         */

        public void easyLevel(ActionEvent actionEvent){
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
        
        public void medLevel(ActionEvent actionEvent){
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
        
        public void hardLevel(ActionEvent actionEvent){
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

        public void goBack(ActionEvent actionEvent){
            Window owner = backButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/LoginPage.fxml"));
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

