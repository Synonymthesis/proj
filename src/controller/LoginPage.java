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


public class LoginPage extends Application {
	
    @FXML
    private Button playButton;
    @FXML 
    private Button loginButton;
    @FXML
    private Button menuButton;
    @FXML 
    private TextField userField;
    @FXML
    private TextField passwordField;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/LoginPage.fxml"));
        primaryStage.setTitle("FXML Login");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
    
    /**
     * Menu item for showing assignments due next week
     * @param actionEvent
     */
    public void startGame(ActionEvent actionEvent) {
            Window owner = playButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/PlayGame.fxml"));
            Stage stage = (Stage) owner;
            Scene scene = null;
            /*
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
            stage.setScene(scene);
    }
    
    /**
     * Default action for opening the menu.
     * @param actionEvent
     */
    public void openMenu(ActionEvent actionEvent) {
        Window owner = menuButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/PauseMenu.fxml"));
        Stage stage = (Stage) owner;
        Scene scene = null;
        /*
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        */
    }
    
    /**
     * TODO: Login function.
     */

   

}