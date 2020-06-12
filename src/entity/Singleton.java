package entity;

public class Singleton {
	static String username;
	static int saelgerid;
	static boolean isAdmin;
	private static final Singleton singletonInstance = new Singleton(username, saelgerid, isAdmin);
	// Singleton prevents any other class from instantiating

	private Singleton(String username, int saelgerid, boolean isAdmin) {
		Singleton.username = username;
		Singleton.saelgerid = saelgerid;
		Singleton.isAdmin = isAdmin;
	}

	// Providing Global point of access
	public static Singleton getSingletonInstance() {
		return singletonInstance;
	}

	public static int getSaelgerid() {
		return saelgerid;
	}

	public static boolean isAdmin() {
		return isAdmin;
	}

	public static void setAdmin(boolean isAdmin) {
		Singleton.isAdmin = isAdmin;
	}

	public static void setSaelgerid(int saelgerid) {
		Singleton.saelgerid = saelgerid;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Singleton.username = username;
	}

	public static Singleton getSingletoninstance() {
		return singletonInstance;
	}

}