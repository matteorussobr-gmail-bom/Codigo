package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scene4Controller {
	
	@FXML
	private Label userLabel1;
	
	@FXML
	private Label userLabel2;
	
	@FXML
	private ImageView charView;
	
	@FXML
	private ImageView charView2;
	
	@FXML
	private Label hpLabel;
	
	@FXML
	private Label hpLabel2;
	
	@FXML
	private Label resLabel;
	
	@FXML
	private Label winLabel;
	
	double p1Point = 0;
	double p2Point = 0;
	
	
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
	public void displayName(String username) {
		userLabel1.setText(username);
	}
	public void displayName2(String username2) {
		userLabel2.setText(username2);
	}
	public void displayImage(Image image) {
		charView.setImage(image);
	}
	public void displayImage2(Image image2) {
		charView2.setImage(image2);
	}
	public void displayScore(String score) {
		hpLabel.setText(score);
	}
	public void displayScore2(String score2) {
		hpLabel2.setText(score2);
	}
}

