package logic;

import db.OpretLaanDB;

public class opretLaan {
    OpretLaanDB oprLaanDB = new OpretLaanDB();
	public void CreateLaan(String fornavnGetText, String tlfGetText, String postnrGetText, String byGetText, String vejGetText, String husnrGetText, String cprGetText, String mailGetText, String bilnavnGetText
			, String bilprisGetText, String udbetalingGetText, String laanleangdeGetText, Enum kreditVurdering) {
		oprLaanDB.createLaan(fornavnGetText, tlfGetText, postnrGetText, byGetText, vejGetText, husnrGetText, cprGetText, mailGetText, bilnavnGetText
				, bilprisGetText, udbetalingGetText, laanleangdeGetText, kreditVurdering);
	}
    
	
}
