package entity;

public class LaaneTilbud {

    private int bilpris;
    private int laanlaengde;
    private String bilnavn;
    private int udbetalingspris;
    private int tilbudsid;

 public LaaneTilbud() {

     }
 
 public LaaneTilbud(int tilbudsid, int laanlaengde) {
	 this.tilbudsid = tilbudsid;
	 this.laanlaengde = laanlaengde;
 }
    public LaaneTilbud(int bilpris, int tilbudsid, int laanlaengde, String bilnavn, int udbetalingspris) {
    		
            this.bilpris = bilpris;
            this.laanlaengde = laanlaengde;
            this.bilnavn = bilnavn;
            this.udbetalingspris = udbetalingspris;
    }



    public int getTilbudsid() {
		return tilbudsid;
	}

	public void setTilbudsid(int tilbudsid) {
		this.tilbudsid = tilbudsid;
	}
	


    public int getBilpris() {
        return bilpris;
    }


    public void setIndbetaling(int bilpris) {
        this.bilpris = bilpris;
    }

    public int getLaanlaengde() {
        return laanlaengde;
    }


    public void setLaanlaengde(int laanlaengde) {
        this.laanlaengde = laanlaengde;
    }

    public String getbilnavn() {
        return bilnavn;
    }


    public void setbilnavn(String bilnavn) {
        this.bilnavn = bilnavn;
    }

    public int getudbetalingspris() {
        return udbetalingspris;
    }


    public void setudbetalingspris(int udbetalingspris) {
        this.udbetalingspris = udbetalingspris;
    }



    public String getAllTilbud() {
        return  tilbudsid + ": " + bilpris + ": " + laanlaengde + ": " + bilnavn+ ": " + udbetalingspris;
    }
}
	
	
	
	
	
	
	
	
	

/*	private String bilnavn;
	private int bilpris;
	private int udbetalingspris;
	private int laanlaengde;
	
 public LaaneTilbud() {
		 
	 }
	public LaaneTilbud(String bilnavn, int bilpris, int udbetalingspris, int laanlaengde) {
			this.bilnavn = bilnavn;
			this.bilpris = bilpris;
			this.udbetalingspris = udbetalingspris;
			this.laanlaengde = laanlaengde;
	}


	public String getBilnavn() {
		return bilnavn;
	}


	public void setBilnavn(String bilnavn) {
		this.bilnavn = bilnavn;
	}


	public int getBilpris() {
		return bilpris;
	}


	public void setBilpris(int bilpris) {
		this.bilpris = bilpris;
	}


	public int getUdbetalingspris() {
		return udbetalingspris;
	}


	public void setUdbetalingspris(int udbetalingspris) {
		this.udbetalingspris = udbetalingspris;
	}


	public int getLaanlaengde() {
		return laanlaengde;
	}


	public void setLaanlaengde(int laanlaengde) {
		this.laanlaengde = laanlaengde;
	}

	
	public String getAllTilbud() {
		return  bilnavn + ": " + bilpris + ": " + udbetalingspris + ": " + laanlaengde;
	}
}
*/