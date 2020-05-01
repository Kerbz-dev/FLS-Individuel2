package presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.OpretBruger;

	public class Main extends Application {
	
		OpretBruger opbruger = new OpretBruger();
	    @Override
	    public void start(Stage primaryStage) {
	    	try {
	    	Parent root = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
	      
	    	Scene scene = new Scene(root);
	    	primaryStage.setScene(scene);
	    	primaryStage.setTitle("Ferrari login");
	    	primaryStage.show();
	    } catch(Exception e) {
	    	e.printStackTrace(); }
	    }

	
	    public static void main(String[] args) {
	        launch(args);
	    }
	    }
	
	
