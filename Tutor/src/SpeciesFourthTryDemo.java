
//code 2

public class SpeciesFourthTryDemo 
{
    public static void main(String[] args)
    {
      int numberOfYears=10;
      int weeks=numberOfYears*52;
      int months=numberOfYears*12;
      SpeciesFourthTry speciesOfTheMonth= new SpeciesFourthTry();
      /*
      System.out.println("Enter number of years to project:");
      Scanner keyboard = new Scanner (System.in); 
      int numberOfYears = keyboard.nextInt();
      System.out.println("Enter data on the Species of the Month:");
      
      speciesOfTheMonth.readInput();
      speciesOfTheMonth.writeOutput();
      int futurePopulation = speciesOfTheMonth.predictPopulation(numberOfYears);
      System.out.println("ln " + numberOfYears + " years the population will be"
              + " " + futurePopulation);
     */
      
      speciesOfTheMonth.setSpecies("rat", 10, 10);
      speciesOfTheMonth.setDeathRate(10);//10%
      System.out.println("The new Species of the Month:");
      speciesOfTheMonth.writeOutput();
      int futurePopulation= speciesOfTheMonth.predictPopulation(numberOfYears);
      System.out.println("ln " + numberOfYears + " years the population will be"
              + " " + futurePopulation);
    }
}
