package logic;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

public class GetKV extends Thread {
	public enum kreditRating {
		A, B, C, D, error
	};
	private String cprnr;
	private String bilprisGetText;
	private String udbetalingGetText;
	private String laanleangdeGetText;
	public GetKV() {
		
	}
	public GetKV (String cprnr, String bilprisGetText, String udbetalingGetText, String laanleangdeGetText) {
		this.cprnr = cprnr;
		this.bilprisGetText = bilprisGetText;
		this.udbetalingGetText = udbetalingGetText;
		this.laanleangdeGetText = laanleangdeGetText;
	}
	
	LaanCheckTlf checkTlfNr = new LaanCheckTlf();
	// private double udlånsrente;
	private double rente, bilpris, kundeindbetaling, samletpris, mdlYdelse, laanlaengde;

	private Rating kv;
//	String A;
//	String B;
//	String C;
//	String D;
	
	
	public kreditRating getKreditvaerdighed(String cpr) {
		kv = CreditRator.i().rate(cpr);
		CreditRator.i().rate(cpr);

		if (kv == Rating.A) {
			System.out.println("Tjekker kreditrating " + kv);
			return kreditRating.A;
		} else if (kv == Rating.B) {
			System.out.println("Tjekker kreditrating " + kv);
			return kreditRating.B;
		} else if (kv == Rating.C) {
			System.out.println("Tjekker kreditrating " + kv);
			return kreditRating.C;

		} else if (kv == Rating.D) {
			System.out.println("Brugeren er rating D");
			return kreditRating.D;
		}

		else {
			System.out.println("Fejl i koden");
			return kreditRating.error;
		}
	}

	public double getRente(String cprnr) {
		rente = InterestRate.i().todaysRate();
		System.out.println("Base rente er: " + rente);
		kv = CreditRator.i().rate(cprnr);
		// String kv = new String();
		CreditRator.i().rate(cprnr);
		if (kv == Rating.A) {
			rente += 1;
			setRente(rente);
			return rente;
		} else if (kv == Rating.B) {
			rente += 2;
			setRente(rente);
			System.out.println("Renten siger: " + rente);
			return rente;
			// rate+=rateA;
		} else if (kv == Rating.C) {
			rente += 3;
			setRente(rente);
			return rente;

		} else if (kv == Rating.D) {

			System.out.println("Brugeren er rating D");
			return 0;
		}

		else {
			System.out.println("Fejl i koden");
			return -1;
		}
	}

	public double getMdlYdelse(String cprnr, String bilprisGetText, String udbetalingGetText,
			String laanleangdeGetText) {
		rente = InterestRate.i().todaysRate();
		rente /= 100;
		kv = CreditRator.i().rate(cprnr);
		bilpris = Double.parseDouble(bilprisGetText);
		laanlaengde = Double.parseDouble(laanleangdeGetText);
		kundeindbetaling = Double.parseDouble(udbetalingGetText);
		// String kv = new String();
		CreditRator.i().rate(cprnr);
		if (kv == Rating.A) {
			rente += 1.01;

			samletpris = ((bilpris - kundeindbetaling) * Math.pow(rente, laanlaengde));
			mdlYdelse = (samletpris / (laanlaengde * 12));
		

			return mdlYdelse;
		} else if (kv == Rating.B) {
			rente += 1.02;
			samletpris = ((bilpris - kundeindbetaling) * Math.pow(rente, laanlaengde));
			mdlYdelse = (samletpris / (laanlaengde * 12));


			return mdlYdelse;
			// rate+=rateA;
		} else if (kv == Rating.C) {
			rente += 1.03;
			samletpris = ((bilpris - kundeindbetaling) * Math.pow(rente, laanlaengde));
			mdlYdelse = (samletpris / (laanlaengde * 12));

			return mdlYdelse;

		} else if (kv == Rating.D) {

			System.out.println("Brugeren er rating D");
			return 0;
		}

		else {
			System.out.println("Fejl i koden");
			return -1;
		}
	}

	public double getSamletPris(String cprnr, String bilprisGetText, String udbetalingGetText, String laanleangdeGetText) {
		
		rente = InterestRate.i().todaysRate();
		rente /= 100;
		System.out.println("Renten divideret med 100: " + rente);
		laanlaengde = Double.parseDouble(laanleangdeGetText);
		kv = CreditRator.i().rate(cprnr);
		bilpris = Double.parseDouble(bilprisGetText);
		kundeindbetaling = Double.parseDouble(udbetalingGetText);
		// String kv = new String();
		CreditRator.i().rate(cprnr);
		if (kv == Rating.A) {
			rente += 1.01;
			System.out.println("Rente +0.01 giver: " + rente);

			samletpris = ((bilpris - kundeindbetaling) * Math.pow(rente, laanlaengde));

			return samletpris;
		} else if (kv == Rating.B) {
			rente += 1.02;
		
			samletpris = ((bilpris - kundeindbetaling) * Math.pow(rente, laanlaengde));
			return samletpris;
			// rate+=rateA;
		} else if (kv == Rating.C) {
			rente += 1.03;
			System.out.println("Rente +0.03 giver: " + rente);

			samletpris = ((bilpris - kundeindbetaling) * Math.pow(rente, laanlaengde));
			System.out.println("Tjekker kreditrating " + kv + " og får samletpris: " + samletpris);
			return samletpris;

		} else if (kv == Rating.D) {

			System.out.println("Brugeren er rating D");
			return 0;
		}

		else {
			System.out.println("Fejl i koden");
			return -1;
		}
	}
	
	public void run() {
		System.out.println("Tjekker rente");
		getRente(cprnr);
		System.out.println("GetKV getRente(cprnr) renten får: " + getRente(cprnr));
		System.out.println(getRente2());
		System.out.println();
		System.out.println("Tjekker mdlydelse");
		getMdlYdelse(cprnr, bilprisGetText, udbetalingGetText, laanleangdeGetText);
		System.out.println("Tjekker samletPris");
		getSamletPris(cprnr, bilprisGetText, udbetalingGetText, laanleangdeGetText);
	
	}

	public double getRente2() {
		return rente;
	}
	public void setRente(double rente) {
		this.rente = rente;
	}
	public double getSamletpris2() {
		return samletpris;
	}
	public void setSamletpris(double samletpris) {
		this.samletpris = samletpris;
	}
	public double getMdlYdelse2() {
		return mdlYdelse;
	}
	public void setMdlYdelse(double mdlYdelse) {
		this.mdlYdelse = mdlYdelse;
	}


}

//    	public double getRente(String samletprisGetText, String tlfGetText) {
//    		 rente = InterestRate.i().todaysRate();
//
//    		 getFisse(tlfGetText);
//    		
//    		if	(getFisse(tlfGetText).equals("A")) {
//    			rente+=0.01;
//    			System.out.println("Rente før den bliver ganget: " + rente);
//    	        int getTextFornavn = Integer.parseInt(samletprisGetText);
//    	        rente = rente * getTextFornavn;
//    	        System.out.println("Rente * samletpris: " + rente);
//    	        
//    		}  else if	(getFisse(tlfGetText).equals("B")) {
//        			rente+=0.02;
//        			System.out.println("Rente før den bliver ganget: " + rente);
//        	        int getTextFornavn = Integer.parseInt(samletprisGetText);
//        	        rente = rente * getTextFornavn;
//        	        System.out.println("Rente * samletpris: " + rente);
//    		}  else if	(getFisse(tlfGetText).equals("C")) {
//    			rente+=0.03;
//    			System.out.println("Rente før den bliver ganget: " + rente);
//    	        int getTextFornavn = Integer.parseInt(samletprisGetText);
//    	        rente = rente * getTextFornavn;
//    	        System.out.println("Rente * samletpris: " + rente);
//    	        
//    		}  else if	(getFisse(tlfGetText).equals("D")) {
//    			System.out.println("FEJL: KV er D");
//    			
//
//    		}
//
//    		return rente;
//    	}
//    	public List getFisse(String tlfGetText) {
//    		if (checkTlfNr.CheckTlfDB(tlfGetText) == true) {
//    			return checkTlfNr.tlfDB.getKV(tlfGetText);
//    		}
//			return null;
//    		
//    	}
//}
