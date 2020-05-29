package logic;

import java.util.List;

import db.SaelgerDB;
import entity.Bilsaelger;

public class getBilsaelger {

    SaelgerDB db = new SaelgerDB();

    public List<Bilsaelger> getsaelgerinfo() {
        return db.getSealger();
}
    
    public List<Bilsaelger> getSaelgerWhereID(String username) {
    	return db.getSaelgerWhereID(username);
    }
}