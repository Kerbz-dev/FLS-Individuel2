package logic;

import db.OpretLoginDB;

public class OpretMedarbejderLogin {
	private OpretLoginDB loginDB = new OpretLoginDB();

	public void opretBruger(int getTextFornavn, String getTextEfternavn, String getTextBrugernavn, String getTextPassword) {
		loginDB.opretLogin(getTextFornavn, getTextEfternavn, getTextBrugernavn, getTextPassword);
	}
}
