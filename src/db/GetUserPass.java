package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetUserPass {
	Connection conn = null;
	public static Connection conDB() throws SQLException
	{
		try { 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;" + "databaseName="
					+ "FerrariDB" + ";" + "integratedSecurity=true;");
			return con;
	} catch (ClassNotFoundException ex) {
		return null;
	}
}
}
