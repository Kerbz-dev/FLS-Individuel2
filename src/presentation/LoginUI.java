package presentation;

import entity.Singleton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.LoginVerification;
import logic.LoginVerification.LoginResult;

public class LoginUI {

	private TextField userLoginField;
	private PasswordField passLoginField;
	private Button loginKnap;
	private Label loginStatus, ferrariLabel;
	private Scene scene;
	private Pane pane, ferraripane;
	private Stage loginStage;
	private Image ferrari;
	private ImageView ferraripic;
	private String username;

	public void start() {
		loginStage = new Stage();
		loginStage.setTitle("Ferrari lånesystem");
		loginStage.getIcons().add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		// Button assignments
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg");
		ferraripic = new ImageView();
		ferrariLabel = new Label("FERRARI");
		loginKnap = new Button("Login");
		userLoginField = new TextField();
		passLoginField = new PasswordField();
		loginStatus = new Label();
		pane = new Pane();
		ferraripane = new Pane();

		// location + font + promt
		userLoginField.setPrefHeight(30);
		userLoginField.setPrefWidth(250);
		userLoginField.setFont(new Font(24));
		userLoginField.setPromptText("Brugernavn");
		userLoginField.relocate(97, 180);
		userLoginField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		passLoginField.setPrefHeight(51);
		passLoginField.setPrefWidth(250);
		passLoginField.relocate(97, 245);
		passLoginField.setFont(new Font(24));
		passLoginField.setPromptText("Password");
		passLoginField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		loginKnap.setPrefHeight(40);
		loginKnap.setPrefWidth(150);
		loginKnap.relocate(145, 368);
		loginKnap.setFont(new Font(18));

		loginStatus.setPrefWidth(350);
		loginStatus.setFont(new Font(24));

		// LOGO Placering
		ferraripic.setFitWidth(250);
		ferraripic.setFitHeight(135);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(95, 15);
		
		// Pane Placering
		ferraripane.setPrefHeight(64);
		ferraripane.setPrefWidth(428);
		pane.setStyle("-fx-background-color: #F40808");
		ferrariLabel.relocate(170, 15);
		ferrariLabel.setFont(new Font(24));

		// Tilføj til pane
		pane.getChildren().add(userLoginField);
		pane.getChildren().add(passLoginField);
		pane.getChildren().add(loginKnap);
		pane.getChildren().add(loginStatus);
		pane.getChildren().add(ferraripic);

		// Show scene
		scene = new Scene(pane, 428, 513);

		loginStage.setResizable(false);
		loginStage.setScene(scene);
		loginStage.show();

		// Laver set on action på knap
		loginKnap.setOnAction(e -> loginCheck());
	}
	
	// Metoder
	private void loginCheck() {
		username = userLoginField.getText();
		String password = passLoginField.getText();
		LoginVerification lgnctrl = new LoginVerification();
		LoginResult lgnCheck;
		Singleton singleton = Singleton.getSingletoninstance();
		lgnCheck = lgnctrl.loginCheck(username, password);
		if (lgnCheck == LoginResult.USER_LOGGED_IN) {
			loginSuccess();
			singleton.setUsername(username);
			startLaaneUI();
			loginStage.close();
			// Singleton singleton = new Singleton();
		}

		else if (lgnCheck == LoginResult.ADMIN_LOGGED_IN) {
			loginSuccess();
			singleton.setUsername(username);
			adminLoginSuccess();
			loginStage.close();
		}

		else if (lgnCheck == LoginResult.FAILED) {
			loginFejl();
		}
	}
	
	private void loginSuccess() {
		loginStatus.relocate(130, 315);
		loginStatus.setTextFill(Color.LIGHTGREEN);
		loginStatus.setText("Login successful!");
	}

	private void loginFejl() {
		loginStatus.relocate(60, 315);
		loginStatus.setTextFill(Color.WHITE);
		loginStatus.setText("Forkert brugernavn eller password");
	}

	private void adminLoginSuccess() {
		adminUI admUI = new adminUI();
		admUI.start();
	}

	private void startLaaneUI() {
		LaaneUI laan = new LaaneUI();
		laan.start();
	}

}
