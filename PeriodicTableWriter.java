import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PeriodicTableWriter {
    private static String elementName = "";
    private static String symbol = "";
    private static String num = "";
    private static String molarMass = "";
    private static String filepath = "PeriodicTable.txt";

    public static void saveRecord(){
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner sc = new Scanner(System.in);

            for(int i = 1; i <= 118 ; i++){
            elementName = sc.next();
            symbol = sc.next();
            num ="" + i;
            molarMass = sc.next();

            pw.println(elementName + "," + symbol + "," + num + "," + molarMass);
            pw.flush();
            System.out.println();
            }

            sc.close();
            pw.close();

            JOptionPane.showMessageDialog(null, "Record Saved");
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Has Occured");
        }
    }
}
