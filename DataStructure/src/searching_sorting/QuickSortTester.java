package searching_sorting;

import utility.ArrayUtil;

public class QuickSortTester {
	public static void main(String args[]) {
		int[] a = ArrayUtil.randomIntArray(99, 99);
		QuickSortV2 qs = new QuickSortV2(a);
		qs.quickSort(0, a.length-1);
		ArrayUtil.print(a);
	}
}
