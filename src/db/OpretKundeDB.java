package db;

import java.sql.Statement;

public class OpretKundeDB {

	private Datakobling DB = new Datakobling();

	public void createKunde(String fornavnGetText, String efternavnGetText, int tlf, int postnr, String byGetText,
			String vejGetText, int husnr, long cpr, String mailGetText, Enum<?> kreditVurdering) {

		try {
			Statement statement = DB.connection.createStatement();

			statement.executeUpdate(
					"insert into kunde (telefonnummer,kundefornavn,kundeefternavn,cpr_nummer,mail,postnummer,bynavn,vejnavn,husnr, kreditVurdering) VALUES ('"
							+ tlf + "', '" + fornavnGetText + "', '" + efternavnGetText + "','" + cpr + "', '"
							+ mailGetText + "', '" + postnr + "', '" + byGetText + "', '" + vejGetText + "', '" + husnr
							+ "', '" + kreditVurdering + "')");

		} catch (Exception e) {
			System.out.println("Got exception in OpretLaanDB");
			System.out.println(e.getMessage());
		}
	}
}