package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
			
			stage.setOnCloseRequest(event -> {
				event.consume();
				logout(stage);
			});
			
			stage.setTitle("Quiz_Project");
			stage.setResizable(false);
			Image icon = new Image("E:\\Aulas\\JavaFX\\Icons\\GameIcon.png");
			stage.getIcons().add(icon);
			//stage.setFullScreen(true);
			//stage.setFullScreenExitHint("Press 'x' to exit fullscreen mode");
			//stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("x"));
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void logout(Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("You're about to close the game!");
		alert.setContentText("Do you want to close the game?");
		
		if(alert.showAndWait().get() == ButtonType.OK) {
		stage.close();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
