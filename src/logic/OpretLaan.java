package logic;

import db.OpretLaanDB;

public class OpretLaan {

    private OpretLaanDB laan = new OpretLaanDB();

    public boolean opretLaan(String bilnavn, String bilpris, String udbetalingspris, String laanleangde, 
            String tlf, String kundenavn, String cpr, String mail, String adr) {

//
//        if (DB.userCheckDuplicate(CreateUsername) == true ) {
//            System.out.println("First duplicateCheck should be true");
//            System.out.println(DB.userCheckDuplicate(CreateUsername));
//            return true;
//        } else if (DB.userCheckDuplicate(CreateUsername) == false ) {
//            System.out.println("Second duplicateCheck should be tfalse");
//            System.out.println(DB.userCheckDuplicate(CreateUsername));
//            login.createLogin(medarbejderNavn, CreateUsername, CreatePassword);
//
//
//
//        }

        laan.createLaan(bilnavn, bilpris, udbetalingspris, laanleangde, tlf, kundenavn, cpr, mail, adr);

        return false;

    }


}