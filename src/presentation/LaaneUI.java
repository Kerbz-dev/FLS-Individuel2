package presentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.LoginVerification;

public class LaaneUI {
	private BorderPane bp;
	private Stage LaaneUIStage;
	private Button opretTilbud, redigerTilbud, fjernTilbud;
	private Line bottomLine, upperLine;
	private Label Lånetilbud, Navn, Tlf, CPR, Addresse, Mail, Bilmodel, Bilpris, Tilbudspris, Laaneperiode, navnOutput,
			tlfOutput, cprOutput, addresseOutput, mailOutput, bilmodelOutput, bilprisOutput, tilbudsprisOutput,
			laaneperiodeOutput;
	private Scene scene;
	private Pane pane1;
	private Image ferrari;
	private ImageView ferraripic;
	private TextField Søg;
	private Label loginName;
//private TableView<LaaneUI> laaneTilbudTable;
//private TableColumn<LaaneUI, String> datoColumn;
//private TableColumn<LaaneUI, String> laanetilbudColumn;

	/*
	 * public LaaneUI(String date, String tilbud) { this.date = date; this.tilbud =
	 * tilbud; }
	 */

	public void start() {

		LaaneUIStage = new Stage();
		LaaneUIStage.setTitle("Ferrari lånesystem");
		pane1 = new Pane();
		opretTilbud = new Button("Opret Tilbud");
		redigerTilbud = new Button("Rediger Tilbud");
		fjernTilbud = new Button("Fjern Tilbud");
		Lånetilbud = new Label("LÅNETILBUD");
		Navn = new Label("Navn:");
		Tlf = new Label("Tlf:");
		CPR = new Label("CPR-nr:");
		Addresse = new Label("Adresse:");
		Mail = new Label("Mail:");
		Bilmodel = new Label("Bilmodel:");
		Bilpris = new Label("Bilpris:");
		Tilbudspris = new Label("Tilbudspris:");
		Laaneperiode = new Label("Låneperiode:");
		navnOutput = new Label("Martin Godthaab Larsen");
		tlfOutput = new Label("222222222222");
		cprOutput = new Label("333333333");
		addresseOutput = new Label("44444444");
		mailOutput = new Label("55555555");
		bilmodelOutput = new Label("6666666666");
		bilprisOutput = new Label("77777777");
		tilbudsprisOutput = new Label("8888888888");
		laaneperiodeOutput = new Label("9999999999");
		bottomLine = new Line();
		upperLine = new Line();
		Søg = new TextField();
		ferrari = new Image("https://seeklogo.com/images/F/ferrari-logo-7935CF173C-seeklogo.com.png");
		ferraripic = new ImageView();
		bp = new BorderPane();
		loginName = new Label();

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

		// Labels
		Navn.setFont(new Font(24));
		Navn.relocate(436, 160);

		Tlf.setFont(new Font(24));
		Tlf.relocate(436, 210);

		CPR.setFont(new Font(24));
		CPR.relocate(436, 260);

		Addresse.setFont(new Font(24));
		Addresse.relocate(436, 310);

		Mail.setFont(new Font(24));
		Mail.relocate(436, 360);

		Bilmodel.setFont(new Font(24));
		Bilmodel.relocate(436, 410);

		Bilpris.setFont(new Font(24));
		Bilpris.relocate(436, 460);

		Tilbudspris.setFont(new Font(24));
		Tilbudspris.relocate(436, 510);

		Laaneperiode.setFont(new Font(24));
		Laaneperiode.relocate(436, 560);

		Lånetilbud.setFont(new Font(36));
		Lånetilbud.relocate(645, 55);

		navnOutput.setFont(new Font(18));
		navnOutput.relocate(585, 166);

		tlfOutput.setFont(new Font(18));
		tlfOutput.relocate(585, 216);

		cprOutput.setFont(new Font(18));
		cprOutput.relocate(585, 265);

		addresseOutput.setFont(new Font(18));
		addresseOutput.relocate(585, 316);

		mailOutput.setFont(new Font(18));
		mailOutput.relocate(585, 364);

		bilmodelOutput.setFont(new Font(18));
		bilmodelOutput.relocate(585, 414);

		bilprisOutput.setFont(new Font(18));
		bilprisOutput.relocate(585, 464);

		tilbudsprisOutput.setFont(new Font(18));
		tilbudsprisOutput.relocate(585, 516);

		laaneperiodeOutput.setFont(new Font(18));
		laaneperiodeOutput.relocate(585, 566);
		

		loginName.relocate(829, 736);
		loginName.setText("Logget ind som " + ": " + "medarbejderNavn");
		


		// Search function
		Søg.setLayoutX(23);
		Søg.setLayoutY(39);
		Søg.setPrefHeight(35);
		Søg.setPrefWidth(322);
		Søg.setFont(new Font(18));
		Søg.setPromptText("Søg tlf. nr.");
		Søg.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		// Add bottom line
		bottomLine.setStartX(-171);
		bottomLine.setEndX(556);
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

		// Setting background color for text zone
		Rectangle background = new Rectangle();
		background.setFill(Color.WHITESMOKE);
		background.setHeight(681);
		background.setArcWidth(5);
		background.setArcHeight(5);
		background.setWidth(727);
		background.setHeight(681);
		background.setStroke(Color.BLACK);
		background.relocate(382, 37);

		// Adding to pane
		pane1.getChildren().addAll(Søg, background, Addresse, CPR, Tilbudspris, Laaneperiode, Lånetilbud, Bilmodel,
				Navn, navnOutput, bilmodelOutput, laaneperiodeOutput, Tlf, bilprisOutput, mailOutput, tilbudsprisOutput,
				tlfOutput, addresseOutput, Mail, cprOutput, Bilpris, upperLine, bottomLine, ferraripic, opretTilbud,
				redigerTilbud, fjernTilbud, loginName);

		scene = new Scene(pane1);
		LaaneUIStage.setScene(scene);
		LaaneUIStage.show();

	}

//	laaneTilbudTable = new TableView<>();
	/*
	 * <ImageView fitHeight="181.0" fitWidth="263.0" layoutX="972.0" layoutY="453.0"
	 * pickOnBounds="true" preserveRatio="true"> <image> <Image
	 * url="@../../../../Pictures/ferrari.png" />
	 */
	// Set font size and position in pane
	/*
	 * <TableView layoutX="23.0" layoutY="81.0" prefHeight="636.0"
	 * prefWidth="322.0"> <columns> <TableColumn prefWidth="114.0" text="DATO" />
	 * <TableColumn prefWidth="207.0" text="LÅNETILBUD" /> TableColumn<LaaneUI, >
	 */

	// date column
	/*
	 * TableColumn<LaaneUI, String> dateColumn = new TableColumn<>("DATO");
	 * datoColumn.setPrefWidth(114); datoColumn.setCellValueFactory(new
	 * PropertyValueFactory<>(date));
	 */

	// laane tilbud column
	/*
	 * TableColumn<LaaneUI, String> laaneColumn = new TableColumn<>("LÅNETILBUD");
	 * datoColumn.setPrefWidth(114); datoColumn.setCellValueFactory(new
	 * PropertyValueFactory<>(tilbud));
	 */
	// add to tableview
//	laaneTilbudTable.setItems(getLaaneTilbud());
	// laaneTilbudTable.getColumns().addAll(dateColumn, laaneColumn);

	// assign width etc
	/*
	 * laaneTilbudTable.setLayoutX(23); laaneTilbudTable.setLayoutY(81);
	 * laaneTilbudTable.setPrefHeight(636); laaneTilbudTable.setPrefWidth(322);
	 */
	// laanetilbudColumn.setPrefWidth(114);

	/*
	 * <TableView layoutX="23.0" layoutY="81.0" prefHeight="636.0"
	 * prefWidth="322.0"> <columns> <TableColumn prefWidth="114.0" text="DATO" />
	 * <TableColumn prefWidth="207.0" text="LÅNETILBUD" />
	 */

	/*
	 * public ObservableList<LaaneUI> getLaaneTilbud() { ObservableList<LaaneUI>
	 * laanetilbudList = FXCollections.observableArrayList();
	 * laanetilbudList.add(new LaaneUI("18/02-2020", "laanetilbud"));
	 * laanetilbudList.add(new LaaneUI("20/02-2020", "laanetilbud2")); return
	 * laanetilbudList;
	 */

}