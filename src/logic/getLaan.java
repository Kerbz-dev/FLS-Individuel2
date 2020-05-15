package logic;

import java.util.List;

import db.laaninfoDB;
import entity.LaaneTilbud;

public class getLaan {
    laaninfoDB db = new laaninfoDB();

    public List<LaaneTilbud> getlaaninfo() {
        return db.getLaan();
}


}