package logic;

import java.util.List;
import db.KundeinfoDB;
import entity.Kunde;

public class getKunde {
	KundeinfoDB db = new KundeinfoDB();

	public List<Kunde> getKundeAll() {
		return db.getKunde();
	}
}