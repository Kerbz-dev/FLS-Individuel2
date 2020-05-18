package logic;

import java.util.List;

import db.LaaneTilbudDB;
import entity.LaaneTilbud;

public class getLaan {
    LaaneTilbudDB db = new LaaneTilbudDB();

    public List<LaaneTilbud> getlaaninfo() {
        return db.getLaan();
}


}