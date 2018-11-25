package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.SynonymAPI;
import model.WordPrompt;


public class PlayGamePage implements Initializable {
	
	@FXML
	private TextField answerField;
	@FXML
	private Label wordPromptLabel;
	@FXML
	private Button submitButton;
	@FXML
	private Button menuButton;
	
	private String currentPrompt;
	private WordPrompt prompt = new WordPrompt();
	
	//TODO: Change this field to belong to a gameround or round class
	//      that this playgame controller inherits from. Value determined at game start or menu
	private int level = 1;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		String word = prompt.getWord(level);
		currentPrompt = word;
		wordPromptLabel.setText(word);
	}

	
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
