package logic;

import db.LoginCheckDB;

public class LoginVerification {
	private int saelgerID;
	public enum LoginResult {FAILED, USER_LOGGED_IN, ADMIN_LOGGED_IN};

	private LoginCheckDB lgnDB = new LoginCheckDB();

	public LoginResult loginCheck(String username, String password) {
		
					/*//////////////////
					 * MANGLER TRÅDE *
					*//////////////////
		if (lgnDB.LoginCheck(username, password) == true) {
			System.out.println(getUserinfo(username));
			return LoginResult.USER_LOGGED_IN;
		
		} else if (lgnDB.adminLoginCheck(username, password) == true) {
			return LoginResult.ADMIN_LOGGED_IN;
		} else {
			return LoginResult.FAILED;
		}
	}
	public int getUserinfo(String username) {
		getBilsaelger getBS = new getBilsaelger();
		for (int i=0; i <  getBS.getSaelgerWhereID(username).size(); i++) {
			int saelgerID = getBS.getSaelgerWhereID(username).get(i).getbilsaelgerid();
			this.saelgerID = saelgerID;
	}
		return saelgerID;
	}
	
	public void run() {
		
	}

}

