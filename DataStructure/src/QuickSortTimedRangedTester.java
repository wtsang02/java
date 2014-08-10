import java.util.Scanner;	
public class QuickSortTimedRangedTester {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter array length:  ");
		int n=in.nextInt();
		ArrayUtil au=new ArrayUtil();
		au.checkRange(n);
		int[] a=au.randomIntArray(n, 100);
		QuickSort qs=new QuickSort(a);
		StopWatch timer=new StopWatch();
		System.out.print("Enter Sort Range From:  ");
		int m=in.nextInt();
		System.out.print("Enter Sort Range To:  ");
		int q=in.nextInt();
		timer.start();
		qs.sort(m,q-1);
		timer.stop();
		au.print(a);
		System.out.print("Time used: "+timer.getEleapsedTime()+" seconds in ascending order");

	}

}
