package db;

 

import java.sql.Statement;

 

public class OpretLoginDB {

 

    public void createLogin(String medarbejderNavn, String username, String saelgerpassword) {
        Datakobling bilsælger = new Datakobling();
        try {
            Statement statement = bilsælger.connection.createStatement();


            statement.executeUpdate(
                    "INSERT INTO bilsealger " + "VALUES ('" + medarbejderNavn + "', '" + username + "', '" + saelgerpassword + "')");

 

            bilsælger.connection.close();

 

        } catch (Exception e) {
            System.out.println("Got exception in OpretLoginDB");
            System.out.println(e.getMessage());
        }
    }
}