package logic;

import db.OpretLaanDB;

public class OpretLaan {

    private OpretLaanDB laan = new OpretLaanDB();

    public boolean opretLaan(String bilnavn, String bilpris, String udbetalingspris, String laanleangde, 
            String tlf, String kundenavn, String cpr, String mail, String adr) {

    	if (laan.kundeCheckDuplicate(cpr, tlf) == true) {
    		return true;
    	}

    	else if (laan.kundeCheckDuplicate(cpr, tlf) == false) {
            laan.createLaan(bilnavn, bilpris, udbetalingspris, laanleangde, tlf, kundenavn, cpr, mail, adr);
    	}

        return false;

    }


}