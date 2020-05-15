package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.Datakobling;
import entity.Kunde;
 


public class KundeinfoDB {


    public List<Kunde> getKunde () {
        ArrayList<Kunde> list = new ArrayList<Kunde>();
        Datakobling DB = new Datakobling(); 
        try {
            Statement stmt = DB.connection.createStatement();
            String query = "SELECT * FROM kunde";
 


 // String query skal opdateres - skal have where clause på den
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	String kundenavn = rs.getString("kundenavn");
            	String telefonnummer = rs.getString("telefonnummer");
            	String email = rs.getString("email");
            	String cpr_nummer = rs.getString("cpr_nummer");
            	String kreditvaerdighed = rs.getString("addresse");
            /*   kunde.setKundenavn(rs.getString("kundenavn"));
               kunde.setTelefonnummer(rs.getInt("telefonnummer"));
               kunde.setEmail(rs.getString("email"));
               kunde.setCpr_nummer(rs.getInt("cpr_nummer"));
               kunde.setKreditvaerdighed(rs.getString("addresse"));
*/
                

        //        System.out.println(Fornavn + Addresse + tlfnr + cprnr + email);

               Kunde kunde = new Kunde(telefonnummer, kundenavn, cpr_nummer, email, kreditvaerdighed);

				list.add(kunde);
            }
        } catch (SQLException e) {
            System.out.println("Error running SQL statement");
            System.out.println(e.getMessage());
        }
        return list;
} 
}
 













