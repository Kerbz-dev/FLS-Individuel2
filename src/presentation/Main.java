package presentation;

import javafx.application.Application;

import javafx.stage.Stage;


public class Main extends Application {

	public void start(Stage loginStage) {
		
		LoginUI uiLaunch = new LoginUI();
		uiLaunch.start(loginStage);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
