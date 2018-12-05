package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class EndGame implements Initializable {
	
	@FXML
	private Label scoreLabel;
	@FXML 
	private Button backButton;
	@FXML 
	private Button scoreboardButton;
	
	
	private LoginPage login = new LoginPage();
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
		SceneController controller = new SceneController();
		controller.transitionScene(backButton, "../view/LoginPage.fxml");
	}
	
	public void displayScoreboard() {
		nextScene = "Scoreboard";
		SceneController controller = new SceneController();
		controller.transitionScene(scoreboardButton, "../view/Scoreboard.fxml");
	}
}
