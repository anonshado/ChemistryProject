import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PeriodicTableReader {
    final static private String filepath = "PeriodicTable.txt";           //csv
    private static String searchTerm;                                    // value searched for in csv
    private static int multiplier;                                        //coefficient of compounds
    private static ArrayList<String> elements;                           //elements in a compoun

    public static void displayELement(String elementSymbol){
        searchTerm = elementSymbol;
        readRecord();
    }

    private static void readRecord(){
        boolean found = false;
        String elementName = "";
        String symbol = "";
        String num =  "";
        String molarMass = "";
        
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

            if(found){
                JOptionPane.showMessageDialog(null, "Element: " + elementName + " \nSymbol: " + symbol + " \nAtomic Num: " + num + " \nMolar Mass: " + molarMass);
            }
        } 
        catch (Exception e) {
            
        }
    }

    public static double compoundMolarMass(String compound){
        double totalMolarMass = 0.0;
        parseCompound(compound);
        
        if(Character.isDigit(elements.get(0).charAt(0))){
            multiplier = elements.get(0).charAt(0);
        }

        for(int i = Character.isDigit(elements.get(0).charAt(0)) ? 1 : 0; i < elements.size(); i++){
            
        }

        
        return totalMolarMass;
    }

    private static void parseCompound(String compound){
        
        if(Character.isDigit(compound.charAt(0))){
             multiplier = compound.charAt(0);
        }

        String[] tempElements = compound.split("(?=\\p{Upper})");
        //TODO: delete for loop that was used for testing
        for(String ele: tempElements)
            System.out.println(ele);
        elements = new ArrayList<String>(Arrays.asList(tempElements));

    }
}
