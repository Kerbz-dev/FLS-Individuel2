package db;

import java.sql.Statement;

public class OpretLaanDB {
	private Datakobling DB = new Datakobling();
//    private int kundeindbetaling;
//    private int laanlaengde;
//    private boolean overstigergraense;
//    private int laanestatus;

	public void createLaan(int tlf, int bilid, String udbetalingGetText, String laanleangdeGetText, boolean overstigergraense,double rente,
			double mdlydelse, double samletpris, int bilinventar) {

		try {
			Statement statement = DB.connection.createStatement();

			/*
			 * ////////////////////////////////////////////////////////// mangler
			 * overstigergraense + laanestatus til første update
			 *//////////////////////////////////////////////////////////
			statement.executeUpdate(
					"INSERT INTO laanetilbud  (telefonnummer, bilid, kundeindbetaling,laanlaengde, overstigergraense, rente,mdlydelse, samletpris) VALUES ('"
							+ tlf + "', '" + bilid + "', '" + udbetalingGetText + "', '" + laanleangdeGetText + "', '" + overstigergraense + "', '"
							+ rente + "','" + mdlydelse + "', '" + samletpris + "')");
			statement.executeUpdate("UPDATE biler SET inventar = '" + bilinventar + "' WHERE bilid = " + bilid + "");
			/*
			 * statement .executeUpdate("insert into biler (bilnavn,bilpris) VALUES ('" +
			 * bilnavnGetText + "', '" + bilprisGetText + "')");
			 */
//            statement.executeUpdate("INSERT INTO kunde " + "VALUES ('" + cpr + "', '" + tlf + "', '" + kundenavn
//            + "', '" + adr + "', '" + mail + "')");

		} catch (Exception e) {
			System.out.println("Got exception in OpretLaanDB");
			System.out.println(e.getMessage());
		}

	}

	public void createStatus(int laanestatus, int tilbudsid) {
		try {
			Statement statement = DB.connection.createStatement();

			/*
			 * ////////////////////////////////////////////////////////// mangler
			 * overstigergraense + laanestatus til første update
			 *//////////////////////////////////////////////////////////
			statement.executeUpdate(
					("UPDATE laanetilbud SET laanestatus = '" + laanestatus + "' WHERE tilbudsid = " + tilbudsid + ""));

			/*
			 * statement .executeUpdate("insert into biler (bilnavn,bilpris) VALUES ('" +
			 * bilnavnGetText + "', '" + bilprisGetText + "')");
			 */
//               statement.executeUpdate("INSERT INTO kunde " + "VALUES ('" + cpr + "', '" + tlf + "', '" + kundenavn
//               + "', '" + adr + "', '" + mail + "')");

		} catch (Exception e) {
			System.out.println("Got exception in OpretLaanDB laanestatus");
			System.out.println(e.getMessage());
		}
	}
}