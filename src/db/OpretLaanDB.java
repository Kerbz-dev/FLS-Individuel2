package db;

import java.sql.Statement;


public class OpretLaanDB {
	private Datakobling DB = new Datakobling();
//	private int kundeindbetaling;
//	private int laanlaengde;
//	private boolean overstigergraense;
//	private int laanestatus;

	public void createLaan(String fornavnGetText, String tlfGetText, String postnrGetText, String byGetText,
			String vejGetText, String husnrGetText, String cprGetText, String mailGetText, String bilnavnGetText,
			String bilprisGetText, String udbetalingGetText, String laanleangdeGetText, Enum<?> kreditVurdering) {

		try {
			Statement statement = DB.connection.createStatement();
			
			/*//////////////////////////////////////////////////////////
			 * mangler overstigergraense + laanestatus til første update
			 *//////////////////////////////////////////////////////////

			statement.executeUpdate("INSERT INTO laanetilbud  (kundeindbetaling,laanlaengde) VALUES ('"
					+ udbetalingGetText + "', '" + laanleangdeGetText + "')");
			
			statement.executeUpdate("insert into kunde (telefonnummer,kundefornavn,cpr_nummer,mail,postnummer,bynavn,vejnavn,husnr, kreditVurdering) VALUES ('"
					+ tlfGetText + "', '" + fornavnGetText + "','" + cprGetText + "', '" + mailGetText + "', '" + postnrGetText + "', '" + byGetText + "', '" + vejGetText
					+ "', '" + husnrGetText + "', '" + kreditVurdering +"')");
			statement
					.executeUpdate("insert into biler (bilnavn,bilpris) VALUES ('" + bilnavnGetText + "', '" + bilprisGetText + "')");
//			statement.executeUpdate("INSERT INTO kunde " + "VALUES ('" + cpr + "', '" + tlf + "', '" + kundenavn
//			+ "', '" + adr + "', '" + mail + "')");

		} catch (Exception e) {
			System.out.println("Got exception in OpretLaanDB");
			System.out.println(e.getMessage());
		}
	}
}
