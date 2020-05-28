package logic;

import java.util.List;

import db.AdminDB;
import db.saelgerinfoDB;
import entity.Admin;
import entity.Bilsaelger;
import entity.Singleton;



public class CheckID {

	Singleton singleton = Singleton.getSingletoninstance();
		public boolean setID(String username) {
			System.out.println("username in checkID:" + username);
			if (checkSaelgerID(username) == true) {
				setSaelgerID(username);
				return true;
				
				
				
			}
			else {
				getAdminID(username);
				return false;
			}
		}
	
	   private void getAdminID(String username) {
			AdminDB admDB = new AdminDB();
		
			for (int i=0; i <  admDB.getAdminWhereID(username).size(); i++) {
				int adminid = admDB.getAdminWhereID(username).get(i).getAdminid();

				singleton.setSaelgerid(adminid);
				
			}
	   }


	   private void setSaelgerID(String username) {
			saelgerinfoDB slgDB = new saelgerinfoDB();
			for (int i=0; i <  slgDB.getSaelgerWhereID(username).size(); i++) {
				int bilsaelgerid = slgDB.getSaelgerWhereID(username).get(i).getbilsaelgerid();
				Bilsaelger slgentity = new Bilsaelger();
				slgentity.setbilsaelgerid(bilsaelgerid);
				singleton.setSaelgerid(bilsaelgerid);
				
			}
	   }
	   
	   private boolean checkSaelgerID(String username) {
		   saelgerinfoDB slgDB = new saelgerinfoDB();
		   if (slgDB.saelgerIDCheck(username) == true) {
			   return true;
		   }
		   return false;
	   }
	   
	
}
