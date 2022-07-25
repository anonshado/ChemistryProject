import java.util.ArrayList;
import java.util.Scanner;

public class MeanDeviation {
    private static ArrayList<Double> data = new ArrayList<Double>();
    private static int amountOfData = 0;
    private static double mean = 0;
    private static double rsd = 0;

    
    private static void gatherData(Scanner sc){
        System.out.print("How Many numbers do you have? ");
        amountOfData = sc.nextInt();

        for(int i = 0; i < amountOfData; i++){
            data.add(sc.nextDouble());
        }
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    private static double calcRSD(){
        for(int i = 0; i < amountOfData; i++){
            rsd += Math.pow((data.get(i) - mean), 2);
        }

        rsd = 100 * ( Math.sqrt( rsd / (amountOfData - 1) ) ) / mean;
        return rsd;
    }

    private static double calcMean(){
        for(int i = 0; i < amountOfData; i++){
            mean += data.get(i);
        }
        
        mean /= amountOfData;
        return mean;
    }

    public static void printMeanDeviation(Scanner sc){
        gatherData(sc);
        System.out.println("Mean: "+ calcMean());
        System.out.printf("RSD: %.2f", calcRSD());
    }
}
