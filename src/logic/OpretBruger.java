package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.LoginUI;
import presentation.OpretLoginUI;
import javafx.scene.paint.Color;

import db.OpretLoginDB;

public class OpretBruger {

	private OpretLoginUI createloginUI;
	private String medarbejderNavn;
	private String createUsername;
	private String createPassword;

	public OpretBruger(OpretLoginUI createlogUI) {
		this.createloginUI = createlogUI;

	}

	 public void opretBruger() {
		OpretLoginDB login = new OpretLoginDB();
		medarbejderNavn = createloginUI.name.getText();
		createUsername = createloginUI.createUsername.getText();
		createPassword = createloginUI.createPassword.getText();

		if (medarbejderNavn.isEmpty() || createUsername.isEmpty() || createPassword.isEmpty()) {
			createloginUI.opretLoginFail();
		} else {
			login.createLogin(medarbejderNavn, createUsername, createPassword);
			createloginUI.opretLoginSuccess();
		}
	}
}