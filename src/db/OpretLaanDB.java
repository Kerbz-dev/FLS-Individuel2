package db;

import java.sql.ResultSet;
import java.sql.Statement;

public class OpretLaanDB {
	private  Datakobling DB = new Datakobling();

        public void createLaan(String bilnavn, String bilpris, String udbetalingspris, String laanleangde, 
                String tlf, String kundenavn, String cpr, String mail, String adr) {
           
            try {
                Statement statement = DB.connection.createStatement();

                statement.executeUpdate("INSERT INTO laanetilbud " + "VALUES ('" + bilnavn + "', '" + bilpris
                        + "', '" + udbetalingspris + "', '" + laanleangde + "')");
                statement.executeUpdate("INSERT INTO kunde " + "VALUES ('" + tlf + "', '" + kundenavn
                        + "', '" + adr + "', '" + cpr + "', '" + mail + "')");


            } catch (Exception e) {
                System.out.println("Got exception in OpretLaanDB");
                System.out.println(e.getMessage());
            }
        }
        

    	public boolean kundeCheckDuplicate(String cpr, String tlf) {

    		try {
    			Statement stmt = DB.connection.createStatement();
    			String sql = "Select * FROM kunde WHERE telefonnummer='" + tlf + "' OR cpr_nummer='"
    					+ cpr + "'";

    			ResultSet rs = stmt.executeQuery(sql);
    			if (rs.next()) {
    				return true;
    				// System.out.println(duplicateCheck);
    			}
    			rs.close();

    		} catch (Exception e) {
    			System.out.println("Got exception from createUserCheckDuplicate in OpretBruger");
    			System.out.print(e);
    		}
    		return false;
    	}
    }