import java.util.Scanner;
public class QuickSortTester {
	public static void main(String args[]){
	Scanner in=new Scanner(System.in);
	System.out.print("Enter array length:  ");
	int n=in.nextInt();
	ArrayUtil au=new ArrayUtil();
	int[] a=au.randomIntArray(n, 100);
	QuickSort qs=new QuickSort(a);
	StopWatch timer=new StopWatch();
	timer.start();
	qs.sort(0,n-1);
	timer.stop();
	au.print(a);
	}
}
