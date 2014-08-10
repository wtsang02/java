package searching_sorting;
import java.util.Scanner;
import utility.StopWatch;

import utility.ArrayUtil;
public class SelectionSortTime {
	public static void main(String[]args){
		Scanner in=new Scanner(System.in);
		System.out.print("Enter array size: ");
		int n=in.nextInt();
		int[]a=ArrayUtil.randomIntArray(n,100);
		SelectionSorter sorter=new SelectionSorter(a);
		StopWatch timer=new StopWatch();
		timer.start();
		sorter.sort();
		timer.stop();
		}
}
