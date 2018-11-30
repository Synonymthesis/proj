package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class MenuPage {
	
	@FXML
	private Button mainMenuButton;
	@FXML
	private Button resumeButton;
	@FXML
	private Button scoreboardButton;
	
	
	public void gotoMainMenu(ActionEvent actionEvent) {
		transitionScene(mainMenuButton, "../view/LoginPage.fxml");
	}
	
	public void resumeGame() {
		transitionScene(resumeButton, "../view/PlayGame.fxml");
	}
	
	public void openScoreboard() {
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
