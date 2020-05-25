package logic;

import java.util.List;

import db.BilDB;
import entity.Biler;
import entity.Kunde;

public class GetBiler {
	BilDB bildb = new BilDB();

	public List<Biler> getAllBilerInfo() {
		return bildb.getAllBiler();
	}

	public boolean KundeCheck(int bilid) {
		if (bildb.BilIDCheck(bilid) == true) {
			getBilerWhere(bilid);
			return true;
		}
		return false;

	}

	public List<Biler> getBilerWhere(int bilid) {
		return bildb.getBilerWhereID(bilid);
}
}