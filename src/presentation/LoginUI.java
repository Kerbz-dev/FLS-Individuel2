package presentation;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.LoginVerification;

public class LoginUI  {

	public TextField userLoginField;
	public PasswordField passLoginField;
	public Button signupKnap;
	public Button loginKnap;
	private Label loginStatus;
	private Scene scene;
	private Pane pane;
	private Pane ferraripane;
	private Label ferrariLabel;
	private Stage loginStage;
	private GridPane gp;
	private Image ferrari;
	private ImageView ferraripic;

	public void start()  {
		loginStage = new Stage();
		loginStage.setTitle("Ferrari lånesystem");
		loginStage.getIcons().add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));
		
		ferrari = new Image("https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg");
		//ferrari = new Image("https://turbologo.com/articles/wp-content/uploads/2019/10/ferrari-logo-illustration-1280x720.jpg");
		ferraripic = new ImageView();
		// signupKnap.setText("Opret Login");
		// loginKnap.setText("Login");

		pane = new Pane();
		ferraripane = new Pane();

		// Button assignments
		ferrariLabel = new Label("FERRARI");
		signupKnap = new Button("Opret bruger");
		loginKnap = new Button("Login");
		userLoginField = new TextField();
		passLoginField = new PasswordField();
		loginStatus = new Label();
		// pane.setPrefHeight(800);
		// pane.setPrefWidth(600);
		// pane.setBackground(value);

		userLoginField.setPrefHeight(30);
		userLoginField.setPrefWidth(250);
		userLoginField.setFont(new Font(24));
		userLoginField.setPromptText("Username");
		userLoginField.relocate(97, 180);
		userLoginField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		
		passLoginField.setPrefHeight(51);
		passLoginField.setPrefWidth(250);
		passLoginField.relocate(97, 245);
		passLoginField.setFont(new Font(24));
		passLoginField.setPromptText("Password");
		passLoginField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		signupKnap.setPrefHeight(40);
		signupKnap.setPrefWidth(150);
		signupKnap.relocate(145, 418);
		signupKnap.setFont(new Font(18));

		loginKnap.setPrefHeight(40);
		loginKnap.setPrefWidth(150);
		loginKnap.relocate(145, 368);
		loginKnap.setFont(new Font(18));

		loginStatus.setPrefWidth(350);
		loginStatus.setFont(new Font(24));
		//loginStatus.relocate(100, 450);
		
		ferraripic.setFitWidth(250);
		ferraripic.setFitHeight(135);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(95, 15);
		
		
		
		
		ferraripane.setPrefHeight(64);
		ferraripane.setPrefWidth(428);
		pane.setStyle("-fx-background-color: #FF2800");
		//#CF0E0E
		ferrariLabel.relocate(170, 15);
		ferrariLabel.setFont(new Font(24));

		// Add to pane
		pane.getChildren().add(signupKnap);
		pane.getChildren().add(userLoginField);
		pane.getChildren().add(loginKnap);
		pane.getChildren().add(passLoginField);
		pane.getChildren().add(loginStatus);
		pane.getChildren().add(ferraripic);
		

		// Show scene
		scene = new Scene(pane, 428, 513);
		
		loginStage.setResizable(false);
		loginStage.setScene(scene);
		loginStage.show();
		
		// Action events
		loginKnap.setOnAction(e -> loginCheck());		
		signupKnap.setOnAction(e -> opretLoginUI()); 
		
}

	public void loginSuccess() {
		loginStatus.relocate(130, 315);
		loginStatus.setTextFill(Color.LIGHTGREEN);
		loginStatus.setText("Login successful!");

	}

	public void loginFail() {
		loginStatus.relocate(60, 315);
		loginStatus.setTextFill(Color.WHITESMOKE);
		loginStatus.setText("Wrong username or password");
	}
	public void loginCheck() {
		
		LoginVerification ctrl = new LoginVerification(this);
		
		ctrl.loginBtn();
	}
	
	public void opretLoginUI() {
		OpretLoginUI oprlogUI = new OpretLoginUI();
		oprlogUI.start();
	}
}
	



