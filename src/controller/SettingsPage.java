package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class SettingsPage {
	@FXML
	private Slider soundsSlider;
	@FXML
	private Slider musicSlider;
	@FXML
	private Button exitButton;
	
	public void returnToMain() {
        SceneController controller = new SceneController();
        controller.transitionScene(exitButton, "../view/LoginPage.fxml");
	}
}
