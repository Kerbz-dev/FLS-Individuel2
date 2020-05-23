package db;

import java.sql.Statement;

public class FjernLaanDB {
	Datakobling DB = new Datakobling();

	public void fjernTilbud(int tlfnr, String tilbudsidString) {

		try {

			Statement statement = DB.connection.createStatement();

			statement.executeUpdate("DELETE FROM laanetilbud WHERE telefonnummer='" + tlfnr
					+ "' AND tilbudsid='" + tilbudsidString + "'");
		} catch (Exception e) {
			System.out.println("Got exception in OpretLaanDB");
			System.out.println(e.getMessage());
		}
	}
}
