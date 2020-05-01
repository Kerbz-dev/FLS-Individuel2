package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import db.OpretLoginDB;


public class OpretBruger {
	String medarbejderNavn;
	String username;
	String password;
	
    @FXML
    private TextField opretNavnField;

    @FXML
    private TextField opretBrugerField;
    
    @FXML
    private TextField opretPassField;
	OpretLoginDB login = new OpretLoginDB();

	@FXML
	public void opretBruger(ActionEvent event) {

		medarbejderNavn = opretNavnField.getText();
		username = opretBrugerField.getText();
		password = opretPassField.getText();
	
		login.createLogin(medarbejderNavn, username, password);
	
	}
}