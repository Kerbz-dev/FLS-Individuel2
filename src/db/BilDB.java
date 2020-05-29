package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Biler;

public class BilDB {
	Datakobling DB = new Datakobling();

	public List<Biler> getAllBiler() {
		ArrayList<Biler> biler = new ArrayList<>();

		try {
			String sql = "SELECT * FROM Biler";

			Statement statement = DB.connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			// iteration starter 'before first'
			while (resultSet.next()) {
				// hent data fra denne række
				int bilId = resultSet.getInt("bilid");
				String bilnavn = resultSet.getString("bilnavn");
				int bilPris = resultSet.getInt("bilpris");
				int inventar = resultSet.getInt("inventar");

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

	public List<Biler> getBilerWhereID(int bilid) {
		ArrayList<Biler> list = new ArrayList<Biler>();
		Datakobling DB = new Datakobling();
		try {
			Statement stmt = DB.connection.createStatement();
			String query = "Select * from biler where bilid='" + bilid + "'";

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				bilid = rs.getInt("bilid");
				String bilnavn = rs.getString("bilnavn");
				int bilpris = rs.getInt("bilpris");
				int inventar = rs.getInt("inventar");

				Biler bilInsert = new Biler(bilid, bilnavn, bilpris, inventar);

				list.add(bilInsert);

			}
		} catch (SQLException e) {
			System.out.println("Got exception from  BilIDCheck in BilDB");
			System.out.println(e.getMessage());
		}
		return list;
	}

}
