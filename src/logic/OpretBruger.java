package logic;


import presentation.OpretLoginUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import db.OpretLoginDB;

public class OpretBruger {

	private OpretLoginUI createloginUI;
	private String medarbejderNavn;
	private String createUsername;
	private String createPassword;
	private boolean duplicateCheck;


	public OpretBruger(OpretLoginUI createlogUI) {
		this.createloginUI = createlogUI;

	}

	public void opretBruger() {
		OpretLoginDB login = new OpretLoginDB();
		medarbejderNavn = createloginUI.name.getText();
		createUsername = createloginUI.createUsername.getText();
		createPassword = createloginUI.createPassword.getText();
		createUserCheckDuplicate();

		if (medarbejderNavn.isEmpty() && createUsername.isEmpty() && createPassword.isEmpty()) {
			createloginUI.opretLoginFailAll();
		}

		  else if (medarbejderNavn.isEmpty()) {
			createloginUI.opretLoginFailMNavn();
		} else if (createUsername.isEmpty()) {
			createloginUI.opretLoginFailUserName();
		} else if (createPassword.isEmpty()) {
			createloginUI.opretLoginFailPassword();
		} else if (this.duplicateCheck == true) {
			createloginUI.opretLoginFailDuplicateBruger();

		} else {
			login.createLogin(medarbejderNavn, createUsername, createPassword);
			createloginUI.opretLoginSuccess();

		}
	}

	public void createUserCheckDuplicate() {
		String usernameFieldInput = createloginUI.createUsername.getText();
		String passwordFieldInput = createloginUI.createPassword.getText();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;"
					+ "databaseName=" + "FerrariDB" + ";" + "integratedSecurity=true;");
			Statement stmt = con.createStatement();
			String sql = "Select * from bilsealger where username='" + usernameFieldInput + "' and password='"
					+ passwordFieldInput + "'";
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				duplicateCheck = true;
				// System.out.println(duplicateCheck);
			} else {
				duplicateCheck = false;
				// System.out.println(duplicateCheck);
			}

			con.close();

		} catch (Exception e) {
			System.out.print(e);
		}
	}
}