package db;

import java.sql.Statement;

public class OpretLaanDB {

        public void createLaan(String bilnavn, String bilpris, String udbetalingspris, String laanleangde, 
                String tlf, String kundenavn, String cpr, String mail, String adr) {
            Datakobling DB = new Datakobling();
            try {
                Statement statement = DB.connection.createStatement();

                statement.executeUpdate("INSERT INTO laanetilbud " + "VALUES ('" + bilnavn + "', '" + bilpris
                        + "', '" + udbetalingspris + "', '" + laanleangde + "')");
                statement.executeUpdate("INSERT INTO kunde " + "VALUES ('" + tlf + "', '" + kundenavn
                        + "', '" + adr + "', '" + cpr + "', '" + mail + "')");

                DB.connection.close();

            } catch (Exception e) {
                System.out.println("Got exception in OpretLaanDB");
                System.out.println(e.getMessage());
            }
        }
    }