package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginCheckDB {
	Datakobling DB = new Datakobling();

	public boolean LoginCheck(String username, String password) {
		try {
			
			PreparedStatement stmt = DB.connection.prepareStatement("Select * FROM bilsaelger WHERE saelgerbrugernavn='"
					+ username + "' AND saelgerpassword='" + password + "' COLLATE Latin1_General_CS_AS");

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			System.out.println("Got exception from LoginCheck in Datakobling ");
			System.out.print(e);
		}
		return false;
	}

	public boolean adminLoginCheck(String username, String password) {
		try {

			PreparedStatement stmt = DB.connection
					.prepareStatement("Select * FROM administrator WHERE adminbrugernavn='" + username + "'"
							+ "AND adminpassword='" + password + "' COLLATE Latin1_General_CS_AS");

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return true;
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			System.out.println("Got exception from adminLoginCheck() in Datakobling");
			System.out.print(e);
		}
		return false;
	}
}
