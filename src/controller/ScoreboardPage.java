package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Player;
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
			SceneController controller = new SceneController();
	        controller.transitionScene(backButton, "../view/LoginPage.fxml");
		} 
		else if (EndGame.getNextScene()=="Scoreboard"){
			SceneController controller = new SceneController();
	        controller.transitionScene(backButton, "../view/EndGame.fxml");
		}
		else {
			SceneController controller = new SceneController();
	        controller.transitionScene(backButton,"../view/PlayGame.fxml");
		}
	}
	

}
