package logic;

public class Kunde {

	 private int telefonnummer;
	 private String kundenavn;
	 private int cpr_nummer;
	 private String email;
	 private String kreditværdighed;
	    

	 public Kunde() {
		 
	 }

	    public Kunde (int telefonnummer, String kundenavn, int cpr_nummer, String email, String kreditværdighed)
	    {
	    	
	        this.telefonnummer = telefonnummer;
	        this.kundenavn = kundenavn;
	        this.cpr_nummer = cpr_nummer;
	        this.email = email;
	        this.kreditværdighed = kreditværdighed;
	    }

	 

	    
	    public int gettelefonnummer() {
	        return this.telefonnummer;
	    }

	 

	    public void settelefonnummer(int telefonnummer) {
	        this.telefonnummer = telefonnummer;
	    }

	 

	    public void setkundenavn(String kundenavn) {
	        this.kundenavn = kundenavn;
	    }

	 

	    public String getkundenavn() {
	        return kundenavn;
	    }

	 

	    public int setcpr_nummer() {
	        return this.cpr_nummer;
	    }

	 

	    public void getcpr_nummer(int cpr_nummer) {
	        this.cpr_nummer = cpr_nummer;
	    }
	    
	    public String setemail() {
	        return this.email;
	    }

	 

	    public void getemail(String email) {
	        this.email = email;
	    }
	    
	    public String setkreditværdighed() {
	        return this.kreditværdighed;
	    }

	 

	    public void getkreditværdighed(String kreditværdighed) {
	        this.kreditværdighed = kreditværdighed;
	    }
	    
	    @Override
	    public String toString() {
	        return telefonnummer + ": " + kundenavn + ": " + cpr_nummer + ": " + email + ": " + kreditværdighed + ": ";
	    }

	 

	}

