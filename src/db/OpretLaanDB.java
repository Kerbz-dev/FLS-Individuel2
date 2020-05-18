package db;

import java.sql.ResultSet;
import java.sql.Statement;

public class OpretLaanDB {
	private Datakobling DB = new Datakobling();
//	private int kundeindbetaling;
//	private int laanlaengde;
//	private boolean overstigergraense;
//	private int laanestatus;

	public void createLaan(String bilnavn, String bilpris, String udbetalingspris, String laanlaengde, String tlf,
			String kundenavn, String cpr, String mail, String adr) {

		try {
			Statement statement = DB.connection.createStatement();

			statement.executeUpdate("INSERT INTO laanetilbud  (kundeindbetaling,laanlaengde) VALUES ('"
					+ udbetalingspris + "', '" + laanlaengde + "')");
			statement.executeUpdate("insert into kunde (telefonnummer,kundefornavn,cpr_nummer,mail,bynavn) VALUES ('"
					+ cpr + "', '" + kundenavn + "', '" + cpr + "', '" + mail + "', '" + adr + "')");
			statement.executeUpdate("insert into biler (bilnavn,bilpris) VALUES ('"+ bilnavn + "', '" + bilpris + "')");
//			statement.executeUpdate("INSERT INTO kunde " + "VALUES ('" + cpr + "', '" + tlf + "', '" + kundenavn
//			+ "', '" + adr + "', '" + mail + "')");

		} catch (Exception e) {
			System.out.println("Got exception in OpretLaanDB");
			System.out.println(e.getMessage());
		}
	}

	public boolean kundeCheckDuplicate(String cpr, String tlf) {

		try {
			Statement stmt = DB.connection.createStatement();
			String sql = "Select * FROM kunde WHERE telefonnummer='" + tlf + "' OR cpr_nummer='" + cpr + "'";

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
				// System.out.println(duplicateCheck);
			}
			rs.close();

		} catch (Exception e) {
			System.out.println("Got exception from kundeCheckDuplicate in OpretLaanDB");
			System.out.print(e);
		}
		return false;
	}
}
