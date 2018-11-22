package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SettingsPage {
	
	@FXML
	private Slider soundsSlider;
	@FXML
	private Slider musicSlider;
	@FXML
	private Button exitButton;
	
	public void returnToMain(ActionEvent actionEvent) {
		Window owner = exitButton.getScene().getWindow();
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
	
	public void testSlider(ActionEvent actionEvent) {
		System.out.printf("Sounds: %.2f\n", soundsSlider.getValue());
		System.out.printf("Music: %.2f\n", musicSlider.getValue());
	}
}
