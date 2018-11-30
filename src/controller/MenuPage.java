package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.scene.Parent;

public class MenuPage {
	
  private static final Logger LOGGER = Logger.getLogger(MenuPage.class.getName());
  
	@FXML
	private Button mainMenuButton;
	@FXML
	private Button resumeButton;
	@FXML
	private Button scoreboardButton;
  @FXML
  private Button levelButton;
	
	
	public void gotoMainMenu(ActionEvent actionEvent) {
		transitionScene(mainMenuButton, "../view/LoginPage.fxml");
	}
	
	public void resumeGame() {
		transitionScene(resumeButton, "../view/PlayGame.fxml");
	}
	
	public void openScoreboard() {
    		transitionScene(scoreboardButton, "../view/Scoreboard.fxml");
    	}
  
  	public void getLevel() {
        	transitionScene(levelButton, "../view/Difficulty.fxml");
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

