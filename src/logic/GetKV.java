package logic;





import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;


public class GetKV {
	public enum kreditRating{A, B, C, D, error};
   // private double udlånsrente;
	   private double rente;
	   private Rating kv;

    
        public kreditRating getKreditvaerdighed(String cpr) {
        rente = InterestRate.i().todaysRate();
        kv = CreditRator.i().rate(cpr);
      //  String kv = new String();
        CreditRator.i().rate(cpr);
        if (kv == Rating.A) {
            rente+=0.01;
            System.out.println("Tjekker kreditrating " + kv + " med rente: " + rente);
            return kreditRating.A;
        } else if(kv == Rating.B) {

            rente+=0.02;
            System.out.println("Tjekker kreditrating " +  kv + " med rente: " + rente);
            return kreditRating.B;
         //   rate+=rateA;
        } else if(kv == Rating.C) {
        	rente+=0.03;
        	 System.out.println("Tjekker kreditrating " + kv + " med rente: " + rente);
        	return kreditRating.C;
        	
        }
        else if (kv == Rating.D) {
        	System.out.println("Brugeren er rating D");
        	return kreditRating.D;
        }
            
        else {
        System.out.println("Fejl i koden");
            return kreditRating.error;
        }
        }
}






