package logic;

import db.Datakobling;

public class LoginVerification {

	public boolean loginCheck(String username, String password) {

		Datakobling DB = new Datakobling();

		DB.LoginCheck(username, password);
		// DB.adminLoginCheck(username, password);
		if (DB.LoginCheck(username, password) == true) {
			System.out.println("Login successful");
			return true;
		}
		else if(DB.LoginCheck(username, password) == false) {
		adminloginCheck(username, password);
		}
	
		return false;
		}
	

	public boolean adminloginCheck(String username, String password) {

		Datakobling DB = new Datakobling();

		DB.adminLoginCheck(username, password);
		// DB.adminLoginCheck(username, password);
		if (DB.adminLoginCheck(username, password) == true) {
			return true;
		}

		else {
		return false;
		}
		}
	}


