package db;

import java.sql.Statement;

public class OpretLoginDB {

	public void createLogin(String medarbejderNavn, String CreateUsername, String CreatePassword) {
		Datakobling DB = new Datakobling();
		try {
			Statement statement = DB.connection.createStatement();

			statement.executeUpdate("INSERT INTO bilsealger " + "VALUES ('" + medarbejderNavn + "', '" + CreateUsername
					+ "', '" + CreatePassword + "')");

			DB.connection.close();

		} catch (Exception e) {
			System.out.println("Got exception in OpretLoginDB");
			System.out.println(e.getMessage());
		}
	}
}
