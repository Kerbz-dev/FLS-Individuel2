package presentation;

import javafx.application.Application;

import javafx.stage.Stage;
import logic.Traade;


public class Main extends Application {
	
	public static void main(String[] args) {
		
	    for ( int i=0; i<5; i++ ) {

	      Traade tråd = new Traade(i);
	      tråd.start();

	    }
		launch(args);
	}

	public void start(Stage loginStage) {
		
		LoginUI uiLaunch = new LoginUI();
		uiLaunch.start();

	}


}
