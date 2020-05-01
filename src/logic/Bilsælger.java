package logic;

public class Bilsælger {

	private String medarbejderNavn;
	private String username;
	private String password;

	public Bilsælger(String medarbejderNavn, String username, String password) {
		
		this.medarbejderNavn = medarbejderNavn;
		this.username = username;
		this.password = password;
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

	public String setpassword() {
		return this.password;
	}

	public void getpassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return medarbejderNavn + ": " + username + ": " + password;

	}

}