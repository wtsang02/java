public class RecursiveHelper {

	public RecursiveHelper() {
		sum = 0;
	}

	private int sum;
	private int evenModifier=0;
	private int oddModifier=-1;
	
	public int sumNIntegers(int n) {
		sum += n;// addes to sum
		if (n == 0) {// if n=0 , its finish calculating
			return sum;// return when finished
		}
		sumNIntegers(n - 1);// -1 to n , so it calculates the next number

		/*
		 * return sum; This will be excuted but the value is not stored. if the
		 * code befoer this was like int i=sumNIntegers(n-1); then the returned
		 * value will be i, but we don't need that value. we are only intrested
		 * in the final answer which will be returned by if(n==0)return sum;
		 */
		return sum;

	}

	public int sumEven(int n) {
		
		
		if (n <= 0) {//if n is <=0 , calc finished, return sum.
			return sum;
		}
		evenModifier+=2;
		sum +=evenModifier;  //add to sum;
		sumEven(n-1);// go to next.
		
		return sum;
		
		
	}

	public int sumOdd(int n) {
		

		if (n <= 0) { 
			return sum;
		}
		oddModifier+=2;
		sum += oddModifier;
		sumOdd(n-1);
		return sum;
		
	}

	public void reset() {
		sum = 0;
	}

}
