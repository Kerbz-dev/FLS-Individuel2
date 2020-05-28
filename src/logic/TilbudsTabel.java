package logic;

import entity.LaaneTilbud;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TilbudsTabel {
	private ObservableList<LaaneTilbud> formList;
	private TableView<LaaneTilbud> formTable = new TableView<LaaneTilbud>();
	private String tilbudsidString;
	private String laanstatus;
	private getLaan laanlogic = new getLaan();
	private TextField Søg;
	
	
	public void visTable() {
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
//	ColumnFornavn.setCellValueFactory(e -> {
//		Kunde kunde = e.getValue();
//		return new SimpleStringProperty(kunde.getKundefornavn());
//
//	});
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

}


}
