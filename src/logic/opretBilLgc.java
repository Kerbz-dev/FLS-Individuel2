package logic;

import db.BilDB;

public class opretBilLgc {
BilDB bilDB = new BilDB();

	public void opretBil(String getTextBilnavn, int bilinventar, int bilpris) {
		bilDB.opretBilDB(getTextBilnavn, bilpris, bilinventar);
	}
	
	public boolean bilCheckDuplicate(String getTextBilnavn) {

		if (bilDB.bilCheckDuplicate(getTextBilnavn) == true) {
			return true;
		}
		
		return false;

	}
}

