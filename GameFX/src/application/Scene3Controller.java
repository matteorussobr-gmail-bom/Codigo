package application;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Scene3Controller implements Initializable {

	@FXML
	private ProgressBar playerHP1;
	
	@FXML
	private ProgressBar playerHP2;
	
	@FXML
	private Label hpLabel;
	
	@FXML
	private Label hpLabel2;
	
	@FXML
	private Label userLabel1;
	
	@FXML
	private Label userLabel2;
	
	@FXML
	private ImageView charView;
	
	@FXML
	private ImageView charView2;
	
	@FXML
	private AnchorPane scenePane;
	
	@FXML
	private RadioButton rButton1, rButton2, rButton3;
	
	@FXML
	private Label questionLabel;
	
	@FXML
	private Label roundLabel;
	
	@FXML
	private ImageView userSign1;
	
	@FXML
	private ImageView userSign2;
	
	private File directory;
	private File directory2;
	private File[] files;
	private File[] files2;
	
	private Media media;
	private Media media2;
	private MediaPlayer mediaPlayer;
	private MediaPlayer mediaPlayer2;
	
	private ArrayList<File> songs;
	private ArrayList<File> songs2;
	
	private ToggleGroup altChoice;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	int y1 = 262;
	int y2 = 346;
	int y3 = 431;
	int round = 0;
	
	double points = 100.0;
	double points2 = 100.0;
	
	public void decreaseBar(MouseEvent event) throws IOException {
		
		if(points > 0.0) {
			points -= 5;
			playerHP1.setProgress(points);
			hpLabel.setText(Double.toString(Math.round(points)) + "%");
			if(points <= 0) {
				String username = userLabel1.getText();
				String username2 = userLabel2.getText();
				Image image = charView.getImage();
				Image image2 = charView2.getImage();
				String score = hpLabel.getText();
				String score2 = hpLabel2.getText();

				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
				root = loader.load();
				
				Scene4Controller scene4Controller = loader.getController();
				scene4Controller.displayName(username);
				scene4Controller.displayName2(username2);
				scene4Controller.displayImage(image);
				scene4Controller.displayImage2(image2);
				scene4Controller.displayScore(score);
				scene4Controller.displayScore2(score2);
				
				//Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
	}
	public void decreaseBar2(MouseEvent event) throws IOException {	
		if(points2 > 0.0) {
			points2 -= 5;
			playerHP2.setProgress(points2);
			hpLabel2.setText(Double.toString(Math.round(points2)) + "%");
			if(points <= 0) {
				String username = userLabel1.getText();
				String username2 = userLabel2.getText();
				Image image = charView.getImage();
				Image image2 = charView2.getImage();
				String score = hpLabel.getText();
				String score2 = hpLabel2.getText();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
				root = loader.load();
				
				Scene4Controller scene4Controller = loader.getController();
				scene4Controller.displayName(username);
				scene4Controller.displayName2(username2);
				scene4Controller.displayImage(image);
				scene4Controller.displayImage2(image2);
				scene4Controller.displayScore(score);
				scene4Controller.displayScore2(score2);
				
				//Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
	}
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
	public void initialize(URL url, ResourceBundle rb) {
		altChoice = new ToggleGroup();
		this.rButton1.setToggleGroup(altChoice);
		this.rButton2.setToggleGroup(altChoice);
		this.rButton3.setToggleGroup(altChoice);
	}
	public void p1Visible(ActionEvent event) {
		userSign1.setVisible(true);
		userLabel1.setVisible(true);
		charView.setVisible(true);
		playerHP1.setVisible(true);
		hpLabel.setVisible(true);
		userSign2.setVisible(false);
		userLabel2.setVisible(false);
		charView2.setVisible(false);
		playerHP2.setVisible(false);
		hpLabel2.setVisible(false);	
	}
	public void p2Visible(ActionEvent event) {
		userSign1.setVisible(false);
		userLabel1.setVisible(false);
		charView.setVisible(false);
		playerHP1.setVisible(false);
		hpLabel.setVisible(false);
		userSign2.setVisible(true);
		userLabel2.setVisible(true);
		charView2.setVisible(true);
		playerHP2.setVisible(true);
		hpLabel2.setVisible(true);
	}
	public void confirm(ActionEvent event) throws IOException {
		round ++;
		
		if(rButton1.isSelected()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm");
			alert.setHeaderText("Confirm your choice");
			alert.setContentText("Are you sure about your answer?");
			
			ButtonType yesButton = new ButtonType("Yes");
			ButtonType noButton = new ButtonType("No");
			
			alert.getButtonTypes().setAll(yesButton, noButton);
			
			Optional<ButtonType> result = alert.showAndWait();
		
			if(result.get() == noButton) {
				round--;
			}
			else if(result.get() == yesButton) {
				Alert alert1 = new Alert(AlertType.INFORMATION);
				alert1.setTitle("Congrats!");
				alert1.setHeaderText("You chose the right answer!");
				alert1.setContentText("You may now pass your turn");
				this.rightAnswer(null, null);
				
				
				if(alert1.showAndWait().get() == ButtonType.OK) {
					rButton1.setSelected(false);
					if(round == 1) {
						questionLabel.setText("Qual das seguintes entidades provavelmente tem atributos inv??lidos?");
						rButton1.setText("Entidade: Car. Atributos: Owner Occupation, Owner Salary, Speed");
						rButton1.setLayoutY(y1);
						rButton2.setText("Entidade: Pet. Atributos: Name, Birthdate, Owner");
						rButton2.setLayoutY(y3);
						rButton3.setText("Entidade: Mother. Atributos: Name, Birthdate, Occupation, Number of Children");
						rButton3.setLayoutY(y2);
						this.p2Visible(null);
						
					}
					else if(round == 2) {
					questionLabel.setText("Quando da especifica????o de um determinado caso de uso utilizando UML, um Programador de Sistemas teve que definir que o caso de uso Procura n??mero do processo era essencial para o comportamento do caso de uso Consulta solicitada por advogado. Conhecedor das representa????es UML, entre os referidos casos de uso, ele corretamente utilizou o relacionamento");
					rButton1.setText("include");
					rButton1.setLayoutY(y2);
					rButton2.setText("generalization");
					rButton2.setLayoutY(y3);
					rButton3.setText("extend");
					rButton3.setLayoutY(y1);
					this.p1Visible(null);
					}
					else if(round == 3) {
						questionLabel.setText("No desenho do projeto de um banco de dados para o sistema de uma organiza????o ?? necess??rio, primeiramente, um entendimento claro das necessidades do usu??rio pela equipe do projeto. Em segundo lugar ?? necess??rio definir o SGBD (Sistema Gerenciador de Banco de Dados) que ser?? utilizado para facilitar a manipula????o das informa????es entre o banco de dados e o sistema. Por fim, na terceira etapa ?? definido o Modelo de dados dividido em 3 fases. Assinale a alternativa que apresenta a descri????o correta do que ?? realizado em uma determinada fase do modelo de dados.");
						rButton1.setText("Na fase 2, o modelo conceitual deve ser criado levando em conta a constru????o do modelo l??gico.");
						rButton1.setLayoutY(y3);
						rButton2.setText("- Na fase 3 (projeto f??sico) h?? o desenho do diagrama de entidade e relacionamento (DER) para mapear quais dados devem ser manipulados no sistema.");
						rButton2.setLayoutY(y1);
						rButton3.setText("Na fase 1 (modelagem conceitual) h?? uma descri????o do banco de dados de forma independente de implementa????o do sistema.");
						rButton3.setLayoutY(y2);
						this.p2Visible(null);
					}
					else if(round == 4) {
						questionLabel.setText("Em Programa????o Orientada a Objetos, imagine uma classe chamada Pessoa que possua atributos e m??todos comuns a outras classes, como por exemplo, Aluno, Professor, Funcion??rio e outros. Ent??o ?? poss??vel tornar a classe Pessoa em uma superclasse. Neste contexto, a liga????o entre Aluno e Pessoa, dentro da implementa????o, chama-se:");
						rButton1.setText("Heran??a");
						rButton1.setLayoutY(y1);
						rButton2.setText("Associa????o");
						rButton2.setLayoutY(y3);
						rButton3.setText("Encapsulamento");
						rButton3.setLayoutY(y2);
						this.p1Visible(null);
					}
					else if(round == 5) {
						questionLabel.setText("Sobre a programa????o orientada a objetos, qual das afirma????es a seguir ?? verdadeira:");
						rButton1.setText("Quando criamos um objeto estamos instanciando uma classe.");
						rButton1.setLayoutY(y3);
						rButton2.setText("Quando criamos um objeto estamos instanciando um atributo.");
						rButton2.setLayoutY(y1);
						rButton3.setText("Somente classes p??blicas podem ser instanciadas.");
						rButton3.setLayoutY(y2);
						this.p2Visible(null);
					}
					else if(round == 6) {
						questionLabel.setText("Na paradigma de Programa????o Orienta????o a Objetos em Java, para que um atributo de uma classe Funcion??rio possa ser acessado apenas por qualquer m??todo de Funcion??rio ou por qualquer m??todo definido em subclasses de Funcion??rio, sua visibilidade deve ser:");
						rButton1.setText("protegida (protected)");
						rButton1.setLayoutY(y1);
						rButton2.setText("privada (private)");
						rButton2.setLayoutY(y2);
						rButton3.setText("est??tica (static)");
						rButton3.setLayoutY(y3);
						this.p1Visible(null);
					}
					else if(round == 7) {
						questionLabel.setText("Quando estamos falando sobre sistemas que manipulam dados em um SGBD, existem quatro opera????es b??sicas que os desenvolvedores precisam implementar, conhecidas pelo acr??nimo CRUD (Create, Read, Update, Delete). Sendo que cada uma dessas opera????es podem ser associadas a um comando SQL. Selecione entre as alternativas, a que apresenta essa rela????o corretamente, na mesma sequ??ncia das opera????es CRUD.");
						rButton1.setText("INSERT, SELECT, UPDATE, DELETE");
						rButton1.setLayoutY(y3);
						rButton2.setText("INSERT, SELECT, UPDATE, DESTROY");
						rButton2.setLayoutY(y1);
						rButton3.setText("INSERT, RETRIEVE, MODIFY, DELETE");
						rButton3.setLayoutY(y2);
						this.p2Visible(null);
					}
					else if(round == 8) {
						questionLabel.setText("Na programa????o orientada a objetos (POO), uma a????o executada por um objeto quando passada uma mensagem ou em resposta a uma mudan??a de estado representa o conceito de  ");
						rButton1.setText("comportamento.");
						rButton1.setLayoutY(y1);
						rButton2.setText("mutante.");
						rButton2.setLayoutY(y3);
						rButton3.setText("construtor.");
						rButton3.setLayoutY(y2);
						this.p1Visible(null);
					}
					else if(round == 9) {
						questionLabel.setText("Em programa????o orientada a objetos, m??todos de acesso do tipo setter t??m a finalidade prim??ria de");
						rButton1.setText("modificar o valor de um atributo.");
						rButton1.setLayoutY(y3);
						rButton2.setText("obter o valor de um atributo.");
						rButton2.setLayoutY(y1);
						rButton3.setText("inicializar os valores de atributos de um objeto assim que ele ?? instanciado.");
						rButton3.setLayoutY(y2);
						this.p2Visible(null);
					}
					else if(round == 10) {
						questionLabel.setText("Quando se diz que uma classe ???Pessoa??? estende a classe ???Humano???, em Programa????o Orientada a Objetos, estamos afirmando o mesmo que");
						rButton1.setText("a classe ???Pessoa??? deriva da classe ???Humano???. ");
						rButton1.setLayoutY(y3);
						rButton2.setText("a classe ???Humano??? ?? subclasse de ???Pessoa???. ");
						rButton2.setLayoutY(y2);
						rButton3.setText("as classes s??o ditas como ???irm??s???. ");
						rButton3.setLayoutY(y1);
						this.p1Visible(null);
					}
					else if(round == 11) {
						questionLabel.setText("__________ ?? um m??todo chamado no momento da cria????o do objeto, ou seja, no momento em que ?? utilizado no comando new. Este m??todo promove a inicializa????o do objeto, de forma que, o objetivo ap??s essa inicializa????o, j?? se encontra logicamente consistente. Complete a lacuna com a alternativa CORRETA relacionada ao m??todo da programa????o orientada ?? objetos.");
						rButton1.setText("Construtor.");
						rButton1.setLayoutY(y2);
						rButton2.setText("Destrutor.");
						rButton2.setLayoutY(y1);
						rButton3.setText("Qualificador.");
						rButton3.setLayoutY(y3);
						this.p2Visible(null);
					}
					else if(round == 12) {
						questionLabel.setText("Orienta????o a objetos ?? um paradigma de an??lise, projeto e programa????o de sistemas de software baseado na composi????o e intera????o entre diversas unidades de software chamadas objetos. Marque a alternativa INCORRETA com rela????o a programa????o de orienta????o a objetos.");
						rButton1.setText("Declarar um objeto ?? o mesmo que instanciar um objeto.");
						rButton1.setLayoutY(y3);
						rButton2.setText("Os pacotes s??o pastas as quais podemos guardar arquivos (classes).");
						rButton2.setLayoutY(y1);
						rButton3.setText("O comportamento de um objeto ?? definido pelos m??todos de sua classe.");
						rButton3.setLayoutY(y2);
						this.p1Visible(null);
					}
					else if(round == 13) {
						questionLabel.setText("Considerando os conceitos de Heran??a, presentes na linguagem orientada a objetos Java, ?? correto afirmar que:");
						rButton1.setText("podem existir m??todos na classe pai que n??o sejam vis??veis na subclasse");
						rButton1.setLayoutY(y1);
						rButton2.setText("os m??todos de classe podem realizar opera????es somente na classe pai ");
						rButton2.setLayoutY(y3);
						rButton3.setText("uma vantagem da heran??a como forma de aumentar a possibilidade de reuso ?? que ela cria depend??ncias entre classes em uma hierarquia ");
						rButton3.setLayoutY(y2);
						this.p2Visible(null);
					}
					else if(round == 14) {
						questionLabel.setText("A respeito das linguagens de programa????o orientadas a objeto, ?? correto afirmar que");
						rButton1.setText("o m??todo conhecido como construtor ?? executado sempre que um objeto ?? criado.");
						rButton1.setLayoutY(y2);
						rButton2.setText("o m??todo conhecido como construtor ?? caracterizado como uma fun????o que sempre retorna um valor diferente.");
						rButton2.setLayoutY(y1);
						rButton3.setText("o polimorfismo ?? o conceito utilizado para definir fun????es de nomes diferentes, por??m com c??digos iguais.");
						rButton3.setLayoutY(y3);
						this.p1Visible(null);
					}
					else if(round == 15) {
						questionLabel.setText("Considerando o paradigma orientado a objetos, o que ?? uma Inst??ncia de Classe?");
						rButton1.setText("Uma ocorr??ncia espec??fica de uma classe.");
						rButton1.setLayoutY(y3);
						rButton2.setText("Uma abstra????o de um objeto do mundo real.");
						rButton2.setLayoutY(y2);
						rButton3.setText("Uma vari??vel de tipo primitivo da classe.");
						rButton3.setLayoutY(y1);
						this.p2Visible(null);
					}
					else if(round == 16) {
						questionLabel.setText("Assinale a alternativa que apresenta uma motiva????o v??lida para a passagem de par??metro por valor para uma fun????o.");
						rButton1.setText("Garantia de que o valor da vari??vel original n??o ser?? alterado.");
						rButton1.setLayoutY(y1);
						rButton2.setText("Economia de mem??ria.");
						rButton2.setLayoutY(y3);
						rButton3.setText("Melhor desempenho.");
						rButton3.setLayoutY(y2);
						this.p1Visible(null);
					}
					else if(round == 17) {
						questionLabel.setText("Com relac??a??o a?? Orientac??a??o a Objeto, assinale a alternativa correta.");
						rButton1.setText("O polimorfismo permite que objetos distintos respondam a mesma mensagem, sendo adaptada para cada objeto.");
						rButton1.setLayoutY(y3);
						rButton2.setText("Heranc??a e?? o nome utilizado para indicar quando uma classe reimplementa o me??todo de outra classe.");
						rButton2.setLayoutY(y2);
						rButton3.setText("Uma classe e?? a representac??a??o dina??mica de um objeto do mundo virtual.");
						rButton3.setLayoutY(y1);
						this.p2Visible(null);
					}
					else if(round == 18) {
						questionLabel.setText(" No modelo relacional, os dados s??o organizados em uma estrutura de armazenamento b??sica denominada ___________.");
						rButton1.setText("Tabela");
						rButton1.setLayoutY(y2);
						rButton2.setText("Linha");
						rButton2.setLayoutY(y3);
						rButton3.setText("Campos");
						rButton3.setLayoutY(y1);
						this.p1Visible(null);
					}
					else if(round == 19) {
						questionLabel.setText("Qual das afirmativas a seguir n??o se aplica a bancos de dados relacionais?");
						rButton1.setText("Os bancos de dados relacionais t??m uma forte orienta????o processual.");
						rButton1.setLayoutY(y1);
						rButton2.setText("Os bancos de dados relacionais s??o de f??cil compreens??o.");
						rButton2.setLayoutY(y2);
						rButton3.setText("Os bancos de dados relacionais fazem a correspond??ncia entre as tabelas usando campos comuns chamados chaves.");
						rButton3.setLayoutY(y3);
						this.p2Visible(null);
					}
					else if(round > 19) {
						String username = userLabel1.getText();
						String username2 = userLabel2.getText();
						Image image = charView.getImage();
						Image image2 = charView2.getImage();
						String score = hpLabel.getText();
						String score2 = hpLabel2.getText();
						
						FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
						root = loader.load();
						
						Scene4Controller scene4Controller = loader.getController();
						scene4Controller.displayName(username);
						scene4Controller.displayName2(username2);
						scene4Controller.displayImage(image);
						scene4Controller.displayImage2(image2);
						scene4Controller.displayScore(score);
						scene4Controller.displayScore2(score2);
						
						//Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
					}
				}
			}		
		}	
		if(rButton2.isSelected()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm");
			alert.setHeaderText("Confirm your choice");
			alert.setContentText("Are you sure about your answer?");
			
			ButtonType yesButton = new ButtonType("Yes");
			ButtonType noButton = new ButtonType("No");
			
			alert.getButtonTypes().setAll(yesButton, noButton);
			
			Optional<ButtonType> result = alert.showAndWait();
		
			if(result.get() == noButton) {
				round--;
			}
			else if(result.get() == yesButton) {
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Oopsie!");
				alert2.setHeaderText("You chose the wrong answer!");
				alert2.setContentText("Right answer was ''" + rButton1.getText() + "''");
				this.wrongAnswer(null, null);
				
				if(alert2.showAndWait().get() == ButtonType.OK) {
					rButton2.setSelected(false);
					if(round == 1) {
						questionLabel.setText("Qual das seguintes entidades provavelmente tem atributos inv??lidos?");
						rButton1.setText("Entidade: Car. Atributos: Owner Occupation, Owner Salary, Speed");
						rButton1.setLayoutY(y1);
						rButton2.setText("Entidade: Pet. Atributos: Name, Birthdate, Owner");
						rButton2.setLayoutY(y3);
						rButton3.setText("Entidade: Mother. Atributos: Name, Birthdate, Occupation, Number of Children");
						rButton3.setLayoutY(y2);
						this.decreaseBar(null);
						this.p2Visible(null);
					}
						else if(round == 2) {
						questionLabel.setText("Quando da especifica????o de um determinado caso de uso utilizando UML, um Programador de Sistemas teve que definir que o caso de uso Procura n??mero do processo era essencial para o comportamento do caso de uso Consulta solicitada por advogado. Conhecedor das representa????es UML, entre os referidos casos de uso, ele corretamente utilizou o relacionamento");
						rButton1.setText("include");
						rButton1.setLayoutY(y2);
						rButton2.setText("generalization");
						rButton2.setLayoutY(y3);
						rButton3.setText("extend");
						rButton3.setLayoutY(y1);
						this.decreaseBar2(null);
						this.p1Visible(null);
						}
						else if(round == 3) {
							questionLabel.setText("No desenho do projeto de um banco de dados para o sistema de uma organiza????o ?? necess??rio, primeiramente, um entendimento claro das necessidades do usu??rio pela equipe do projeto. Em segundo lugar ?? necess??rio definir o SGBD (Sistema Gerenciador de Banco de Dados) que ser?? utilizado para facilitar a manipula????o das informa????es entre o banco de dados e o sistema. Por fim, na terceira etapa ?? definido o Modelo de dados dividido em 3 fases. Assinale a alternativa que apresenta a descri????o correta do que ?? realizado em uma determinada fase do modelo de dados.");
							rButton1.setText("Na fase 2, o modelo conceitual deve ser criado levando em conta a constru????o do modelo l??gico.");
							rButton1.setLayoutY(y3);
							rButton2.setText("- Na fase 3 (projeto f??sico) h?? o desenho do diagrama de entidade e relacionamento (DER) para mapear quais dados devem ser manipulados no sistema.");
							rButton2.setLayoutY(y1);
							rButton3.setText("Na fase 1 (modelagem conceitual) h?? uma descri????o do banco de dados de forma independente de implementa????o do sistema.");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 4) {
							questionLabel.setText("Em Programa????o Orientada a Objetos, imagine uma classe chamada Pessoa que possua atributos e m??todos comuns a outras classes, como por exemplo, Aluno, Professor, Funcion??rio e outros. Ent??o ?? poss??vel tornar a classe Pessoa em uma superclasse. Neste contexto, a liga????o entre Aluno e Pessoa, dentro da implementa????o, chama-se:");
							rButton1.setText("Heran??a");
							rButton1.setLayoutY(y1);
							rButton2.setText("Associa????o");
							rButton2.setLayoutY(y3);
							rButton3.setText("Encapsulamento");
							rButton3.setLayoutY(y2);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 5) {
							questionLabel.setText("Sobre a programa????o orientada a objetos, qual das afirma????es a seguir ?? verdadeira:");
							rButton1.setText("Quando criamos um objeto estamos instanciando uma classe.");
							rButton1.setLayoutY(y3);
							rButton2.setText("Quando criamos um objeto estamos instanciando um atributo.");
							rButton2.setLayoutY(y1);
							rButton3.setText("Somente classes p??blicas podem ser instanciadas.");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 6) {
							questionLabel.setText("Na paradigma de Programa????o Orienta????o a Objetos em Java, para que um atributo de uma classe Funcion??rio possa ser acessado apenas por qualquer m??todo de Funcion??rio ou por qualquer m??todo definido em subclasses de Funcion??rio, sua visibilidade deve ser:");
							rButton1.setText("protegida (protected)");
							rButton1.setLayoutY(y1);
							rButton2.setText("privada (private)");
							rButton2.setLayoutY(y2);
							rButton3.setText("est??tica (static)");
							rButton3.setLayoutY(y3);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 7) {
							questionLabel.setText("Quando estamos falando sobre sistemas que manipulam dados em um SGBD, existem quatro opera????es b??sicas que os desenvolvedores precisam implementar, conhecidas pelo acr??nimo CRUD (Create, Read, Update, Delete). Sendo que cada uma dessas opera????es podem ser associadas a um comando SQL. Selecione entre as alternativas, a que apresenta essa rela????o corretamente, na mesma sequ??ncia das opera????es CRUD.");
							rButton1.setText("INSERT, SELECT, UPDATE, DELETE");
							rButton1.setLayoutY(y3);
							rButton2.setText("INSERT, SELECT, UPDATE, DESTROY");
							rButton2.setLayoutY(y1);
							rButton3.setText("INSERT, RETRIEVE, MODIFY, DELETE");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 8) {
							questionLabel.setText("Na programa????o orientada a objetos (POO), uma a????o executada por um objeto quando passada uma mensagem ou em resposta a uma mudan??a de estado representa o conceito de  ");
							rButton1.setText("comportamento.");
							rButton1.setLayoutY(y1);
							rButton2.setText("mutante.");
							rButton2.setLayoutY(y3);
							rButton3.setText("construtor.");
							rButton3.setLayoutY(y2);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 9) {
							questionLabel.setText("Em programa????o orientada a objetos, m??todos de acesso do tipo setter t??m a finalidade prim??ria de");
							rButton1.setText("modificar o valor de um atributo.");
							rButton1.setLayoutY(y3);
							rButton2.setText("obter o valor de um atributo.");
							rButton2.setLayoutY(y1);
							rButton3.setText("inicializar os valores de atributos de um objeto assim que ele ?? instanciado.");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 10) {
							questionLabel.setText("Quando se diz que uma classe ???Pessoa??? estende a classe ???Humano???, em Programa????o Orientada a Objetos, estamos afirmando o mesmo que");
							rButton1.setText("a classe ???Pessoa??? deriva da classe ???Humano???. ");
							rButton1.setLayoutY(y3);
							rButton2.setText("a classe ???Humano??? ?? subclasse de ???Pessoa???. ");
							rButton2.setLayoutY(y2);
							rButton3.setText("as classes s??o ditas como ???irm??s???. ");
							rButton3.setLayoutY(y1);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 11) {
							questionLabel.setText("__________ ?? um m??todo chamado no momento da cria????o do objeto, ou seja, no momento em que ?? utilizado no comando new. Este m??todo promove a inicializa????o do objeto, de forma que, o objetivo ap??s essa inicializa????o, j?? se encontra logicamente consistente. Complete a lacuna com a alternativa CORRETA relacionada ao m??todo da programa????o orientada ?? objetos.");
							rButton1.setText("Construtor.");
							rButton1.setLayoutY(y2);
							rButton2.setText("Destrutor.");
							rButton2.setLayoutY(y1);
							rButton3.setText("Qualificador.");
							rButton3.setLayoutY(y3);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 12) {
							questionLabel.setText("Orienta????o a objetos ?? um paradigma de an??lise, projeto e programa????o de sistemas de software baseado na composi????o e intera????o entre diversas unidades de software chamadas objetos. Marque a alternativa INCORRETA com rela????o a programa????o de orienta????o a objetos.");
							rButton1.setText("Declarar um objeto ?? o mesmo que instanciar um objeto.");
							rButton1.setLayoutY(y3);
							rButton2.setText("Os pacotes s??o pastas as quais podemos guardar arquivos (classes).");
							rButton2.setLayoutY(y1);
							rButton3.setText("O comportamento de um objeto ?? definido pelos m??todos de sua classe.");
							rButton3.setLayoutY(y2);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 13) {
							questionLabel.setText("Considerando os conceitos de Heran??a, presentes na linguagem orientada a objetos Java, ?? correto afirmar que:");
							rButton1.setText("podem existir m??todos na classe pai que n??o sejam vis??veis na subclasse");
							rButton1.setLayoutY(y1);
							rButton2.setText("os m??todos de classe podem realizar opera????es somente na classe pai ");
							rButton2.setLayoutY(y3);
							rButton3.setText("uma vantagem da heran??a como forma de aumentar a possibilidade de reuso ?? que ela cria depend??ncias entre classes em uma hierarquia ");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 14) {
							questionLabel.setText("A respeito das linguagens de programa????o orientadas a objeto, ?? correto afirmar que");
							rButton1.setText("o m??todo conhecido como construtor ?? executado sempre que um objeto ?? criado.");
							rButton1.setLayoutY(y2);
							rButton2.setText("o m??todo conhecido como construtor ?? caracterizado como uma fun????o que sempre retorna um valor diferente.");
							rButton2.setLayoutY(y1);
							rButton3.setText("o polimorfismo ?? o conceito utilizado para definir fun????es de nomes diferentes, por??m com c??digos iguais.");
							rButton3.setLayoutY(y3);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 15) {
							questionLabel.setText("Considerando o paradigma orientado a objetos, o que ?? uma Inst??ncia de Classe?");
							rButton1.setText("Uma ocorr??ncia espec??fica de uma classe.");
							rButton1.setLayoutY(y3);
							rButton2.setText("Uma abstra????o de um objeto do mundo real.");
							rButton2.setLayoutY(y2);
							rButton3.setText("Uma vari??vel de tipo primitivo da classe.");
							rButton3.setLayoutY(y1);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 16) {
							questionLabel.setText("Assinale a alternativa que apresenta uma motiva????o v??lida para a passagem de par??metro por valor para uma fun????o.");
							rButton1.setText("Garantia de que o valor da vari??vel original n??o ser?? alterado.");
							rButton1.setLayoutY(y1);
							rButton2.setText("Economia de mem??ria.");
							rButton2.setLayoutY(y3);
							rButton3.setText("Melhor desempenho.");
							rButton3.setLayoutY(y2);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 17) {
							questionLabel.setText("Com relac??a??o a?? Orientac??a??o a Objeto, assinale a alternativa correta.");
							rButton1.setText("O polimorfismo permite que objetos distintos respondam a mesma mensagem, sendo adaptada para cada objeto.");
							rButton1.setLayoutY(y3);
							rButton2.setText("Heranc??a e?? o nome utilizado para indicar quando uma classe reimplementa o me??todo de outra classe.");
							rButton2.setLayoutY(y2);
							rButton3.setText("Uma classe e?? a representac??a??o dina??mica de um objeto do mundo virtual.");
							rButton3.setLayoutY(y1);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 18) {
							questionLabel.setText(" No modelo relacional, os dados s??o organizados em uma estrutura de armazenamento b??sica denominada ___________.");
							rButton1.setText("Tabela");
							rButton1.setLayoutY(y2);
							rButton2.setText("Linha");
							rButton2.setLayoutY(y3);
							rButton3.setText("Campos");
							rButton3.setLayoutY(y1);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 19) {
							questionLabel.setText("Qual das afirmativas a seguir n??o se aplica a bancos de dados relacionais?");
							rButton1.setText("Os bancos de dados relacionais t??m uma forte orienta????o processual.");
							rButton1.setLayoutY(y1);
							rButton2.setText("Os bancos de dados relacionais s??o de f??cil compreens??o.");
							rButton2.setLayoutY(y2);
							rButton3.setText("Os bancos de dados relacionais fazem a correspond??ncia entre as tabelas usando campos comuns chamados chaves.");
							rButton3.setLayoutY(y3);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round > 19) {
							String username = userLabel1.getText();
							String username2 = userLabel2.getText();
							Image image = charView.getImage();
							Image image2 = charView2.getImage();
							String score = hpLabel.getText();
							String score2 = hpLabel2.getText();
							
							FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
							root = loader.load();
							
							Scene4Controller scene4Controller = loader.getController();
							scene4Controller.displayName(username);
							scene4Controller.displayName2(username2);
							scene4Controller.displayImage(image);
							scene4Controller.displayImage2(image2);
							scene4Controller.displayScore(score);
							scene4Controller.displayScore2(score2);
							
							//Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
							stage = (Stage)((Node)event.getSource()).getScene().getWindow();
							scene = new Scene(root);
							stage.setScene(scene);
							stage.show();
						}
				}
			}
		}
		if(rButton3.isSelected()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm");
			alert.setHeaderText("Confirm your choice");
			alert.setContentText("Are you sure about your answer?");
			
			ButtonType yesButton = new ButtonType("Yes");
			ButtonType noButton = new ButtonType("No");
			
			alert.getButtonTypes().setAll(yesButton, noButton);
			
			Optional<ButtonType> result = alert.showAndWait();
		
			if(result.get() == noButton) {
				round--;
			}
			else if(result.get() == yesButton) {
				Alert alert3 = new Alert(AlertType.INFORMATION);
				alert3.setTitle("Oopsie!");
				alert3.setHeaderText("You chose the wrong answer!");
				alert3.setContentText("Right answer was ''" + rButton1.getText() + "''");
				this.wrongAnswer(null, null);				
				
				if(alert3.showAndWait().get() == ButtonType.OK) {
					rButton3.setSelected(false);
					
					if(round == 1) {
						questionLabel.setText("Qual das seguintes entidades provavelmente tem atributos inv??lidos?");
						rButton1.setText("Entidade: Car. Atributos: Owner Occupation, Owner Salary, Speed");
						rButton1.setLayoutY(y1);
						rButton2.setText("Entidade: Pet. Atributos: Name, Birthdate, Owner");
						rButton2.setLayoutY(y3);
						rButton3.setText("Entidade: Mother. Atributos: Name, Birthdate, Occupation, Number of Children");
						rButton3.setLayoutY(y2);
						this.decreaseBar(null);
						this.p2Visible(null);
					}
						else if(round == 2) {
						questionLabel.setText("Quando da especifica????o de um determinado caso de uso utilizando UML, um Programador de Sistemas teve que definir que o caso de uso Procura n??mero do processo era essencial para o comportamento do caso de uso Consulta solicitada por advogado. Conhecedor das representa????es UML, entre os referidos casos de uso, ele corretamente utilizou o relacionamento");
						rButton1.setText("include");
						rButton1.setLayoutY(y2);
						rButton2.setText("generalization");
						rButton2.setLayoutY(y3);
						rButton3.setText("extend");
						rButton3.setLayoutY(y1);
						this.decreaseBar2(null);
						this.p1Visible(null);
						}
						else if(round == 3) {
							questionLabel.setText("No desenho do projeto de um banco de dados para o sistema de uma organiza????o ?? necess??rio, primeiramente, um entendimento claro das necessidades do usu??rio pela equipe do projeto. Em segundo lugar ?? necess??rio definir o SGBD (Sistema Gerenciador de Banco de Dados) que ser?? utilizado para facilitar a manipula????o das informa????es entre o banco de dados e o sistema. Por fim, na terceira etapa ?? definido o Modelo de dados dividido em 3 fases. Assinale a alternativa que apresenta a descri????o correta do que ?? realizado em uma determinada fase do modelo de dados.");
							rButton1.setText("Na fase 2, o modelo conceitual deve ser criado levando em conta a constru????o do modelo l??gico.");
							rButton1.setLayoutY(y3);
							rButton2.setText("- Na fase 3 (projeto f??sico) h?? o desenho do diagrama de entidade e relacionamento (DER) para mapear quais dados devem ser manipulados no sistema.");
							rButton2.setLayoutY(y1);
							rButton3.setText("Na fase 1 (modelagem conceitual) h?? uma descri????o do banco de dados de forma independente de implementa????o do sistema.");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 4) {
							questionLabel.setText("Em Programa????o Orientada a Objetos, imagine uma classe chamada Pessoa que possua atributos e m??todos comuns a outras classes, como por exemplo, Aluno, Professor, Funcion??rio e outros. Ent??o ?? poss??vel tornar a classe Pessoa em uma superclasse. Neste contexto, a liga????o entre Aluno e Pessoa, dentro da implementa????o, chama-se:");
							rButton1.setText("Heran??a");
							rButton1.setLayoutY(y1);
							rButton2.setText("Associa????o");
							rButton2.setLayoutY(y3);
							rButton3.setText("Encapsulamento");
							rButton3.setLayoutY(y2);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 5) {
							questionLabel.setText("Sobre a programa????o orientada a objetos, qual das afirma????es a seguir ?? verdadeira:");
							rButton1.setText("Quando criamos um objeto estamos instanciando uma classe.");
							rButton1.setLayoutY(y3);
							rButton2.setText("Quando criamos um objeto estamos instanciando um atributo.");
							rButton2.setLayoutY(y1);
							rButton3.setText("Somente classes p??blicas podem ser instanciadas.");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 6) {
							questionLabel.setText("Na paradigma de Programa????o Orienta????o a Objetos em Java, para que um atributo de uma classe Funcion??rio possa ser acessado apenas por qualquer m??todo de Funcion??rio ou por qualquer m??todo definido em subclasses de Funcion??rio, sua visibilidade deve ser:");
							rButton1.setText("protegida (protected)");
							rButton1.setLayoutY(y1);
							rButton2.setText("privada (private)");
							rButton2.setLayoutY(y2);
							rButton3.setText("est??tica (static)");
							rButton3.setLayoutY(y3);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 7) {
							questionLabel.setText("Quando estamos falando sobre sistemas que manipulam dados em um SGBD, existem quatro opera????es b??sicas que os desenvolvedores precisam implementar, conhecidas pelo acr??nimo CRUD (Create, Read, Update, Delete). Sendo que cada uma dessas opera????es podem ser associadas a um comando SQL. Selecione entre as alternativas, a que apresenta essa rela????o corretamente, na mesma sequ??ncia das opera????es CRUD.");
							rButton1.setText("INSERT, SELECT, UPDATE, DELETE");
							rButton1.setLayoutY(y3);
							rButton2.setText("INSERT, SELECT, UPDATE, DESTROY");
							rButton2.setLayoutY(y1);
							rButton3.setText("INSERT, RETRIEVE, MODIFY, DELETE");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 8) {
							questionLabel.setText("Na programa????o orientada a objetos (POO), uma a????o executada por um objeto quando passada uma mensagem ou em resposta a uma mudan??a de estado representa o conceito de  ");
							rButton1.setText("comportamento.");
							rButton1.setLayoutY(y1);
							rButton2.setText("mutante.");
							rButton2.setLayoutY(y3);
							rButton3.setText("construtor.");
							rButton3.setLayoutY(y2);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 9) {
							questionLabel.setText("Em programa????o orientada a objetos, m??todos de acesso do tipo setter t??m a finalidade prim??ria de");
							rButton1.setText("modificar o valor de um atributo.");
							rButton1.setLayoutY(y3);
							rButton2.setText("obter o valor de um atributo.");
							rButton2.setLayoutY(y1);
							rButton3.setText("inicializar os valores de atributos de um objeto assim que ele ?? instanciado.");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 10) {
							questionLabel.setText("Quando se diz que uma classe ???Pessoa??? estende a classe ???Humano???, em Programa????o Orientada a Objetos, estamos afirmando o mesmo que");
							rButton1.setText("a classe ???Pessoa??? deriva da classe ???Humano???. ");
							rButton1.setLayoutY(y3);
							rButton2.setText("a classe ???Humano??? ?? subclasse de ???Pessoa???. ");
							rButton2.setLayoutY(y2);
							rButton3.setText("as classes s??o ditas como ???irm??s???. ");
							rButton3.setLayoutY(y1);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 11) {
							questionLabel.setText("__________ ?? um m??todo chamado no momento da cria????o do objeto, ou seja, no momento em que ?? utilizado no comando new. Este m??todo promove a inicializa????o do objeto, de forma que, o objetivo ap??s essa inicializa????o, j?? se encontra logicamente consistente. Complete a lacuna com a alternativa CORRETA relacionada ao m??todo da programa????o orientada ?? objetos.");
							rButton1.setText("Construtor.");
							rButton1.setLayoutY(y2);
							rButton2.setText("Destrutor.");
							rButton2.setLayoutY(y1);
							rButton3.setText("Qualificador.");
							rButton3.setLayoutY(y3);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 12) {
							questionLabel.setText("Orienta????o a objetos ?? um paradigma de an??lise, projeto e programa????o de sistemas de software baseado na composi????o e intera????o entre diversas unidades de software chamadas objetos. Marque a alternativa INCORRETA com rela????o a programa????o de orienta????o a objetos.");
							rButton1.setText("Declarar um objeto ?? o mesmo que instanciar um objeto.");
							rButton1.setLayoutY(y3);
							rButton2.setText("Os pacotes s??o pastas as quais podemos guardar arquivos (classes).");
							rButton2.setLayoutY(y1);
							rButton3.setText("O comportamento de um objeto ?? definido pelos m??todos de sua classe.");
							rButton3.setLayoutY(y2);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 13) {
							questionLabel.setText("Considerando os conceitos de Heran??a, presentes na linguagem orientada a objetos Java, ?? correto afirmar que:");
							rButton1.setText("podem existir m??todos na classe pai que n??o sejam vis??veis na subclasse");
							rButton1.setLayoutY(y1);
							rButton2.setText("os m??todos de classe podem realizar opera????es somente na classe pai ");
							rButton2.setLayoutY(y3);
							rButton3.setText("uma vantagem da heran??a como forma de aumentar a possibilidade de reuso ?? que ela cria depend??ncias entre classes em uma hierarquia ");
							rButton3.setLayoutY(y2);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 14) {
							questionLabel.setText("A respeito das linguagens de programa????o orientadas a objeto, ?? correto afirmar que");
							rButton1.setText("o m??todo conhecido como construtor ?? executado sempre que um objeto ?? criado.");
							rButton1.setLayoutY(y2);
							rButton2.setText("o m??todo conhecido como construtor ?? caracterizado como uma fun????o que sempre retorna um valor diferente.");
							rButton2.setLayoutY(y1);
							rButton3.setText("o polimorfismo ?? o conceito utilizado para definir fun????es de nomes diferentes, por??m com c??digos iguais.");
							rButton3.setLayoutY(y3);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 15) {
							questionLabel.setText("Considerando o paradigma orientado a objetos, o que ?? uma Inst??ncia de Classe?");
							rButton1.setText("Uma ocorr??ncia espec??fica de uma classe.");
							rButton1.setLayoutY(y3);
							rButton2.setText("Uma abstra????o de um objeto do mundo real.");
							rButton2.setLayoutY(y2);
							rButton3.setText("Uma vari??vel de tipo primitivo da classe.");
							rButton3.setLayoutY(y1);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 16) {
							questionLabel.setText("Assinale a alternativa que apresenta uma motiva????o v??lida para a passagem de par??metro por valor para uma fun????o.");
							rButton1.setText("Garantia de que o valor da vari??vel original n??o ser?? alterado.");
							rButton1.setLayoutY(y1);
							rButton2.setText("Economia de mem??ria.");
							rButton2.setLayoutY(y3);
							rButton3.setText("Melhor desempenho.");
							rButton3.setLayoutY(y2);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 17) {
							questionLabel.setText("Com relac??a??o a?? Orientac??a??o a Objeto, assinale a alternativa correta.");
							rButton1.setText("O polimorfismo permite que objetos distintos respondam a mesma mensagem, sendo adaptada para cada objeto.");
							rButton1.setLayoutY(y3);
							rButton2.setText("Heranc??a e?? o nome utilizado para indicar quando uma classe reimplementa o me??todo de outra classe.");
							rButton2.setLayoutY(y2);
							rButton3.setText("Uma classe e?? a representac??a??o dina??mica de um objeto do mundo virtual.");
							rButton3.setLayoutY(y1);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round == 18) {
							questionLabel.setText(" No modelo relacional, os dados s??o organizados em uma estrutura de armazenamento b??sica denominada ___________.");
							rButton1.setText("Tabela");
							rButton1.setLayoutY(y2);
							rButton2.setText("Linha");
							rButton2.setLayoutY(y3);
							rButton3.setText("Campos");
							rButton3.setLayoutY(y1);
							this.decreaseBar2(null);
							this.p1Visible(null);
						}
						else if(round == 19) {
							questionLabel.setText("Qual das afirmativas a seguir n??o se aplica a bancos de dados relacionais?");
							rButton1.setText("Os bancos de dados relacionais t??m uma forte orienta????o processual.");
							rButton1.setLayoutY(y1);
							rButton2.setText("Os bancos de dados relacionais s??o de f??cil compreens??o.");
							rButton2.setLayoutY(y2);
							rButton3.setText("Os bancos de dados relacionais fazem a correspond??ncia entre as tabelas usando campos comuns chamados chaves.");
							rButton3.setLayoutY(y3);
							this.decreaseBar(null);
							this.p2Visible(null);
						}
						else if(round > 19) {
							String username = userLabel1.getText();
							String username2 = userLabel2.getText();
							Image image = charView.getImage();
							Image image2 = charView2.getImage();
							String score = hpLabel.getText();
							String score2 = hpLabel2.getText();
							
							FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
							root = loader.load();
							
							Scene4Controller scene4Controller = loader.getController();
							scene4Controller.displayName(username);
							scene4Controller.displayName2(username2);
							scene4Controller.displayImage(image);
							scene4Controller.displayImage2(image2);
							scene4Controller.displayScore(score);
							scene4Controller.displayScore2(score2);
							
							//Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
							stage = (Stage)((Node)event.getSource()).getScene().getWindow();
							scene = new Scene(root);
							stage.setScene(scene);
							stage.show();
						}
				}
			}
		}
	}
	public void stopGame(MouseEvent event) throws IOException {
		Alert stop = new Alert(AlertType.WARNING);
		stop.setTitle("Confirm");
		stop.setHeaderText("Both players must agree to end the match!");
		stop.setContentText("Are you two ok with this decision?");
		
		ButtonType yesButton = new ButtonType("Yes");
		ButtonType noButton = new ButtonType("No");
		
		stop.getButtonTypes().setAll(yesButton, noButton);
		
		Optional<ButtonType> result = stop.showAndWait();
		
		if(result.get() == yesButton) {
			hpLabel.setText(Double.toString(Math.round(points)) + "%");
			playerHP1.setProgress(points);
			hpLabel2.setText(Double.toString(Math.round(points2)) + "%");
			playerHP2.setProgress(points2);
			
			String username = userLabel1.getText();
			String username2 = userLabel2.getText();
			Image image = charView.getImage();
			Image image2 = charView2.getImage();
			String score = hpLabel.getText();
			String score2 = hpLabel2.getText();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
			root = loader.load();
			
			Scene4Controller scene4Controller = loader.getController();
			scene4Controller.displayName(username);
			scene4Controller.displayName2(username2);
			scene4Controller.displayImage(image);
			scene4Controller.displayImage2(image2);
			scene4Controller.displayScore(score);
			scene4Controller.displayScore2(score2);
			
			//Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else if(result.get() == noButton) {
			
			if(round % 2 == 0) {
				hpLabel.setText(Double.toString(Math.round(points - 15)) + "%");
				playerHP1.setProgress(points - 15);
				hpLabel2.setText(Double.toString(Math.round(points2 + 15)) + "%");
				playerHP2.setProgress(points2 + 15);
				
				String username = userLabel1.getText();
				String username2 = userLabel2.getText();
				Image image = charView.getImage();
				Image image2 = charView2.getImage();
				String score = hpLabel.getText();
				String score2 = hpLabel2.getText();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
				root = loader.load();
				
				Scene4Controller scene4Controller = loader.getController();
				scene4Controller.displayName(username);
				scene4Controller.displayName2(username2);
				scene4Controller.displayImage(image);
				scene4Controller.displayImage2(image2);
				scene4Controller.displayScore(score);
				scene4Controller.displayScore2(score2);
				
				//Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
			else if(round % 2 == 1) {
				hpLabel.setText(Double.toString(Math.round(points + 15)) + "%");
				playerHP1.setProgress(points + 15);
				hpLabel2.setText(Double.toString(Math.round(points2 - 15)) + "%");
				playerHP2.setProgress(points2 - 15);
				
				String username = userLabel1.getText();
				String username2 = userLabel2.getText();
				Image image = charView.getImage();
				Image image2 = charView2.getImage();
				String score = hpLabel.getText();
				String score2 = hpLabel2.getText();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
				root = loader.load();
				
				Scene4Controller scene4Controller = loader.getController();
				scene4Controller.displayName(username);
				scene4Controller.displayName2(username2);
				scene4Controller.displayImage(image);
				scene4Controller.displayImage2(image2);
				scene4Controller.displayScore(score);
				scene4Controller.displayScore2(score2);
				
				//Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}		
		}	
	}
	public void wrongAnswer(URL arg0, ResourceBundle arg1) {
		songs2 = new ArrayList<File>();		
		directory2 = new File("Wrong Answer");		
		files2 = directory2.listFiles();		
		if(files2 != null) {			
			for(File file2 : files2) {				
				songs2.add(file2);
			}
		}
		media2 = new Media(songs2.get(0).toURI().toString());
		mediaPlayer2 = new MediaPlayer(media2);
		mediaPlayer2.setVolume(0.015);
		mediaPlayer2.setCycleCount(1);
		mediaPlayer2.play();
	}
	public void rightAnswer(URL arg2, ResourceBundle arg3) {
		songs = new ArrayList<File>();		
		directory = new File("Right Answer");		
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
		mediaPlayer.play();
	}
}