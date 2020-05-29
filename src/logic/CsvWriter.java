package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import db.LaaneTilbudDB;

public class CsvWriter {
	LaaneTilbudDB db = new LaaneTilbudDB();
	getLaan gl = new getLaan();
	getKunde gk = new getKunde();

	public boolean exportCsv(int tilbudsid, int tlfnr) {

		String filepath = "C:\\CSV\\" + "Tilbud" + " " + tilbudsid + "-" + tlfnr + ".csv";

		try (PrintWriter writer = new PrintWriter(new File(filepath))) {

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < gl.getKundeWhere(tlfnr).size(); i++) {

				sb.append(gl.getKundeWhere(tlfnr).get(i).getKundefornavn());
				sb.append(", ");
				sb.append(gl.getKundeWhere(tlfnr).get(i).getKundeefternavn());
				sb.append(", ");
				sb.append(gl.getKundeWhere(tlfnr).get(i).getTelefonnummer());
				sb.append(", ");
				sb.append(gl.getKundeWhere(tlfnr).get(i).getCpr_nummer());
				sb.append(", ");
				sb.append(gl.getKundeWhere(tlfnr).get(i).getMail());
				sb.append(", ");
				sb.append(gl.getKundeWhere(tlfnr).get(i).getPostnummer());
				sb.append(", ");
				sb.append(gl.getKundeWhere(tlfnr).get(i).getBynavn());
				sb.append(", ");
				sb.append(gl.getKundeWhere(tlfnr).get(i).getVejnavn());
				sb.append(", ");
				sb.append(gl.getKundeWhere(tlfnr).get(i).getHusnummer());
				sb.append(", ");
				sb.append(gl.getKundeWhere(tlfnr).get(i).getKreditVurdering());
				sb.append(", ");

			}

			for (int i = 0; i < gl.getLaanWhere(tilbudsid).size(); i++) {

				sb.append(gl.getLaanWhere(tilbudsid).get(i).getIndbetaling());
				sb.append(", ");
				sb.append(gl.getLaanWhere(tilbudsid).get(i).getLaanlaengde());
				sb.append(", ");
				sb.append(gl.getLaanWhere(tilbudsid).get(i).getBilid());
				sb.append(", ");
				sb.append(gl.getLaanWhere(tilbudsid).get(i).getBilsaelgerid());
				sb.append(", ");
				sb.append(gl.getLaanWhere(tilbudsid).get(i).getRentedato());
				sb.append(", ");
				sb.append(gl.getLaanWhere(tilbudsid).get(i).getOverstigergraense());
				sb.append(", ");
				sb.append(gl.getLaanWhere(tilbudsid).get(i).getLaanestatus());
				sb.append(", ");
				sb.append(gl.getLaanWhere(tilbudsid).get(i).getRente());
				sb.append(", ");
				sb.append(gl.getLaanWhere(tilbudsid).get(i).getMdlydelse());
				sb.append(", ");
				sb.append(gl.getLaanWhere(tilbudsid).get(i).getSamletpris());
				sb.append("\n");
			}

			writer.write(sb.toString());

			return true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean exportAllCsv(int tilbudsid, int tlfnr) {

		String filepath = "C:\\CSV\\CSVall.csv";

		try (PrintWriter writer = new PrintWriter(new File(filepath))) {

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < gk.getKundeAll().size(); i++) {

				sb.append(gk.getKundeAll().get(i).getKundefornavn());
				sb.append(", ");
				sb.append(gk.getKundeAll().get(i).getKundeefternavn());
				sb.append(", ");
				sb.append(gk.getKundeAll().get(i).getTelefonnummer());
				sb.append(", ");
				sb.append(gk.getKundeAll().get(i).getCpr_nummer());
				sb.append(", ");
				sb.append(gk.getKundeAll().get(i).getMail());
				sb.append(", ");
				sb.append(gk.getKundeAll().get(i).getPostnummer());
				sb.append(", ");
				sb.append(gk.getKundeAll().get(i).getBynavn());
				sb.append(", ");
				sb.append(gk.getKundeAll().get(i).getVejnavn());
				sb.append(", ");
				sb.append(gk.getKundeAll().get(i).getHusnummer());
				sb.append(", ");
				sb.append(gk.getKundeAll().get(i).getKreditVurdering());
				sb.append(", ");
				sb.append("\n");

			}

			for (int i = 0; i < gl.getLaanAll().size(); i++) {

				sb.append(gl.getLaanAll().get(i).getIndbetaling());
				sb.append(", ");
				sb.append(gl.getLaanAll().get(i).getLaanlaengde());
				sb.append(", ");
				sb.append(gl.getLaanAll().get(i).getBilid());
				sb.append(", ");
				sb.append(gl.getLaanAll().get(i).getBilsaelgerid());
				sb.append(", ");
				sb.append(gl.getLaanAll().get(i).getRentedato());
				sb.append(", ");
				sb.append(gl.getLaanAll().get(i).getOverstigergraense());
				sb.append(", ");
				sb.append(gl.getLaanAll().get(i).getLaanestatus());
				sb.append(", ");
				sb.append(gl.getLaanAll().get(i).getRente());
				sb.append(", ");
				sb.append(gl.getLaanAll().get(i).getMdlydelse());
				sb.append(", ");
				sb.append(gl.getLaanAll().get(i).getSamletpris());
				sb.append(", ");
				sb.append("\n");

			}

			writer.write(sb.toString());

			return true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

}
