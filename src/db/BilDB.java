package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Biler;
import entity.Kunde;

public class BilDB {
	Datakobling DB = new Datakobling();

	public List<Biler> getAllBiler() {
		ArrayList<Biler> biler = new ArrayList<>();

		try {
			String sql = "SELECT * FROM Biler";
			// String sql2 = "SELECT bilid, bilnavn, bilpris FROM Biler";

			Statement statement = DB.connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			// iteration starter 'before first'
			while (resultSet.next()) {
				// hent data fra denne række
				int bilId = resultSet.getInt("bilid");
				String bilnavn = resultSet.getString("bilnavn");
				int bilPris = resultSet.getInt("bilpris");
				int inventar = resultSet.getInt("inventar");

				// brug data, e.g. => entitets/model object
				Biler biler1 = new Biler(bilId, bilnavn, bilPris, inventar);

				biler.add(biler1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return biler;
	}

	public boolean BilIDCheck(int bilid) {
		try {

			Statement stmt = DB.connection.createStatement();
			String sql = "Select * from biler where bilid='" + bilid + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;

			}

		} catch (Exception e) {
			System.out.println("Got exception from  BilIDCheck in BilDB");
			System.out.print(e);

		}
		return false;

	}

	public List<Biler> getBilerWhereID (int bilid) {
        ArrayList<Biler> list = new ArrayList<Biler>();
        Datakobling DB = new Datakobling(); 
        try {
            Statement stmt = DB.connection.createStatement();
            String query = "Select * from biler where bilid='" + bilid + "'";

 // String query skal opdateres - skal have where clause på den
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	bilid = rs.getInt("bilid");
            	String bilnavn = rs.getString("bilnavn");
            	int bilpris = rs.getInt("bilpris");
            	int inventar = rs.getInt("inventar");
                // char kreditVurdering = rs.getCharacterStream("kreditVurdering");
//                Kunde kunde = new Kunde();
//               kunde.setKundenavn(rs.getString("kundenavn"));
//               kunde.setTelefonnummer(rs.getString("telefonnummer"));
//               kunde.setEmail(rs.getString("email"));
//               kunde.setCpr_nummer(rs.getString("cpr_nummer"));
//               kunde.setKreditvaerdighed(rs.getString("addresse"));
//


               Biler bilInsert = new Biler(bilid, bilnavn, bilpris, inventar);

        //       System.out.println(kunde);
                list.add(bilInsert);

            }
        } catch (SQLException e) {
            System.out.println("Got exception from  BilIDCheck in BilDB");
            System.out.println(e.getMessage());
        }
        return list;
} 

}
