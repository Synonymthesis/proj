package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class MenuPage extends LoginPage {
	
	@FXML
	private Button mainMenuButton;
	
	public void gotoMainMenu(ActionEvent actionEvent) {
        Window owner = mainMenuButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/LoginPage.fxml"));
        Stage stage = (Stage) owner;
        Scene scene = null;
        /*
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        stage.setScene(scene);
	}
}
