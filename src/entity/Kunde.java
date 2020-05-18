package entity;

public class Kunde {

	 private String telefonnummer;
	 private String kundenavn;
	 private String cpr_nummer;
	 private String email;
	 private String kreditvaerdighed;
	    

		public Kunde() {
			// TODO Auto-generated constructor stub
		}
		
	    public Kunde (String telefonnummer, String kundenavn, String cpr_nummer, String email, String kreditvaerdighed)
	    {
	    	
	        this.telefonnummer = telefonnummer;
	        this.kundenavn = kundenavn;
	        this.cpr_nummer = cpr_nummer;
	        this.email = email;
	        this.kreditvaerdighed = kreditvaerdighed;
	    }

	    



		public String getTelefonnummer() {
			return telefonnummer;
		}

		public void setTelefonnummer(String telefonnummer) {
			this.telefonnummer = telefonnummer;
		}

		public String getKundenavn() {
			return kundenavn;
		}

		public void setKundenavn(String kundenavn) {
			this.kundenavn = kundenavn;
		}

		public String getCpr_nummer() {
			return cpr_nummer;
		}

		public void setCpr_nummer(String cpr_nummer) {
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

