package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.control.Button;
import presentation.LoginUI;
import presentation.Main;
import presentation.adminUI;

public class LoginVerification {

//	private Datakobling DB;
	private LoginUI loginui;

	public LoginVerification(LoginUI loginui) {
		this.loginui = loginui;

	}

	public void loginCheck() {
		String usernameInput = loginui.userLoginField.getText();
		String passwordInput = loginui.passLoginField.getText();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;"
					+ "databaseName=" + "FerrariDB" + ";" + "integratedSecurity=true;");
			Statement stmt = con.createStatement();
			String sql = "Select * from bilsealger where username='" + usernameInput + "' and saelgerpassword='"
					+ passwordInput + "'";

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				loginui.loginSuccess();
			} else {
				adminLoginCheck();
			}
			con.close();

		} catch (Exception e) {
			System.out.println("Got exception from loginCheck() in LoginVerification");
			System.out.print(e);
		}
	}

	public void adminLoginCheck() {
		String usernameInput = loginui.userLoginField.getText();
		String passwordInput = loginui.passLoginField.getText();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;"
					+ "databaseName=" + "FerrariDB" + ";" + "integratedSecurity=true;");
			Statement stmt = con.createStatement();
			String sql2 = "Select * from administrator where adminbrugernavn='" + usernameInput
					+ "' and adminpassword='" + passwordInput + "'";
			ResultSet rs2 = stmt.executeQuery(sql2);
			if (rs2.next()) {
				loginui.loginSuccess();
				loginui.adminLoginSuccess();
			} else {
				loginui.loginFail();
			}
			con.close();

		} catch (Exception e) {
			System.out.println("Got exception from adminLoginCheck in LoginVerification");
			System.out.print(e);
		}

		/*
		 * Bedre måde at gøre det på, men kan ikke fange info fra DB
		 * 
		 * int count = 0; String usernameInput =
		 * loginui.userLoginField.getText().trim(); String passwordInput =
		 * loginui.passLoginField.getText().trim(); System.out.println(usernameInput);
		 * System.out.println(passwordInput); System.out.println("user input virker");
		 * String query = "SELECT * FROM bilsealger";
		 * 
		 * try { ps = con.prepareStatement(query); rs = ps.executeQuery(query);
		 * System.out.println("connection established"); count++; boolean check = false;
		 * while(rs.next()); String username = rs.getString("username"); String password
		 * = rs.getString("password"); System.out.println(username);
		 * System.out.println(password);
		 * System.out.println("retrieved username + password from DB");
		 * 
		 * if(username.equals(usernameInput) && password.equals(passwordInput)) { check
		 * = true; ps.close(); System.out.println("Login successful!"); } else {
		 * System.out.println("Login failed");
		 * 
		 * }
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 */
	}
}
