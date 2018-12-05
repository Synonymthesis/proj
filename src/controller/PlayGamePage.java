package controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.css.PseudoClass;
import javafx.scene.Scene;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.Timeline;
import javafx.util.Duration;
import model.LeaderboardDatabase;
import model.Shaker;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.scene.paint.Color;
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
	@FXML
	private Label timerLabel;
	@FXML
	private Label wrongAnswer;
	
	
	private static String currentPrompt;
	private WordPrompt prompt = new WordPrompt();
	private static Integer STARTTIME = 30; 
	private Timeline timeline;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
		
	

	private int level = 1;
	private LoginPage login = new LoginPage();
	final PseudoClass errorClass = PseudoClass.getPseudoClass("error");
	private static final String FILENAME = "src/model/leaderboard.json";
	private LeaderboardDatabase data = new LeaderboardDatabase(FILENAME);
	private static final Logger LOGGER = Logger.getLogger(PlayGamePage.class.getName());
	/**
     * Set up prompt for opening the play screen .
     *
     */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		level = login.getPlayer().getLevel();
		updatePrompt();
		timer();
		PauseTransition visiblePause = new PauseTransition(Duration.seconds(STARTTIME));
		visiblePause.setOnFinished(event -> transitionScene(menuButton, "../view/EndGame.fxml"));
		visiblePause.play();
		
	}
	public void initializeLevel(int playerLevel) {
		level = playerLevel;
		if (level == 2) {
			STARTTIME = 20;
		}else if(level == 3){
			STARTTIME = 10;
		}
	}
	public void updatePrompt() {
		String word = prompt.getWord(level);
		currentPrompt = word;
		wordPromptLabel.setText(word);
		answerField.setText("");
	}

	public void check() {
		validate(answerField);
	}
	
	private void validate(TextField tf) {
		Shaker shaker = new Shaker(tf);
	    if (SynonymAPI.checkSynonym(currentPrompt, tf.getText())) {
	    	tf.pseudoClassStateChanged(errorClass, false);
	        login.getPlayer().incrementScore(1);
	        String name = login.getPlayer().getName();
	        if (name == null) {
	        	name = "Your Score";
	        }
	        data.saveScore(name, login.getPlayer().getScore());
	        updatePrompt();
	    }
	    else{
	    	wrongAnswer.setText("Wrong Answer. Try Again");
			wrongAnswer.setVisible(true);
			PauseTransition visiblePause = new PauseTransition(Duration.seconds(1));
			visiblePause.setOnFinished(event -> wrongAnswer.setVisible(false));
			visiblePause.play();
	    	tf.pseudoClassStateChanged(errorClass, true);
	    	shaker.shake();
	    }

	}
	
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
    
    
    public void timer() {
    	timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");

        if (timeline != null) {
            timeline.stop();
            transitionScene(menuButton,"../view/PauseMenu.fxml" );
        }
        timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(STARTTIME+1),
                new KeyValue(timeSeconds, 0)
                ));
       
        timeline.playFromStart();
    } 
    
}
