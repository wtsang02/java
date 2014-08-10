package searching_sorting;
import utility.ArrayUtil;

public class MergeSort {
	public MergeSort(int[] anArray){
		a=anArray;
	}
	public void sort(){
		if(a.length<=1)return;
		int[] first=new int[a.length/2];
		int[] second=new int[a.length-first.length];
		System.arraycopy(a, 0, first, 0, first.length);
		System.arraycopy(a, first.length, second, 0, second.length);
		MergeSort firstSorter=new MergeSort(first);
		MergeSort secondSorter=new MergeSort(second);
		firstSorter.sort();
		secondSorter.sort();
		
		merge(first,second);
		ArrayUtil.print(a);
	}
	private void merge(int[] first,int[] second){
		int iFirst=0;
		int iSecond=0;
		int j=0;
		while(iFirst<first.length&&iSecond<second.length){
			if(first[iFirst]<second[iSecond]){
				a[j]=first[iFirst];
				iFirst++;
			}
			else{
				a[j]=second[iSecond];
				iSecond++;
			}
			j++;
		}
		System.arraycopy(first, iFirst, a, j, first.length-iFirst);
		System.arraycopy(second,iSecond,a,j,second.length-iSecond);
	}
	private int[] a;
}
