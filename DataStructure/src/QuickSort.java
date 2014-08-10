public class QuickSort{
	public QuickSort(int[] anArray){
		a=anArray;
	}
public void sort(int from,int to){
	if(from>=to) 
		return;
	int p=partition(from,to);
	sort(p+1,to);
	sort(from,p);
	}
private int partition(int from,int to)throws ArrayIndexOutOfBoundsException{
	int pivot=a[from];
	int j=to+1;
	int i=from-1;
	try{
		while(i<j){
			i++;
			while(a[i]<pivot)i++;
			j--;
			while(a[j]>pivot)j--;
			if(i<j)	swap(i,j);
		}
		return j;
	}
	catch (ArrayIndexOutOfBoundsException e){
		System.out.println(e);
		return j;
	}
}

private void swap(int i,int j){
	int temp=a[i];
	a[i]=a[j];
	a[j]=temp;
}
private int[] a;
}