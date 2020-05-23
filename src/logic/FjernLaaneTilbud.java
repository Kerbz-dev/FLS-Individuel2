package logic;

import db.FjernLaanDB;

public class FjernLaaneTilbud {
	FjernLaanDB flaanDB = new FjernLaanDB();
	public void FjernLaan (int tlfnr, String tilbudsidString) {
		flaanDB.fjernTilbud(tlfnr, tilbudsidString);
		
	}
}
