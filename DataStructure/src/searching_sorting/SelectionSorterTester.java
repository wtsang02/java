package searching_sorting;
import utility.ArrayUtil;
public class SelectionSorterTester {
public static void main(String[]args){
	int[] a=ArrayUtil.randomIntArray(20,100);
	SelectionSorter sorter=new SelectionSorter(a);
	sorter.sort();
	ArrayUtil.print(a);

	
	}
}
