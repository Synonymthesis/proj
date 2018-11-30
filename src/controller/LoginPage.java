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
    public String getNextScene() {
    	return nextScene;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LoginPage.fxml"));
        Parent root = null;
        root = loader.load();
        primaryStage.setTitle("FXML Login");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
    
    /**
     * Menu item for showing assignments due next week
     * @param actionEvent
     */

    public void startGame(ActionEvent actionEvent){
    	nextScene = "PlayGame";
        transitionScene(playButton, "../view/PlayGame.fxml");
    }
    
    public Player getPlayer() {
    	return player;
    }
    
    public void getUsername(ActionEvent actionEvent) {
    	String text = userField.getText();
    	player.setName(text);
    }
    
    public void getPasswd() {
    	String passwd = passwordField.getText();
    	//TODO: save password to username as key in some table
    }
    
    /**
     * Default action for opening the settings.
     * @param actionEvent
     */
    public void openSettings() {
    	nextScene = "Settings";
    	transitionScene(settingsButton, "../view/SettingsPage.fxml");
    }
    
    public void openScoreboard() {
    	nextScene = "Scoreboard";
    	transitionScene(scoreboardButton, "../view/Scoreboard.fxml");
    }
    
    private void transitionScene(Button button, String fxmlScene) {
		Window owner = button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlScene));
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