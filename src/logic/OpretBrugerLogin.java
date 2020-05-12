package logic;




import db.Datakobling;
import db.OpretLoginDB;


public class OpretBrugerLogin {


    private Datakobling DB = new Datakobling();
    private OpretLoginDB login = new OpretLoginDB();
    
    public boolean opretBruger(String medarbejderNavn, String CreateUsername, String CreatePassword) {


        if (DB.userCheckDuplicate(CreateUsername) == true ) {
            System.out.println("First duplicateCheck should be true");
            System.out.println(DB.userCheckDuplicate(CreateUsername));
            return true;
        } else if (DB.userCheckDuplicate(CreateUsername) == false ) {
            System.out.println("Second duplicateCheck should be tfalse");
            System.out.println(DB.userCheckDuplicate(CreateUsername));
            login.createLogin(medarbejderNavn, CreateUsername, CreatePassword);
            
            
        
        }
        return false;
        
    }
}




