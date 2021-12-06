package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {
	
	@FXML
	private Button loginButton;
	@FXML
	TextField userTextField;
	@FXML
	TextField userTextField2;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void switchToScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void login(ActionEvent event) throws IOException {
		
		String username = userTextField.getText();
		String username2 = userTextField2.getText();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));	
		root = loader.load();	
		
		Scene2Controller scene2Controller = loader.getController();
		scene2Controller.displayName(username);
		scene2Controller.displayName2(username2);
		
		//root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));	
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
