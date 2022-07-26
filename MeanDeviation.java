import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MeanDeviation {
    private static ArrayList<Double> data = new ArrayList<Double>();
    private static int amountOfData = 0;
    private static double mean = 0;
    private static double rsd = 0;

    //helper method that collects data and stores in an arraylist to be used later by other helper methods
    private static void gatherData(Scanner sc){
        System.out.print("How Many numbers do you have? ");
        amountOfData = sc.nextInt();

        for(int i = 0; i < amountOfData; i++){
            data.add(sc.nextDouble());
        }
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    //method that calculates the relative standard deviation(RSD)
    private static double calcRSD(){
        for(int i = 0; i < amountOfData; i++){
            rsd += Math.pow((data.get(i) - mean), 2);
        }

        rsd = 100 * ( Math.sqrt( rsd / (amountOfData - 1) ) ) / mean;
        rsd = Math.floor(rsd * 100) / 100;
        return rsd;
    }

    //method that calculates the mean then returns it
    private static double calcMean(){
        for(int i = 0; i < amountOfData; i++){
            mean += data.get(i);
        }
        
        mean /= amountOfData;
        return mean;
    }

    //method that prints both the mean and relative standard deviation
    public static void printMeanDeviation(Scanner sc){
        gatherData(sc);
        System.out.println("Mean: "+ calcMean());
        System.out.printf("RSD: %.2f\n", calcRSD());
        JOptionPane.showMessageDialog(null, "Mean: " + mean + "\nRSD: " + rsd);
    }
}
