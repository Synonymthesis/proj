package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Difficulty extends LoginPage {
    
    private static final String PLAY_GAME = "../view/PlayGame.fxml";
    private static final Logger LOGGER = Logger.getLogger(Difficulty.class.getName());
    
    @FXML
    private Button easyButton;
    @FXML
    private Button mediumButton;
    @FXML
    private Button hardButton;
    @FXML
    private Button backButton;
    
    /**
     * Menu item for showing assignments due next week
     * @param actionEvent
     */
    
    public void easyLevel(){
        transitionScene(easyButton);
    }
    
    public void medLevel(){
        transitionScene(mediumButton);
    }
    
    public void hardLevel(){
        transitionScene(hardButton);
    }
    
    public void goBack(){
        transitionScene(backButton);
    }
    
    public void transitionScene(Button button) {
        Window owner = button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(PLAY_GAME));
        Stage stage = (Stage) owner;
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Button won't work.");
        }
        stage.setScene(scene);
        
    }
}
