package entity;

public class LaaneTilbud {

	private String bilnavn;
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
