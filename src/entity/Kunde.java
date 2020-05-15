package entity;

public class Kunde {

	 private int telefonnummer;
	 private String kundenavn;
	 private int cpr_nummer;
	 private String email;
	 private String kreditvaerdighed;
	    
	 public Kunde() {
		 
	 }

	    public Kunde (int telefonnummer, String kundenavn, int cpr_nummer, String email, String kreditvaerdighed)
	    {
	    	
	        this.telefonnummer = telefonnummer;
	        this.kundenavn = kundenavn;
	        this.cpr_nummer = cpr_nummer;
	        this.email = email;
	        this.kreditvaerdighed = kreditvaerdighed;
	    }


		public int getTelefonnummer() {
			return telefonnummer;
		}

		public void setTelefonnummer(int telefonnummer) {
			this.telefonnummer = telefonnummer;
		}

		public String getKundenavn() {
			return kundenavn;
		}

		public void setKundenavn(String kundenavn) {
			this.kundenavn = kundenavn;
		}

		public int getCpr_nummer() {
			return cpr_nummer;
		}

		public void setCpr_nummer(int cpr_nummer) {
			this.cpr_nummer = cpr_nummer;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getKreditvaerdighed() {
			return kreditvaerdighed;
		}

		public void setKreditvaerdighed(String kreditvaerdighed) {
			this.kreditvaerdighed = kreditvaerdighed;
		}

		@Override
	    public String toString() {
	        return telefonnummer + ": " + kundenavn + ": " + cpr_nummer + ": " + email + ": " + kreditvaerdighed + ": ";
	    }

	 

	}

