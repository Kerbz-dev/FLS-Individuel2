package logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import presentation.LoginUI;

public class LoginVerification {

//	private Datakobling DB;
	private LoginUI loginui;

	public LoginVerification(LoginUI loginui) {
		this.loginui = loginui;

	}

//	JOptionPane.showMessageDialog(null, "Username or Password blank")

	public void loginBtn() {
		String usernameInput = loginui.userLoginField.getText();
		String passwordInput = loginui.passLoginField.getText();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;"
					+ "databaseName=" + "FerrariDB" + ";" + "integratedSecurity=true;");
			Statement stmt = con.createStatement();
			String sql = "Select * from bilsealger where username='" + usernameInput + "' and password='"
					+ passwordInput + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				loginui.loginSuccess(); }
			else {
				loginui.loginFail();
			}
			con.close();

		} catch (Exception e) {
			System.out.print(e);
		}

		/*
		 * int count = 0; String usernameInput =
		 * loginui.userLoginField.getText().trim(); String passwordInput =
		 * loginui.passLoginField.getText().trim(); System.out.println(usernameInput);
		 * System.out.println(passwordInput); System.out.println("user input virker");
		 * String query = "SELECT * FROM bilsealger";
		 * 
		 * try { ps = con.prepareStatement(query); rs = ps.executeQuery(query);
		 * System.out.println("connection established"); count++; boolean check = false;
		 * while(rs.next()); String username = rs.getString("username"); String password
		 * = rs.getString("password"); System.out.println(username);
		 * System.out.println(password);
		 * System.out.println("retrieved username + password from DB");
		 * 
		 * if(username.equals(usernameInput) && password.equals(passwordInput)) { check
		 * = true; ps.close(); System.out.println("Login successful!"); } else {
		 * System.out.println("Login failed");
		 * 
		 * }
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 */
	}
}
