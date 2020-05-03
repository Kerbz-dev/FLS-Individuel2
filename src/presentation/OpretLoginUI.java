package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.LoginVerification;
import logic.OpretBruger;

public class OpretLoginUI {

	private Stage OpretLG;

	public TextField name;
	public TextField createUsername;
	public TextField createPassword;
	private Label opretLoginStatus;
	private Button opretLoginKnap;
	private Scene scene2;
	private Pane pane2;
	// private BorderPane bp2;

	public void start() {
		OpretLG = new Stage();
		OpretLG.setTitle("Ferrari lånesystem");

		// bp2 = new BorderPane();
		pane2 = new Pane();

		opretLoginKnap = new Button("Opret medarbejder");
		opretLoginStatus = new Label();
		name = new TextField();
		createUsername = new TextField();
		createPassword = new TextField();

		// name.setPrefHeight(30);
		// name.setPrefWidth(214);
		name.setFont(new Font(24));
		name.setPromptText("Medarbejder navn");
		name.relocate(150, 76);

		// createUsername.setPrefHeight(30);
		// createUsername.setPrefWidth(214);
		createUsername.setFont(new Font(24));
		createUsername.setPromptText("Brugernavn");
		createUsername.relocate(150, 149);

		// createPassword.setPrefHeight(30);
		// createPassword.setPrefWidth(214);
		createPassword.setFont(new Font(24));
		createPassword.setPromptText("Password");
		createPassword.relocate(150, 222);

		// OpretLoginKnap.setPrefHeight(40);
		// OpretLoginKnap.setPrefWidth(154);
		opretLoginKnap.relocate(180, 313);
		opretLoginKnap.setFont(new Font(24));

		opretLoginStatus.setFont(new Font(24));
		opretLoginStatus.relocate(165, 400);
		opretLoginStatus.setTextFill(Color.RED);

		// pane2.setPrefHeight(200);
		// pane2.setPrefWidth(200);

		// Add to pane
		pane2.getChildren().add(name);
		pane2.getChildren().add(createUsername);
		pane2.getChildren().add(createPassword);
		pane2.getChildren().add(opretLoginKnap);
		pane2.getChildren().add(opretLoginStatus);
		// bp2.getChildren().add(pane2);

		// Show scene
		scene2 = new Scene(pane2, 600, 500);
		OpretLG.setResizable(false);
		OpretLG.setScene(scene2);
		OpretLG.show();

		// Action buttons
		opretLoginKnap.setOnAction(e -> opretBruger());

	}

	public void opretLoginSuccess() {
		opretLoginStatus.setTextFill(Color.GREEN);
		opretLoginStatus.setText("Medarbejder blev oprettet!");

	}

	public void opretLoginFail() {
		opretLoginStatus.setTextFill(Color.RED);
		opretLoginStatus.setText("Udfyld venligst alle felter");
	}

	public void opretBruger() {

		OpretBruger oprBruger = new OpretBruger(this);

		oprBruger.opretBruger();
	}

}
