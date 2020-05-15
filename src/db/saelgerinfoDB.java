package db;

    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.List;
    import db.Datakobling;
    import entity.Bilsaelger;

public class saelgerinfoDB {

        public List<Bilsaelger> getSealger () {
            ArrayList<Bilsaelger> list = new ArrayList<Bilsaelger>();
            Datakobling DB = new Datakobling(); 
            try {
                Statement stmt = DB.connection.createStatement();
                String query = "SELECT * FROM bilsaelger";

                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String medarbejderfornavn = rs.getString("medarbejderfornavn");
                    String medarbejderefternavn = rs.getString("medarbejderefternavn");
                    String saelgerbrugernavn = rs.getString("saelgerbrugernavn");
                    String saelgerpassword = rs.getString("saelgerpassword");
                    int maksgraense = rs.getInt("maksgraense");

                    Bilsaelger saelger = new Bilsaelger(medarbejderfornavn, medarbejderefternavn, saelgerbrugernavn, saelgerpassword, maksgraense);

                    list.add(saelger);
                }
            } catch (SQLException e) {
                System.out.println("Error running SQL statement");
                System.out.println(e.getMessage());
            }
            return list;
        } 
    }