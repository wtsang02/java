package searching_sorting;

public class BinarySearcher {
	public BinarySearcher(int[] anArray){
		a=anArray;
	}
public int search(int v){
	int low=0;
	int high=a.length-1;
	while(low<=high){
		int mid=(low+high)/2;
		int diff=a[mid]-v;
		if(diff==0)
			return mid;
		else if(diff<0)low=mid+1;
		else
			high=mid-1;
	}
	
	
	return -1;
}
private int[] a;
}
