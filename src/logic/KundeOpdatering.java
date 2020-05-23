package logic;

import db.OpdaterKundeDB;

public class KundeOpdatering {
	static OpdaterKundeDB opdaterDB = new OpdaterKundeDB();
	public void OpdaterKunde(String fornavnGT, String efternavnGT, String tlfGT, String postnrGT, String byGT, String vejGT,
			String husnrGT, String cprGT, String mailGT) {
		opdaterDB.kundeOpdatering(fornavnGT, efternavnGT, tlfGT, postnrGT, byGT, vejGT,
				husnrGT, cprGT, mailGT);
	}

}
