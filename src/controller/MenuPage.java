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
	
	//make settings return and levels 
	@FXML
	private Button settingsButton;
	@FXML
	private Button levelButton;
	
	public void gotoMainMenu() {
		Window owner = mainMenuButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LoginPage.fxml"));
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
	
	/**
     * Default action for opening the settings.
     * @param actionEvent
     */
    public void openSettings() {
    	Window owner = settingsButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/SettingsPage.fxml"));
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
    
    /**
     * Default action for choosing level.
     * @param actionEvent
     */
    public void getLevel() {
    	Window owner = levelButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/difficulty.fxml"));
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
