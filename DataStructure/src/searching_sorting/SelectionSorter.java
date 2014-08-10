package searching_sorting;

public class SelectionSorter {
	public SelectionSorter(int[] anArray){
		a=anArray;
		}
public void sort(){
	for(int i=0;i<a.length-1;i++){
		int minPos=minimumPosition(i);
		swap(minPos,i);
	}
}
private int minimumPosition(int from){
	int minpos=from;
	for(int i=from+1;i<a.length;i++)
		if(a[i]<a[minpos])minpos=i;
			return minpos;
	}//find smallest element in array

private void swap(int i,int j){
	int temp=a[i];
	a[i]=a[j];
	a[j]=temp;
}
private int[]a;
}

