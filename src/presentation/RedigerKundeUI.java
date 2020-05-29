package presentation;

import java.text.DecimalFormat;
import java.text.ParsePosition;

import entity.Kunde;
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
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.KundeOpdatering;
import logic.getKunde;

public class RedigerKundeUI {
	private DecimalFormat numberFormatter = new DecimalFormat("0");
	private TextField kundefornavnTField, kundeefternavnTField, tlfTField, PostnrTField, ByTField, VejTField,
			HusnrTField, cprTField, mailTField, SoegTField;
	private Button opdaterKundeBtn;
	private Stage opretKundeStage;
	private String fornavnGT, efternavnGT, tlfGT, postnrGT, byGT, vejGT, husnrGT, cprGT, mailGT;
	private Label opretStatusLbl;
	private Scene scene;
	private Pane pane;
	private Image ferrari;
	private ImageView ferraripic;
	private getKunde kundelogic = new getKunde();
	private ObservableList<Kunde> formList;
	private TableView<Kunde> formTable = new TableView<Kunde>();
	private LaaneUI laaneUI;

	public RedigerKundeUI(LaaneUI laaneUI) {
		this.laaneUI = laaneUI;
	}

	@SuppressWarnings("unchecked")
	public void start() {
		opretKundeStage = new Stage();
		opretKundeStage.setTitle("Ferrari lånesystem");
		opretKundeStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		Label lgnNameLbl = new Label("logget ind som " + Singleton.getUsername());
		// Sætter pane + billede
		pane = new Pane();
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
		pane.setPrefHeight(670.0);
		ferraripic = new ImageView();

		// Sætter knap
		opdaterKundeBtn = new Button("Opdater kunde");

		// Sætter TField
		kundefornavnTField = new TextField();
		kundeefternavnTField = new TextField();
		PostnrTField = new TextField();
		ByTField = new TextField();
		VejTField = new TextField();
		HusnrTField = new TextField();
		tlfTField = new TextField();
		cprTField = new TextField();
		mailTField = new TextField();
		SoegTField = new TextField();
		opretStatusLbl = new Label();

		// TField lokationer
		kundefornavnTField.relocate(320.0, 195.0);
		kundefornavnTField.setPrefHeight(25.0);
		kundefornavnTField.setPrefWidth(321);
		kundeefternavnTField.relocate(320.0, 225.0);
		kundeefternavnTField.setPrefHeight(25.0);
		kundeefternavnTField.setPrefWidth(321.0);
		PostnrTField.relocate(320.0, 255.0);
		PostnrTField.setPrefHeight(25.0);
		PostnrTField.setPrefWidth(321.0);
		ByTField.setPrefWidth(321.0);
		ByTField.relocate(320.0, 285.0);
		ByTField.setPrefHeight(25.0);
		VejTField.setPrefWidth(321.0);
		VejTField.relocate(320.0, 315.0);
		VejTField.setPrefHeight(25.0);
		HusnrTField.setPrefWidth(321.0);
		HusnrTField.relocate(320.0, 345.0);
		HusnrTField.setPrefHeight(25.0);
		tlfTField.relocate(320.0, 375.0);
		tlfTField.setPrefHeight(25.0);
		tlfTField.setPrefWidth(321.0);
		cprTField.relocate(320.0, 405.0);
		cprTField.setPrefHeight(25.0);
		cprTField.setPrefWidth(321.0);
		mailTField.relocate(320.0, 435);
		mailTField.setPrefHeight(25.0);
		mailTField.setPrefWidth(321.0);
		opdaterKundeBtn.relocate(390, 550);
		formTable.setPrefWidth(250);
		formTable.setPrefHeight(500);
		formTable.relocate(23, 75);
		SoegTField.setLayoutX(23);
		SoegTField.setLayoutY(25);
		SoegTField.setPrefHeight(35);
		SoegTField.setPrefWidth(250);
		SoegTField.setPromptText("Søg - fx tlf. nr.");
		SoegTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		ferraripic.setFitWidth(350);
		ferraripic.setFitHeight(130);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(305, 20);

		// Sætter prompt text til kun at blive vist når et bogstav bliver indsat
		mailTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		cprTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		tlfTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		PostnrTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		ByTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		VejTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		HusnrTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		kundefornavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		kundeefternavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		
		// Sætter pane baggrundsfarve
		pane.setStyle("-fx-background-color: #F40808");

		// Sætter prompt text
		kundefornavnTField.setPromptText("Fornavn");
		kundeefternavnTField.setPromptText("Efternavn");
		mailTField.setPromptText("E-Mail");
		cprTField.setPromptText("CPR-nr");
		tlfTField.setPromptText("Tlf.nr");
		PostnrTField.setPromptText("Postnr");
		HusnrTField.setPromptText("Husnr");
		VejTField.setPromptText("Vejnavn");
		ByTField.setPromptText("By");

		lgnNameLbl.setPrefHeight(17);
		lgnNameLbl.setPrefWidth(200);
		lgnNameLbl.relocate(750, 625);

		tlfTField.setEditable(false);

		// Laver tabel + funktionalitet
		TableColumn<Kunde, String> ColumnFornavn = new TableColumn<Kunde, String>("Fornavn");
		TableColumn<Kunde, String> ColumnEfternavn = new TableColumn<Kunde, String>("Efternavn");
		TableColumn<Kunde, String> ColumnTlf = new TableColumn<Kunde, String>("Tlf. nr");

		ColumnFornavn.setCellValueFactory(e -> {
			Kunde kunde = e.getValue();
			return new SimpleStringProperty(kunde.getKundefornavn());
		});

		ColumnEfternavn.setCellValueFactory(e -> {
			Kunde kunde = e.getValue();
			return new SimpleStringProperty(kunde.getKundeefternavn());
		});
		ColumnTlf.setCellValueFactory(e -> {
			Kunde kunde = e.getValue();
			int telefonnummer = kunde.getTelefonnummer();
			String tlfnr = Integer.toString(telefonnummer);
			return new SimpleStringProperty(tlfnr);
		});

		formTable.getColumns().addAll(ColumnFornavn, ColumnEfternavn, ColumnTlf);
		formTable.setItems(formList);
		udfyldTbl();

		// Sætter TField til kun at tal kan sættes
		cprTField.setTextFormatter(new TextFormatter<>(c -> {
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

		// Sætter font størrelser
		SoegTField.setFont(new Font(18));
		opretStatusLbl.setFont(new Font(24));
		kundeefternavnTField.setFont(new Font(14));
		kundefornavnTField.setFont(new Font(14));
		opdaterKundeBtn.setFont(new Font(24));
		lgnNameLbl.setFont(new Font(12));
		mailTField.setFont(new Font(14));
		cprTField.setFont(new Font(14));
		tlfTField.setFont(new Font(14));
		PostnrTField.setFont(new Font(14));
		HusnrTField.setFont(new Font(14));
		VejTField.setFont(new Font(14));
		ByTField.setFont(new Font(14));

		// Tilføj til pane
		pane.getChildren().addAll(kundefornavnTField, kundeefternavnTField, PostnrTField, ByTField, VejTField,
				HusnrTField, tlfTField, cprTField, mailTField, opdaterKundeBtn, opretStatusLbl, ferraripic, lgnNameLbl,
				SoegTField, formTable);

		// Vis scene
		scene = new Scene(pane, 950, 670);
		opretKundeStage.setScene(scene);
		opretKundeStage.show();

		// Sætter set on action på knap
		opdaterKundeBtn.setOnAction(e -> checkOpdatering());

		// Sætter mouseevent på tabel
		formTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 1) {
				setTFields();
			}
		});
	}

	// Metoder
	private void checkOpdatering() {
		fornavnGT = kundefornavnTField.getText();
		efternavnGT = kundeefternavnTField.getText();
		tlfGT = tlfTField.getText();
		postnrGT = PostnrTField.getText();
		byGT = ByTField.getText();
		vejGT = VejTField.getText();
		husnrGT = HusnrTField.getText();
		cprGT = cprTField.getText();
		mailGT = mailTField.getText();

		if (fieldsEmpty() == true) {
			opdaterFejl();

		} else if (cprTField.getText().length() != 10) {
			cprFejl();
		}
		else
			opdaterKunde();
		opdaterTable();
		laaneUI.opdaterTable();
	}

	private void opdaterKunde() {
		KundeOpdatering kundeopdatering = new KundeOpdatering();

		opretStatusLbl.setText("Kunde opdateret!");
		opretStatusLbl.setTextFill(Color.LIGHTGREEN);
		opretStatusLbl.relocate(390.5, 490);
		kundeopdatering.OpdaterKunde(fornavnGT, efternavnGT, tlfGT, postnrGT, byGT, vejGT, husnrGT, cprGT, mailGT);
	}

	private boolean fieldsEmpty() {
		if (fornavnGT.isEmpty() || efternavnGT.isEmpty() || tlfGT.isEmpty() || postnrGT.isEmpty() || byGT.isEmpty()
				|| vejGT.isEmpty() || husnrGT.isEmpty() || cprGT.isEmpty() || mailGT.isEmpty()) {
			return true;
		}
		return false;
	}

	private void opdaterFejl() {
		opretStatusLbl.setText("Udfyld venligst alle felter!");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(345, 490);

	}

	private void cprFejl() {
		opretStatusLbl.setText("Der skal vaare 10 CPR-cifre. Nuværende antal: " + cprTField.getText().length());
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(200, 490);
	}

	private void setTFields() {
		if (formTable.getSelectionModel().getSelectedItem() != null) {
			Kunde selectedKunde = formTable.getSelectionModel().getSelectedItem();
			int telefonnummer = selectedKunde.getTelefonnummer();
			String tlfnr = Integer.toString(telefonnummer);
			long cpr = selectedKunde.getCpr_nummer();
			String cprnr = Long.toString(cpr);
			int postnr = selectedKunde.getPostnummer();
			String postnrString = Integer.toString(postnr);
			int husnr = selectedKunde.getHusnummer();
			String husnrString = Integer.toString(husnr);

			kundefornavnTField.setText(selectedKunde.getKundefornavn());
			kundeefternavnTField.setText(selectedKunde.getKundeefternavn());
			tlfTField.setText(tlfnr);
			cprTField.setText(cprnr);
			PostnrTField.setText(postnrString);
			mailTField.setText(selectedKunde.getMail());
			ByTField.setText(selectedKunde.getBynavn());
			VejTField.setText(selectedKunde.getVejnavn());
			HusnrTField.setText(husnrString);
		}
	}

	private void opdaterTable() {
		if (formList.size() > 0) {
			formList.clear();
			udfyldTbl();
		}
	}

	private void udfyldTbl() {
		formTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		formList = FXCollections.observableList(kundelogic.getKundeAll());
		FilteredList<Kunde> filteredData = new FilteredList<>(formList, p -> true);

		// Søg funktion
		SoegTField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(formSearch -> {
				int telefonnummer = formSearch.getTelefonnummer();
				String tlfnr = Integer.toString(telefonnummer);
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (formSearch.getKundefornavn().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (formSearch.getKundeefternavn().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
				else if (tlfnr.toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});

		SortedList<Kunde> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(formTable.comparatorProperty());

		// Tilføjer sorteret og filtreret data til vores TableView
		formTable.setItems(sortedData);
	}
}
