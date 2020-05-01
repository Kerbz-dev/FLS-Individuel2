package db;


	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import db.Kunde;

public class Datakobling {
	   public String databaseName;
	   public Connection connection;

	 


	   public Datakobling() {
	       databaseName = "FerrariDB";

	 

	       loadJdbcDriver();
	       openConnection(databaseName);
	   }

	 

	   public boolean loadJdbcDriver() {
	       try {
	           System.out.println("Loading JDBC driver...");

	 

	           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	 

	           System.out.println("JDBC driver loaded");

	 

	           return true;
	       } catch (ClassNotFoundException e) {
	           System.out.println("Could not load JDBC driver!");
	           return false;
	       }
	   }

	 

	   public boolean openConnection(String databaseName) {
	       try {
	           String connectionString = "jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;" + "databaseName="
	                   + databaseName + ";" + "integratedSecurity=true;";

	 

	           connection = null;

	 

	           System.out.println("Connecting to database...");

	 

	           connection = DriverManager.getConnection(connectionString);

	 

	           System.out.println("Connected to database");

	 

	           return true;
	       } catch (SQLException e) {
	           System.out.println("Could not connect to database!");
	           System.out.println(e.getMessage());

	 

	           return false;
	       }
	   }
	   
	   public ArrayList<Kunde> getAllKunde() {
	       ArrayList<Kunde> kunde = new ArrayList<>();
	       
	       try {
	         String sql = "SELECT * FROM kunde";
	         
	         Statement statement = connection.createStatement();

	 

	         ResultSet resultSet = statement.executeQuery(sql);

	 

	         // iteration starter 'before first'
	         while (resultSet.next()) {
	           // hent data fra denne rï¿½kke
	           int telefonnummer = resultSet.getInt("telefonnummer");
	           String teamname = resultSet.getString("kundenavn");
	           int cpr_nummer = resultSet.getInt("cpr_nummer");
	           String email = resultSet.getString("email");
	           String kreditværdighed = resultSet.getString("kreditværdighed");
	           
	           // brug data, e.g. => entitets/model object
	           Kunde kunde1 =
	             new Kunde(telefonnummer, teamname, cpr_nummer, email, kreditværdighed);
	           
	           kunde.add(kunde1);
	           
	         }
	       }
	       catch (SQLException e) {
	         e.printStackTrace();
	       }
	       
	       return kunde;
	     }

	 

	     
	   
	} 

