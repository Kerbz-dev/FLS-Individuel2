package presentation;

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
import logic.FjernLaaneTilbud;
import logic.GetBiler;
import logic.LaanCheckTlf;
import logic.LaanOverstiger;
import logic.getBilsaelger;
import logic.getKunde;
import logic.getLaan;
import logic.opretLaan;

public class LaaneUI {
	private BorderPane bp;
	private Stage LaaneUIStage;
	private Button opretTilbud, redigerTilbud, fjernTilbud, godkendBtn, afvisBtn, exportCsvBtn;
	private Line bottomLine, upperLine;
	private Label Lånetilbud, Navn, Tlf, CPR, Addresse, Mail, Bilmodel, Bilpris, Laaneperiode, navnOutput, tlfOutput,
			cprOutput, addresseOutput, mailOutput, bilmodelOutput, bilprisOutput, loginName, mdlydelseOutput,
			udbetalingLbl, mdlydelseLbl, samletprisLbl, prisoutputLbl, periodeoutputLbl, udbtloutputLbl;
	private Scene scene;
	private Pane pane1;
	private Image ferrari;
	private ImageView ferraripic;
	private TextField Søg;
	private int tlfnr, kndPostnr, kndHusnr, kndTlf;
	private Kunde kundeentity = new Kunde();
	// private Kunde kunde = new Kunde();
	private getKunde kundelogic = new getKunde();
	private List<Kunde> kunder = kundelogic.getKundeAll();
	private LaaneTilbud laanentity = new LaaneTilbud();
	private getLaan laanlogic = new getLaan();
	private List<LaaneTilbud> getDato;
	private List<LaaneTilbud> getlaan = laanlogic.getLaanAll();
	private ObservableList<LaaneTilbud> formList;
	private TableView<LaaneTilbud> formTable = new TableView<LaaneTilbud>();
	private String tilbudsidString, kndFornavn, kndEfternavn, kndMail, kndBy, kndVej;
	private long kndCpr;
	private double samletPris;
	private int laanestatus;
	private String laanstatus;
	private int tilbudsid;
	private String username;
	private int saelgerID;
	// ObservableList<Kunde> formList;

	@SuppressWarnings("unchecked")
	public void start() {
		username = Singleton.getUsername();
		LaaneUIStage = new Stage();
		LaaneUIStage.setTitle("Ferrari lånesystem");
		LaaneUIStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));
		pane1 = new Pane();
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
		bottomLine = new Line();
		upperLine = new Line();
		Søg = new TextField();
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
		exportCsvBtn = new Button("Eksporter til CSV");

		bp.setPrefHeight(777);
		bp.setPrefWidth(1149);

		pane1.setPrefHeight(777);
		pane1.setPrefWidth(1166);

		// Ferrari logo
		ferraripic.setFitHeight(156);
		ferraripic.setFitWidth(137);
		ferraripic.relocate(951, 469);
		ferraripic.setPreserveRatio(true);
		ferraripic.setImage(ferrari);

		// Buttons
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

		// Labels
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

		loginName.relocate(922, 736);
		loginName.setText("Logget ind som " + ": " + username);

		// Search function
		Søg.setLayoutX(23);
		Søg.setLayoutY(55); // 39
		Søg.setPrefHeight(35);
		Søg.setPrefWidth(322);
		Søg.setFont(new Font(18));
		Søg.setPromptText("Søg tlf. nr.");
		Søg.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		// Add bottom line
		bottomLine.setStartX(-571);
		bottomLine.setEndX(625);
		bottomLine.setLayoutX(553);
		bottomLine.setLayoutY(632);
		bottomLine.setStroke(Color.RED);
		bottomLine.setStrokeWidth(3);

		// Add upper line
		upperLine.setStartX(-108);
		upperLine.setEndX(617);
		upperLine.setLayoutY(122);
		upperLine.setLayoutX(491);
		upperLine.setStroke(Color.RED);
		upperLine.setStrokeWidth(3);
		pane1.setStyle("-fx-background-color: #FF2800");

		formTable.relocate(25, 125);
		formTable.setPrefHeight(425);
		formTable.setPrefWidth(320);

		/*
		 * //////////////////////////// Table der skal søges/filtreres
		 *////////////////////////////

		TableColumn<LaaneTilbud, String> ColumnDato = new TableColumn<LaaneTilbud, String>("Dato");
		TableColumn<LaaneTilbud, String> ColumnTilbud = new TableColumn<LaaneTilbud, String>("Lånetilbud");

		// TableColumn<Kunde, String> ColumnFornavn = new TableColumn<Kunde,
		// String>("Fornavn");
		// TableColumn<Kunde, String> ColumnEfternavn = new TableColumn<Kunde,
		// String>("Efternavn");
		TableColumn<LaaneTilbud, String> ColumnTlf = new TableColumn<LaaneTilbud, String>("Tlf. nr");
		TableColumn<LaaneTilbud, String> ColumnStatus = new TableColumn<LaaneTilbud, String>("Status");
		formTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

//
//		ColumnFornavn.setCellValueFactory(e -> {
//			Kunde kunde = e.getValue();
//			return new SimpleStringProperty(kunde.getKundefornavn());
//
//		});
//

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

		formTable.getColumns().addAll(ColumnDato, ColumnTilbud, ColumnTlf, ColumnStatus);

		formTable.setItems(formList);

		/*
		 * //////////////////////////////// Søgefunktion til tablecolumn
		 *////////////////////////////////

		formTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		formList = FXCollections.observableList(laanlogic.getLaanAll());
		// System.out.println("getKundeAll returner: " +
		// formList.get(2).getKreditVurdering());
		FilteredList<LaaneTilbud> filteredData = new FilteredList<>(formList, p -> true);

		Søg.textProperty().addListener((observable, oldValue, newValue) -> {
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
				// If a filter text (the text field) is empty, show all forms
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compares the textfield to the object (the input) with the filter from above
				String lowerCaseFilter = newValue.toLowerCase();

				// Filter matches with Analyze Title

				if (tlfnr.toLowerCase().contains(lowerCaseFilter)) {
					return true;

				}
				
				if (laanstatus.toLowerCase().contains(lowerCaseFilter)) {
					return true;

				}

				// No match at all
				return false;
			});
		});

		SortedList<LaaneTilbud> sortedData = new SortedList<>(filteredData);

		// Connect the SortedList comparator to the TableView comparator
		// 'The comparator that denotes the order of this SortedList'
		sortedData.comparatorProperty().bind(formTable.comparatorProperty());

		// Tilføjer sorteret og filtreret data til vores TableView
		formTable.setItems(sortedData);

		// Fanger det vaglte element

		// Setting background color for text zone
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

		// Adding to pane
		pane1.getChildren().addAll(Søg, background, background2, Addresse, CPR, Laaneperiode, Lånetilbud, Bilmodel,
				Navn, navnOutput, bilmodelOutput, mdlydelseOutput, Tlf, bilprisOutput, mailOutput, tlfOutput,
				addresseOutput, Mail, cprOutput, Bilpris, opretTilbud, redigerTilbud, fjernTilbud, loginName,
				godkendBtn, afvisBtn, exportCsvBtn, prisoutputLbl, periodeoutputLbl, udbtloutputLbl, samletprisLbl,
				mdlydelseLbl, udbetalingLbl, formTable, ferraripic, upperLine, bottomLine);

		scene = new Scene(pane1);
		LaaneUIStage.setScene(scene);
		LaaneUIStage.show();

		opretTilbud.setOnAction(e -> opretLaaneUIv2());
		godkendBtn.setOnAction(e -> getstatusInfo());
		afvisBtn.setOnAction(e -> getstatusInfo2());
		redigerTilbud.setOnAction(e -> redigerKundeUI());
		fjernTilbud.setOnAction(e -> fjernTilbud());
		exportCsvBtn.setOnAction(e -> exportCSV());

		formTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 1) {
				onRowSelect();
				onRowSelect1();
			}
		});
	}

	private void opretLaaneUIv2() {
		OpretLaanUI opretLaan = new OpretLaanUI();
		opretLaan.start();
	}

	private void redigerKundeUI() {
		RedigerKundeUI redigerUI = new RedigerKundeUI();
		redigerUI.start();
	}

	private void opdaterTable() {
        if (formList.size() > 0) {
        	formList.clear();
        	formList = FXCollections.observableList(laanlogic.getLaanAll());
        	for(int i=0; i < formList.size(); i++) {
        	formList.get(i).getAllTilbud();
        	formTable.setItems(formList);
        	
        	}
	}
	}

	private void onRowSelect() {
		// check the table's selected item and get selected item
		LaanCheckTlf tlfcheck = new LaanCheckTlf();
		GetBiler billogic = new GetBiler();
		if (formTable.getSelectionModel().getSelectedItem() != null) {
			LaaneTilbud selectedTilbud = formTable.getSelectionModel().getSelectedItem();
			// navnOutput.setText(selectedTilbud.getKundefornavn());
			int bilid = selectedTilbud.getBilid();

			int laanlaengde = selectedTilbud.getLaanlaengde();
			String laengdeString = Integer.toString(laanlaengde);
			periodeoutputLbl.setText(laengdeString + " år");
			laanestatus = selectedTilbud.getLaanestatus();
	
			samletPris = selectedTilbud.getSamletpris();
			String sprisString = Double.toString(samletPris);
			prisoutputLbl.setText(sprisString + " kr.");

			selectedTilbud.getMdlydelse();
			double mdlydelse = selectedTilbud.getMdlydelse();
			String ydelseString = Double.toString(mdlydelse);
			mdlydelseOutput.setText(ydelseString + " kr.");

			int telefonnummer = selectedTilbud.getTelefonnummer();
			String tlfnr = Integer.toString(telefonnummer);
			tlfOutput.setText(tlfnr);

			int udbtl = selectedTilbud.getIndbetaling();
			String udbtlString = Integer.toString(udbtl);
			udbtloutputLbl.setText(udbtlString + " kr.");

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
					// System.out.println(kundelogic.getKundeAll().get(telefonnummer).getKreditVurdering());
					// System.out.println(kundeentity.getKreditVurdering());
					// Kunde slctKunde = tlfnr;
				}
			}
			if (billogic.KundeCheck(bilid) == true) {
				List<Biler> bilGet = billogic.getBilerWhere(bilid);
				for (int i = 0; i < bilGet.size(); i++) {
					String bilnavn = bilGet.get(i).getBilnavn();
					int bilpris = bilGet.get(i).getBilPris();
					String bilprisString = Integer.toString(bilpris);

					bilmodelOutput.setText(bilnavn);
					bilprisOutput.setText(bilprisString);

				}

			}
			// long cpr = selectedTilbud.getCpr_nummer();
			// String cprnr = Long.toString(cpr);
			// cprOutput.setText(cprnr);
			// addresseOutput.setText(selectedTilbud.getVejnavn() + " " +
			// selectedTilbud.getHusnummer() + ", "
			// + selectedTilbud.getPostnummer() + " " + selectedTilbud.getBynavn());
			// mailOutput.setText(selectedTilbud.getMail());

		}
	}

	private void fjernTilbud() {
		if (formTable.getSelectionModel().getSelectedItem() != null) {
			FjernLaaneTilbud fjerntilbudlogic = new FjernLaaneTilbud();
			LaaneTilbud selectedTilbud = formTable.getSelectionModel().getSelectedItem();
			tlfnr = selectedTilbud.getTelefonnummer();
			tilbudsid = selectedTilbud.getTilbudsid();
			tilbudsidString = Integer.toString(tilbudsid);
			System.out.println(tilbudsidString);
			fjerntilbudlogic.FjernLaan(tlfnr, tilbudsidString);
		}

		}
	

	private void getstatusInfo() {
		if (formTable.getSelectionModel().getSelectedItem() != null) {
		LaanOverstiger LO = new LaanOverstiger();
		opretLaan ol = new opretLaan();
		laanestatus = LO.godkendLaan(samletPris, laanestatus);
		System.out.println(laanestatus);
		LaaneTilbud selectedTilbud = formTable.getSelectionModel().getSelectedItem();
		tilbudsid = selectedTilbud.getTilbudsid();
		ol.CreateStatus(laanestatus, tilbudsid);
		opdaterTable();
	}

	}

	private void getstatusInfo2() {
		if (formTable.getSelectionModel().getSelectedItem() != null) {
		LaanOverstiger LO = new LaanOverstiger();
		opretLaan ol = new opretLaan();
		laanestatus = LO.afvisLaan(samletPris, laanestatus);
		System.out.println(laanestatus);
		LaaneTilbud selectedTilbud = formTable.getSelectionModel().getSelectedItem();
		tilbudsid = selectedTilbud.getTilbudsid();
		ol.CreateStatus(laanestatus, tilbudsid);
		opdaterTable();
		}
	}

	private void onRowSelect1() {
		LaanOverstiger LO = new LaanOverstiger();
		System.out.println("samletpris får: "  + samletPris);
		System.out.println("lånestatus får: " + laanestatus);
		// check the table's selected item and get selected item
		if (formTable.getSelectionModel().getSelectedItem() != null &&  LO.laaneStatus(laanestatus) == true && LO.overstigerGraense(samletPris) == false) {
			godkendBtn.setDisable(false);
			afvisBtn.setDisable(false);

		} else {
			godkendBtn.setDisable(true);
			afvisBtn.setDisable(true);
		}

	}
    public void exportCSV() {
    	CsvWriter CsvW = new CsvWriter();
        if (formTable.getSelectionModel().getSelectedItem() != null) {
        	
            List<LaaneTilbud> laanGet = laanlogic.getLaanWhere(tilbudsid);

            LaaneTilbud selectedTilbud = formTable.getSelectionModel().getSelectedItem();
            tilbudsid = selectedTilbud.getTilbudsid();
            tlfnr = selectedTilbud.getTelefonnummer();
            System.out.println("tilbudsid fra laaneUI: " + tilbudsid);
            CsvW.exportCsv(tilbudsid, tlfnr);

            }else {
                CsvW.exportAllCsv();

            }

        }
//	private void setColumnTilbud() {
//		for (int i = 0; i < getlaan.size(); i++) {
//			int tilbudsid = getlaan.get(i).getTilbudsid();
//			tilbudsidString = Integer.toString(tilbudsid);
//
//			/*
//			 * ///////////////////////////////////////////////////////////////////////
//			 * Tidligere tests System.out.println("tilbudsid får: " + tilbudsid);
//			 * System.out.println("tilbudsidString får: " + tilbudsidString);
//			 *///////////////////////////////////////////////////////////////////////
//
//		}
//	}

}
