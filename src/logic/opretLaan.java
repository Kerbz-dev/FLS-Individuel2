package logic;

import db.OpretLaanDB;

public class opretLaan {
    OpretLaanDB oprLaanDB = new OpretLaanDB();
	public void CreateLaan(String fornavn, String tlf, String postnr, String by, String vej, String husnr, String cpr, String mail, String bilnavn
			, String bilpris, String udbetaling, String laanleangde, Enum<?> kreditVurdering) {
		//Enum med unbound type, kan bruges til alle typer variable
		
		oprLaanDB.createLaan(fornavn, tlf, postnr, by, vej, husnr, cpr, mail, bilnavn
				, bilpris, udbetaling, laanleangde, kreditVurdering);
	}
    
	
}
