package logic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import db.LaaneTilbudDB;
import entity.Kunde;
import entity.LaaneTilbud;
import presentation.LaaneUI;

public class CsvWriter {
    LaaneTilbudDB db = new LaaneTilbudDB();
	getLaan gl = new getLaan();


    		public void exportCsv(int tilbudsid, int tlfnr) {
        	
//    			Kunde kundeentity = new Kunde();
    			// private Kunde kunde = new Kunde();
    			getKunde kundelogic = new getKunde();
    			List<Kunde> kunder = kundelogic.getKundeAll();
    			String filepath = "C:\\CSV\\CSVtest.csv";

    			LaaneUI lnUI = new LaaneUI();

    			try (PrintWriter writer = new PrintWriter(new File(filepath))) {

//    				getLaan gt = new getLaan();

//    				List<LaaneTilbud> tilbud = gt.getLaanAll();

    				StringBuilder sb = new StringBuilder();

    				System.out.println("tilbudsid: " + tilbudsid);

    				List<LaaneTilbud> GigaJohn = gl.getLaanWhere(tilbudsid);
    				List<Kunde> GigaKunde = gl.getKundeWhere(tlfnr);
//    				lnUI.testcsv();
//    				flemse = lnUI.testcsv();
//    				System.out.println(lnUI.testcsv());
//    				System.out.println(flemse);
//    				sb.append(flemse);
    				// sb.append("Alt fra tilbud: ");
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

//    				sb.append("kundefornavn: ");
//    				for (int i = 0; i < kunder.size(); i++) {
//    					sb.append(kunder.get(i).getKundefornavn());
//    					sb.append(", ");
//    				}
    	//
//    				sb.append("\n");
//    				sb.append("kundeefternavn: ");
//    				for (int i = 0; i < kunder.size(); i++) {
//    					sb.append(kunder.get(i).getKundeefternavn());
//    					sb.append(", ");
//    				}
    	//
//    				sb.append("\n");
//    				sb.append("CPR: ");
//    				for (int i = 0; i < kunder.size(); i++) {
//    					sb.append(kunder.get(i).getCpr_nummer());
//    					// sb.append(i + ':');
//    					// System.out.println(i);
//    					sb.append(", ");
//    				}
    	//
//    				sb.append("\n");
//    				sb.append("E-mail: ");
//    				for (int i = 0; i < kunder.size(); i++) {
//    					sb.append(kunder.get(i).getMail());
//    					sb.append(", ");
//    				}
    	//
//    				sb.append("\n");
//    				sb.append("postnummer: ");
//    				for (int i = 0; i < kunder.size(); i++) {
//    					sb.append(kunder.get(i).getPostnummer());
//    					sb.append(", ");
//    				}
    	//
//    				sb.append("\n");
//    				sb.append("bynavn: ");
//    				for (int i = 0; i < kunder.size(); i++) {
//    					sb.append(kunder.get(i).getBynavn());
//    					sb.append(", ");
//    				}
    	//
//    				sb.append("\n");
//    				sb.append("vejnavn: ");
//    				for (int i = 0; i < kunder.size(); i++) {
//    					sb.append(kunder.get(i).getVejnavn());
//    					sb.append(", ");
//    				}
    	//
//    				sb.append("\n");
//    				sb.append("hurnr: ");
//    				for (int i = 0; i < kunder.size(); i++) {
//    					sb.append(kunder.get(i).getHusnummer());
//    					sb.append(", ");
//    				}
    	//
//    				sb.append("\n");
//    				sb.append("kreditVurdering: ");
//    				for (int i = 0; i < kunder.size(); i++) {
//    					sb.append(kunder.get(i).getKreditVurdering());
//    					sb.append(", ");
//    				}

    				writer.write(sb.toString());

    				System.out.println("done!");

    			} catch (FileNotFoundException e) {
    				System.out.println(e.getMessage());
    			}

    		}
    	}
