package logic;

import db.OpretLoginDB;

public class opretUsrLogin {
	private OpretLoginDB loginDB = new OpretLoginDB();

	public void opretBruger(String medarbejderNavn, String CreateUsername, String CreatePassword) {
		loginDB.createLogin(medarbejderNavn, CreateUsername, CreatePassword);
	}
}
