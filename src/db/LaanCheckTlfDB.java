package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Kunde;


public class LaanCheckTlfDB {
	Datakobling DB = new Datakobling();

	public boolean TlfCheck(String tlfGetText) {
		try {

			Statement stmt = DB.connection.createStatement();
			String sql = "Select * from kunde where telefonnummer='" + tlfGetText + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;

			}

		} catch (Exception e) {
			System.out.println("Got exception from  TlfCheck in LaanCheckTlfDB ");
			System.out.print(e);

		}
		return false;

	}
	
	public boolean LaanTlfCheck(int telefonnummer) {
		try {

			Statement stmt = DB.connection.createStatement();
			String sql = "Select * from kunde where telefonnummer='" + telefonnummer + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;

			}

		} catch (Exception e) {
			System.out.println("Got exception from  TlfCheck in LaanCheckTlfDB ");
			System.out.print(e);

		}
		return false;

	}

	public List<Kunde> getKundeWhereTlf (int telefonnummer) {
        ArrayList<Kunde> list = new ArrayList<Kunde>();
        Datakobling DB = new Datakobling(); 
        try {
            Statement stmt = DB.connection.createStatement();
            String query = "Select * from kunde where telefonnummer='" + telefonnummer + "'";

 // String query skal opdateres - skal have where clause på den
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String kundefornavn = rs.getString("kundefornavn");
                String kundeefternavn = rs.getString("kundeefternavn");
                long cpr_nummer = rs.getLong("cpr_nummer");
                String mail = rs.getString("mail");
                int postnummer = rs.getInt("postnummer");
                String bynavn = rs.getString("bynavn");
                String vejnavn = rs.getString("vejnavn");
                int husnummer = rs.getInt("husnr");
                String kreditVurdering = rs.getString("kreditVurdering");
                // char kreditVurdering = rs.getCharacterStream("kreditVurdering");
//                Kunde kunde = new Kunde();
//               kunde.setKundenavn(rs.getString("kundenavn"));
//               kunde.setTelefonnummer(rs.getString("telefonnummer"));
//               kunde.setEmail(rs.getString("email"));
//               kunde.setCpr_nummer(rs.getString("cpr_nummer"));
//               kunde.setKreditvaerdighed(rs.getString("addresse"));
//


                Kunde kundeInsert = new Kunde(telefonnummer, kundefornavn, kundeefternavn, cpr_nummer, mail, postnummer, bynavn, vejnavn, husnummer, kreditVurdering);

        //       System.out.println(kunde);
                list.add(kundeInsert);

            }
        } catch (SQLException e) {
            System.out.println("Error running SQL statement");
            System.out.println(e.getMessage());
        }
        return list;
} 

	
	public String getCPR(String tlfGetText) {
		String cprnr = null;
		try {
			Statement stmt = DB.connection.createStatement();
			String query = "SELECT * from kunde WHERE telefonnummer='" + tlfGetText + "'";
//				+ " JOIN biler ON laanetilbud.bilid = biler.bilid"
//				+ " JOIN bilsaelger ON laanetilbud.bilsaelgerid = bilsaelger.bilsaelgerid"

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				cprnr = rs.getString("cpr_nummer");
			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}
		return cprnr;
	}
}