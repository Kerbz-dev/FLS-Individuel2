package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Datakobling {
	String databaseName;
	public Connection connection;

	public Datakobling() {
		databaseName = "FerrariDB";

		loadJdbcDriver();
		openConnection(databaseName);
	}

	public boolean loadJdbcDriver() {
		try {
			System.out.println("Loading JDBC driver...");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			System.out.println("JDBC driver loaded");

			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load JDBC driver!");
			return false;
		}
	}

	public boolean openConnection(String databaseName) {
		try {
			String connectionString = "jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;" + "databaseName="
					+ databaseName + ";" + "integratedSecurity=true;";

			connection = null;

			System.out.println("Connecting to database...");

			connection = DriverManager.getConnection(connectionString);

			System.out.println("Connected to database");

			return true;
		} catch (SQLException e) {
			System.out.println("Could not connect to database!");
			System.out.println(e.getMessage());

			return false;
		}
	}


	public boolean LoginCheck(String username, String password) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "Select * from bilsaelger where saelgerbrugernavn='" + username + "' and saelgerpassword='" + password
					+ "'";

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Got exception from LoginCheck in Datakobling ");
			System.out.print(e);

		}
		return false;

	}

	public boolean adminLoginCheck(String username, String password) {

		try {

			Statement stmt = connection.createStatement();
			String sql = "Select * from administrator where adminbrugernavn='" + username + "' and adminpassword='"
					+ password + "'";

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Got exception from adminLoginCheck() in Datakobling");
			System.out.print(e);
		}
		return false;
		
	}

	public boolean userCheckDuplicate(String CreateUsername) {

		try {
			Statement stmt = connection.createStatement();
			String sql = "Select * from bilsaelger where saelgerbrugernavn='" + CreateUsername + "' ";

			// or saelgerpassword='"+ passwordFieldInput + "'
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {

				return true;
				// System.out.println(duplicateCheck);
			}
			rs.close();

		} catch (Exception e) {
			System.out.println("Got exception from createUserCheckDuplicate in OpretBruger");
			System.out.print(e);
		}
		return false;
	}
}
