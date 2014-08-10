package searching_sorting;
import java.util.Scanner;
import utility.ArrayUtil;
public class BinarySearcherTester {

	public static void main(String[] args) {
		ArrayUtil au=new ArrayUtil();
		Scanner in=new Scanner(System.in);
		int[] i=au.randomIntArray(100, 100);
		QuickSort qs=new QuickSort(i);
		qs.sort(0, 99);
		au.print(i);
		BinarySearcher bs=new BinarySearcher(i);
		System.out.println("Type what number you would like to search.");
		int n=in.nextInt();
		System.out.print(bs.search(n));
	}
}
