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
	
	public void gotoMainMenu(ActionEvent actionEvent) {
		transitionScene("../view/LoginPage.fxml");
	}
	
	public void resumeGame() {
		transitionScene("../view/PlayGame.fxml");
	}
	
	private void transitionScene(String fxmlScene) {
		Window owner = mainMenuButton.getScene().getWindow();
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
