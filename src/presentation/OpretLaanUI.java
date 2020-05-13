package presentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.OpretLaan;
import logic.getKunde;

public class OpretLaanUI {

	private TextField navnTField;
	private TextField adrTField;
	private TextField tlfTField;
	private TextField cprTField;
	private TextField mailTField;
	private TextField bilnavnTField;
	private TextField bilprisTField;
	private TextField udbetalingTField;
	private TextField laengdeTField;
	private Button opretLaanBtn;
	private Stage opretLaanStage;

	private Scene scene3;
	private Pane pane3;
	private Image ferrari;
	private ImageView ferraripic;

	public void start() {
		opretLaanStage = new Stage();
		opretLaanStage.setTitle("Ferrari lånesystem");
		opretLaanStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		Label lgnNameLbl = new Label("logget in som " +  "username");

		pane3 = new Pane();
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
		pane3.setPrefHeight(670.0);
		ferraripic = new ImageView();

		// Button assignments
		opretLaanBtn = new Button("Opret lånetilbud");

		navnTField = new TextField();
		adrTField = new TextField();
		tlfTField = new TextField();
		cprTField = new TextField();
		mailTField = new TextField();
		bilnavnTField = new TextField();
		bilprisTField = new TextField();
		udbetalingTField = new TextField();
		laengdeTField = new TextField();

		navnTField.relocate(298.0, 225.0);
		navnTField.setPrefHeight(25.0);
		navnTField.setPrefWidth(321.0);
		adrTField.relocate(298.0, 255.0);
		adrTField.setPrefHeight(25.0);
		adrTField.setPrefWidth(321.0);
		tlfTField.relocate(298.0, 285.0);
		tlfTField.setPrefHeight(25.0);
		tlfTField.setPrefWidth(321.0);
		cprTField.relocate(298, 315.0);
		cprTField.setPrefHeight(25.0);
		cprTField.setPrefWidth(321.0);
		mailTField.relocate(298, 345);
		mailTField.setPrefHeight(25.0);
		mailTField.setPrefWidth(321.0);
		bilnavnTField.relocate(298, 375);
		bilnavnTField.setPrefHeight(25.0);
		bilnavnTField.setPrefWidth(321.0);
		bilprisTField.relocate(298, 405);
		bilprisTField.setPrefHeight(25.0);
		bilprisTField.setPrefWidth(321.0);
		udbetalingTField.relocate(298, 435);
		udbetalingTField.setPrefHeight(25.0);
		udbetalingTField.setPrefWidth(321.0);
		laengdeTField.relocate(298, 465);
		laengdeTField.setPrefHeight(25.0);
		laengdeTField.setPrefWidth(321.0);

		ferraripic.setFitWidth(350);
		ferraripic.setFitHeight(175);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(282, 30);
		pane3.setPrefHeight(556);
		pane3.setPrefWidth(842);

		pane3.setPrefWidth(930.0);
		opretLaanBtn.relocate(347.0, 525);

		// adrTField.relocate(arg0, arg1);
		laengdeTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		udbetalingTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilprisTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilnavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		mailTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		cprTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		tlfTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		adrTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		navnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		pane3.setStyle("-fx-background-color: #ff2800");

		laengdeTField.setPromptText("Lånets længde:");
		udbetalingTField.setPromptText("Udbetaling:");
		bilprisTField.setPromptText("Bilpris:");
		bilnavnTField.setPromptText("Bilnavn:");
		mailTField.setPromptText("E-Mail:");
		cprTField.setPromptText("CPR-nr:");
		tlfTField.setPromptText("Tlf.nr:");
		adrTField.setPromptText("Addresse:");
		navnTField.setPromptText("Navn:");

		lgnNameLbl.setPrefHeight(17);
		lgnNameLbl.setPrefWidth(200);
		lgnNameLbl.relocate(750, 625);
		
		
		//Font sizes
		opretLaanBtn.setFont(new Font(24));
		lgnNameLbl.setFont(new Font(12));
		laengdeTField.setFont(new Font(14));
		udbetalingTField.setFont(new Font(14));
		bilprisTField.setFont(new Font(14));
		bilnavnTField.setFont(new Font(14));
		mailTField.setFont(new Font(14));
		cprTField.setFont(new Font(14));
		tlfTField.setFont(new Font(14));
		adrTField.setFont(new Font(14));
		navnTField.setFont(new Font(14));
		// Add to pane
		pane3.getChildren().add(ferraripic);
		pane3.getChildren().add(lgnNameLbl);
		pane3.getChildren().add(mailTField);
		pane3.getChildren().add(cprTField);
		pane3.getChildren().add(navnTField);
		pane3.getChildren().add(tlfTField);
		pane3.getChildren().add(adrTField);
		pane3.getChildren().add(bilnavnTField);
		pane3.getChildren().add(bilprisTField);
		pane3.getChildren().add(udbetalingTField);
		pane3.getChildren().add(laengdeTField);
		pane3.getChildren().add(opretLaanBtn);
	
	      opretLaanBtn.setOnAction(e -> opretLaan()); 
		// Show scene
		scene3 = new Scene(pane3, 930, 670);
		opretLaanStage.setScene(scene3);
		opretLaanStage.show();
	}
	
	 private void opretLaan() {
	        String kundenavn = navnTField.getText();
	        String adr = adrTField.getText();
	        String tlf = tlfTField.getText();
	        String cpr = cprTField.getText();
	        String mail = mailTField.getText();
	        String bilnavn = bilnavnTField.getText();
	        String bilpris = bilprisTField.getText();
	        String udbetalingspris = udbetalingTField.getText();
	        String laanleangde = laengdeTField.getText();

	        OpretLaan laanlogic = new OpretLaan();

	        if (kundenavn.isEmpty() && adr.isEmpty() && tlf.isEmpty() 
	                && cpr.isEmpty() && mail.isEmpty() && bilnavn.isEmpty() 
	                && bilpris.isEmpty() && udbetalingspris.isEmpty() && laanleangde.isEmpty()) {
	            System.out.println("Lån Fejlede");;
	        }
	        else {
	            laanlogic.opretLaan(bilnavn, bilpris, udbetalingspris, laanleangde, tlf, kundenavn, cpr, mail, adr);
	            System.out.println("Great Success");
	        }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
     /*public void Kundeinfo() {
    
    
     String Fornavn = new String();
     String Efternavn= new String();
     String Addresse = new String();
     String tlfnr = new String();
     String cprnr = new String();
     String email = new String();
    
     getKunde gK = new getKunde();

     gK.getKundeinfo(Fornavn, Addresse, tlfnr, cprnr, email);
     System.out.print(Fornavn + Addresse +  tlfnr + cprnr + email);
     adrTField.setText(Addresse);
     lgnNameLbl.setText(Addresse);
     System.out.println(Addresse);
 }
*/
}