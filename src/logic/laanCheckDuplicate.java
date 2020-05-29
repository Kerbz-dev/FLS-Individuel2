package logic;

import db.DuplicateCheckDB;

public class laanCheckDuplicate {

	private DuplicateCheckDB laan = new DuplicateCheckDB();

	public boolean LaanCheckDuplicate(long cpr, int tlf) {

		if (laan.kundeCheckDuplicate(cpr, tlf) == true) {
			return true;
		}

		return false;

	}

}