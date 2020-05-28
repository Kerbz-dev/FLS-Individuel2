package logic;

import javafx.scene.paint.Color;

public class TFieldLogik {

	opretLaan OpretLaan = new opretLaan();

	public enum TFieldResult {
		bilnavnIsEmpty, bilprisIsEmpty, udbetalingIsEmpty, laanleangdeIsEmpty, allIsEmpty, udbtlOverstiger,
		laengdeUgyldig, laengdeOverstiger, Success
	};

//    private boolean udbetalingscheck() {
//        String udbtlString = udbetalingTField.getText();
//        String bilprisString = bilprisTField.getText();
//        int udbtlInt = Integer.parseInt(udbtlString);
//        int bilprisInt = Integer.parseInt(bilprisString);
//        if (udbtlInt > bilprisInt) {
//            opretStatusLbl.setTextFill(Color.WHITE);
//            opretStatusLbl.setText("Udbetaling må ikke være større end bilens pris.");
//            opretStatusLbl.relocate(225, 625);
//            return true;
//        } else {
//            return false;
//        }
	public TFieldResult TFieldCheck(String tlfGetText, String bilnavnGetText, String bilprisGetText,
			String udbetalingGetText, String laanleangdeGetText, double rente) {
		int udbtlInt = Integer.parseInt(udbetalingGetText);
		int bilprisInt = Integer.parseInt(bilprisGetText);
		int laengdeInt = Integer.parseInt(laanleangdeGetText);
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
			else if (udbtlInt > bilprisInt) {
				return TFieldResult.udbtlOverstiger;
			}

			else if (laengdeInt < 0) {
				return TFieldResult.laengdeUgyldig;
			}
			else if (laengdeInt > 30) {
				return TFieldResult.laengdeOverstiger;
			}
		else
			return TFieldResult.Success;
	}
}