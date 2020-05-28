package logic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import db.LaaneTilbudDB;
import entity.Kunde;
import entity.LaaneTilbud;

public class CsvWriter {
    LaaneTilbudDB db = new LaaneTilbudDB();
	getLaan gl = new getLaan();
	getKunde gk = new getKunde();

    		public void exportCsv(int tilbudsid, int tlfnr) {
        	
//    			Kunde kundeentity = new Kunde();
    			// private Kunde kunde = new Kunde();
    			String filepath = "C:\\CSV\\CSVtest.csv";

    			
    			//Det eneste de skal gøre, er at lave en ny funktion, som de kalder exportAllCsv, og så kalde den i præsentation's else

    			try (PrintWriter writer = new PrintWriter(new File(filepath))) {

//    				getLaan gt = new getLaan();

//    				List<LaaneTilbud> tilbud = gt.getLaanAll();

    				StringBuilder sb = new StringBuilder();

    				System.out.println("tilbudsid: " + tilbudsid);

    				List<LaaneTilbud> GigaJohn = gl.getLaanWhere(tilbudsid);
    				List<Kunde> GigaKunde = gl.getKundeWhere(tlfnr);

    				for (int i = 0; i < gl.getKundeWhere(tlfnr).size(); i++) {
    				sb.append(GigaKunde.get(i).getKundefornavn() + " " + GigaKunde.get(i).getKundeefternavn());
					sb.append(", ");
					sb.append(GigaKunde.get(i).getCpr_nummer());
    				}
    				for (int i = 0; i < gl.getLaanWhere(tilbudsid).size(); i++) {
    					System.out.println(gl.getLaanWhere(tilbudsid).get(i).getAllTilbud());
    					// sb.append(gl.getLaanWhere(tilbudsid).get(i).getAllTilbud());
    					// sb.append(", ");
//    					Scanner scan = new Scanner((Readable) gl.getLaanWhere(tilbudsid));
//    					scan.useDelimiter(":");
//    					scan.
//    					sb.useDelimiter(",");
//    					sb.next();
    					// sb.replace(gl.getLaanWhere(tilbudsid), ':', ',');
    					System.out.println(GigaJohn);
//    					System.out.println(scan);

    					sb.append(gl.getLaanWhere(tilbudsid).get(i).getTelefonnummer());
    					sb.append(", ");
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

    				System.out.println("done!");

    			} catch (FileNotFoundException e) {
    				System.out.println(e.getMessage());
    			}

    		}
    	

public void exportAllCsv() {
	
//	Kunde kundeentity = new Kunde();
	// private Kunde kunde = new Kunde();
	String filepath = "C:\\CSV\\CSVtest.csv";


	try (PrintWriter writer = new PrintWriter(new File(filepath))) {


		StringBuilder sb = new StringBuilder();


		for (int i = 0; i < gk.getKundeAll().size(); i++) {
		sb.append(gk.getKundeAll().get(i).toString());
		sb.append(", ");
		sb.append("\n");
		}
		for (int i = 0; i < gl.getLaanAll().size(); i++) {
			sb.append(gl.getLaanAll().get(i));
			sb.append(", ");
			sb.append("\n");

		}

		writer.write(sb.toString());

		System.out.println("done!");

	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	}

}
}
