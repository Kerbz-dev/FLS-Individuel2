package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.LoginUI;
import presentation.OpretLoginUI;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.OpretLoginDB;

public class OpretBruger {

	private OpretLoginUI createloginUI;
	private String medarbejderNavn;
	private String createUsername;
	private String createPassword;
	private String username;
	private String password;

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
		
			
		
			
		}
		else {
			login.createLogin(medarbejderNavn, createUsername, createPassword);
			createloginUI.opretLoginSuccess();
		}
	}
	 
	 public void checkDuplicateUserPW() {
			    username = new String();
		        password = new String();
		        String usernameInput = createUsername; 
		        String passwordInput = createloginUI.createPassword.getText();
		        
		    try  {
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;"
						+ "databaseName=" + "FerrariDB" + ";" + "integratedSecurity=true;");
		    
		        try(PreparedStatement st = connection.prepareStatement("select * from bilsealger WHERE username=? AND password=?")) {
		            st.setString(1, username);
		            st.setString(2, password);
		            try(ResultSet rs = st.executeQuery()) {
		                if(rs.next()) 
				         {
				           System.out.println("Sofarsogud");
				           if(username.equals(usernameInput) || (password.equals(passwordInput)))//this part does not happen even if it should
				           {
				   	        System.out.println(username);
					        System.out.println(password);
				               System.out.println("It already exists");
				           }
				         } }
		            }

		     }
		    

		     catch (SQLException e) 
		     {
		        System.out.println("SQL Exception: "+ e.toString());
		      } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	 }
}