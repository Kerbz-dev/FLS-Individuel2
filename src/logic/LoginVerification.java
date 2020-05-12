package logic;

import db.Datakobling;


public class LoginVerification {
	public enum LoginResult {FAILED, USER_LOGGED_IN, ADMIN_LOGGED_IN};
	private Datakobling DB = new Datakobling();
	
	public LoginResult loginCheck(String username, String password) {

		

		
		//-----
		
		if (DB.LoginCheck(username, password)) {
			return LoginResult.USER_LOGGED_IN;
		}
		else if (DB.adminLoginCheck(username, password)) {
			return LoginResult.ADMIN_LOGGED_IN;
		}
		else {
			return LoginResult.FAILED;
	}
	}
}
	
	/*

	public boolean adminloginCheck(String username, String password) {

		if (DB.adminLoginCheck(username, password) == true) {
			return true;
		}

		else {
		return false;
		}
		}
		*/
	



