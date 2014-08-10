

import java.util.Scanner;

public class PetDemo 
{
    public static void main(String[] args)
    {
    	Scanner in=new Scanner(System.in);
    	
    	double totalWeight=0;
    	int numOfpet=0;
    	double weight=in.nextDouble();
        Pet casey = new Pet("Casey", numOfpet, weight);
        casey.writeOutput();
      
        totalWeight+=weight;
        numOfpet++;
    
        weight=in.nextDouble();
        Pet rex = new Pet("Rex", 3, weight);
        rex.writeOutput();
        totalWeight+=weight;
        numOfpet++;
        
        /*
        Pet balto = new Pet("Balto", 9, 24.2);
        balto.writeOutput();
        
        Pet tiny = new Pet("Tiny", 1, 6.8);
        tiny.writeOutput();
        
        Pet rover = new Pet("Rover", 4, 43.7);
        rover.writeOutput();
      
        */
        double avgWeight=totalWeight/numOfpet;
    }  
}
