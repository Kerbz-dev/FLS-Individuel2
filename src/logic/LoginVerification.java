package logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import db.Datakobling;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.LoginUI;

public class LoginVerification {

	String medarbejderNavn;
	
//	private Datakobling DB;
	private LoginUI loginui;
	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public LoginVerification(LoginUI loginui) {
		this.loginui = loginui;

	}

	


//	JOptionPane.showMessageDialog(null, "Username or Password blank")
	
	public void loginBtn() {
		int count = 0;
		String usernameInput = loginui.userLoginField.getText().trim();
		String passwordInput = loginui.passLoginField.getText().trim();
		System.out.println(usernameInput);
		System.out.println(passwordInput);
		System.out.println("user input virker");
			String query = "SELECT * FROM bilsealger";
			
	try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery(query);
		System.out.println("connection established");
		count++;
		boolean check = false;
		while(rs.next());
		String username = rs.getString("username");
		String password = rs.getString("password");
		System.out.println(username);
		System.out.println(password);
		System.out.println("retrieved username + password from DB");
		
		if(username.equals(usernameInput) && password.equals(passwordInput)) {
			check = true;
			ps.close();
			System.out.println("Login successful!");
		} else {
			System.out.println("Login failed");
				
		}
		
	} catch (Exception e) {
	
	}
	}
}

		
		
		
	

