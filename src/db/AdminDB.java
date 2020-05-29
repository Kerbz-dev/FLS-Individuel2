package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Admin;

public class AdminDB {
	public List<Admin> getAdminWhereID(String username) {
		ArrayList<Admin> list = new ArrayList<Admin>();
		Datakobling DB = new Datakobling();
		try {

			PreparedStatement stmt = DB.connection
					.prepareStatement("SELECT * FROM administrator WHERE adminbrugernavn='" + username + "'");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				int adminid = rs.getInt("adminid");

				String adminbrugernavn = rs.getString("adminbrugernavn");

				Admin saelgerUpdate = new Admin(adminid, adminbrugernavn);

				list.add(saelgerUpdate);

			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}
}
