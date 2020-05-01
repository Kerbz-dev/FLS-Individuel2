package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.LoginUI;
import presentation.OpretLoginUI;
import db.OpretLoginDB;

public class OpretBruger {

	
	private OpretLoginUI createlogUI;
	private String medarbejderNavn;
	private String createUsername;
	private String createPassword;
	public OpretBruger(OpretLoginUI createlogUI) {
		this.createlogUI = createlogUI;
		
	}

	OpretLoginDB login = new OpretLoginDB();

	public void opretBruger() {
	
    	medarbejderNavn = createlogUI.name.getText();
		createUsername = createlogUI.createUsername.getText();
		createPassword = createlogUI.createPassword.getText();
		
    	if(medarbejderNavn.isEmpty() || createUsername.isEmpty() || createPassword.isEmpty()) {
    		System.out.println("Please enter medarbejder navn, username and password.");
    	}
    	else {

		login.createLogin(medarbejderNavn, createUsername, createPassword);
    	}
	}
}