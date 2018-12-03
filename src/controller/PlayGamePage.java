package controller;
import java.util.Collections;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import model.Shaker;
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
	@FXML 
	private Button skipButton;
	
	
	private String currentPrompt;
	private WordPrompt prompt = new WordPrompt();
	
	//TODO: Change this field to belong to a gameround or round class
	//      that this playgame controller inherits from. Value determined at game start or menu
	private int level = 1;
	private LoginPage login = new LoginPage();
	final PseudoClass errorClass = PseudoClass.getPseudoClass("error");
	private static final Logger LOGGER = Logger.getLogger(PlayGamePage.class.getName());
	/**
     * Set up prompt for opening the play screen .
     *
     */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		level = login.getPlayer().getLevel();
		updatePrompt();
		//checkAnswer(answerField);
	}
	
	public void updatePrompt() {
		String word = prompt.getWord(level);
		currentPrompt = word;
		wordPromptLabel.setText(word);
		answerField.setText("");
	}

//	private void checkAnswer(TextField tf) { 
//		tf.textProperty().addListener(new ChangeListener<String>() {
//	        @Override
//	        public void changed(ObservableValue<? extends String> observable,
//	                String oldValue, String newValue) {
//	            validate(tf);
//	        }
//
//	    });
//	    validate(tf);
//	}

	public void check() {
		validate(answerField);
	}
	
	private void validate(TextField tf) {
		Shaker shaker = new Shaker(tf);
	    if (SynonymAPI.checkSynonym(currentPrompt, tf.getText())) {
	    	tf.pseudoClassStateChanged(errorClass, false);
	        login.getPlayer().incrementScore(1);
	        updatePrompt();
	    }
	    else{
	    	tf.pseudoClassStateChanged(errorClass, true);
	    	shaker.shake();
	    }

	}

	
//	public void checkAnswer() {
//		ObservableList<String> styleClass = answerField.getStyleClass();
//		String ans = answerField.getText();
//		if (SynonymAPI.checkSynonym(currentPrompt, ans)) {
//			login.getPlayer().incrementScore(1);
//			styleClass.removeAll(Collections.singleton("error"));    
//			updatePrompt();
//		}
//		else {
//			if (! answerField.getStyleClass().contains("error")) {
//				answerField.getStyleClass().add("error");
//            }
//		}
//	
//	}
	
	private void transitionScene(Button button, String fxmlScene) {
		Window owner = button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlScene));
        Parent root = null;
        try {
        	root = loader.load();
        } catch (IOException e) {
        	LOGGER.log(Level.WARNING, "transitioning from PlayGame", e.getStackTrace());
        }
        Stage stage = (Stage) owner;
        Scene scene = null;
        scene = new Scene(root);
        stage.setScene(scene);
	}

	/**
     * Default action for opening the pause menu.
     * @param actionEvent
     */
    public void openMenu() {
    	transitionScene(menuButton, "../view/PauseMenu.fxml");
    }
    
}
