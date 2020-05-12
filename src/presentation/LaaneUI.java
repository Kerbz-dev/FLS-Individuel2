package presentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LaaneUI {
	private BorderPane bp;
	private Stage LaaneUIStage;
	private Button opretTilbud, redigerTilbud, fjernTilbud, godkendBtn, afvisBtn;
	private Line bottomLine, upperLine;
	private Label L�netilbud, Navn, Tlf, CPR, Addresse, Mail, Bilmodel, Bilpris, Laaneperiode, navnOutput,
			tlfOutput, cprOutput, addresseOutput, mailOutput, bilmodelOutput, bilprisOutput, loginName,
			mdlydelseOutput, udbetalingLbl, mdlydelseLbl, samletprisLbl, prisoutputLbl, periodeoutputLbl, udbtloutputLbl;
	private Scene scene;
	private Pane pane1;
	private Image ferrari;
	private ImageView ferraripic;
	private TextField S�g;
	private TableView tilbudTbl;

	public void start() {

		LaaneUIStage = new Stage();
		LaaneUIStage.setTitle("Ferrari l�nesystem");
		LaaneUIStage.getIcons().add(new Image("https://i.pinimg.com/564x/c9/87/c8/c987c8a5c896fca22c5cfbd62edb7359.jpg"));
		pane1 = new Pane();
		opretTilbud = new Button("Opret Tilbud");
		redigerTilbud = new Button("Rediger Tilbud");
		fjernTilbud = new Button("Fjern Tilbud");
		L�netilbud = new Label("L�NETILBUD");
		Navn = new Label("Navn:");
		Tlf = new Label("Tlf:");
		CPR = new Label("CPR-nr:");
		Addresse = new Label("Adresse:");
		Mail = new Label("Mail:");
		Bilmodel = new Label("Bilmodel:");
		Bilpris = new Label("Bilpris:");
		Laaneperiode = new Label("L�neperiode:");
		navnOutput = new Label("Martin Godthaab Larsen");
		tlfOutput = new Label("222222222222");
		cprOutput = new Label("333333333");
		addresseOutput = new Label("44444444");
		mailOutput = new Label("55555555");
		bilmodelOutput = new Label("6666666666");
		bilprisOutput = new Label("77777777");
		mdlydelseOutput = new Label("9999999999");
		bottomLine = new Line();
		upperLine = new Line();
		S�g = new TextField();
		ferrari = new Image("https://seeklogo.com/images/F/ferrari-logo-7935CF173C-seeklogo.com.png");
		ferraripic = new ImageView();
		bp = new BorderPane();
		loginName = new Label();
		udbetalingLbl = new Label("Udbetaling:");
		mdlydelseLbl = new Label("Mdl. ydelse:"); 
		samletprisLbl = new Label("Samlet pris: "); 
		prisoutputLbl = new Label("487.292.200,-"); 
		periodeoutputLbl = new Label("5 �r"); 
		udbtloutputLbl = new Label("5.000.000");
		godkendBtn = new Button("Godkend");
		afvisBtn = new Button("Afvis");
		tilbudTbl = new TableView();
		
		
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
		godkendBtn.relocate(41, 663);
		
		afvisBtn.setPrefHeight(39);
		afvisBtn.setPrefWidth(134);
		afvisBtn.setFont(new Font(18));
		afvisBtn.relocate(191, 663);
		
		/*
	    <Button layoutX="41.0" layoutY="663.0" mnemonicParsing="false" prefHeight="39.0" prefWidth="134.0" text="Godkend">
        <font>
           <Font size="18.0" />
        </font>
     </Button>
     <Button layoutX="191.0" layoutY="663.0" mnemonicParsing="false" prefHeight="39.0" prefWidth="134.0" text="Afvis">
		
*/
        
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
		Laaneperiode.relocate(430, 440);
		
		udbetalingLbl.setFont(new Font(24));
		udbetalingLbl.relocate(430, 560);
		
		mdlydelseLbl.setFont(new Font(24));
		mdlydelseLbl.relocate(430, 520);
		
		samletprisLbl.setFont(new Font(24));
		samletprisLbl.relocate(430, 480);
		
		
		L�netilbud.setFont(new Font(36));
		L�netilbud.relocate(645, 55);

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

		mdlydelseOutput.setFont(new Font(18));
		mdlydelseOutput.relocate(577, 524);
		
		prisoutputLbl.setFont(new Font(18));
		prisoutputLbl.relocate(577, 480);
		
		periodeoutputLbl.setFont(new Font(18));
		periodeoutputLbl.relocate(577, 444);
		
		udbtloutputLbl.setFont(new Font(18));
		udbtloutputLbl.relocate(577, 564);
		
		loginName.relocate(829, 736);
		loginName.setText("Logget ind som " + ": " + "medarbejderNavn");
		

		// Search function
		S�g.setLayoutX(23);
		S�g.setLayoutY(39);
		S�g.setPrefHeight(35);
		S�g.setPrefWidth(322);
		S�g.setFont(new Font(18));
		S�g.setPromptText("S�g tlf. nr.");
		S�g.setStyle("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");

		// Add bottom line
		bottomLine.setStartX(-171);
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
		
		// Making TableView
		tilbudTbl.setEditable(true);
		
		// Creating colums for tblView
	      TableColumn dateCol = new TableColumn("Dato");
	      TableColumn tilbudCol = new TableColumn("L�netilbud");
	      tilbudTbl.getColumns().addAll(dateCol, tilbudCol);

		// Setting background color for text zone
		Rectangle background = new Rectangle();
		background.setFill(Color.WHITESMOKE);
		background.setHeight(681);
		background.setWidth(727);
		background.setArcWidth(5);
		background.setArcHeight(5);
		background.setStroke(Color.BLACK);
		background.relocate(382, 37);
//  <Rectangle arcHeight="5.0" arcWidth="5.0" fill="#f8f4f4" height="79.0" layoutX="23.0" layoutY="639.0" stroke="BLACK" strokeType="INSIDE" width="322.0" />
		//<Rectangle arcHeight="5.0" arcWidth="5.0" fill="#f8f4f4" height="77.0" layoutX="23.0" layoutY="641.0" stroke="BLACK" strokeType="INSIDE" width="322.0" />
		Rectangle background2 = new Rectangle();
		background2.setFill(Color.WHITESMOKE);
		background2.setHeight(79);
		background2.setWidth(322);
		background2.setArcWidth(5);
		background2.setArcHeight(5);
		background2.setStroke(Color.BLACK);
		background2.relocate(23, 639);
		
		// Adding to pane
		pane1.getChildren().addAll(S�g, background, background2, Addresse, CPR, Laaneperiode, L�netilbud, Bilmodel,
				Navn, navnOutput, bilmodelOutput, mdlydelseOutput, Tlf, bilprisOutput, mailOutput,
				tlfOutput, addresseOutput, Mail, cprOutput, Bilpris, upperLine, bottomLine, ferraripic, opretTilbud,
				redigerTilbud, fjernTilbud, loginName, godkendBtn, afvisBtn, prisoutputLbl, periodeoutputLbl, 
				udbtloutputLbl, samletprisLbl, mdlydelseLbl, udbetalingLbl, tilbudTbl);

		scene = new Scene(pane1);
		LaaneUIStage.setScene(scene);
		LaaneUIStage.show();
		
		opretTilbud.setOnAction(e -> opretLaaneUI());

	}
	
	  private void opretLaaneUI() {
			OpretLaanUI opretLaan = new OpretLaanUI();
			opretLaan.start();
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
	 * <TableColumn prefWidth="207.0" text="L�NETILBUD" /> TableColumn<LaaneUI, >
	 */

	// date column
	/*
	 * TableColumn<LaaneUI, String> dateColumn = new TableColumn<>("DATO");
	 * datoColumn.setPrefWidth(114); datoColumn.setCellValueFactory(new
	 * PropertyValueFactory<>(date));
	 */

	// laane tilbud column
	/*
	 * TableColumn<LaaneUI, String> laaneColumn = new TableColumn<>("L�NETILBUD");
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
	 * <TableColumn prefWidth="207.0" text="L�NETILBUD" />
	 */

	/*
	 * public ObservableList<LaaneUI> getLaaneTilbud() { ObservableList<LaaneUI>
	 * laanetilbudList = FXCollections.observableArrayList();
	 * laanetilbudList.add(new LaaneUI("18/02-2020", "laanetilbud"));
	 * laanetilbudList.add(new LaaneUI("20/02-2020", "laanetilbud2")); return
	 * laanetilbudList;
	 */

}