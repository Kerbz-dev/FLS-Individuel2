package logic;

public class Traade extends Thread {
	private int id;
	 public Traade (int id) {
		     this.id = id;
		   }
	public void run()  {
	    System.out.println( "Hello I'm thread no.: " + id );
	}
} 
