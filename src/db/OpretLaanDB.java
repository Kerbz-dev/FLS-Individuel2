package db;

import java.sql.Statement;

public class OpretLaanDB {
	private Datakobling DB = new Datakobling();

	public void createLaan(int tlf, int bilid, int saelgerID, String udbetalingGetText, String laanleangdeGetText,
			boolean overstigergraense, double rente, double mdlydelse, double samletpris, int bilinventar) {

		try {
			Statement statement = DB.connection.createStatement();

			statement.executeUpdate(
					"INSERT INTO laanetilbud  (telefonnummer, bilid, bilsaelgerid, kundeindbetaling,laanlaengde, overstigergraense, rente,mdlydelse, samletpris) VALUES ('"
							+ tlf + "', '" + bilid + "', '" + saelgerID + "', '" + udbetalingGetText + "', '"
							+ laanleangdeGetText + "', '" + overstigergraense + "', '" + rente + "','" + mdlydelse
							+ "', '" + samletpris + "')");
			statement.executeUpdate("UPDATE biler SET inventar = '" + bilinventar + "' WHERE bilid = " + bilid + "");

		} catch (Exception e) {
			System.out.println("Got exception in OpretLaanDB - Createlaan");
			System.out.println(e.getMessage());
		}

	}

	public void createStatus(int laanestatus, int tilbudsid) {
		try {
			Statement statement = DB.connection.createStatement();

			statement.executeUpdate(
					("UPDATE laanetilbud SET laanestatus = '" + laanestatus + "' WHERE tilbudsid = " + tilbudsid + ""));

		} catch (Exception e) {
			System.out.println("Got exception in OpretLaanDB createstatus");
			System.out.println(e.getMessage());
		}
	}

	public void inventarOpdatering(int bilid, int bilinventar) {

		try {
			Statement statement = DB.connection.createStatement();

			statement.executeUpdate("UPDATE biler SET inventar='" + bilinventar + "' WHERE bilid = " + bilid + "");

		} catch (Exception e) {
			System.out.println("Got exception in OpretLaanDB - InventarUpdate");
			System.out.println(e.getMessage());
		}

	}
}