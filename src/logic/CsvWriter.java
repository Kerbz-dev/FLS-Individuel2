package logic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import db.laaninfoDB;
import entity.Kunde;
import entity.LaaneTilbud;

public class CsvWriter {
    laaninfoDB db = new laaninfoDB();



      public static void main(String[] args) {

    	  Kunde kundeentity = new Kunde();
    		// private Kunde kunde = new Kunde();
    		getKunde kundelogic = new getKunde();
    		List<Kunde> kunder = kundelogic.getKundeAll();
        String filepath="C:\\CSV\\CSVtest.csv";
        try (PrintWriter writer = new PrintWriter(new File(filepath))) {
          getLaan gt = new getLaan();

          List<LaaneTilbud> tilbud = gt.getlaaninfo();

          StringBuilder sb = new StringBuilder();
          sb.append("Name: ");
          for(int i = 0; i < kunder.size(); i++) {
          sb.append(kunder.get(i).getKundenavn());
          sb.append(", ");
          }
          
          sb.append("\n");
          sb.append("CPR: ");
          for(int i = 0; i < kunder.size(); i++) {
        	  
          sb.append(kunder.get(i).getCpr_nummer());
         // sb.append(i + ':');
         // System.out.println(i);
          sb.append(", ");

          }
          
          sb.append("\n");
          sb.append("E-mail: ");
          for(int i = 0; i < kunder.size(); i++) {
          sb.append(kunder.get(i).getEmail());
          sb.append(", ");

          }
          writer.write(sb.toString());

          System.out.println("done!");

        } catch (FileNotFoundException e) {
          System.out.println(e.getMessage());
        }

      }
    }