package controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

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
	
	
	private String currentPrompt;
	private WordPrompt prompt = new WordPrompt();
	private Integer startTime = 30; 
	private Timeline timeline;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(startTime);

	private int level = 1;
	private LoginPage login = new LoginPage();
	final PseudoClass errorClass = PseudoClass.getPseudoClass("error");

	/**
     * Set up prompt for opening the play screen .
     *
     */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		level = login.getPlayer().getLevel();
		updatePrompt();
		timer();
		SceneController controller = new SceneController();
		PauseTransition visiblePause = new PauseTransition(Duration.seconds(startTime));
		visiblePause.setOnFinished(event -> controller.transitionScene(menuButton, "../view/EndGame.fxml"));
		visiblePause.play();
	}
	public void initializeLevel(int playerLevel) {
		level = playerLevel;
		if (level == 2) {
			startTime = 20;
		}else if(level == 3){
			startTime = 10;
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
	        LeaderboardDatabase.getInstance().saveScore(name, login.getPlayer().getScore());
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

	/**
     * Default action for opening the pause menu.
     * @param actionEvent
     */
    public void openMenu() {
    	SceneController controller = new SceneController();
    	controller.transitionScene(menuButton, "../view/PauseMenu.fxml");
    }
    
    
    public void timer() {
    	timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");
        SceneController controller = new SceneController();

        if (timeline != null) {
            timeline.stop();
            controller.transitionScene(menuButton,"../view/PauseMenu.fxml" );
        }
        timeSeconds.set(startTime);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(startTime+1),
                new KeyValue(timeSeconds, 0)
                ));
       
        timeline.playFromStart();
    } 
    
}
