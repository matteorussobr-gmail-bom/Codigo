package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scene2Controller {
	
	@FXML
	Label userLabel1;
	@FXML
	Label userLabel2;
	@FXML
	ImageView charView;
	@FXML
	ImageView descView;
	@FXML
	ImageView charView2;
	@FXML
	ImageView descView2;
	@FXML
	Button karlosButton;
	@FXML
	Button karlosButton2;
	@FXML
	Button mecButton;
	@FXML
	Button mecButton2;
	@FXML
	Button joseButton;
	@FXML
	Button joseButton2;
	@FXML
	Button lilButton;
	@FXML
	Button lilButton2;
	@FXML
	Button nandoButton;
	@FXML
	Button nandoButton2;
	@FXML
	Button confirm;
	@FXML
	Label titleLabel;
	
	int charVal;
	int charVal2;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void displayName(String username) {
		userLabel1.setText(username);
	}
	public void displayName2(String username2) {
		userLabel2.setText(username2);
	}
	public void switchToScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchToKarlos(ActionEvent event) throws IOException {
		Image karlos = new Image("E:\\Aulas\\JavaFX\\Icons\\Sanic.png");
		charView.setImage(karlos);
		charVal = 1;
		Image kardesc = new Image("E:\\Aulas\\JavaFX\\Icons\\sanicdesc.png");
		descView.setImage(kardesc);
	}
	public void switchToMequestraio(ActionEvent event) throws IOException {
		Image mec = new Image("E:\\Aulas\\JavaFX\\Icons\\mequestraio.png");
		charView.setImage(mec);
		charVal = 2;
		Image mecdesc = new Image("E:\\Aulas\\JavaFX\\Icons\\mecdesc.png");
		descView.setImage(mecdesc);
	}
	public void switchToToalha(ActionEvent event) throws IOException {
		Image toalha = new Image("E:\\Aulas\\JavaFX\\Icons\\jose.png");
		charView.setImage(toalha);
		charVal = 3;
		Image josedesc = new Image("E:\\Aulas\\JavaFX\\Icons\\josedesc.png");
		descView.setImage(josedesc);
	}
	public void switchToNas(ActionEvent event) throws IOException {
		Image nas = new Image("E:\\Aulas\\JavaFX\\Icons\\nas.png");
		charView.setImage(nas);
		charVal = 4;
		Image nasdesc = new Image("E:\\Aulas\\JavaFX\\Icons\\nasdesc.png");
		descView.setImage(nasdesc);
	}
	public void switchToNando(ActionEvent event) throws IOException {
		Image nando = new Image("E:\\Aulas\\JavaFX\\Icons\\fernando.png");
		charView.setImage(nando);
		charVal = 5;
		Image nandodesc = new Image("E:\\Aulas\\JavaFX\\Icons\\nandodesc.png");
		descView.setImage(nandodesc);
	}
	public void switchToKarlos2(ActionEvent event) throws IOException {
		Image karlos = new Image("E:\\Aulas\\JavaFX\\Icons\\Sanic.png");
		charView2.setImage(karlos);
		charVal2 = 1;
		Image kardesc = new Image("E:\\Aulas\\JavaFX\\Icons\\sanicdesc.png");
		descView2.setImage(kardesc);
	}
	public void switchToMequestraio2(ActionEvent event) throws IOException {
		Image mec = new Image("E:\\Aulas\\JavaFX\\Icons\\mequestraio.png");
		charView2.setImage(mec);
		charVal2 = 2;
		Image mecdesc = new Image("E:\\Aulas\\JavaFX\\Icons\\mecdesc.png");
		descView2.setImage(mecdesc);
	}
	public void switchToToalha2(ActionEvent event) throws IOException {
		Image toalha = new Image("E:\\Aulas\\JavaFX\\Icons\\jose.png");
		charView2.setImage(toalha);
		charVal2 = 3;
		Image josedesc = new Image("E:\\Aulas\\JavaFX\\Icons\\josedesc.png");
		descView2.setImage(josedesc);
	}
	public void switchToNas2(ActionEvent event) throws IOException {
		Image nas = new Image("E:\\Aulas\\JavaFX\\Icons\\nas.png");
		charView2.setImage(nas);
		charVal2 = 4;
		Image nasdesc = new Image("E:\\Aulas\\JavaFX\\Icons\\nasdesc.png");
		descView2.setImage(nasdesc);
	}
	public void switchToNando2(ActionEvent event) throws IOException {
		Image nando = new Image("E:\\Aulas\\JavaFX\\Icons\\fernando.png");
		charView2.setImage(nando);
		charVal2 = 5;
		Image nandodesc = new Image("E:\\Aulas\\JavaFX\\Icons\\nandodesc.png");
		descView2.setImage(nandodesc);
	}
	public void confirm(ActionEvent event) throws IOException {
		
			if((charVal == 0) || (charVal2 == 0)) {
				titleLabel.setText("You must choose a character!");
			}
			else if((charVal == 0) && (charVal2 == 0)) {
				titleLabel.setText("You must choose a character!");
			}
			else if(charVal == charVal2) {
				titleLabel.setText("You can't pick the same character!");
			}
			else if(charVal != charVal2) {
				
				String username = userLabel1.getText();
				String username2 = userLabel2.getText();
				Image image = charView.getImage();
				Image image2 = charView2.getImage();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));	
				root = loader.load();
				
				Scene3Controller scene3Controller = loader.getController();
				scene3Controller.displayName(username);
				scene3Controller.displayName2(username2);
				scene3Controller.displayImage(image);
				scene3Controller.displayImage2(image2);
				
				//Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
	}

