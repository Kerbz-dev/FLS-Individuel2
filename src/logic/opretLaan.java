package logic;

import db.OpretLaanDB;

public class opretLaan {
    OpretLaanDB oprLaanDB = new OpretLaanDB();
    public void CreateLaan(String tlfGetText, String udbetalingGetText, String laanleangdeGetText) {
        oprLaanDB.createLaan( tlfGetText, udbetalingGetText, laanleangdeGetText);
    }


}