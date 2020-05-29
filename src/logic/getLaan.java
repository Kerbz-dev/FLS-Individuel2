package logic;

import java.util.List;

import db.LaanCheckTlfDB;
import db.LaaneTilbudDB;
import entity.Kunde;
import entity.LaaneTilbud;

public class getLaan {
	LaaneTilbudDB db = new LaaneTilbudDB();
	LaanCheckTlfDB laanCheckDB = new LaanCheckTlfDB();

	public List<LaaneTilbud> getLaanAll() {
		return db.getLaan();
	}

	public List<LaaneTilbud> getLaanHvorOG() {
		return db.getLaanHvorOG();
	}

	public List<LaaneTilbud> getLaanWhere(int tilbudsid) {
		return db.getLaanWhere(tilbudsid);

	}

	public List<Kunde> getKundeWhere(int tlfnr) {
		return laanCheckDB.getKundeTlf(tlfnr);
	}

}