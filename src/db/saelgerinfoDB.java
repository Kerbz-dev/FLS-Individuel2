package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Bilsaelger;

public class saelgerinfoDB {

	public List<Bilsaelger> getSealger() {
		ArrayList<Bilsaelger> list = new ArrayList<Bilsaelger>();
		Datakobling DB = new Datakobling();
		try {
			Statement stmt = DB.connection.createStatement();
			String query = "SELECT * FROM bilsaelger";
			// String query1 = "SELECT saelgerfornavn, saelgerbrugernavn, saelgerpassword
			// FROM bilsaelger";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int bilsaelgerid = rs.getInt("bilsaelgerid");
				
				String medarbejderfornavn = rs.getString("saelgerfornavn");
				String saelgerbrugernavn = rs.getString("saelgerbrugernavn");
				String saelgerpassword = rs.getString("saelgerpassword");
				String medarbejderefternavn = rs.getString("saelgerefternavn");
				int maksgraense = rs.getInt("maksgraense");

				Bilsaelger saelger = new Bilsaelger(bilsaelgerid, medarbejderfornavn, saelgerbrugernavn,
						saelgerpassword, medarbejderefternavn, maksgraense);

				list.add(saelger);
			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<Bilsaelger> getSaelgerWhereID(String username) {
		ArrayList<Bilsaelger> list = new ArrayList<Bilsaelger>();
		Datakobling DB = new Datakobling();
		Bilsaelger bilslg = new Bilsaelger();
		try {
			Statement stmt = DB.connection.createStatement();
			String query = "SELECT * FROM bilsaelger WHERE saelgerbrugernavn='" + username + "'";
			// String query skal opdateres - skal have where clause på den
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
			
				int bilsaelgerid = rs.getInt("bilsaelgerid");
				bilslg.setbilsaelgerid(bilsaelgerid);
				String medarbejderfornavn = rs.getString("saelgerfornavn");
				String saelgerbrugernavn = rs.getString("saelgerbrugernavn");
				String saelgerpassword = rs.getString("saelgerpassword");
				String medarbejderefternavn = rs.getString("saelgerefternavn");
				int maksgraense = rs.getInt("maksgraense");

				Bilsaelger saelgerUpdate = new Bilsaelger(bilsaelgerid, medarbejderfornavn, saelgerbrugernavn,
						saelgerpassword, medarbejderefternavn, maksgraense);

				// System.out.println(kunde);
				list.add(saelgerUpdate);

			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public boolean saelgerIDCheck(String username) {
		try {
			Datakobling DB = new Datakobling();
			Statement stmt = DB.connection.createStatement();
			String sql = "Select * from bilsaelger where saelgerbrugernavn='" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;

			}

		} catch (Exception e) {
			System.out.println("Got exception from  salgerIDCheck in saelgerinfoDB");
			System.out.print(e);

		}
		return false;

	}
	
	
}