package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Admin;

public class AdminDB {
	public List<Admin> getAdminWhereID(String username) {
		ArrayList<Admin> list = new ArrayList<Admin>();
		Datakobling DB = new Datakobling();
		try {
			Statement stmt = DB.connection.createStatement();
			String query = "SELECT * FROM administrator WHERE adminbrugernavn='" + username + "'";
			// String query skal opdateres - skal have where clause på den
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
			
				int adminid = rs.getInt("adminid");
		//		adm.setbilsaelgerid(bilsaelgerid);
				String adminbrugernavn = rs.getString("adminbrugernavn");
	
	
				Admin saelgerUpdate = new Admin(adminid, adminbrugernavn);
	
				// System.out.println(kunde);
				list.add(saelgerUpdate);
	
			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}
}

