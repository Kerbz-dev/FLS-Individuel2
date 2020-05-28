package entity;

 

public class Singleton {
    static String username;
    static int saelgerid;
    private static final Singleton singletonInstance = new Singleton(username, saelgerid);
    // Singleton prevents any other class from instantiating
    
    private Singleton(String username, int saelgerid) {
        Singleton.username = username;
        Singleton.saelgerid = saelgerid;
    }
    
    // Providing Global point of access
    public static Singleton getSingletonInstance() {
        return singletonInstance;
    }

 

    public static int getSaelgerid() {
		return saelgerid;
	}

	public static void setSaelgerid(int saelgerid) {
		Singleton.saelgerid = saelgerid;
	}

	public static String getUsername() {
        return username;
    }

 

    public void setUsername(String username) {
        Singleton.username = username;
    }

 

    public static Singleton getSingletoninstance() {
        return singletonInstance;
    } 
    
    
}