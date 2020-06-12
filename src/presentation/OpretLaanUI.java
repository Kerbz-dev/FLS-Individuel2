package presentation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;

import entity.Biler;
import entity.Singleton;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.CheckID;
import logic.GetBiler;
import logic.GetKV;
import logic.LaanCheckTlf;
import logic.LaanOverstiger;
import logic.TFieldLogik;
import logic.TFieldLogik.TFieldResult;
import logic.opretLaan;

public class OpretLaanUI {

	private DecimalFormat numberFormatter = new DecimalFormat("0");
	private TextField tlfTField, bilnavnTField, bilprisTField, udbetalingTField, laengdeTField, samletprisTField,
			renteTField, mdlYdelseTField;
	private Stage opretLaanStage;
	private Scene scene;
	private Pane pane;
	private String bilnavnGetText, bilprisGetText, udbetalingGetText, laanleangdeGetText, tlfGetText, renteString,
			cprnr, bilnavn;
	private Image ferrari;
	private ImageView ferraripic;
	private Button vaelgBilBtn, indsaetBil, opretLaanBtn, tlfSoegBtn, opretKundeBtn;
	private Label opretStatusLbl, lblbilMangler, lbltlfUgyldig;
	private double rente, samletPris, mdlYdelse;
	private boolean isClicked = false;
	private int bilid, bilpris, bilinventar, saelgerID, udbetaling, laanleangde;
	private long tlf;
	private boolean overstigergraense;
	private GetBiler billogic = new GetBiler();
	private ObservableList<Biler> bilObserver;
	private TableView<Biler> bilList1 = new TableView<Biler>();
	private LaaneUI lnUI;

	public OpretLaanUI(LaaneUI lnUI) {
		this.lnUI = lnUI;
	}

	public void start() {
		// Sætter stage
		opretLaanStage = new Stage();
		opretLaanStage.setTitle("Ferrari lånesystem");
		opretLaanStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		// Sætter label

		// Sætter pane + billede
		pane = new Pane();
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
		ferraripic = new ImageView();

		// Sætter knapper
		opretLaanBtn = new Button("Opret lånetilbud");
		vaelgBilBtn = new Button("Vælg Bil");
		indsaetBil = new Button("Indsæt bil i lån");
		tlfTField = new TextField();
		opretStatusLbl = new Label();
		bilnavnTField = new TextField();
		bilprisTField = new TextField();
		udbetalingTField = new TextField();
		laengdeTField = new TextField();
		samletprisTField = new TextField();
		renteTField = new TextField();
		mdlYdelseTField = new TextField();
		lblbilMangler = new Label("Vælg venligst en bil!");
		lbltlfUgyldig = new Label("Beklager, kunden findes ikke i systemet!");
		tlfSoegBtn = new Button("Søg");
		opretKundeBtn = new Button("Opret ny kunde");

		// TField Lokation + Diverse
		tlfTField.relocate(295.0, 200.0);
		tlfTField.setPrefHeight(51.0);
		tlfTField.setPrefWidth(330.0);
		tlfTField.setFont(new Font(24));
		tlfSoegBtn.relocate(640, 200);
		tlfSoegBtn.setFont(new Font(24));

		mdlYdelseTField.relocate(295.0, 525);
		mdlYdelseTField.setPrefHeight(35);
		mdlYdelseTField.setPrefWidth(330.0);
		mdlYdelseTField.setFont(new Font(14));
		mdlYdelseTField.setVisible(false);
		mdlYdelseTField.setEditable(false);

		samletprisTField.relocate(295.0, 575.0);
		samletprisTField.setPrefHeight(35);
		samletprisTField.setPrefWidth(330.0);
		samletprisTField.setFont(new Font(14));
		samletprisTField.setVisible(false);
		samletprisTField.setEditable(false);

		renteTField.relocate(295.0, 475);
		renteTField.setPrefHeight(35);
		renteTField.setPrefWidth(330.0);
		renteTField.setFont(new Font(14));
		renteTField.setVisible(false);
		renteTField.setEditable(false);

		bilnavnTField.relocate(295.0, 275);
		bilnavnTField.setPrefHeight(35.0);
		bilnavnTField.setPrefWidth(330.0);
		bilprisTField.relocate(295.0, 325);
		bilprisTField.setPrefHeight(35.0);
		bilprisTField.setPrefWidth(330.0);

		udbetalingTField.relocate(295.0, 375);
		udbetalingTField.setPrefHeight(35.0);
		udbetalingTField.setPrefWidth(330.0);

		laengdeTField.relocate(295.0, 425);
		laengdeTField.setPrefHeight(35.0);
		laengdeTField.setPrefWidth(330.0);

		vaelgBilBtn.relocate(640, 277);
		vaelgBilBtn.setPrefHeight(30.0);
		vaelgBilBtn.setPrefWidth(80);

		indsaetBil.setPrefWidth(200);
		indsaetBil.relocate(640, 575);
		indsaetBil.setVisible(false);

		bilList1.setPrefHeight(300);
		bilList1.setPrefWidth(250);
		bilList1.relocate(640, 270);
		bilList1.setVisible(false);

		opretLaanBtn.relocate(355, 665);

		lblbilMangler.relocate(642, 535);
		lblbilMangler.setVisible(false);
		lblbilMangler.setFont(new Font(24));
		lblbilMangler.setTextFill(Color.WHITE);

		ferraripic.setFitWidth(350);
		ferraripic.setFitHeight(130);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(285, 25);

		bilnavnTField.setEditable(false);
		bilprisTField.setEditable(true);

		lbltlfUgyldig.relocate(250, 290);
		lbltlfUgyldig.setFont(new Font(24));
		lbltlfUgyldig.setTextFill(Color.WHITE);
		lbltlfUgyldig.setVisible(false);

		opretKundeBtn.setVisible(false);
		opretKundeBtn.setFont(new Font(24));
		opretKundeBtn.relocate(375, 380);

		// Sætter prompt text til at blive vist når et bogstav er blever indsat
		mdlYdelseTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		renteTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		tlfTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		laengdeTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		udbetalingTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilprisTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		bilnavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		samletprisTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		// Sætter prompt text + TField Synlighed
		mdlYdelseTField.setPromptText("Her vises den månedlige ydelse");
		renteTField.setPromptText("Her vises renten på lånet");
		samletprisTField.setPromptText("Her vises den samlede pris for lånetilbuddet");
		tlfTField.setPromptText("Indtast telefonnummer");
		laengdeTField.setPromptText("Lånets længde i år:");
		udbetalingTField.setPromptText("Udbetaling:");
		bilprisTField.setPromptText("Bilpris:");
		bilnavnTField.setPromptText("Bilnavn:");
		bilnavnTField.setVisible(false);
		bilprisTField.setVisible(false);
		udbetalingTField.setVisible(false);
		laengdeTField.setVisible(false);
		vaelgBilBtn.setVisible(false);
		opretLaanBtn.setVisible(false);
		opretStatusLbl.setVisible(false);
		
		opretLaanStage.setResizable(false);
		// Formatter TField så kun tal kan blive indsat + Tableview
		bilprisTField.setTextFormatter(new TextFormatter<>(c -> {
			if (c.getControlNewText().isEmpty()) {
				return c;
			}
			ParsePosition parsePosition = new ParsePosition(0);
			Object object = numberFormatter.parse(c.getControlNewText(), parsePosition);

			if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
				return null;
			} else {
				return c;
			}
		}));
		
		tlfTField.setTextFormatter(new TextFormatter<>(c -> {
			if (c.getControlNewText().isEmpty()) {
				return c;
			}
			ParsePosition parsePosition = new ParsePosition(0);
			Object object = numberFormatter.parse(c.getControlNewText(), parsePosition);

			if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
				return null;
			} else {
				return c;
			}
		}));

		udbetalingTField.setTextFormatter(new TextFormatter<>(c -> {
			if (c.getControlNewText().isEmpty()) {
				return c;
			}
			ParsePosition parsePosition = new ParsePosition(0);
			Object object = numberFormatter.parse(c.getControlNewText(), parsePosition);

			if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
				return null;
			} else {
				return c;
			}
		}));

		laengdeTField.setTextFormatter(new TextFormatter<>(c -> {
			if (c.getControlNewText().isEmpty()) {
				return c;
			}
			ParsePosition parsePosition = new ParsePosition(0);
			Object object = numberFormatter.parse(c.getControlNewText(), parsePosition);

			if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
				return null;
			} else {
				return c;
			}
		}));

		// Sætter set on action på knapper
		opretLaanBtn.setOnAction(e -> LaanCheck());
		tlfSoegBtn.setOnAction(e -> tlfnrCheck());
		opretKundeBtn.setOnAction(e -> startKundeUI());
		bilList1.setOnMouseClicked((MouseEvent event) -> {

			// Sætter mouseevent på vores biltabel
			if (event.getClickCount() > 0) {
				Biler valgtBilNavn = bilList1.getSelectionModel().getSelectedItem();
				if (bilList1.getSelectionModel().getSelectedItem() != null && valgtBilNavn.getInventar() == 0) {
					indsaetBil.setDisable(true);
				} else {
					indsaetBil.setDisable(false);
				}
			}
		});

		// Sætter set on action på knapper
		vaelgBilBtn.setOnAction(e -> {
			bilList1.setVisible(true);
			indsaetBil.setVisible(true);
			vaelgBilBtn.setDisable(true);

			if (isClicked == false) {
				opretTabel();
				isClicked = true;
			}
		});
		indsaetBil.setOnAction(e -> {
			Biler valgtBilNavn = bilList1.getSelectionModel().getSelectedItem();

			if (valgtBilNavn == null) {
				lblbilMangler.setVisible(true);
			} else {
				bilnavnTField.setText(valgtBilNavn.getBilnavn());
				bilpris = valgtBilNavn.getBilPris();
				String bilprisString = Integer.toString(bilpris);

				bilprisTField.setText(bilprisString);
				bilList1.setVisible(false);
				indsaetBil.setVisible(false);
				vaelgBilBtn.setDisable(false);
				lblbilMangler.setVisible(false);
				bilid = valgtBilNavn.getBilId();
			}
		});

		// Sætter skriftstørrelse på knapper + TField
		opretLaanBtn.setFont(new Font(24));
		laengdeTField.setFont(new Font(14));
		udbetalingTField.setFont(new Font(14));
		bilprisTField.setFont(new Font(14));
		bilnavnTField.setFont(new Font(14));
		vaelgBilBtn.setFont(new Font(12));
		indsaetBil.setFont(new Font(14));
		opretStatusLbl.setFont(new Font(24));

		// Sætter farve til pane
		pane.setStyle("-fx-background-color: #F40808");

		// Tilføjer til pane
		pane.getChildren().addAll(opretLaanBtn, opretStatusLbl, ferraripic, tlfTField, bilnavnTField,
				bilprisTField, udbetalingTField, laengdeTField, renteTField, mdlYdelseTField, samletprisTField,
				vaelgBilBtn, indsaetBil, bilList1, lblbilMangler, lbltlfUgyldig, tlfSoegBtn, opretKundeBtn);

		// Vis scene
		scene = new Scene(pane, 950, 735);
		opretLaanStage.setScene(scene);
		opretLaanStage.show();
	}

	// Metoder
	private void LaanCheck() {
		LaanOverstiger LO = new LaanOverstiger();
		// add tlf
		bilnavnGetText = bilnavnTField.getText();
		bilprisGetText = bilprisTField.getText();
		udbetalingGetText = udbetalingTField.getText();
		laanleangdeGetText = laengdeTField.getText();
		
		tlf = Long.parseLong(tlfGetText);
		udbetaling = Integer.parseInt(udbetalingGetText);
    	laanleangde = Integer.parseInt(laanleangdeGetText);

		if (checkTFields() == true) {
		} else {
			getRente();
			renteString = Double.toString(rente);

			// Setting format for our textfields
			NumberFormat pengeformat = NumberFormat.getCurrencyInstance();

			String ydelseStr = pengeformat.format(mdlYdelse);
			String sprisStr = pengeformat.format(samletPris);
			renteTField.setText("Renten er: " + renteString + "%");
			samletprisTField.setText("Samlede pris: " + sprisStr);
			mdlYdelseTField
					.setText("Månedlig ydelse: " + ydelseStr + " pr. måned over " + laanleangdeGetText + " år");
			if (LO.overstigerGraense(samletPris) == true) {
				overstigergraense = true;
			} else {
				overstigergraense = false;
			}
			OpretLaan();
			opdaterTilbudTbl();
		}

	}

	private boolean checkTFields() {
		TFieldLogik tflog = new TFieldLogik();
		TFieldResult tfCheck = tflog.TFieldCheck(tlfGetText, bilnavnGetText, bilprisGetText, udbetalingGetText,
				laanleangdeGetText, rente);
		opretStatusLbl.setTextFill(Color.WHITE);

		switch (tfCheck) {
		case bilnavnIsEmpty:
			opretStatusLbl.setText("Udfyld venligst bilnavn");
			opretStatusLbl.relocate(340, 625);
			return true;
		case bilprisIsEmpty:
			opretStatusLbl.setText("Udfyld venligst bilpris");
			opretStatusLbl.relocate(345, 625);
			return true;
		case udbetalingIsEmpty:
			opretStatusLbl.setText("Udfyld venligst udbetaling");
			opretStatusLbl.relocate(325, 625);
			return true;
		case laanleangdeIsEmpty:
			opretStatusLbl.setText("Udfyld venligst lånets længde");
			opretStatusLbl.relocate(310, 625);
			return true;
		case allIsEmpty:
			opretStatusLbl.setText("Udfyld venligst alle manglende felter");
			opretStatusLbl.relocate(265, 625);
			return true;
		case udbtlOverstiger:
			opretStatusLbl.setText("Udbetaling må ikke være større end bilens pris");
			opretStatusLbl.relocate(215, 625);
			return true;
		case laengdeUgyldig:
			opretStatusLbl.setText("Lånets længde må ikke være mindre end 0 år");
			opretStatusLbl.relocate(220, 625);
			return true;
		case laengdeOverstiger:
			opretStatusLbl.setText("Lånets længde må ikke være større end 30 år");
			opretStatusLbl.relocate(220, 625);
			return true;
		case Success:
			opretStatusLbl.setText("Lån Oprettet!");
			opretStatusLbl.relocate(390, 625);
			return false;
		default:
			opretStatusLbl.setText("Der skete en fejl! Genstart venligst systemet.");
			opretStatusLbl.relocate(255, 625);
			return true;
		}
	}

	private void tlfnrCheck() {
		tlfGetText = tlfTField.getText();
		LaanCheckTlf tlfLogic = new LaanCheckTlf();
		if (tlfLogic.CheckTlfDB(tlfGetText) == true) {
			bilnavnTField.setVisible(true);
			bilprisTField.setVisible(true);
			udbetalingTField.setVisible(true);
			laengdeTField.setVisible(true);
			vaelgBilBtn.setVisible(true);
			lbltlfUgyldig.setVisible(false);
			opretKundeBtn.setVisible(false);
			opretLaanBtn.setVisible(true);
			opretStatusLbl.setVisible(true);
			samletprisTField.setVisible(true);
			renteTField.setVisible(true);
			mdlYdelseTField.setVisible(true);
			vaelgBilBtn.setDisable(false);
			rydTFields();
		}

		else if (tlfLogic.CheckTlfDB(tlfGetText) == false) {
			bilnavnTField.setVisible(false);
			bilprisTField.setVisible(false);
			udbetalingTField.setVisible(false);
			laengdeTField.setVisible(false);
			vaelgBilBtn.setVisible(false);
			opretLaanBtn.setVisible(false);
			lbltlfUgyldig.setVisible(true);
			opretKundeBtn.setVisible(true);
			opretStatusLbl.setVisible(false);
			samletprisTField.setVisible(false);
			renteTField.setVisible(false);
			mdlYdelseTField.setVisible(false);
			bilList1.setVisible(false);
			indsaetBil.setVisible(false);
		}
	}

	private void startKundeUI() {
		OpretKundeUI kundeUI = new OpretKundeUI();
		kundeUI.start();
	}

	private void getRente() {
		LaanCheckTlf tlflogic = new LaanCheckTlf();
		cprnr = tlflogic.getCPRNR(tlfGetText);
		GetKV getKV = new GetKV();
		rente = getKV.getRente(cprnr, bilprisGetText, udbetalingGetText, laanleangdeGetText);
		mdlYdelse = getKV.getMdlYdelse(cprnr, bilprisGetText, udbetalingGetText, laanleangdeGetText);
		samletPris = getKV.getSamletpris2();

		mdlYdelse = Math.round(mdlYdelse * 100.0) / 100.0;
		rente = Math.round(rente * 100.0) / 100.0;
		samletPris = Math.round(samletPris * 100.0) / 100.0;

	}

	private void rydTFields() {
		bilnavnTField.clear();
		laengdeTField.clear();
		bilprisTField.clear();
		udbetalingTField.clear();
		samletprisTField.clear();
		renteTField.clear();
		mdlYdelseTField.clear();
		;
	}

	private void OpretLaan() {
		opretLaan laanlogic = new opretLaan();
		String username = Singleton.getUsername();
		CheckID ID = new CheckID();
		ID.setID(username);
		saelgerID = Singleton.getSaelgerid();
		Biler valgtBilNavn = bilList1.getSelectionModel().getSelectedItem();
		bilinventar = valgtBilNavn.getInventar();
		if (bilinventar >= 1) {
			bilinventar -= 1;

		}
		laanlogic.CreateLaan(tlf, bilid, saelgerID, udbetaling, laanleangde, overstigergraense,
				rente, mdlYdelse, samletPris, bilinventar);
	}

	@SuppressWarnings("unchecked")
	private void opretTabel() {
		TableColumn<Biler, String> ColumnBilnavn = new TableColumn<Biler, String>("Bilnavn");
		TableColumn<Biler, String> ColumnBilpris = new TableColumn<Biler, String>("Bilpris");
		TableColumn<Biler, String> ColumnBilinventar = new TableColumn<Biler, String>("Inventar");

		ColumnBilnavn.setCellValueFactory(e -> {
			Biler blr = e.getValue();
			bilnavn = blr.getBilnavn();

			return new SimpleStringProperty(bilnavn);
		});

		ColumnBilpris.setCellValueFactory(e -> {
			Biler blr = e.getValue();
			bilpris = blr.getBilPris();
			String bilprisString = Integer.toString(bilpris);
			return new SimpleStringProperty(bilprisString);
		});

		ColumnBilinventar.setCellValueFactory(e -> {
			Biler blr = e.getValue();
			bilinventar = blr.getInventar();
			String bilinventarString = Integer.toString(bilinventar);
			return new SimpleStringProperty(bilinventarString);
		});

		bilList1.getColumns().addAll(ColumnBilnavn, ColumnBilpris, ColumnBilinventar);
		bilList1.setItems(bilObserver);

		bilObserver = FXCollections.observableList(billogic.getAllBilerInfo());
		FilteredList<Biler> filteredData = new FilteredList<>(bilObserver, p -> true);

		SortedList<Biler> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(bilList1.comparatorProperty());

		// Tilføjer sorteret og filtreret data til vores TableView
		bilList1.setItems(sortedData);
	}

	private void opdaterTilbudTbl() {
		lnUI.opdaterTable();
	}
}
