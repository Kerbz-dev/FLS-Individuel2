package presentation;

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
import logic.OpretMedarbejderLogin;
import logic.userCheckDuplicate;

public class OpretMedarbejderUI {
	private Stage opretLoginStage;
	private TextField fornavnTF, efternavnTF, brugernavnTF, passwordTF;
	private Label opretLoginStatus;
	private Image ferrari;
	private ImageView ferraripic;
	private Button opretLoginKnap;
	private Scene scene;
	private Pane pane;

	public void start() {
		opretLoginStage = new Stage();
		opretLoginStage.setTitle("Ferrari lånesystem");
		opretLoginStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		// Sætter pane, TField, knap og label
		pane = new Pane();
		opretLoginKnap = new Button("Opret medarbejder");
		opretLoginStatus = new Label();
		fornavnTF = new TextField();
		efternavnTF = new TextField();
		brugernavnTF = new TextField();
		passwordTF = new TextField();
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg");
		ferraripic = new ImageView();

		// Sætter TField lokation + Diverse
		fornavnTF.setFont(new Font(24));
		fornavnTF.setPromptText("Fornavn");
		fornavnTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		fornavnTF.relocate(150, 195);

		efternavnTF.setFont(new Font(24));
		efternavnTF.setPromptText("Efternavn");
		efternavnTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		efternavnTF.relocate(150, 255);
		brugernavnTF.setFont(new Font(24));
		brugernavnTF.setPromptText("Brugernavn");
		brugernavnTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		brugernavnTF.relocate(150, 315);

		passwordTF.setFont(new Font(24));
		passwordTF.setPromptText("Password");
		passwordTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		passwordTF.relocate(150, 375);

		opretLoginKnap.relocate(180, 505);
		opretLoginKnap.setFont(new Font(24));

		opretLoginStatus.setFont(new Font(24));
		opretLoginStatus.setFont(new Font(30));

		ferraripic.setFitWidth(250);
		ferraripic.setFitHeight(135);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(173, 25);

		// Sætter baggrundsfarve til pane
		pane.setStyle("-fx-background-color: #F40808");

		// Tilføj til pane
		pane.getChildren().addAll(fornavnTF, efternavnTF, brugernavnTF, passwordTF, opretLoginKnap, opretLoginStatus,
				ferraripic);

		// Show scene
		scene = new Scene(pane, 600, 600);
		opretLoginStage.setResizable(false);
		opretLoginStage.setScene(scene);
		opretLoginStage.show();

		// Sætter set on action til knap
		opretLoginKnap.setOnAction(e -> opretBruger());

	}

	// Metoder
	private void opretLoginSuccess() {
		opretLoginStatus.setTextFill(Color.LIGHTGREEN);
		opretLoginStatus.relocate(130, 445);
		opretLoginStatus.setText("Medarbejder blev oprettet!");

	}

	private void opretLoginFejllAlle() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(135, 445);
		opretLoginStatus.setText("Udfyld venligst alle felter");
	}

	private void opretLoginFailMNavn() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(95, 445);
		opretLoginStatus.setText("Udfyld venligst medarbejder navn");
	}

	private void opretLoginFejlBrugernavnTF() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(125, 445);
		opretLoginStatus.setText("Udfyld venligst brugernavn");
	}

	private void opretLoginFejlPassword() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(130, 445);
		opretLoginStatus.setText("Udfyld venligst password");
	}

	private void opretLoginFejlDuplikeretBruger() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(150, 445);
		opretLoginStatus.setAlignment(Pos.CENTER);
		opretLoginStatus.setText("Bruger findes allerede");
	}

	private void systemFejl() {
		opretLoginStatus.setTextFill(Color.WHITE);
		opretLoginStatus.relocate(50, 445);
		opretLoginStatus.setAlignment(Pos.CENTER);
		opretLoginStatus.setText("Systemfejl! Genstart venligst programmet og prøv igen.");
	}

	private void opretBruger() {
		userCheckDuplicate opretLoginLGC = new userCheckDuplicate();
		String getTextFornavn = fornavnTF.getText();
		String getTextEfternavn = efternavnTF.getText();
		String getTextBrugernavn = brugernavnTF.getText();
		String getTextPassword = passwordTF.getText();

		if (getTextFornavn.isEmpty() && getTextEfternavn.isEmpty() && getTextBrugernavn.isEmpty()
				&& getTextPassword.isEmpty()) {
			opretLoginFejllAlle();
		} else if (getTextFornavn.isEmpty()) {
			opretLoginFailMNavn();
		} else if (getTextEfternavn.isEmpty()) {
			opretLoginFailMNavn();
		} else if (getTextBrugernavn.isEmpty()) {
			opretLoginFejlBrugernavnTF();
		} else if (getTextPassword.isEmpty()) {
			opretLoginFejlPassword();
		} else if (opretLoginLGC.UserCheckDuplicate(getTextBrugernavn) == true) {
			opretLoginFejlDuplikeretBruger();

		} else if (opretLoginLGC.UserCheckDuplicate(getTextBrugernavn) == false) {
			opretLoginSuccess();
			OpretMedarbejderLogin crtLogin = new OpretMedarbejderLogin();
			crtLogin.opretBruger(getTextFornavn, getTextEfternavn, getTextBrugernavn, getTextPassword);
		} else {
			systemFejl();
		}
	}
}
