package utility;

import java.util.Random;

public class Numbers {

	public static void main(String[] args) throws InterruptedException {

		int[] anArray = ArrayUtil.randomIntArray(10000, 999999);

		int i = 0;
		for (i = 0; i < 10000; i++) {
			System.out.print(anArray[i]);
			int temp=i+generator.nextInt(10);
			int temp2=i+generator.nextInt(10);
			int temp3=i+generator.nextInt(10);
			int temp4=i+generator.nextInt(10);
			int temp5=i+generator.nextInt(10);
			int temp6=i+generator.nextInt(10);
			int temp7=i+generator.nextInt(10);
			int temp8=i+generator.nextInt(10);
			System.out.print(anArray[temp5]);
			System.out.print(anArray[temp6]);
			System.out.print(anArray[temp7]);
			System.out.print(anArray[temp8]);
			
			System.out.print(anArray[temp3]);
			System.out.print(anArray[temp4]);
			System.out.print(anArray[temp2]);
			System.out.println(anArray[temp]);
			Thread.sleep(400);

		}
	}
	private static Random generator= new Random();
}
