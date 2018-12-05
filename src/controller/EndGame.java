package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

public class EndGame implements Initializable {
	
	@FXML
	private Label scoreLabel;
	@FXML 
	private Button backButton;
	@FXML 
	private Button scoreboardButton;
	
	
	private LoginPage login = new LoginPage();
	private static final Logger LOGGER = Logger.getLogger(PlayGamePage.class.getName());
	private static String nextScene = "";
	
	public String getNextScene() {
		return nextScene;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		updateScore();
	}
	
	public void updateScore() {
		int score = login.getPlayer().getScore();
		scoreLabel.setText(String.valueOf(score));
	}
	
	public void goBack() {
		transitionScene(backButton, "../view/LoginPage.fxml");
	}
	
	public void displayScoreboard() {
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
            LOGGER.log(Level.WARNING, "Button won't work.");
        }
        Stage stage = (Stage) owner;
        Scene scene = null;
        scene = new Scene(root);
        stage.setScene(scene);
	}

}
