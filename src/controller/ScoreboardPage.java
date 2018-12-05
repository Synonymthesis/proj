package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ScoreboardPage implements Initializable {
	@FXML
    private Button backButton;
    @FXML 
    private Label playerScore;
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		updateScore();
	}
    
	public void updateScore() {
		LoginPage p = new LoginPage();
		Player player = p.getPlayer();
		playerScore.setText(String.valueOf(player.getScore()));
	}
	
	public void backToMain() {
		if (LoginPage.getNextScene()=="Scoreboard") {
			SceneController s = new SceneController();
			s.transitionScene(backButton, "../view/LoginPage.fxml");
		} 
		else if (EndGame.getNextScene()=="Scoreboard"){
			SceneController s = new SceneController();
			s.transitionScene(backButton, "../view/EndGame.fxml");
		}
		else {
			SceneController s = new SceneController();
			s.transitionScene(backButton, "../view/PlayGame.fxml");
		}
	}


}
