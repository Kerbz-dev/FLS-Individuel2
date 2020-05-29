package logic;

import db.AdminDB;
import db.SaelgerDB;
import entity.Bilsaelger;
import entity.Singleton;

public class CheckID {

	public boolean setID(String username) {

		if (checkSaelgerID(username) == true) {
			setSaelgerID(username);
			return true;

		} else {
			getAdminID(username);
			return false;
		}
	}

	private void getAdminID(String username) {
		AdminDB admDB = new AdminDB();

		for (int i = 0; i < admDB.getAdminWhereID(username).size(); i++) {
			int adminid = admDB.getAdminWhereID(username).get(i).getAdminid();

			Singleton.setSaelgerid(adminid);

		}
	}

	private void setSaelgerID(String username) {
		SaelgerDB slgDB = new SaelgerDB();
		for (int i = 0; i < slgDB.getSaelgerWhereID(username).size(); i++) {
			int bilsaelgerid = slgDB.getSaelgerWhereID(username).get(i).getbilsaelgerid();
			Bilsaelger slgentity = new Bilsaelger();
			slgentity.setbilsaelgerid(bilsaelgerid);
			Singleton.setSaelgerid(bilsaelgerid);

		}
	}

	private boolean checkSaelgerID(String username) {
		SaelgerDB slgDB = new SaelgerDB();
		if (slgDB.saelgerIDCheck(username) == true) {
			return true;
		}
		return false;
	}

}
