package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class MenuPage {
	
	@FXML
	private Button mainMenuButton;
	@FXML
	private Button resumeButton;
	@FXML
	private Button scoreboardButton;
  @FXML
  private Button levelButton;
	
	
	public void gotoMainMenu() {
		SceneController controller = new SceneController();
		controller.transitionScene(mainMenuButton, "../view/LoginPage.fxml");
	}
	
	public void resumeGame() {
		SceneController controller = new SceneController();
		controller.transitionScene(resumeButton, "../view/PlayGame.fxml");
	}
	
	public void openScoreboard() {
		SceneController controller = new SceneController();
    	controller.transitionScene(scoreboardButton, "../view/Scoreboard.fxml");
    }
  
  	public void getLevel() {
  		SceneController controller = new SceneController();
        controller.transitionScene(levelButton, "../view/Difficulty.fxml");
    }
}

