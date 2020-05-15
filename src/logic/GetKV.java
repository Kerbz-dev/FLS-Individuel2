package logic;



import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;


public class GetKV {
	public enum kreditRating{rateA, rateB, rateC, rateD};
   // private double udlånsrente;
    private String cpr = "2802922003";
    private double rate;
  



    
        public kreditRating getkreditvaerdighed() {
        rate = InterestRate.i().todaysRate();
      //  String kv = new String();
        CreditRator.i().rate(cpr);
        if (CreditRator.i().rate(cpr) == Rating.A) {
        	System.out.println("Kreditværdighed er:");
            System.out.println(CreditRator.i().rate(cpr));
            System.out.println(InterestRate.i().todaysRate());
            rate++;
            System.out.println(rate);
            return kreditRating.rateA;
        } else {
            System.out.println("Kreditværdighed er ikke A");
            System.out.println("Kreditværdighed er:"); 
            System.out.println(CreditRator.i().rate(cpr));
            System.out.println(InterestRate.i().todaysRate());
            return kreditRating.rateD;
        }
        }
}






