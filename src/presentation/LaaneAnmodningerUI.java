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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.CsvWriter;
import logic.GetBiler;
import logic.LaanCheckTlf;
import logic.LaanOverstiger;
import logic.getLaan;
import logic.opretLaan;

public class LaaneAnmodningerUI {
	private BorderPane bp;
	private Stage LaaneUIStage;
	private Button godkendBtn, afvisBtn, eksportCsvBtn, opdaterInventarBtn;
	private Line bottomLine, upperLine;
	private Label Lånetilbud, Navn, Tlf, CPR, Addresse, Mail, Bilmodel, Bilpris, Laaneperiode, navnOutput, tlfOutput,
			cprOutput, addresseOutput, mailOutput, bilmodelOutput, bilprisOutput, loginName, mdlydelseOutput,
			udbetalingLbl, mdlydelseLbl, samletprisLbl, prisoutputLbl, periodeoutputLbl, udbtloutputLbl, csvStatusLbl;
	private Scene scene;
	private Pane pane;
	private Image ferrari;
	private ImageView ferraripic;
	private TextField Soeg;
	private getLaan laanlogic = new getLaan();
	private List<LaaneTilbud> getlaanHvorOG = laanlogic.getLaanHvorOG();
	private ObservableList<LaaneTilbud> formList;
	private TableView<LaaneTilbud> tilbudsTable = new TableView<LaaneTilbud>();
	private String tilbudsidString, laanstatus;
	private int bilid, bilinventar, laanestatus, tilbudsid, tlfnr;
	private double samletPris;

	@SuppressWarnings("unchecked")
	public void start() {
		
		// Sætter variabler
		LaaneUIStage = new Stage();
		LaaneUIStage.setTitle("Ferrari lånesystem");
		LaaneUIStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));
		pane = new Pane();
		Lånetilbud = new Label("Låneanmodninger for salgschef");
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
		bp = new BorderPane();
		loginName = new Label();
		udbetalingLbl = new Label("Udbetaling:");
		mdlydelseLbl = new Label("Mdl. ydelse:");
		samletprisLbl = new Label("Samlet pris: ");
		prisoutputLbl = new Label();
		periodeoutputLbl = new Label();
		udbtloutputLbl = new Label();
		godkendBtn = new Button("Godkend");
		afvisBtn = new Button("Afvis");
		eksportCsvBtn = new Button("Eksporter til CSV");
		opdaterInventarBtn = new Button("Opdater inventar for biler");


		bp.setPrefHeight(777);
		bp.setPrefWidth(1149);

		pane.setPrefHeight(777);
		pane.setPrefWidth(1166);

		// Ferrari logo
		ferraripic.setFitHeight(156);
		ferraripic.setFitWidth(137);
		ferraripic.relocate(951, 469);
		ferraripic.setPreserveRatio(true);
		ferraripic.setImage(ferrari);

		// Knapper lokation
		godkendBtn.setPrefHeight(39);
		godkendBtn.setPrefWidth(134);
		godkendBtn.setFont(new Font(18));
		godkendBtn.relocate(41, 578);

		afvisBtn.setPrefHeight(39);
		afvisBtn.setPrefWidth(134);
		afvisBtn.setFont(new Font(18));
		afvisBtn.relocate(191, 578);

		eksportCsvBtn.setPrefHeight(39);
		eksportCsvBtn.setPrefWidth(284);
		eksportCsvBtn.setFont(new Font(18));
		eksportCsvBtn.relocate(41, 658);
		
		opdaterInventarBtn.setPrefHeight(39);
		opdaterInventarBtn.setPrefWidth(284);
		opdaterInventarBtn.setFont(new Font(18));
		opdaterInventarBtn.relocate(600, 658);

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
		Lånetilbud.relocate(490, 55);

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
		loginName.setText("Logget ind som " + ": " + Singleton.getUsername());
		
		csvStatusLbl.setFont(new Font(18));
		csvStatusLbl.relocate(102, 725);
		
		LaaneUIStage.setResizable(false);
		// Search funktion
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

		// Tilføj øvre linje
		upperLine.setStartX(-108);
		upperLine.setEndX(617);
		upperLine.setLayoutY(122);
		upperLine.setLayoutX(491);
		upperLine.setStroke(Color.RED);
		upperLine.setStrokeWidth(3);
		pane.setStyle("-fx-background-color: #F40808");

		tilbudsTable.relocate(25, 125);
		tilbudsTable.setPrefHeight(425);
		tilbudsTable.setPrefWidth(320);

		// Laver Tableview + Funktioner
		TableColumn<LaaneTilbud, String> ColumnDato = new TableColumn<LaaneTilbud, String>("Dato");
		TableColumn<LaaneTilbud, String> ColumnTilbud = new TableColumn<LaaneTilbud, String>("Lånetilbud");

		TableColumn<LaaneTilbud, String> ColumnTlf = new TableColumn<LaaneTilbud, String>("Tlf. nr");
		TableColumn<LaaneTilbud, String> ColumnStatus = new TableColumn<LaaneTilbud, String>("Status");

		for (int i = 0; i < getlaanHvorOG.size(); i++) {
			samletPris = getlaanHvorOG.get(i).getSamletpris();
			LaanOverstiger LO = new LaanOverstiger();
			if (LO.overstigerGraense(samletPris) == true) {
				String tlbdato = getlaanHvorOG.get(i).getRentedato();
				ColumnDato.setCellValueFactory(e -> {

					return new SimpleStringProperty(tlbdato);
				});
			}
		}

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
		tilbudsTable.getColumns().addAll(ColumnDato, ColumnTilbud, ColumnTlf, ColumnStatus);
		tilbudsTable.setItems(formList);
		tilbudsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		fyldTable();


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
		pane.getChildren().addAll(Soeg, background, background2, Addresse, CPR, Laaneperiode, Lånetilbud, Bilmodel,
				Navn, navnOutput, bilmodelOutput, mdlydelseOutput, Tlf, bilprisOutput, mailOutput, tlfOutput,
				addresseOutput, Mail, cprOutput, Bilpris, loginName, godkendBtn, afvisBtn, eksportCsvBtn, prisoutputLbl, csvStatusLbl,
				periodeoutputLbl, udbtloutputLbl, samletprisLbl, mdlydelseLbl, udbetalingLbl, tilbudsTable, ferraripic,
				upperLine, bottomLine, opdaterInventarBtn);

		// Sætter scene og Viser Stage
		scene = new Scene(pane);
		LaaneUIStage.setScene(scene);
		LaaneUIStage.show();

		// Laver set on action på knapper
		godkendBtn.setOnAction(e -> godkendTilbud());
		afvisBtn.setOnAction(e -> afvisTilbud());
		eksportCsvBtn.setOnAction(e -> eksportCSV());
		
		// Laver mouseEvent (Når man klikker i tabellen skal der ske noget)  på vores tabel
		tilbudsTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 0) {
				valgtTlbSetLbl();
				setKnapFunktion();
			}
		});
	}

	// Metoder
	private void valgtTlbSetLbl() {
		LaanCheckTlf tlfcheck = new LaanCheckTlf();
		GetBiler billogic = new GetBiler();
		NumberFormat pengeformat = NumberFormat.getCurrencyInstance();

		if (tilbudsTable.getSelectionModel().getSelectedItem() != null) {
			LaaneTilbud selectedTilbud = tilbudsTable.getSelectionModel().getSelectedItem();
			int bilid = selectedTilbud.getBilid();

			int laanlaengde = selectedTilbud.getLaanlaengde();
			String laengdeString = Integer.toString(laanlaengde);
			periodeoutputLbl.setText(laengdeString + " år");

			selectedTilbud.getLaanestatus();

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

			laanestatus = selectedTilbud.getLaanestatus();
			if (tlfcheck.LaanCheckTlfDB(telefonnummer) == true) {
				List<Kunde> kndGet = tlfcheck.getKundeWhere(telefonnummer);
				for (int i = 0; i < kndGet.size(); i++) {
					long cprint = kndGet.get(i).getCpr_nummer();
					String cprString = Long.toString(cprint);

					navnOutput.setText(kndGet.get(i).getKundefornavn());
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

	private void opdaterTable() {
		if (formList.size() > 0) {
			formList.clear();
			fyldTable();
		}
	}
	
	private void eksportCSV() {
		CsvWriter CsvW = new CsvWriter();
		if (tilbudsTable.getSelectionModel().getSelectedItem() != null) {

			LaaneTilbud selectedTilbud = tilbudsTable.getSelectionModel().getSelectedItem();
			tilbudsid = selectedTilbud.getTilbudsid();
			tlfnr = selectedTilbud.getTelefonnummer();
			if (CsvW.exportCsv(tilbudsid, tlfnr) == true) {
				csvSuccess();
			}
			
			else if (CsvW.exportCsv(tilbudsid, tlfnr) == false) {
				csvFail();
			}
		}
			if (tilbudsTable.getSelectionModel().getSelectedItem() == null) {
			
				if (CsvW.exportAllCsv(tilbudsid, tlfnr) == true) {
					csvSuccess();
				}
				
				else if (CsvW.exportAllCsv(tilbudsid, tlfnr) == false) {
					csvFail();
				}

		}
			
		}

	
	private void godkendTilbud() {
		if (tilbudsTable.getSelectionModel().getSelectedItem() != null) {
		LaanOverstiger LO = new LaanOverstiger();
		opretLaan ol = new opretLaan();
		laanestatus = LO.admingodkendLaan(samletPris, laanestatus);
		godkendBtn.setDisable(true);
		afvisBtn.setDisable(true);
		LaaneTilbud selectedTilbud = tilbudsTable.getSelectionModel().getSelectedItem();
		int tilbudsid = selectedTilbud.getTilbudsid();
		ol.CreateStatus(laanestatus, tilbudsid);
		opdaterTable();
	}
	}

	private void afvisTilbud() {
		if (tilbudsTable.getSelectionModel().getSelectedItem() != null) {
		LaanOverstiger LO = new LaanOverstiger();
		opretLaan ol = new opretLaan();
		laanestatus = LO.adminafvisLaan(samletPris, laanestatus);
		godkendBtn.setDisable(true);
		afvisBtn.setDisable(true);
		LaaneTilbud selectedTilbud = tilbudsTable.getSelectionModel().getSelectedItem();
		int tilbudsid = selectedTilbud.getTilbudsid();
		ol.CreateStatus(laanestatus, tilbudsid);
		inventarOpdatering();
		opdaterTable();
	}
	}
	private void fyldTable() {
		tilbudsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		formList = FXCollections.observableList(laanlogic.getLaanHvorOG());
		FilteredList<LaaneTilbud> filteredData = new FilteredList<>(formList, p -> true);

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
		sortedData.comparatorProperty().bind(tilbudsTable.comparatorProperty());

		// Tilføjer sorteret og filtreret data til vores TableView
		tilbudsTable.setItems(sortedData);
	}

	private void setKnapFunktion() {
		LaanOverstiger LO = new LaanOverstiger();
		
		// Checker tabellens valgte tilbud og Ændre knapper udfra dette
		if (tilbudsTable.getSelectionModel().getSelectedItem() != null && LO.laaneStatus(laanestatus) == true) {
			godkendBtn.setDisable(false);
			afvisBtn.setDisable(false);

		} else {
			godkendBtn.setDisable(true);
			afvisBtn.setDisable(true);
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
	private void inventarOpdatering() {
		opretLaan ol = new opretLaan();
		GetBiler gb = new GetBiler();
		LaaneTilbud valgtBilNavn = tilbudsTable.getSelectionModel().getSelectedItem();
		bilid = valgtBilNavn.getBilid();
		List<Biler> bilGet = gb.getBilerWhere(bilid);
		for (int i = 0; i < bilGet.size(); i++)
			bilinventar = gb.getBilerWhere(bilid).get(i).getInventar() + 1;
		ol.inventarUpdate(bilid, bilinventar);
		}
	}
