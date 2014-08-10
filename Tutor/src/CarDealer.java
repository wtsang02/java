import java.util.Scanner;

public class CarDealer {
	// Using array to store the inv
	private Car[] carInv;
	private int currentYear;//this is the year variable to calculate current value of a car.
	private int index;//This is the position that the cars are filled upto, and cannot go over MAX_NUMBER_OF_CARS

	/**
	 * Please develop a car dealer inventory software to record the car dealer's
	 * used car inventory. The java code should be objective oriented type. It
	 * should record each car's lot number, model, product year, the purchase
	 * value and the current value. Your code need to use array to store the car
	 * inventory. The user will be allow to input the actual number of cars and
	 * should be able to get the total current value of the whole inventory
	 * after user indicated years.The car's current value will be depreciated
	 * 10% every year. The user should also be able to remove car from the
	 * inventory or modify the information of each cars. You need submit a
	 * report to describe the main class and blueprint class. You need use UML
	 * language to draw the structure of the blueprint class.
	 * 
	 *  Md.Akib Ali Sardar
	 * DEC 6 2012
	 */
	
	public static void main(String[] args) {
		// Constants
		int MAX_NUMBER_OF_CARS = 100;
		int CURRENT_YEAR = 2012;

		// Creates the CarDealer object with the constants.
		CarDealer cd = new CarDealer(MAX_NUMBER_OF_CARS, CURRENT_YEAR);

		// Create SCanner object
		Scanner in = new Scanner(System.in);
		// Show user the menu.
		cd.printMenu();
		// Get the first input.
		String input = in.next();
		// As long as user doesn't type 0.
		while (!input.equals("0")) {
			//add car option
			if (input.equals("1")) {
				cd.addCar(in);
				cd.showDetails();
				//remove car option
			} else if (input.equals("2")) {
				System.out.println("Enter index of the car ");
				int position = in.nextInt();
				cd.removeCar(position);
				cd.showDetails();
				//show car info option
			} else if (input.equals("3")) {
				System.out.println("Enter index of the car ");
				int position = in.nextInt();
				cd.getCarInfo(position);
				//edit car info option
			} else if (input.equals("4")) {
				System.out.println("Enter index of the car ");
				int position = in.nextInt();
				cd.editCarInfo(position, in);
				//if it matches none of above.
			} else {
				System.out.println("Wrong input. Try again.");
			}
			//Show menu and get input again.
			cd.printMenu();
			input = in.next();

		}// END Main menu loop
		System.out.println("\n Application is exiting.");
	}

	public CarDealer(int maxNumberOfCars, int year) {
		currentYear = year;
		carInv = new Car[maxNumberOfCars];
		index = 0;
	}

	// Prints the menu , \n is new line.
	public void printMenu() {
		System.out.println("Main menu of Car Dealer Inv \n BY Md.Akib Ali Sardar \n");
		System.out.println("Type in a number \n" + "1)Input Cars \n"
				+ "2)Remove Cars \n" + "3)Get a Car information \n"
				+ "4)Modify a car's infomation \n" + "0)Exit program.");
	}

	public void addCar(Scanner in) {
		// creates a empty car with no deails
		Car temp = new Car();
		System.out.println("Adding a car, please enter infomation.");

		// ask user to fill in the details.

		temp.setLotNumber(index);
		in.nextLine();//consume the return
		System.out.println("Model");
		temp.setModel(in.nextLine());
		System.out.println("product year");
		temp.setProductYear(in.nextInt());
		System.out.println("Purchase Value");
		temp.setPurchaseValue(in.nextDouble());
		System.out.println("Car added to index: "+index);

		//store the car in the array.
		carInv[index] = temp;
		index++;
	}
//Prints out the details of the car dealer inv. and the total values.
	public void showDetails() {
		System.out.println("Detail Information of this Inv");
		System.out.println("There are " + index + " out of " + carInv.length
				+ " max we can hold");
		double totalValue = 0;
		for (int i = 0; i != index; i++) {
			totalValue += carInv[i].getCurrentValue(currentYear);
		}
		System.out.println("Total value is " + totalValue);

	}

	// This method removes a car and creates a new array given its position.
	public void removeCar(int position) {
		if (position < index) {
			// make a new array with same car.
			Car[] newInv = new Car[carInv.length];
			int j = 0;
			for (int i = 0; i < newInv.length; i++) {
				// if i is the position, it will not be added to the new array.
				if (i == position) {
					i--;//i is the position of the new array, we need to fill it because we went in this loop.
					index--;//-1 from the index so we know that we have one less car.
					position = -1;//Don't need this position anymore

				} else {
					if(carInv[j]==null){//if at j position of hte old list is null,
						//it means we are done and no longer need to finish the arry.
						break;
					}
					newInv[i] = carInv[j];//putting the old list to the new list. except the removed one.
				}
				j++;

			}
			carInv = newInv;
		} //end if
		else {
			System.out.println("That index doesn't exisit.");
		}

	}


//Prints a car info given the position.
	public void getCarInfo(int position) {

		if (position < index) {
			carInv[position].print(currentYear);
		} else {
			System.out.println("That index doesn't exisit.");
		}
	}
	
//edits a car info given position.
	public void editCarInfo(int position, Scanner in) {
		if (position < index) {
			System.out.println("Current car info: ");
			carInv[position].print(currentYear);
			
			switch (editMenu(in)) {
			case 1:
				System.out.println("Please enter new Model");
				in.nextLine();//consume the return
				carInv[position].setModel(in.nextLine());
				carInv[position].print(currentYear);
				break;
			case 2:
				System.out.println("Please enter new lot number");
				carInv[position].setLotNumber(in.nextInt());
				carInv[position].print(currentYear);
				break;
			case 3:
				System.out.println("Please enter new product year");
				carInv[position].setProductYear(in.nextInt());
				carInv[position].print(currentYear);
				break;
			case 4:
				System.out.println("Please enter new purchase price");
				carInv[position].setPurchaseValue(in.nextDouble());
				carInv[position].print(currentYear);
				break;
			case 0:
				System.out.println("Nothing changed. Exiting to main menu.");
				break;
			default:
				System.out.println("Wrong input, exiting to main menu.");

			}

		} else {
			System.out.println("That index doesn't exisit.");
		}

	}
//prints the edit menu.
	private int editMenu(Scanner in) {
		System.out.println("Type in a number \n " + "1)Edit model \n"
				+ "2)Edit lot number \n" + "3)Edit product year \n"
				+ "4)Edit purchase price \n" + "0)Exit to Main Menu. \n\n");
		return in.nextInt();
	}

}
