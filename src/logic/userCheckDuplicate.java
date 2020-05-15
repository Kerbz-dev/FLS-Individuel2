package logic;

import db.Datakobling;

public class userCheckDuplicate {

	private Datakobling DB = new Datakobling();

	public boolean UserCheckDuplicate(String CreateUsername) {

		if (DB.userCheckDuplicate(CreateUsername) == true) {
			return true;
		}
		
		return false;

	}
}
