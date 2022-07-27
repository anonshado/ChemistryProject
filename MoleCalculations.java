public class MoleCalculations {
    
    //method that calculates the collective molar mass for a compound
    public static double compoundMolarMass(String compound){
        double totalMolarMass = 0.0;

        //parses input for necessary data i.e coefficients, subscripts, 
        InputParser.parseElements(compound);
        InputParser.parseCoefficient();  
        InputParser.parseSubscripts();
             

        //calculates the total molar mass
        for(int i = Character.isDigit(PeriodicTableReader.getElements().get(0).charAt(0)) ? 1 : 0; i < PeriodicTableReader.getElements().size(); i++){
            totalMolarMass += Double.parseDouble(PeriodicTableReader.getElements().get(i));
        }

        return totalMolarMass;
    }

    //converts from grams to mols of a compound
    //TODO: this method
    public static double gramsToMols(String compound, double grams){
        
        return -1;
    }
}
