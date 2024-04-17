package MySpace.Moneytracker;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import MySpace.DateipfadeErstellen;
import MySpace.Farben;
import MySpace.Fortsetzung;

public class Auswertung {
    private static int ergebnis;
    private static int haushaltsergebnis;
    private static int schulergebnis;
    private static int sozialesergebnis;
    private static int taschengeldergebnis;
    private static int ausgaben;
    private static int einkommen;
    private static String auswertung;
    //Hierbei werden die Einträge nach der Kategorie geordnet zu verschieden Summen addiert um dann eine Auswertung der Finanzen zu erhalten.
    public static void auswertung(){
        int i = 1;
        try {
            Path filePath = Paths.get(DateipfadeErstellen.create_filepath_Moneytracker());
            List<String> readAllLines = Files.readAllLines(filePath, Charset.defaultCharset());
            int y = 1;
            for (String string : readAllLines) {
                if (string.contains("+")) {
                    int total01 = Integer.parseInt(readAllLines.get(y));
                    ergebnis += total01;
                }
                if (string.contains("-")) {
                    int total02 = Integer.parseInt(readAllLines.get(y));
                    ergebnis -= total02;
                }
                y++;
            }
            for (String string : readAllLines) {
                if (string.contains("Haushalt")) {
                    string = readAllLines.get(i++);
                    if (string.contains("+")) {
                        int total03 = Integer.parseInt(readAllLines.get(i++));
                        haushaltsergebnis += total03; // Nächste Zeile speichern  
                        i--;
                    }
                    if (string.contains("-")) {
                        int total04 = Integer.parseInt(readAllLines.get(i++));
                        haushaltsergebnis -= total04; // Nächste Zeile speichern  
                        i--;
                    }
                    i--;
                }
                if (string.contains("Schule")) {
                    string = readAllLines.get(i++);
                    if (string.contains("+")) {
                        int total05 = Integer.parseInt(readAllLines.get(i++));
                        schulergebnis += total05; // Nächste Zeile speichern  
                        i--;
                    }
                    if (string.contains("-")) {
                        int total06 = Integer.parseInt(readAllLines.get(i++));
                        schulergebnis -= total06; // Nächste Zeile speichern 
                        i--; 
                    }
                    i--;
                }
                if (string.contains("Soziales")) {
                    string = readAllLines.get(i++);
                    if (string.contains("+")) {
                        int total07 = Integer.parseInt(readAllLines.get(i++));
                        sozialesergebnis += total07; // Nächste Zeile speichern  
                        i--;
                    }
                    if (string.contains("-")) {
                        int total08 = Integer.parseInt(readAllLines.get(i++));
                        sozialesergebnis -= total08; // Nächste Zeile speichern  
                        i--;
                    }
                    i--;
                }
                if (string.contains("Taschengeld")) {
                    string = readAllLines.get(i++);
                    if (string.contains("+")) {
                        int total09 = Integer.parseInt(readAllLines.get(i++));
                        taschengeldergebnis += total09; // Nächste Zeile speichern  
                        i--;
                    }
                    if (string.contains("-")) {
                        int total10 = Integer.parseInt(readAllLines.get(i++));
                        taschengeldergebnis -= total10; // Nächste Zeile speichern  
                        i--;
                    }
                    i--;
                }
               i++; 
            }
            i = 0;
            for (String string : readAllLines) {
                string = readAllLines.get(i++);
                if (string.contains("+")) {
                    int total11 = Integer.parseInt(readAllLines.get(i++));
                    einkommen += total11; // Nächste Zeile speichern 
                    i--; 
                }
                if (string.contains("-")) {
                    int total12 = Integer.parseInt(readAllLines.get(i++));
                    ausgaben -= total12; // Nächste Zeile speichern  
                    i--;
                }
            }
            auswerten();
            System.out.println(auswertung);
            Fortsetzung.frageNachFortsetzung();
        } catch (Exception e) {
            throw new IllegalArgumentException("Fehler ist passiert");
        }
    }

    public static void auswerten(){
        auswertung = Farben.color_green_underlined + "Einkommen:" + Farben.reset + "                        " + Farben.color_green +  einkommen + Farben.reset + "\n" + Farben.color_red_underlined + "generelle Ausgaben:" + Farben.reset + "               " + Farben.color_red + ausgaben + Farben.reset + "\n" + Farben.color_red_underlined + "Ausgaben im Haushalt:" + Farben.reset + "             " + Farben.color_red + haushaltsergebnis + Farben.reset + "\n" + Farben.color_red_underlined + "Ausgaben für die Schule:" + Farben.reset + "          " + Farben.color_red + schulergebnis + Farben.reset + "\n" + Farben.color_red_underlined + "Ausgaben für Soziales:" + Farben.reset + "            " + Farben.color_red + sozialesergebnis + Farben.reset + "\n"+ Farben.color_green_underlined + "Einkommen durch Taschengeld:" + Farben.reset + "      " + Farben.color_green + taschengeldergebnis + Farben.reset + "\n" + Farben.color_green_underlined + "Gesamtergebnis:" + Farben.reset + "                   " + Farben.color_green + ergebnis + Farben.reset;
    }
}
