package logic;

import db.LaanCheckTlfDB;

public class LaanCheckTlf {
	LaanCheckTlfDB tlfDB = new LaanCheckTlfDB();
	public boolean CheckTlfDB(String tlfGetText) {
		if (tlfDB.TlfCheck(tlfGetText) == true) {
			return true;
		}
	
		return false;
	
	}
}
