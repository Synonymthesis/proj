package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.WordPrompt;

public class Scoreboard {
	
	private static final Logger LOGGER = Logger.getLogger(WordPrompt.class.getName());
	
	@FXML
	private Button backButton;
	
	@FXML
	private void backToMain(ActionEvent event) {
		transitionScene(backButton, "../view/LoginPage.fxml");
	}
	
	private void transitionScene(Button button, String fxmlScene) {
		Window owner = button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlScene));
        Parent root = null;
        try {
        	root = loader.load();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.toString());
        }
        Stage stage = (Stage) owner;
        Scene scene = null;
        scene = new Scene(root);
        stage.setScene(scene);
	}
}
