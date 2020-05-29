package db;

import java.sql.Statement;

public class OpdaterKundeDB {
	public void kundeOpdatering(String fornavnGT, String efternavnGT, String tlfGT, String postnrGT,
			String byGT, String vejGT, String husnrGT, String cprGT, String mailGT) {
		Datakobling DB = new Datakobling();
		try {
			Statement statement = DB.connection.createStatement();

			statement.executeUpdate(
					("UPDATE kunde SET kundefornavn = '" + fornavnGT + "', kundeefternavn = '" + efternavnGT + "', cpr_nummer = '" + cprGT + "', mail = '" + mailGT + "', postnummer = '" + postnrGT + "', bynavn = '" + byGT + "', vejnavn = '" + vejGT + "', husnr = '" + husnrGT + "' WHERE telefonnummer = " + tlfGT + ""));

			DB.connection.close();

		} catch (Exception e) {
			System.out.println("Got exception in OpretLoginDB");
			System.out.println(e.getMessage());
		}
	}
}
