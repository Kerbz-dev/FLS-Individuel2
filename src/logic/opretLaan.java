package logic;

import db.OpretLaanDB;

public class opretLaan {
    OpretLaanDB oprLaanDB = new OpretLaanDB();
    public void CreateLaan(String tlfGetText, int bilid, String udbetalingGetText, String laanleangdeGetText, boolean overstigergraense, double rente, double mdlYdelse, double samletPris, int bilinventar) {
    	/*/////////////////////////////////////////////////////////////
    	 * WE CAN DO DIS TO CONVERT STRINGS TO INT ETC
    	 */////////////////////////////////////////////////////////////
    	int tlf = Integer.parseInt(tlfGetText);

    	oprLaanDB.createLaan(tlf, bilid, udbetalingGetText, laanleangdeGetText, overstigergraense, rente, mdlYdelse, samletPris, bilinventar);
    	
    }
    
    public void CreateStatus(int laanestatus, int tilbudsid) {
        /*/////////////////////////////////////////////////////////////
         * WE CAN DO DIS TO CONVERT STRINGS TO INT ETC
         */////////////////////////////////////////////////////////////

 

        oprLaanDB.createStatus(laanestatus, tilbudsid);
    }
    
    

}