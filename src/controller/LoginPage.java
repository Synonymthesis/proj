package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Player;

import java.io.IOException;

public class LoginPage extends Application {
	
    @FXML
    private Button playButton;
    @FXML 
    private Button loginButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button scoreboardButton;
    @FXML 
    private TextField userField;
    @FXML
    private TextField passwordField;
    
    private static String nextScene = "";
    private static Player player= new Player();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static synchronized String getNextScene() {
		return nextScene;
	}
    public static synchronized void updateNextScene(String filename) {
    	nextScene = filename;
	}
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LoginPage.fxml"));
        Parent root = null;
        root = loader.load();
		
        primaryStage.setTitle("FXML Login");
        primaryStage.setScene(new Scene(root, 930, 700));
        primaryStage.show();
    }
    
    /**
     * Menu item for showing assignments due next week
     * @param actionEvent
     */

    public void startGame(){
    	updateNextScene("PlayGame");
    	SceneController controller = new SceneController();
        controller.transitionScene(playButton, "../view/PlayGame.fxml");
    }
    
    public Player getPlayer() {
    	return player;
    }
    
    public void getUsername() {
    	String text = userField.getText();
    	player.setName(text);
    }
    
    public String getPasswd() {
    	return passwordField.getText();
    }
    
    /**
     * Default action for opening the settings.
     * @param actionEvent
     */
    public void openSettings() {
    	updateNextScene("Settings");
    	SceneController controller = new SceneController();
    	controller.transitionScene(settingsButton, "../view/SettingsPage.fxml");
    }
    
    public void openScoreboard() {
    	updateNextScene("Scoreboard");
    	SceneController controller = new SceneController();
    	controller.transitionScene(scoreboardButton, "../view/Scoreboard.fxml");
    }
}