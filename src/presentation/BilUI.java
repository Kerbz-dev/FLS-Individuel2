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
import logic.opretBilLgc;

public class BilUI {

	private Stage opretBilStage;
	private TextField bilnavnTF, bilprisTF, bilinventarTF;
	private Label opretBilStatus;
	private Image ferrari;
	private ImageView ferraripic;
	private Button opretBilKnap;
	private Scene scene;
	private Pane pane;
	private int bilinventar;
	private int bilpris;
	private InventarUI invUI;
	private String getTextBilnavn;
	private String getTextBilpris;
	private String getTextBilinventar;

	public BilUI() {

	}

	public BilUI(InventarUI invUI) {
		this.invUI = invUI;
	}

	public void start() {
		opretBilStage = new Stage();
		opretBilStage.setTitle("Ferrari lånesystem");
		opretBilStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		// Sætter pane, TField, knap og label
		pane = new Pane();
		opretBilKnap = new Button("Opret ny bil");
		opretBilStatus = new Label();
		bilnavnTF = new TextField();
		bilprisTF = new TextField();
		bilinventarTF = new TextField();
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg");
		ferraripic = new ImageView();

		// Sætter TField lokation + Diverse
		bilnavnTF.setFont(new Font(24));
		bilnavnTF.setPromptText("Udfyld venligst bilnavn");
		bilnavnTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilnavnTF.relocate(150, 195);

		bilprisTF.setFont(new Font(24));
		bilprisTF.setPromptText("Udfyld venligst bilpris");
		bilprisTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilprisTF.relocate(150, 255);
		bilinventarTF.setFont(new Font(24));
		bilinventarTF.setPromptText("Inventar - hvor mange biler er tilgængelige?");
		bilinventarTF.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilinventarTF.relocate(150, 315);

		opretBilKnap.relocate(215, 475);
		opretBilKnap.setFont(new Font(24));

		opretBilStatus.setFont(new Font(24));
		opretBilStatus.setFont(new Font(30));

		ferraripic.setFitWidth(250);
		ferraripic.setFitHeight(135);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(173, 25);

		// Sætter baggrundsfarve til pane
		pane.setStyle("-fx-background-color: #F40808");

		// Tilføj til pane
		pane.getChildren().addAll(bilnavnTF, bilprisTF, bilinventarTF, opretBilKnap, opretBilStatus, ferraripic);

		// Show scene
		scene = new Scene(pane, 600, 600);
		opretBilStage.setResizable(false);
		opretBilStage.setScene(scene);
		opretBilStage.show();

		// Sætter set on action til knap
		opretBilKnap.setOnAction(e -> opretBil());

	}

	// Metoder
	private void opretBilSuccess() {
		opretBilStatus.setTextFill(Color.LIGHTGREEN);
		opretBilStatus.relocate(160, 400);
		opretBilStatus.setText("Bilen blev oprettet!");

	}

	private void opretBilFejlAlle() {
		opretBilStatus.setTextFill(Color.WHITE);
		opretBilStatus.relocate(135, 400);
		opretBilStatus.setText("Udfyld venligst alle felter");
	}

	private void opretLoginFailBilnavn() {
		opretBilStatus.setTextFill(Color.WHITE);
		opretBilStatus.relocate(160, 400);
		opretBilStatus.setText("Udfyld venligst bilnavn");
	}

	private void opretBilFejlInventar() {
		opretBilStatus.setTextFill(Color.WHITE);
		opretBilStatus.relocate(158, 400);
		opretBilStatus.setText("Udfyld venligst inventar");
	}
	
	private void opretBilFejlPris() {
		opretBilStatus.setTextFill(Color.WHITE);
		opretBilStatus.relocate(160, 400);
		opretBilStatus.setText("Udfyld venligst bilpris");
	}

	private void opretBilFejlDuplicate() {
		opretBilStatus.setTextFill(Color.WHITE);
		opretBilStatus.relocate(160, 400);
		opretBilStatus.setAlignment(Pos.CENTER);
		opretBilStatus.setText("Bil findes allerede!");
	}

	private void systemFejl() {
		opretBilStatus.setTextFill(Color.WHITE);
		opretBilStatus.relocate(50, 400);
		opretBilStatus.setAlignment(Pos.CENTER);
		opretBilStatus.setText("Systemfejl! Genstart venligst programmet og prøv igen.");
	}

	private void opretBil() {
		opretBilLgc bilLgc = new opretBilLgc();
		if (bilnavnTF.getText().isEmpty() != true || bilprisTF.getText().isEmpty() != true
				|| bilinventarTF.getText().isEmpty() != true) {
			getTextBilnavn = bilnavnTF.getText();
			getTextBilpris = bilprisTF.getText();
			getTextBilinventar = bilinventarTF.getText();
		} else {
			opretBilFejlAlle();
			return;
		}

		if (getTextBilnavn.isEmpty()) {
			opretLoginFailBilnavn();
		} else if (getTextBilpris.isEmpty()) {
			opretBilFejlPris();
		} else if (getTextBilinventar.isEmpty()) {
			opretBilFejlInventar();
		} else if (bilLgc.bilCheckDuplicate(getTextBilnavn) == true) {
			opretBilFejlDuplicate();

		} else if (bilLgc.bilCheckDuplicate(getTextBilinventar) == false) {
			opretBilSuccess();
			opretBilLgc billgc = new opretBilLgc();
			bilpris = Integer.parseInt(getTextBilinventar);
			bilinventar = Integer.parseInt(getTextBilpris);
			billgc.opretBil(getTextBilnavn, bilpris, bilinventar);
			invUI.opdaterTable();
		} else {
			systemFejl();
		}
	}
}
