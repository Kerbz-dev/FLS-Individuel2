package presentation;

 

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.LoginVerification;
import logic.OpretBruger;

 

public class OpretLoginUI {

	private Stage OpretLG;

    public TextField name;
    public TextField createUsername;
    public TextField createPassword;
     Button OpretLoginKnap;
     private Scene scene2;
     private Pane pane2;
    // private BorderPane bp2;
    

     
     public void start() {
    	 OpretLG = new Stage();
         OpretLG.setTitle("Lav bruger");
         
         
   //    bp2 = new BorderPane();
        pane2 = new Pane();
         
           OpretLoginKnap = new Button("Opret Bruger");
        
         name = new TextField();
        createUsername = new TextField();
         createPassword = new TextField();
         
           //name.setPrefHeight(30);
          //name.setPrefWidth(214);
          name.setFont(new Font(24));
         name.setPromptText("Medarbejder navn");
         name.relocate(57, 76);
         
         //createUsername.setPrefHeight(30);
         //createUsername.setPrefWidth(214);
         createUsername.setFont(new Font(24));
          createUsername.setPromptText("Brugernavn");
          createUsername.relocate(57, 149);
     
         //createPassword.setPrefHeight(30);
         //createPassword.setPrefWidth(214);
         createPassword.setFont(new Font(24));
         createPassword.setPromptText("Password");
         createPassword.relocate(57, 222);
         
     //    OpretLoginKnap.setPrefHeight(40);
    //    OpretLoginKnap.setPrefWidth(154);
        OpretLoginKnap.relocate(57, 313);
        OpretLoginKnap.setFont(new Font(24));
        
    
        
        pane2.setPrefHeight(200);
        pane2.setPrefWidth(200);
     
        
        
         //Add to pane
        pane2.getChildren().add(name);
        pane2.getChildren().add(createUsername);
        pane2.getChildren().add(createPassword);
        pane2.getChildren().add(OpretLoginKnap);
    //    bp2.getChildren().add(pane2);

 
        // Action buttons
		OpretLoginKnap.setOnAction(e -> opretBruger()); 
         
        //Show scene
        scene2 = new Scene(pane2, 600, 400);
        OpretLG.setScene(scene2);
        OpretLG.show();
     
         
         
     }
     
    public void opretBruger() {
 		
 		OpretBruger oprBruger = new OpretBruger(this);
 		
 		oprBruger.opretBruger();
 	}
     
}
 