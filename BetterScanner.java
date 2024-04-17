package MySpace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BetterScanner {
        /*
         * Ein Verbesserter Scanner gesplittet in String und int um jeweils den Datentypen einlesen zukönnen.
         */
        public static String betterScannerString(String text)
        {
            //Erstellen des Objekts reader der Klasse BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //Erstellen der String Variable eingabe, um den Input zu speichern.
            String eingabe;
            //while Loop (Dauerschleife)
            while(true)
            {
                //Printen des übergebenen Textes 
                System.out.print(text);
                //Try Catch um zu verhindern, dass bei einem Fehler das Programm abstürtzt.
                try
                {
                    //Den Input der oben erstellten Variable übergeben.
                    eingabe = reader.readLine();
                    //Aus der Schleife ausbrechen.
                    break;
                }
                catch(Exception e)
                {
                    //Dies wird geprintet sobald die Schritte in dem Try Abschnitt einen Fehler wirft.
                    System.out.println("Ungültige Eingabe!\n");
                }
            }
            //Die Variable eingabe mit dem Input gespeichert wird übergeben.
            return eingabe;
        }
        public static int betterScannerInt(String text)
        {
            //Erstellen des Objekts reader der Klasse BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));     
            //Erstellen der int Variable eingabe, um den Input zu speichern.
            int eingabe;
            //while Loop (Dauerschleife)
            while(true)
            {
                //Printen des übergebenen Textes 
                System.out.print(text);
                //Try Catch um zu verhindern, dass bei einem Fehler das Programm abstürtzt.
                try
                {
                    //Den Input der oben erstellten Variable übergeben.
                    eingabe = Integer.parseInt(reader.readLine());
                    //Aus der Schleife ausbrechen.
                    break;
                }
                catch(Exception e)
                {
                    //Dies wird geprintet sobald die Schritte in dem Try Abschnitt einen Fehler wirft, also wenn zum Beispiel ein String eingegeben wird..
                    System.out.println("Ungültige Eingabe!\n");
                }
            }
            //Die Variable eingabe mit dem Input gespeichert wird übergeben.
            return eingabe;
        }
}
