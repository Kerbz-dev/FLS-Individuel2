package presentation;

import java.text.NumberFormat;
import java.util.List;
import entity.Biler;
import entity.Kunde;
import entity.LaaneTilbud;
import entity.Singleton;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.CsvWriter;
import logic.FjernLaaneTilbud;
import logic.GetBiler;
import logic.LaanCheckTlf;
import logic.LaanOverstiger;
import logic.getLaan;
import logic.opretLaan;

public class LaaneUI {
	private Stage LaaneUIStage;
	private Button opretTilbud, redigerTilbud, fjernTilbud, godkendBtn, afvisBtn, exportCsvBtn;
	private Line bottomLine, upperLine;
	private Label Lånetilbud, Navn, Tlf, CPR, Addresse, Mail, Bilmodel, Bilpris, Laaneperiode, navnOutput, tlfOutput,
			cprOutput, addresseOutput, mailOutput, bilmodelOutput, bilprisOutput, loginName, mdlydelseOutput,
			udbetalingLbl, mdlydelseLbl, samletprisLbl, prisoutputLbl, periodeoutputLbl, udbtloutputLbl, csvStatusLbl;
	private Scene scene;
	private Pane pane;
	private Image ferrari;
	private ImageView ferraripic;
	private TextField Soeg;
	private int bilid, bilinventar, tilbudsid, laanestatus, tlfnr;
	private getLaan laanlogic = new getLaan();
	private ObservableList<LaaneTilbud> tlbList;
	private TableView<LaaneTilbud> tlbTable = new TableView<LaaneTilbud>();
	private String tilbudsidString, laanstatus, username;
	private double samletPris;
	private TableColumn<LaaneTilbud, String> ColumnDato;
	private TableColumn<LaaneTilbud, String> ColumnTilbud;
	private TableColumn<LaaneTilbud, String> ColumnTlf;
	private TableColumn<LaaneTilbud, String> ColumnStatus;

	@SuppressWarnings("unchecked")
	public void start() {

		// Sætter Labels
		username = Singleton.getUsername();
		LaaneUIStage = new Stage();
		LaaneUIStage.setTitle("Ferrari lånesystem");
		LaaneUIStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));
		pane = new Pane();
		opretTilbud = new Button("Opret Tilbud");
		redigerTilbud = new Button("Rediger Kunde");
		fjernTilbud = new Button("Fjern Tilbud");
		Lånetilbud = new Label("LÅNETILBUD");
		Navn = new Label("Navn:");
		Tlf = new Label("Tlf:");
		CPR = new Label("CPR-nr:");
		Addresse = new Label("Adresse:");
		Mail = new Label("Mail:");
		Bilmodel = new Label("Bilmodel:");
		Bilpris = new Label("Bilpris:");
		Laaneperiode = new Label("Låneperiode:");
		navnOutput = new Label();
		tlfOutput = new Label();
		cprOutput = new Label();
		addresseOutput = new Label();
		mailOutput = new Label();
		bilmodelOutput = new Label();
		bilprisOutput = new Label();
		mdlydelseOutput = new Label();
		csvStatusLbl = new Label();
		bottomLine = new Line();
		upperLine = new Line();
		Soeg = new TextField();
		ferrari = new Image("https://seeklogo.com/images/F/ferrari-logo-7935CF173C-seeklogo.com.png");
		ferraripic = new ImageView();
		loginName = new Label();
		udbetalingLbl = new Label("Udbetaling:");
		mdlydelseLbl = new Label("Mdl. ydelse:");
		samletprisLbl = new Label("Samlet pris: ");
		prisoutputLbl = new Label();
		periodeoutputLbl = new Label();
		udbtloutputLbl = new Label();
		godkendBtn = new Button("Godkend");
		afvisBtn = new Button("Afvis");
		exportCsvBtn = new Button("Eksporter til CSV");

		pane.setPrefHeight(777);
		pane.setPrefWidth(1166);

		// Ferrari Logo
		ferraripic.setFitHeight(156);
		ferraripic.setFitWidth(137);
		ferraripic.relocate(951, 469);
		ferraripic.setPreserveRatio(true);
		ferraripic.setImage(ferrari);

		// Knapper Placering + Diverse
		opretTilbud.setPrefHeight(45);
		opretTilbud.setPrefWidth(152);
		opretTilbud.setFont(new Font(18));
		opretTilbud.relocate(439, 655);

		redigerTilbud.setPrefHeight(45);
		redigerTilbud.setPrefWidth(152);
		redigerTilbud.setFont(new Font(18));
		redigerTilbud.relocate(660, 655);

		fjernTilbud.setPrefHeight(45);
		fjernTilbud.setPrefWidth(152);
		fjernTilbud.setFont(new Font(18));
		fjernTilbud.relocate(884, 655);

		godkendBtn.setPrefHeight(39);
		godkendBtn.setPrefWidth(134);
		godkendBtn.setFont(new Font(18));
		godkendBtn.relocate(41, 578);

		afvisBtn.setPrefHeight(39);
		afvisBtn.setPrefWidth(134);
		afvisBtn.setFont(new Font(18));
		afvisBtn.relocate(191, 578);

		exportCsvBtn.setPrefHeight(39);
		exportCsvBtn.setPrefWidth(284);
		exportCsvBtn.setFont(new Font(18));
		exportCsvBtn.relocate(41, 658);

		// Labels lokation
		Navn.setFont(new Font(24));
		Navn.relocate(430, 160);

		Tlf.setFont(new Font(24));
		Tlf.relocate(430, 200);

		CPR.setFont(new Font(24));
		CPR.relocate(430, 240);

		Addresse.setFont(new Font(24));
		Addresse.relocate(430, 280);

		Mail.setFont(new Font(24));
		Mail.relocate(430, 320);

		Bilmodel.setFont(new Font(24));
		Bilmodel.relocate(430, 360);

		Bilpris.setFont(new Font(24));
		Bilpris.relocate(430, 400);

		Laaneperiode.setFont(new Font(24));
		Laaneperiode.relocate(430, 480);

		udbetalingLbl.setFont(new Font(24));
		udbetalingLbl.relocate(430, 440);

		mdlydelseLbl.setFont(new Font(24));
		mdlydelseLbl.relocate(430, 520);

		samletprisLbl.setFont(new Font(24));
		samletprisLbl.relocate(430, 560);

		Lånetilbud.setFont(new Font(36));
		Lånetilbud.relocate(645, 55);

		navnOutput.setFont(new Font(18));
		navnOutput.relocate(577, 164);

		tlfOutput.setFont(new Font(18));
		tlfOutput.relocate(577, 205);

		cprOutput.setFont(new Font(18));
		cprOutput.relocate(577, 244);

		addresseOutput.setFont(new Font(18));
		addresseOutput.relocate(577, 284);

		mailOutput.setFont(new Font(18));
		mailOutput.relocate(577, 324);

		bilmodelOutput.setFont(new Font(18));
		bilmodelOutput.relocate(577, 366);

		bilprisOutput.setFont(new Font(18));
		bilprisOutput.relocate(577, 404);

		udbtloutputLbl.setFont(new Font(18));
		udbtloutputLbl.relocate(577, 445);

		periodeoutputLbl.setFont(new Font(18));
		periodeoutputLbl.relocate(577, 485);

		mdlydelseOutput.setFont(new Font(18));
		mdlydelseOutput.relocate(577, 524);

		prisoutputLbl.setFont(new Font(18));
		prisoutputLbl.relocate(577, 565);

		loginName.relocate(930, 736);
		loginName.setText("Logget ind som " + ": " + username);

		csvStatusLbl.setFont(new Font(18));
		csvStatusLbl.relocate(102, 725);
		
		LaaneUIStage.setResizable(false);

		// Soeg funktion
		Soeg.setLayoutX(23);
		Soeg.setLayoutY(55); // 39
		Soeg.setPrefHeight(35);
		Soeg.setPrefWidth(322);
		Soeg.setFont(new Font(18));
		Soeg.setPromptText("Søg - fx tlf. nr.");
		Soeg.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		// Tilføj nedre linje
		bottomLine.setStartX(-571);
		bottomLine.setEndX(625);
		bottomLine.setLayoutX(553);
		bottomLine.setLayoutY(632);
		bottomLine.setStroke(Color.RED);
		bottomLine.setStrokeWidth(3);

		// Tilføj øvre Linje
		upperLine.setStartX(-108);
		upperLine.setEndX(617);
		upperLine.setLayoutY(122);
		upperLine.setLayoutX(491);
		upperLine.setStroke(Color.RED);
		upperLine.setStrokeWidth(3);
		pane.setStyle("-fx-background-color: #F40808");

		// Laver Tableview + Funktioner
		tlbTable.relocate(25, 125);
		tlbTable.setPrefHeight(425);
		tlbTable.setPrefWidth(320);

		ColumnDato = new TableColumn<LaaneTilbud, String>("Dato");
		ColumnTilbud = new TableColumn<LaaneTilbud, String>("Lånetilbud");

		ColumnTlf = new TableColumn<LaaneTilbud, String>("Tlf. nr");
		ColumnStatus = new TableColumn<LaaneTilbud, String>("Status");
		tlbTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		ColumnDato.setCellValueFactory(e -> {
			LaaneTilbud ltb = e.getValue();
			String tlbdato = ltb.getRentedato();

			return new SimpleStringProperty(tlbdato);
		});

		ColumnTilbud.setCellValueFactory(e -> {
			LaaneTilbud ltb = e.getValue();
			int tilbudsid = ltb.getTilbudsid();
			tilbudsidString = Integer.toString(tilbudsid);
			return new SimpleStringProperty(tilbudsidString);
		});

		ColumnTlf.setCellValueFactory(e -> {
			LaaneTilbud ltb = e.getValue();
			int telefonnummer = ltb.getTelefonnummer();
			String tlfnr = Integer.toString(telefonnummer);
			return new SimpleStringProperty(tlfnr);
		});

		ColumnStatus.setCellValueFactory(e -> {
			LaaneTilbud ltb = e.getValue();
			int laanestatus = ltb.getLaanestatus();
			if (laanestatus == 2) {
				laanstatus = "Godkendt";
			} else if (laanestatus == 1) {
				laanstatus = "Afventer";
			}

			else if (laanestatus == 0) {
				laanstatus = "Afvist";
			}
			return new SimpleStringProperty(laanstatus);
		});

		tlbTable.getColumns().addAll(ColumnDato, ColumnTilbud, ColumnTlf, ColumnStatus);
		tlbTable.setItems(tlbList);
		fyldTable();
		checkAdminStatus();

		// Sætter baggrundsfarve for text zonen
		Rectangle background = new Rectangle();
		background.setFill(Color.WHITESMOKE);
		background.setHeight(681);
		background.setWidth(727);
		background.setArcWidth(5);
		background.setArcHeight(5);
		background.setStroke(Color.BLACK);
		background.relocate(382, 37);

		Rectangle background2 = new Rectangle();
		background2.setFill(Color.WHITESMOKE);
		background2.setHeight(155);
		background2.setWidth(322);
		background2.setArcWidth(5);
		background2.setArcHeight(5);
		background2.setStroke(Color.BLACK);
		background2.relocate(23, 564);

		// Tilføjer alt til pane
		pane.getChildren().addAll(Soeg, background, background2, Addresse, CPR, Laaneperiode, Lånetilbud, Bilmodel, Navn,
				navnOutput, bilmodelOutput, mdlydelseOutput, Tlf, bilprisOutput, mailOutput, tlfOutput, addresseOutput,
				Mail, cprOutput, Bilpris, opretTilbud, redigerTilbud, fjernTilbud, loginName, godkendBtn, afvisBtn,
				exportCsvBtn, prisoutputLbl, periodeoutputLbl, udbtloutputLbl, samletprisLbl, mdlydelseLbl,
				udbetalingLbl, tlbTable, ferraripic, upperLine, bottomLine, csvStatusLbl);

		// Sætter scene og Viser Stage
		scene = new Scene(pane);
		LaaneUIStage.setScene(scene);
		LaaneUIStage.show();

		// Laver set on action på knapper
		opretTilbud.setOnAction(e -> opretLaaneUIv2());
		godkendBtn.setOnAction(e -> godkendTilbud());
		afvisBtn.setOnAction(e -> afvisTilbud());
		redigerTilbud.setOnAction(e -> redigerKundeUI());
		fjernTilbud.setOnAction(e -> fjernTilbud());
		exportCsvBtn.setOnAction(e -> eksportCSV());
		LaaneUIStage.setOnCloseRequest(e -> checkLogin());

		// Laver mouseEvent (Når man klikker i tabellen skal der ske noget) på vores
		// tabel
		tlbTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 0) {
				valgtTlbSetLbl();
				setKnapFunktion();
			}
		});
	}

	// Metoder
	private void opretLaaneUIv2() {
		OpretLaanUI opretLaan = new OpretLaanUI(this);
		opretLaan.start();
	}

	private void inventarOpdatering() {
		opretLaan ol = new opretLaan();
		GetBiler gb = new GetBiler();
		LaaneTilbud valgtBilNavn = tlbTable.getSelectionModel().getSelectedItem();
		bilid = valgtBilNavn.getBilid();
		List<Biler> bilGet = gb.getBilerWhere(bilid);
		for (int i = 0; i < bilGet.size(); i++)
			bilinventar = gb.getBilerWhere(bilid).get(i).getInventar() + 1;
		ol.inventarUpdate(bilid, bilinventar);
	}

	private void redigerKundeUI() {
		RedigerKundeUI redigerUI = new RedigerKundeUI(this);
		redigerUI.start();
	}

	public void opdaterTable() {
		if (tlbList.size() >= 0) {
			tlbList.clear();
			fyldTable();
		}
	}

	private void valgtTlbSetLbl() {
		LaanCheckTlf tlfcheck = new LaanCheckTlf();
		GetBiler billogic = new GetBiler();
		NumberFormat pengeformat = NumberFormat.getCurrencyInstance();

		if (tlbTable.getSelectionModel().getSelectedItem() != null) {
			LaaneTilbud selectedTilbud = tlbTable.getSelectionModel().getSelectedItem();
			int bilid = selectedTilbud.getBilid();

			int laanlaengde = selectedTilbud.getLaanlaengde();
			String laengdeString = Integer.toString(laanlaengde);
			periodeoutputLbl.setText(laengdeString + " år");
			laanestatus = selectedTilbud.getLaanestatus();

			samletPris = selectedTilbud.getSamletpris();
			String sprisString = pengeformat.format(samletPris);
			prisoutputLbl.setText(sprisString);

			selectedTilbud.getMdlydelse();
			double mdlydelse = selectedTilbud.getMdlydelse();
			String ydelseString = pengeformat.format(mdlydelse);
			mdlydelseOutput.setText(ydelseString);

			int telefonnummer = selectedTilbud.getTelefonnummer();
			String tlfnr = Integer.toString(telefonnummer);
			tlfOutput.setText(tlfnr);

			int udbtl = selectedTilbud.getIndbetaling();
			String udbtlString = pengeformat.format(udbtl);
			udbtloutputLbl.setText(udbtlString);

			if (tlfcheck.LaanCheckTlfDB(telefonnummer) == true) {
				List<Kunde> kndGet = tlfcheck.getKundeWhere(telefonnummer);
				for (int i = 0; i < kndGet.size(); i++) {
					long cpr = kndGet.get(i).getCpr_nummer();
					String cprString = Long.toString(cpr);

					navnOutput.setText(kndGet.get(i).getKundefornavn() + " " + kndGet.get(i).getKundeefternavn());
					addresseOutput.setText(kndGet.get(i).getVejnavn() + " " + kndGet.get(i).getHusnummer() + ", "
							+ kndGet.get(i).getPostnummer() + " " + kndGet.get(i).getBynavn());
					cprOutput.setText(cprString);
					mailOutput.setText(kndGet.get(i).getMail());
				}
			}

			if (billogic.BilCheck(bilid) == true) {
				List<Biler> bilGet = billogic.getBilerWhere(bilid);
				for (int i = 0; i < bilGet.size(); i++) {
					String bilnavn = bilGet.get(i).getBilnavn();
					int bilpris = bilGet.get(i).getBilPris();

					String bilprisString = pengeformat.format(bilpris);

					bilmodelOutput.setText(bilnavn);
					bilprisOutput.setText(bilprisString);
				}
			}
		}
	}

	private void fjernTilbud() {
		if (tlbTable.getSelectionModel().getSelectedItem() != null) {
			FjernLaaneTilbud fjerntilbudlogic = new FjernLaaneTilbud();
			LaaneTilbud selectedTilbud = tlbTable.getSelectionModel().getSelectedItem();
			tlfnr = selectedTilbud.getTelefonnummer();
			tilbudsid = selectedTilbud.getTilbudsid();
			tilbudsidString = Integer.toString(tilbudsid);
			fjerntilbudlogic.FjernLaan(tlfnr, tilbudsidString);
			opdaterTable();
		}

	}

	private void godkendTilbud() {
		if (tlbTable.getSelectionModel().getSelectedItem() != null) {
			LaanOverstiger LO = new LaanOverstiger();
			opretLaan ol = new opretLaan();
			laanestatus = LO.godkendLaan(samletPris, laanestatus);
			LaaneTilbud selectedTilbud = tlbTable.getSelectionModel().getSelectedItem();
			tilbudsid = selectedTilbud.getTilbudsid();
			ol.CreateStatus(laanestatus, tilbudsid);
			opdaterTable();
		}

	}

	private void afvisTilbud() {
		if (tlbTable.getSelectionModel().getSelectedItem() != null) {
			LaanOverstiger LO = new LaanOverstiger();
			opretLaan ol = new opretLaan();
			laanestatus = LO.afvisLaan(samletPris, laanestatus);
			LaaneTilbud selectedTilbud = tlbTable.getSelectionModel().getSelectedItem();
			tilbudsid = selectedTilbud.getTilbudsid();
			ol.CreateStatus(laanestatus, tilbudsid);
			inventarOpdatering();
			opdaterTable();
		}
	}

	private void setKnapFunktion() {
		LaanOverstiger LO = new LaanOverstiger();
		
		// check the table's selected item and get selected item
		if (tlbTable.getSelectionModel().getSelectedItem() != null && LO.laaneStatus(laanestatus) == true
				&& LO.overstigerGraense(samletPris) == false) {
			godkendBtn.setDisable(false);
			afvisBtn.setDisable(false);

		} else {
			godkendBtn.setDisable(true);
			afvisBtn.setDisable(true);
		}

	}

	private void eksportCSV() {
		CsvWriter CsvW = new CsvWriter();
		if (tlbTable.getSelectionModel().getSelectedItem() != null) {

			LaaneTilbud selectedTilbud = tlbTable.getSelectionModel().getSelectedItem();
			tilbudsid = selectedTilbud.getTilbudsid();
			tlfnr = selectedTilbud.getTelefonnummer();
			if (CsvW.exportCsv(tilbudsid, tlfnr) == true) {
				csvSuccess();
			}

			else if (CsvW.exportCsv(tilbudsid, tlfnr) == false) {
				csvFail();
			}
		}
		if (tlbTable.getSelectionModel().getSelectedItem() == null) {

			if (CsvW.exportAllCsv(tilbudsid, tlfnr) == true) {
				csvSuccess();
			}

			else if (CsvW.exportAllCsv(tilbudsid, tlfnr) == false) {
				csvFail();
			}

		}

	}

	private void csvSuccess() {
		csvStatusLbl.setTextFill(Color.LIGHTGREEN);
		csvStatusLbl.setText("CSV fil blev oprettet!");
	}

	private void csvFail() {
		csvStatusLbl.setTextFill(Color.WHITE);
		csvStatusLbl.setText("CSV fil blev ikke oprettet!");
		csvStatusLbl.relocate(75, 725);
	}
	
	private void checkLogin() {

		if (Singleton.isAdmin() == true) {
			// Gør intet, siden vi først vil lukke vinduet ved AdminUI (lappeløsning, men der er ikke tid!)
		}
		else {
			LoginUI lgnUI = new LoginUI();
		
			lgnUI.start();
		}
	}
	

	private void fyldTable() {

		tlbTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tlbList = FXCollections.observableList(laanlogic.getLaanAll());

		FilteredList<LaaneTilbud> filteredData = new FilteredList<>(tlbList, p -> true);

		// Soeg funktionalitet
		Soeg.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(formSearch -> {
				int telefonnummer = formSearch.getTelefonnummer();
				int status = formSearch.getLaanestatus();
				if (status == 2) {
					laanstatus = "Godkendt";
				} else if (status == 1) {
					laanstatus = "Afventer";
				}

				else if (status == 0) {
					laanstatus = "Afvist";
				}
				String tlfnr = Integer.toString(telefonnummer);
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (tlfnr.toLowerCase().contains(lowerCaseFilter)) {
					return true;

				}

				if (laanstatus.toLowerCase().contains(lowerCaseFilter)) {
					return true;

				}

				return false;
			});
		});

		SortedList<LaaneTilbud> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tlbTable.comparatorProperty());

		// Tilføjer sorteret og filtreret data til vores TableView
		tlbTable.setItems(sortedData);
	}
	
	public void checkAdminStatus() {
		if (Singleton.isAdmin() == true) {
			fjernTilbud.setDisable(false);
		}
		else {
			fjernTilbud.setDisable(true);
		}
	}



}