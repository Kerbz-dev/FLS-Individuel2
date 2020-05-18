package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.LaaneTilbud;

public class laaninfoDB {


        public List<LaaneTilbud> getLaan () {
            ArrayList<LaaneTilbud> list = new ArrayList<LaaneTilbud>();
            Datakobling DB = new Datakobling(); 
            try {
                Statement stmt = DB.connection.createStatement();
                String query = "SELECT * FROM laanetilbud";

                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int laanlaengde = rs.getInt("laanlaengde");
                    String bilnavn = rs.getString("bilnavn");
                    int bilpris = rs.getInt("bilpris");
                    int udbetalingspris = rs.getInt("udbetalingspris");
                    int tilbudsid = rs.getInt("tilbudsid");


                    LaaneTilbud laan = new LaaneTilbud(tilbudsid, laanlaengde,
                            udbetalingspris, bilnavn, bilpris);

                    list.add(laan);
                }
            } catch (SQLException e) {
                System.out.println("Error running SQL statement");
                System.out.println(e.getMessage());
            }
            return list;
        } 
    }