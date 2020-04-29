package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
	void opretBruger(ActionEvent event) {

		medarbejderNavn = opretNavnField.getText();
		username = opretBrugerField.getText();
		password = opretPassField.getText();
	
		login.createLogin(medarbejderNavn, username, password);
	
	}
}