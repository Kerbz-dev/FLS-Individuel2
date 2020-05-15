package logic;

import db.OpretLaanDB;

public class opretLaan {
    OpretLaanDB oprLaanDB = new OpretLaanDB();
	public void CreateLaan(String bilnavn, String bilpris, String udbetalingspris, String laanleangde, String tlf, String kundenavn, String cpr, String mail, String adr) {
		oprLaanDB.createLaan(bilnavn, bilpris, udbetalingspris, laanleangde, tlf, kundenavn, cpr, mail, adr);
	}
    
	
}
