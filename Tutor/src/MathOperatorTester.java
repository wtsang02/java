import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MathOperatorTester {

	/**
	 * This program solves 3+4 2-5 24*32 ...
	 * 
	 * @param args
	 */

	
	//DEFINE CONSTANTS.
	private static String[] OPERATORS = new String[] { "+", "-", "*", "/" };
	//DEFINE THESE VARIABLES AS INTEGERS.
	private static final int plus = 0;
	private static final int minus = 1;
	private static final int times = 2;
	private static final int devide = 3;

	public static void main(String[] args) {
		// Make your own StudentGrades.txt with the given format first.
		File sourceFile = new File("Math.txt");

		// Scanner to read your file
		Scanner in = null;
		try {
			in = new Scanner(sourceFile);// refer it to your source file.
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		//check if scanner has next or not done.
		while (in.hasNext()) {
			int first = in.nextInt();//get the first number
			String operator = in.next();//operator
			int second = in.nextInt();//second number
			double result = 0;//init results
			switch (getOperator(operator)) {//retrive a int value of the operator. getOperator is defined
			//in the bottom.
			
			//these contants are actucally numbers(0-3).
			case plus:
				result = first + second;
				break;
			case minus:
				result = first - second;

				break;
			case times:
				result = (double)first * second;//cast to double first if you want decimals
				break;
			case devide:
				if (second != 0) {
					result = (double)first / second;
				} else {
					// second can't be zero.
				}
				break;
			default:
				// s.o.p program fail.
				
			}
			
			System.out.println(first+ operator+second+" will give you "+result);
		}

	}
//given the operator, it will return 0-3.
	private static int getOperator(String sign) {

		for (int i = 0; i < OPERATORS.length; i++) {
			if (sign.equals(OPERATORS[i])) {
				return i;

			}
		}
		return -1;// Program fails.
	}

}
