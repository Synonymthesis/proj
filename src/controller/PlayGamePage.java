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


public class PlayGamePage {
	
	@FXML
	private TextField answerField;
	@FXML
	private Label wordPromptLabel;
	@FXML
	private Button submitButton;
	@FXML
	private Button menuButton;
	
	/**
     * Default action for opening the pause menu.
     * @param actionEvent
     */
    public void openMenu(ActionEvent actionEvent) {
    	Window owner = menuButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PauseMenu.fxml"));
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
