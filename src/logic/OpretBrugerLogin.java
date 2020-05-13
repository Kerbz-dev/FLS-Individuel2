package logic;

import db.Datakobling;
import db.OpretLoginDB;

public class OpretBrugerLogin {

	private Datakobling DB = new Datakobling();
	private OpretLoginDB login = new OpretLoginDB();

	public boolean opretBruger(String medarbejderNavn, String CreateUsername, String CreatePassword) {

		if (DB.userCheckDuplicate(CreateUsername) == true) {
			return true;
		} else if (DB.userCheckDuplicate(CreateUsername) == false) {
			login.createLogin(medarbejderNavn, CreateUsername, CreatePassword);

		}
		return false;

	}
}
