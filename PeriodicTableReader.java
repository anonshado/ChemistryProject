import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PeriodicTableReader {
    final static private String filepath = "PeriodicTable.txt";                                         // file name of the csv containing elements and some of their properties
    private static String searchTerm;                                                                   // value to be searched for in csv
    private static int multiplier;                                                                      // the coefficient of compounds
    private static boolean found = false;                                                               // used to determnine whether ELement is found in the csv
    private static String elementName = "";                                                             // used to hold element's name
    private static String symbol = "";                                                                  // used to hold element's symbol
    private static String num =  "";                                                                    // used to hold element's Atomic number
    private static String molarMass = "";                                                               // used to hold element's Atomic mass in g/mol
    private static List<String> elements;                                                               // used to hold compound's indiviual elements
    private static HashMap<String, Double> elementAndSubscript = new HashMap<String, Double>();         // used to hold elements and their respective subscripts

    // display's an element's name, symbol, atomic number, and molar mass
    public static void displayELement(String elementSymbol){
        searchTerm = elementSymbol;
        readRecord(elementSymbol);
        if(found){
            JOptionPane.showMessageDialog(null, "Element: " + elementName + " \nSymbol: " + symbol + " \nAtomic Num: " + num + " \nMolar Mass: " + molarMass);
        }
        else{
            JOptionPane.showMessageDialog(null, "Error: Element Not Found");
        }
    }

    // linearally traverses PeriodicTable.txt
    public static void readRecord(String elementSymbol){
        try {
            Scanner sc = new Scanner(new File(filepath));
            sc.useDelimiter("[ ,\n]");

            while(sc.hasNext() && !found){
                elementName = sc.next();
                symbol = sc.next();
                num = sc.next();
                molarMass = sc.next();
                found = symbol.equals(searchTerm) ? true : false;
            }

        } 
        catch (Exception e) {
            System.out.println("Error: Filepath Not Found");
        }
    }

    /*
     * The Following methods are getters and setter for various fields that need to be accessed outside of this class
     */

    public static List<String> getElements(){
        return elements;
    }

    public static void setElements(List<String> elements) {
        PeriodicTableReader.elements = elements;
    }


    public static int getMultiplier() {
        return multiplier;
    }

    public static void setMultiplier(int multiplier) {
        PeriodicTableReader.multiplier = multiplier;
    }

    public static HashMap<String, Double> getElementAndSubscript() {
        return elementAndSubscript;
    }

    public static void setElementAndSubscript(HashMap<String, Double> elementAndSubscript) {
        PeriodicTableReader.elementAndSubscript = elementAndSubscript;
    }
    
}
