package db;

 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 

import db.Datakobling;

 

public class KundeinfoDB {

    /*public List getKundeinfo (String Fornavn, String Addresse, String tlfnr, String cprnr, String email) {
        ArrayList<Kunde> list = new ArrayList<Kunde>();
        Datakobling DB = new Datakobling(); 
        try {
            Statement stmt = DB.connection.createStatement();
            String query = "SELECT * FROM kunde";
        //    System.out.println(query);

 

            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

 

                Fornavn = rs.getString("kundenavn");

 

                Addresse = rs.getString("addresse");

 

                tlfnr = rs.getString("telefonnummer");

 

                cprnr = rs.getString("cpr_nummer");
                
                email = rs.getString("email");

 

                
    
                
                list.add(Fornavn, Addresse, tlfnr, cprnr, email);

 

        //        System.out.println(Fornavn + Addresse + tlfnr + cprnr + email);
            
    
            }
        } catch (SQLException e) {
            System.out.println("Error running SQL statement");
            System.out.println(e.getMessage());
        }
        return list;
} */
}