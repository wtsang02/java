
public class Assign4 {

	/**
	 		CSCI185  Programming Assignment 4
		 
		Write a recursive definition for the following methods and test the methods
		1.      Compute the sume of n integers
		         sumNIntegers(n) = 1 + 2 + 3 + ... + (n-1) + n  (n >=1)
		·         Test it with sumNIntegers(100)
		2.      Compute the sum of n even integers
		               sumEven(n) = 2 + 4 + 6 + 8 + 10 + … +  2*(n-1) + 2*n  (n >=1)
		·         Test it with sumEven(100)
		3.      Compute the sum of n odd integers
		               sumOdd(n) = 1 + 3 + 5 + 7 + 9 + … + [2*(n-1) - 1] + [2*n -1]  (n >=1)
		·         Test it with sumOdd(100)
	 */
	
	public static void main(String[] args) {
		RecursiveHelper helper=new RecursiveHelper();
		System.out.println(helper.sumNIntegers(100));
		helper.reset(); // make the field zero again for next calculation.
		
		System.out.println(helper.sumEven(5));
		helper.reset();
		
		System.out.println(helper.sumOdd(5));
		helper.reset();
	
	}

}
