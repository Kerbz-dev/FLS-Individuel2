package presentation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;

public class adminUI {
	
	private Button laan;
	private Button laaneanmodning;
	private Button opretSealger;
	
	private Scene scene;
    private Pane pane;
    private Image ferrari;
    private ImageView ferraripic;
	private Stage adminUIStage;
    
    
    public void start() {

    	adminUIStage = new Stage();
        
        
        pane = new Pane();
        ferrari = new Image("https://3.bp.blogspot.com/-DRM75enaO7s/VDrpAiCm55I/AAAAAAAABGM/VnsBvuXIygU/s1600/Ferrari%2BCar%2Blogos.jpg%22");
        ferraripic = new ImageView();
        ferraripic.setImage(ferrari);
        
        
        
      // Button assignments
      laan = new Button("Opret lån");
      laaneanmodning = new Button("Låneanmodninger");
      opretSealger = new Button("Opret Sælger");
       
      
      pane.setStyle("-fx-background-color: #ff2800");
      
      
      ferraripic.relocate(223,30);
      ferraripic.setFitWidth(300);
      ferraripic.setFitHeight(150);
      
      laan.setPrefHeight(62);
      laan.setPrefWidth(189);
      laan.relocate(274, 235);
      
      laaneanmodning.setPrefHeight(62);
      laaneanmodning.setPrefWidth(189);
      laaneanmodning.relocate(274, 317);
      
      opretSealger.setPrefHeight(62);
      opretSealger.setPrefWidth(189);
      opretSealger.relocate(274, 404);
      
      
      pane.getChildren().add(ferraripic);
      pane.getChildren().add(laaneanmodning);
      pane.getChildren().add(opretSealger);
      pane.getChildren().add(laan);
      
      
      scene = new Scene(pane, 755, 551);
      adminUIStage.setScene(scene);
      adminUIStage.show();
      
		opretSealger.setOnAction(e -> opretLoginUI());
      
}
    
    public void opretLoginUI() {
		OpretLoginUI oprlogUI = new OpretLoginUI();
		oprlogUI.start();
	}
    
    
    
}
