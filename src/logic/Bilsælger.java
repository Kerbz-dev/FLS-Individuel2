package logic;

public class Bils�lger {

	private String medarbejderNavn;
	private String username;
	private String saelgerpassword;

	public Bils�lger(String medarbejderNavn, String username, String saelgerpassword) {
		
		this.medarbejderNavn = medarbejderNavn;
		this.username = username;
		this.saelgerpassword = saelgerpassword;
	}

	public String getmedarbejderNavn() {
		return this.medarbejderNavn;
	}

	public void setmedarbejderNavn(String medarbejderNavn) {
		this.medarbejderNavn = medarbejderNavn;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getusername() {
		return username;
	}

	public String setsaelgerpassword() {
		return this.saelgerpassword;
	}

	public void getsaelgerpassword(String saelgerpassword) {
		this.saelgerpassword = saelgerpassword;
	}

	@Override
	public String toString() {
		return medarbejderNavn + ": " + username + ": " + saelgerpassword;

	}

}