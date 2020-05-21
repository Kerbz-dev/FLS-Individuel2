package db;

import java.sql.ResultSet;
import java.sql.Statement;

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
}
