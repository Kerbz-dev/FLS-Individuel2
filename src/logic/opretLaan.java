package logic;

import db.OpretLaanDB;

public class opretLaan {
    OpretLaanDB oprLaanDB = new OpretLaanDB();
    public void CreateLaan(long tlf, int bilid, int saelgerID, int udbetaling, int laanleangde, boolean overstigergraense, double rente, double mdlYdelse, double samletPris, int bilinventar) {

    	oprLaanDB.createLaan(tlf, bilid, saelgerID, udbetaling, laanleangde, overstigergraense, rente, mdlYdelse, samletPris, bilinventar);
    	
    }
    
    public void inventarUpdate(int bilid, int bilinventar) {
        oprLaanDB.inventarOpdatering(bilid, bilinventar);
    }

    public void CreateStatus(int laanestatus, int tilbudsid) {
        oprLaanDB.createStatus(laanestatus, tilbudsid);
    }
    
    

}