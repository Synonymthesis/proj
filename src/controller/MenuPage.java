package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;


public class MenuPage {
    private static final Logger LOGGER = Logger.getLogger(MenuPage.class.getName());
    
    @FXML
    private Button mainMenuButton;
    @FXML
    private Button resumeButton;
    
    @FXML
    private Button settingsButton;
    @FXML
    private Button levelButton;
    
    
    public void gotoMainMenu() {
        transitionScene(mainMenuButton, "../view/LoginPage.fxml");
    }
    
    public void resumeGame() {
        transitionScene(resumeButton, "../view/PlayGame.fxml");
    }
    
    
    /**
     * Default action for choosing level.
     * @param actionEvent
     */
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

