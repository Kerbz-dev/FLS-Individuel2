package entity;

public class Admin {

	private int adminid;
	private String adminbrugernavn;
	private String adminpassword;

	public Admin(int adminid, String adminbrugernavn) {

		this.adminid = adminid;
		this.adminbrugernavn = adminbrugernavn;

	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminbrugernavn() {
		return adminbrugernavn;
	}

	public void setAdminbrugernavn(String adminbrugernavn) {
		this.adminbrugernavn = adminbrugernavn;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

}