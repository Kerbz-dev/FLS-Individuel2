package presentation;

import db.Datakobling;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.OpretBruger;

public class OpretLoginUI {

	private Stage opretLoginStage;

	private TextField name;
	public TextField createUsername;
	public TextField createPassword;
	private Label opretLoginStatus;
	private Image ferrari;
	private ImageView ferraripic;
	private Button opretLoginKnap;
	private Scene scene2;
	private Pane pane2;
	// private BorderPane bp2;

	public void start() {
		opretLoginStage = new Stage();
		opretLoginStage.setTitle("Ferrari lånesystem");
		opretLoginStage.getIcons().add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));
		

		// bp2 = new BorderPane();
		pane2 = new Pane();
		opretLoginKnap = new Button("Opret medarbejder");
		opretLoginStatus = new Label();
		name = new TextField();
		createUsername = new TextField();
		createPassword = new TextField();
		ferrari = new Image("https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg");
		ferraripic = new ImageView();

		// name.setPrefHeight(30);
		// name.setPrefWidth(214);
		name.setFont(new Font(24));
		name.setPromptText("Medarbejder navn");
		name.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		name.relocate(150, 200);

		// createUsername.setPrefHeight(30);
		// createUsername.setPrefWidth(214);
		createUsername.setFont(new Font(24));
		createUsername.setPromptText("Brugernavn");
		createUsername.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		createUsername.relocate(150, 273);

		// createPassword.setPrefHeight(30);
		// createPassword.setPrefWidth(214);
		createPassword.setFont(new Font(24));
		createPassword.setPromptText("Password");
		createPassword.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		createPassword.relocate(150, 346);

		// OpretLoginKnap.setPrefHeight(40);
		// OpretLoginKnap.setPrefWidth(154);
		opretLoginKnap.relocate(180, 470);
		opretLoginKnap.setFont(new Font(24));

		opretLoginStatus.setFont(new Font(24));
		opretLoginStatus.setFont(new Font(30));
		
		ferraripic.setFitWidth(250);
		ferraripic.setFitHeight(135);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(173, 25);
		
		pane2.setStyle("-fx-background-color: #FF2800");


		// Add to pane
		pane2.getChildren().add(name);
		pane2.getChildren().add(createUsername);
		pane2.getChildren().add(createPassword);
		pane2.getChildren().add(opretLoginKnap);
		pane2.getChildren().add(opretLoginStatus);
		pane2.getChildren().add(ferraripic);
		// bp2.getChildren().add(pane2);

		// Show scene
		scene2 = new Scene(pane2, 600, 600);
		opretLoginStage.setResizable(false);
		opretLoginStage.setScene(scene2);
		opretLoginStage.show();

		// Action buttons
		opretLoginKnap.setOnAction(e -> opretBruger());

	}

	public void opretLoginSuccess() {
		opretLoginStatus.setTextFill(Color.LIGHTGREEN);
		opretLoginStatus.relocate(130, 410);
		opretLoginStatus.setText("Medarbejder blev oprettet!");
	}

	public void opretLoginFailAll() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(135, 410);
		opretLoginStatus.setText("Udfyld venligst alle felter");
	}
	
	public void opretLoginFailMNavn() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(95, 410);
		opretLoginStatus.setText("Udfyld venligst medarbejder navn");
	}
	public void opretLoginFailUserName() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(125, 410);
		opretLoginStatus.setText("Udfyld venligst brugernavn");
	}
	
	public void opretLoginFailPassword() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(130, 410);
		opretLoginStatus.setText("Udfyld venligst password");
	}
	
	public void opretLoginFailDuplicateBruger() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(150, 410);
		opretLoginStatus.setAlignment(Pos.CENTER);
		opretLoginStatus.setText("Bruger findes allerede");
	}

	private void opretBruger() {
		OpretBruger oprBruger = new OpretBruger(this);
		
		//oprBruger.opretBruger();
		oprBruger.createUserCheckDuplicate();
	}
	
	public String getName() {
		
		return name.getText();
	}
}
