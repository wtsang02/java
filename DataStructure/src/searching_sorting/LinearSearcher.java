package searching_sorting;

import java.util.ArrayList;

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
public int search(String key,ArrayList<String> list){
	
	for(int i=0;i<list.size();i++){
		if(list.get(i).equals(key)){
			return i;
		}
		
	}
	return -1;
}
	

private int[] a;
}
