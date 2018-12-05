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
		LoginPage l = new LoginPage();
		EndGame e = new EndGame();
		if (l.getNextScene()=="Scoreboard") {
			transitionScene(backButton, "../view/LoginPage.fxml");
		} 
		else if (e.getNextScene()=="Scoreboard"){
			transitionScene(backButton, "../view/EndGame.fxml");
		}
		else {
			transitionScene(backButton, "../view/PlayGame.fxml");
		}
	}
	
	private void transitionScene(Button button, String fxmlScene) {
		Window owner = button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlScene));
        Parent root = null;
        try {
        	loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        root = loader.getRoot();
        Stage stage = (Stage) owner;
        Scene scene = null;
        scene = new Scene(root);
        stage.setScene(scene);
	}
	

}
