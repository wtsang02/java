
public class MergeSortTester {


	public static void main(String[] args) {
		int[] a=ArrayUtil.randomIntArray(8, 10);
		ArrayUtil.print(a);
		MergeSort sorter=new MergeSort(a);
		sorter.sort();
		ArrayUtil.print(a);
	}

}
