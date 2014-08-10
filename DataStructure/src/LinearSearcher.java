
public class LinearSearcher {
public LinearSearcher(int[] anArray){
	a=anArray;
}
public int search(int v){
	for(int i=0;i<a.length;i++){
		if(a[i]==v)
			return i;
	}
	return -1;
	}
private int[] a;
}
