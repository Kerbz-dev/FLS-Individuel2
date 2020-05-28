package logic;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

public class GetKV {
	public enum kreditRating {
		A, B, C, D, error
	};

	
	
	LaanCheckTlf checkTlfNr = new LaanCheckTlf();
	// private double udlånsrente;
	private double rente, bilpris, kundeindbetaling, samletpris, mdlYdelse, laanlaengde;

	private Rating kv;
	
	
	public kreditRating getKreditvaerdighed(String cpr) {
		kv = CreditRator.i().rate(cpr);
		

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

	public double getRente(String cprnr, String bilprisGetText, String udbetalingGetText, String laanleangdeGetText) {
		rente = InterestRate.i().todaysRate();
		
		System.out.println("Base rente er: " + rente);
		kv = CreditRator.i().rate(cprnr);
		bilpris = Double.parseDouble(bilprisGetText);
		laanlaengde = Double.parseDouble(laanleangdeGetText);
		kundeindbetaling = Double.parseDouble(udbetalingGetText);
		
		
		if (kv == Rating.A) {
			rente += 1;
            
            if (laanlaengde > 3) {
                rente +=1;
            }
            if (kundeindbetaling < bilpris/2) {
                rente+=1;
            }
			setRente(rente);
			return rente;
		} else if (kv == Rating.B) {
			rente += 2;
            
            if (laanlaengde > 3) {
                rente +=1;
            }
            if (kundeindbetaling < bilpris/2) {
                rente+=1;
            }
			setRente(rente);
			return rente;
		} else if (kv == Rating.C) {
			rente += 3;
            
            if (laanlaengde > 3) {
                rente +=1;
            }
            if (kundeindbetaling < bilpris/2) {
                rente+=1;
            }
			setRente(rente);
			return rente;

		} else if (kv == Rating.D) {
			rente = 0;
			setRente(rente);
			System.out.println("Brugeren er rating D");
			return rente;
		}

		else {
			System.out.println("Fejl i koden");
			rente = -1;
			setRente(rente);
			return rente;
		}
	}
	

	public double getMdlYdelse(String cprnr, String bilprisGetText, String udbetalingGetText, String laanleangdeGetText) {
		rente = getRente2();
		rente = rente/100 + 1;
		System.out.println("MdlYdelse rente får :" + rente);
	//	rente /= 100;
		//kv = CreditRator.i().rate(cprnr);
		bilpris = Double.parseDouble(bilprisGetText);
		laanlaengde = Double.parseDouble(laanleangdeGetText);
		kundeindbetaling = Double.parseDouble(udbetalingGetText);

		 if (rente == 0) {

				System.out.println("Brugeren er rating D");
				return 0;
			}
		
			else if (rente == -1) {
				System.out.println("Fejl i koden");
				return -1;
			}
;
			samletpris = ((bilpris - kundeindbetaling) * Math.pow(rente, laanlaengde));
			mdlYdelse = (samletpris / (laanlaengde * 12));

		

		 setMdlYdelse(mdlYdelse);
		 setSamletpris(samletpris);
		 return mdlYdelse;
		
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
