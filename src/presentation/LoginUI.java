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


	public void start()  {
		loginStage = new Stage();
		loginStage.setTitle("Ferrari succ");
		

		// signupKnap.setText("Opret Login");
		// loginKnap.setText("Login");

		pane = new Pane();
		ferraripane = new Pane();

		// Button assignments
		ferrariLabel = new Label("FERRARI");
		signupKnap = new Button("Create user");
		loginKnap = new Button("Login");
		userLoginField = new TextField();
		passLoginField = new PasswordField();
		loginStatus = new Label();
		// pane.setPrefHeight(800);
		// pane.setPrefWidth(600);
		// pane.setBackground(value);

		userLoginField.setPrefHeight(30);
		userLoginField.setPrefWidth(214);
		userLoginField.setFont(new Font(24));
		userLoginField.setPromptText("Username");
		userLoginField.relocate(117, 149);

		passLoginField.setPrefHeight(51);
		passLoginField.setPrefWidth(214);
		passLoginField.relocate(117, 224);
		passLoginField.setFont(new Font(24));
		passLoginField.setPromptText("Password");

		signupKnap.setPrefHeight(40);
		signupKnap.setPrefWidth(154);
		signupKnap.relocate(148, 388);
		signupKnap.setFont(new Font(18));

		loginKnap.setPrefHeight(40);
		loginKnap.setPrefWidth(154);
		loginKnap.relocate(148, 319);
		loginKnap.setFont(new Font(18));

		loginStatus.setPrefWidth(350);
		loginStatus.setFont(new Font(24));
		//loginStatus.relocate(100, 450);
		
		
		ferraripane.setPrefHeight(64);
		ferraripane.setPrefWidth(428);
		ferraripane.setStyle("-fx-background-color: #ff2800");
		ferrariLabel.relocate(170, 15);
		ferrariLabel.setFont(new Font(24));
		ferraripane.getChildren().add(ferrariLabel);

		// Add to pane
		pane.getChildren().add(signupKnap);
		pane.getChildren().add(userLoginField);
		pane.getChildren().add(loginKnap);
		pane.getChildren().add(passLoginField);
		pane.getChildren().add(ferraripane);
		pane.getChildren().add(loginStatus);
		

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
		loginStatus.relocate(140, 450);
		loginStatus.setTextFill(Color.GREEN);
		loginStatus.setText("Login successful!");

	}

	public void loginFail() {
		loginStatus.relocate(60, 450);
		loginStatus.setTextFill(Color.RED);
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
	



