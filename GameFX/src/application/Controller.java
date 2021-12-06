package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Controller implements Initializable {
	
	
	@FXML
	private Button logoutButton;
	@FXML
	private AnchorPane scenePane;
	
	private File directory;
	private File[] files;
	
	private Media media;
	private MediaPlayer mediaPlayer;
	
	private ArrayList<File> songs;
	
	
	private Scene scene;
	private Stage stage;
	private Parent root;
	
	public void logout(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("You're about to close the game!");
		alert.setContentText("Do you want to close the game?");
		
		if(alert.showAndWait().get() == ButtonType.OK) {
		stage = (Stage) scenePane.getScene().getWindow();
		stage.close();
		}
	}
	public void switchToScene1(ActionEvent event) throws IOException {
		mediaPlayer.play();
		Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchToSceneHelp(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SceneHelp.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchToSceneDevs(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SceneDevs.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		songs = new ArrayList<File>();		
		directory = new File("music");		
		files = directory.listFiles();		
		if(files != null) {			
			for(File file : files) {				
				songs.add(file);
			}
		}
		media = new Media(songs.get(0).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.015);
		mediaPlayer.setCycleCount(1);
	}
}	

