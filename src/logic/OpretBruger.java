package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.LoginUI;
import presentation.OpretLoginUI;
import db.OpretLoginDB;

public class OpretBruger {

	
	private OpretLoginUI createloginUI;
	private String medarbejderNavn;
	private String createUsername;
	private String createPassword;
	
	public OpretBruger(OpretLoginUI createlogUI) {
		this.createloginUI = createlogUI;
		
	}

	OpretLoginDB login = new OpretLoginDB();

	public void opretBruger() {
	
    	medarbejderNavn = createloginUI.name.getText();
		createUsername = createloginUI.createUsername.getText();
		createPassword = createloginUI.createPassword.getText();
		
    	if(medarbejderNavn.isEmpty() || createUsername.isEmpty() || createPassword.isEmpty()) {
    		System.out.println("Please enter medarbejder navn, username and password.");
    	}
    	else {

		login.createLogin(medarbejderNavn, createUsername, createPassword);
    	}
	}
}