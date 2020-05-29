package logic;

import db.DuplicateCheckDB;

public class kundeCheckDuplicate {

    private DuplicateCheckDB duplicateDB = new DuplicateCheckDB();

    public boolean KundeCheckDuplicate(String cprGetText, String tlfGetText) {
    	
		long cpr = Long.parseLong(cprGetText);
		int tlf = Integer.parseInt(tlfGetText);

		if (duplicateDB.kundeCheckDuplicate(cpr, tlf) == true) {
            return true;
        }

        return false;

    }

}