package db;

import java.sql.Statement;

public class OpretLaanDB {
    private Datakobling DB = new Datakobling();
//    private int kundeindbetaling;
//    private int laanlaengde;
//    private boolean overstigergraense;
//    private int laanestatus;

    public void createLaan( int tlf, String udbetalingGetText, String laanleangdeGetText, double rente, double mdlydelse, double samletpris) {

        try {
            Statement statement = DB.connection.createStatement();

            /*//////////////////////////////////////////////////////////
             * mangler overstigergraense + laanestatus til første update
             *//////////////////////////////////////////////////////////
            statement.executeUpdate("INSERT INTO laanetilbud  (telefonnummer,kundeindbetaling,laanlaengde,rente,mdlydelse, samletpris) VALUES ('"
                    + tlf + "', '" + udbetalingGetText + "', '" + laanleangdeGetText +  "', '" + rente + "','" +  mdlydelse +  "', '" + samletpris + "')");

     /*       statement
                    .executeUpdate("insert into biler (bilnavn,bilpris) VALUES ('" + bilnavnGetText + "', '" + bilprisGetText + "')");*/
//            statement.executeUpdate("INSERT INTO kunde " + "VALUES ('" + cpr + "', '" + tlf + "', '" + kundenavn
//            + "', '" + adr + "', '" + mail + "')");

        } catch (Exception e) {
            System.out.println("Got exception in OpretLaanDB");
            System.out.println(e.getMessage());
        }
    }
}