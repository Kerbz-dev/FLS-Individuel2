package logic;


import java.util.ArrayList;


import db.LaaneTilbudDB;
import entity.Biler;


public class GetBiler {
     LaaneTilbudDB db = new LaaneTilbudDB();
          
     public ArrayList<Biler> getAllBilerInfo() {
            return db.getAllBiler();     
        }
}





