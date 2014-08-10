package searching_sorting;

public class InsertionSort {
	public InsertionSort(int[] anArray){
	a=anArray;
	
}
	public void sort(){
		for(int i=1;i<a.length;i++){
			int next=a[i];
			int j=i;
			while (j>0&&a[j-1]>next){
				a[j]=a[j-1];
				j--;
				
			}
		}
	}
	private int a[];
}
