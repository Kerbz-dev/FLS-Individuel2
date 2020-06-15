package presentation;

import entity.Singleton;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class adminUI {
	private Button laan, laaneanmodning, opretSealger, opdaterInventar;
	private Scene scene;
	private Pane pane;
	private Image ferrari;
	private ImageView ferraripic;
	private Stage adminUIStage;

	public void start() {

		adminUIStage = new Stage();
		adminUIStage.setTitle("Ferrari lånesystem");
		pane = new Pane();
		pane.setStyle("-fx-background-color: #F40808");
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
		ferraripic = new ImageView();
		ferraripic.setImage(ferrari);
		adminUIStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		// Laver knapper
		laan = new Button("Opret lån");
		laaneanmodning = new Button("Låneanmodninger");
		opretSealger = new Button("Opret Sælger");
		opdaterInventar = new Button("Opdater inventar");
		

		// LOGO Placering
		ferraripic.relocate(223, 30);
		ferraripic.setFitWidth(300);
		ferraripic.setFitHeight(150);

		// Button Placering
		laan.setPrefHeight(62);
		laan.setPrefWidth(189);
		laan.relocate(274, 235);

		laaneanmodning.setPrefHeight(62);
		laaneanmodning.setPrefWidth(189);
		laaneanmodning.relocate(274, 317);

		opretSealger.setPrefHeight(62);
		opretSealger.setPrefWidth(189);
		opretSealger.relocate(274, 404);
		
		opdaterInventar.setPrefHeight(62);
		opdaterInventar.setPrefWidth(189);
		opdaterInventar.relocate(274, 491);

		pane.getChildren().add(ferraripic);
		pane.getChildren().add(laaneanmodning);
		pane.getChildren().add(opretSealger);
		pane.getChildren().add(laan);
		pane.getChildren().add(opdaterInventar);

		scene = new Scene(pane, 755, 600);
		adminUIStage.setResizable(false);
		adminUIStage.setScene(scene);
		adminUIStage.show();

		// Laver set on action på knapper
		opretSealger.setOnAction(e -> opretLoginUI());
		laan.setOnAction(e -> opretLaaneUI());
		laaneanmodning.setOnAction(e -> opretAnmodningerUI());
		adminUIStage.setOnCloseRequest(e -> startLogin());
		opdaterInventar.setOnAction(e -> startInventarUI());
	}

	// Metoder
	private void opretLoginUI() {
		OpretMedarbejderUI oprlogUI = new OpretMedarbejderUI();
		oprlogUI.start();
	}

	private void opretLaaneUI() {
		LaaneUI laan = new LaaneUI();
		laan.start();
	}

	private void opretAnmodningerUI() {
		LaaneAnmodningerUI laUI = new LaaneAnmodningerUI();
		laUI.start();
	}
	
	private void startLogin() {
		LoginUI lgnUI = new LoginUI();
		lgnUI.start();
	}
	
	private void startInventarUI() {
		if (Singleton.isAdmin() == true) {
		InventarUI invUI = new InventarUI();
		invUI.start();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			
			alert.setTitle("Du er ikke logget ind som admin!");
			alert.setHeaderText("Ingen adgang");
			
			alert.showAndWait();
		}
	}
}
