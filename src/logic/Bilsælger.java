package logic;


public class Bilsælger {

	private String medarbejderNavn;
	private String username;
	private String saelgerpassword;

	public Bilsælger(String medarbejderNavn, String username, String saelgerpassword) {
		
		this.medarbejderNavn = medarbejderNavn;
		this.username = username;
		this.saelgerpassword = saelgerpassword;
		
		
	}

	public String getmedarbejderNavn() {
		return medarbejderNavn;
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

	public void setsaelgerpassword(String saelgerpassword) {
		this.saelgerpassword = saelgerpassword;
	}

	public String getsaelgerpassword() {
		return saelgerpassword;
	}

	@Override
	public String toString() {
		return medarbejderNavn + ": " + username + ": " + saelgerpassword;

	}

}