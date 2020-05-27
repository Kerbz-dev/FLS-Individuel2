package logic;

import java.util.List;

import db.LaaneTilbudDB;
import entity.LaaneTilbud;

public class LaanOverstiger {
    private int maksgraense = 3000000;
    LaaneTilbudDB db = new LaaneTilbudDB();
    

    public List<LaaneTilbud> getLaan() {
        return db.getLaan();
}

    
    public boolean overstigerGraense(double samletPris) {
        if (samletPris > maksgraense)
        return true; 
        else {      
        return false;
        }
    }
    
    public boolean laaneStatus(int laanestatus) {
		if(laanestatus == 1 ) {
			return true;
		}
    	return false;
    	
    }
    
    
    public int admingodkendLaan(double samletPris, int laanestatus) {
        if (samletPris > maksgraense) {
            laanestatus = 2;
            }
        return laanestatus;
        }


    public int adminafvisLaan(double samletPris, int laanestatus) {
        if (samletPris > maksgraense) {
            laanestatus = 0;
            }
        return laanestatus;
        }
    
    public int godkendLaan(double samletPris, int laanestatus) {
        if (samletPris < maksgraense) {
            laanestatus = 2;
            }
        return laanestatus;
        }


    public int afvisLaan(double samletPris, int laanestatus) {
        if (samletPris < maksgraense) {
            laanestatus = 0;
            }
        return laanestatus;
        }
    
    public boolean lala(int laanestatus) {
        if (laanestatus == 1)
        return true; 
        else {      
        return false;
        }
    }
 /*   public boolean getTilbud() {
    	for (int i=0; i < getlaan.size(); i++) {
    	
    		if (getlaan.get(i).getSamletpris() == true) {
    			
    		}
    	
    	
    	
    }
    	return false;
        
    } */


}


