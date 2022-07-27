import java.util.Scanner;

public class tester {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String compound  = sc.next();
        sc.close();

        //Test parseCompound method from periodic table reader 
        InputParser.parseElements(compound);

        //Test display elemetn method from periodc table reader
        //PeriodicTableReader.displayELement(symbol);

        //test printmeandeviation from meandeviation 
        //MeanDeviation.printMeanDeviation(sc);

        //System.out.println(Character.isDigit(PeriodicTableReader.getElements().get(0).charAt(0)));

        // Test parseSubscript method from teh inputparser class
        InputParser.parseSubscripts();
    }
}
