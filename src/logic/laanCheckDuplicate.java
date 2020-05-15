package logic;

import db.OpretLaanDB;

public class laanCheckDuplicate {

    private OpretLaanDB laan = new OpretLaanDB();

    public boolean LaanCheckDuplicate(String cpr, String tlf) {

    	if (laan.kundeCheckDuplicate(cpr, tlf) == true) {
    		return true;
    	}


        return false;

    }


}