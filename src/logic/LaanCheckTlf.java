package logic;

import java.util.List;

import db.LaanCheckTlfDB;
import entity.Kunde;

public class LaanCheckTlf {
	LaanCheckTlfDB tlfDB = new LaanCheckTlfDB();

	public boolean CheckTlfDB(String tlfGetText) {
		if (tlfDB.TlfCheck(tlfGetText) == true) {
			return true;
		}

		return false;

	}

	public boolean LaanCheckTlfDB(int telefonnummer) {
		if (tlfDB.LaanTlfCheck(telefonnummer) == true) {
			getKundeWhere(telefonnummer);
			return true;
		}
		return false;

	}

	public List<Kunde> getKundeWhere(int telefonnummer) {
		return tlfDB.getKundeWhereTlf(telefonnummer);
	}

	public String getCPRNR(String tlfGetText) {
		return tlfDB.getCPR(tlfGetText);
	}
}
