package presentation;

import java.text.DecimalFormat;
import java.text.ParsePosition;

import entity.Kunde;
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
import logic.getKunde;
import logic.KundeOpdatering;

public class RedigerKundeUI {
	DecimalFormat numberFormatter = new DecimalFormat("0");
	private TextField kundefornavnTField;
	private TextField kundeefternavnTField;
	private TextField tlfTField;
	private TextField PostnrTField;
	private TextField ByTField;
	private TextField VejTField;
	private TextField HusnrTField;
	private TextField cprTField;
	private TextField mailTField;
	private Button opdaterKundeBtn;
	private Stage opretKundeStage;
	private String fornavnGT;
	private String efternavnGT;
	private String tlfGT;
	private String postnrGT;
	private String byGT;
	private String vejGT;
	private String husnrGT;
	private String cprGT;
	private TextField SoegTField;
	private String mailGT;
	private Label opretStatusLbl;
	private Scene scene4;
	private Pane pane4;
	private Image ferrari;
	private ImageView ferraripic;
	private getKunde kundelogic = new getKunde();
	private ObservableList<Kunde> formList;
	private TableView<Kunde> formTable = new TableView<Kunde>();

	public void start() {
		opretKundeStage = new Stage();
		opretKundeStage.setTitle("Ferrari lånesystem");
		opretKundeStage.getIcons()
				.add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));

		Label lgnNameLbl = new Label("logget in som " + "username");

		pane4 = new Pane();
		ferrari = new Image(
				"https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
		pane4.setPrefHeight(670.0);
		ferraripic = new ImageView();

//		// Button assignments
		opdaterKundeBtn = new Button("Opdater kunde");

		kundefornavnTField = new TextField();
		kundeefternavnTField = new TextField();
		// adrTField = new TextField();
		PostnrTField = new TextField();
		ByTField = new TextField();
		VejTField = new TextField();
		HusnrTField = new TextField();
		tlfTField = new TextField();
		cprTField = new TextField();
		mailTField = new TextField();
		SoegTField = new TextField();

		opretStatusLbl = new Label();
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
		opretStatusLbl.setFont(new Font(24));
		opdaterKundeBtn.relocate(390, 550);
		formTable.setPrefWidth(250);
		formTable.setPrefHeight(500);
		formTable.relocate(23, 75);
		SoegTField.setLayoutX(23);
		SoegTField.setLayoutY(25);
		SoegTField.setPrefHeight(35);
		SoegTField.setPrefWidth(250);
		SoegTField.setFont(new Font(18));
		SoegTField.setPromptText("Søg - fx tlf. nr.");
		SoegTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		ferraripic.setFitWidth(350);
		ferraripic.setFitHeight(130);
		ferraripic.setImage(ferrari);
		ferraripic.relocate(305, 20);

		// Setting prompt text style to only appear once a character has been inserted
		mailTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		cprTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		tlfTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		PostnrTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		ByTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		VejTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		HusnrTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		kundefornavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		kundeefternavnTField.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
		pane4.setStyle("-fx-background-color: #F40808");

		// Setting prompt text
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

		// Setting colums for arraylist
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

		/*
		 * //////////////////////////////// Søgefunktion til tablecolumn
		 *////////////////////////////////

		formTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		formList = FXCollections.observableList(kundelogic.getKundeAll());
		// System.out.println("getKundeAll returner: " +
		// formList.get(2).getKreditVurdering());
		FilteredList<Kunde> filteredData = new FilteredList<>(formList, p -> true);

		SoegTField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(formSearch -> {
				int telefonnummer = formSearch.getTelefonnummer();
				String tlfnr = Integer.toString(telefonnummer);
				// If a filter text (the text field) is empty, show all forms
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compares the textfield to the object (the input) with the filter from above
				String lowerCaseFilter = newValue.toLowerCase();

				// Filter matches with Analyze Title
				if (formSearch.getKundefornavn().toLowerCase().contains(lowerCaseFilter)) {
					return true;
					// Filter matches with date
				} else if (formSearch.getKundeefternavn().toLowerCase().contains(lowerCaseFilter)) {
					return true;
					// Filter matches with date
				}

				else if (tlfnr.toLowerCase().contains(lowerCaseFilter)) {
					return true;

				}

				// No match at all
				return false;
			});
		});

		SortedList<Kunde> sortedData = new SortedList<>(filteredData);

		// Connect the SortedList comparator to the TableView comparator
		// 'The comparator that denotes the order of this SortedList'
		sortedData.comparatorProperty().bind(formTable.comparatorProperty());

		// Tilføjer sorteret og filtreret data til vores TableView
		formTable.setItems(sortedData);

		// Fanger det vaglte element

		// Make TFields number only accept number inputs
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

		// Font sizes
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

		// Add to pane
		pane4.getChildren().addAll(kundefornavnTField, kundeefternavnTField, PostnrTField, ByTField, VejTField,
				HusnrTField, tlfTField, cprTField, mailTField, opdaterKundeBtn, opretStatusLbl, ferraripic, lgnNameLbl,
				SoegTField, formTable);

		// Show scene
		scene4 = new Scene(pane4, 950, 670);
		opretKundeStage.setScene(scene4);
		opretKundeStage.show();

		opdaterKundeBtn.setOnAction(e -> checkOpdatering());

		formTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 1) {
				setTFields();
			}
		});
	}

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
			opdaterFail();

		} else if (cprTField.getText().length() != 10) {
			cprFail();

		}

		else
			opdaterKunde();
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

	private void opdaterFail() {
		opretStatusLbl.setText("Udfyld venligst alle felter!");
		opretStatusLbl.setTextFill(Color.WHITE);
		opretStatusLbl.relocate(345, 490);

	}

	private void cprFail() {
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

}
