import java.util.Arrays;

public class InputParser{

    //checks for coefficient and if presents sets multiplier equal to it
    public static void parseCoefficient(){
        if(Character.isDigit(PeriodicTableReader.getElements().get(0).charAt(0))){
            PeriodicTableReader.setMultiplier(Integer.parseInt(PeriodicTableReader.getElements().get(0).substring(0,1)));
        }
    }
    // splits input string, "compound", at new elements 
    public static void parseElements(String compound){
        String[] tempElements = compound.split("(?=\\p{Upper})");
        PeriodicTableReader.setElements(Arrays.asList(tempElements));

    }

    // parses elements for subscripts. parseCompound() must be run first 
    public static void parseSubscripts(){
        
        // splits string in elements[] in to element and subscript and puts them into elementAndSubscript
        for(int i = Character.isDigit(PeriodicTableReader.getElements().get(0).charAt(0)) ? 1 : 0; i < PeriodicTableReader.getElements().size(); i++){
            
            // if no subscripts is presents the value of 1 is assigned else subscript value is
            if((PeriodicTableReader.getElements().get(i).replaceAll("[A-Za-z]", "")).length() <= 0){
                PeriodicTableReader.setElementAndSubscript( 1, (PeriodicTableReader.getElements().get(i).replaceAll("[0-9]", "")));
            }
            else{
                PeriodicTableReader.setElementAndSubscript( (Integer.parseInt(PeriodicTableReader.getElements().get(i).replaceAll("[A-Za-z]", ""))), (PeriodicTableReader.getElements().get(i).replaceAll("[0-9]", "")));
            }
        }

        System.out.println(PeriodicTableReader.getElementAndSubscript().keySet());
        System.out.println(PeriodicTableReader.getElementAndSubscript().values());

    }
}