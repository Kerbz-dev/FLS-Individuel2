package logic;



import java.util.List;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

import entity.Kunde;


public class GetKV {
	public enum kreditRating{rateA, rateB, rateC, rateD, error};
   // private double udlånsrente;
   
    private double rate;
    private Rating kv;

    
        public kreditRating getKreditvaerdighed(String cpr) {
        rate = InterestRate.i().todaysRate();
        kv = CreditRator.i().rate(cpr);
      //  String kv = new String();
        CreditRator.i().rate(cpr);
        if (kv == Rating.A) {
            rate+=0.01;
            System.out.println("Tjekker kreditrating " + kv + " med rente: " + rate);
            return kreditRating.rateA;
        } else if(kv == Rating.B) {

            rate+=0.02;
            System.out.println("Tjekker kreditrating " +  kv + " med rente: " + rate);
            return kreditRating.rateB;
         //   rate+=rateA;
        } else if(kv == Rating.C) {
        	rate+=0.03;
        	 System.out.println("Tjekker kreditrating " + kv + " med rente: " + rate);
        	return kreditRating.rateC;
        	
        }
        else if (kv == Rating.D) {
        	System.out.println("Brugeren er rating D");
        	return kreditRating.rateD;
        }
            
        else {
        System.out.println("Fejl i koden");
            return kreditRating.error;
        }
        
        }
}






