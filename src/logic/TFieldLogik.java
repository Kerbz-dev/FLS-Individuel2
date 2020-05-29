package logic;

public class TFieldLogik {

	opretLaan OpretLaan = new opretLaan();

	public enum TFieldResult {
		bilnavnIsEmpty, bilprisIsEmpty, udbetalingIsEmpty, laanleangdeIsEmpty, allIsEmpty, udbtlOverstiger,
		laengdeUgyldig, laengdeOverstiger, Success
	};
	
	public TFieldResult TFieldCheck(String tlfGetText, String bilnavnGetText, String bilprisGetText,
			String udbetalingGetText, String laanleangdeGetText, double rente) {
	
		if (bilnavnGetText.isEmpty() && udbetalingGetText.isEmpty() && bilprisGetText.isEmpty()
				&& udbetalingGetText.isEmpty() && laanleangdeGetText.isEmpty()) {
			return TFieldResult.allIsEmpty;
		} else if (bilnavnGetText.isEmpty()) {
			return TFieldResult.bilnavnIsEmpty;
		} else if (bilprisGetText.isEmpty()) {
			return TFieldResult.bilprisIsEmpty;
		} else if (udbetalingGetText.isEmpty()) {
			return TFieldResult.udbetalingIsEmpty;
		} else if (laanleangdeGetText.isEmpty()) {
			return TFieldResult.laanleangdeIsEmpty;
		}
			else if (checkUdbetaling(udbetalingGetText, bilprisGetText) == true) {
				return TFieldResult.udbtlOverstiger;
			}

			else if (checkLaengdeUnder(laanleangdeGetText) == true) {
				return TFieldResult.laengdeUgyldig;
			}
			else if (checkLaengdeOver(laanleangdeGetText) == true) {
				return TFieldResult.laengdeOverstiger;
			}
		else
			return TFieldResult.Success;
	}
	private boolean checkUdbetaling(String udbetalingGetText, String bilprisGetText) {
		int udbtlInt = Integer.parseInt(udbetalingGetText);
			
		int bilprisInt = Integer.parseInt(bilprisGetText);
		if (udbtlInt > bilprisInt) {
			return true;
		}
	
	return false;
}
	
	private boolean checkLaengdeUnder(String laanleangdeGetText) {
		int laengdeInt = Integer.parseInt(laanleangdeGetText);
		if (laengdeInt < 0) {
			return true;
		}
	return false;
	}
	private boolean checkLaengdeOver(String laanleangdeGetText) {
		int laengdeInt = Integer.parseInt(laanleangdeGetText);
		if (laengdeInt > 30) {
			return true;
		}
	return false;
	}
	
}