package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Scoreboard {
	
	@FXML
	private Button backButton;
	
	@FXML
	private void backToMain() {
		SceneController controller = new SceneController();
		controller.transitionScene(backButton, "../view/LoginPage.fxml");
	}
}
