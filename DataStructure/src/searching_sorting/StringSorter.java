package searching_sorting;
import utility.RandomStringRL;

public class StringSorter {
	public StringSorter(int aNumber){
		number=aNumber;
	}
	public String createString(){
		RandomStringRL rs=new RandomStringRL();
		return rs.getString();
}
	public void storeStrings(){
		String[] temp=new String[number];
		for(int i=0;i<number;i++)
			temp[i]=createString();
		a=temp;
		}
	public void sort(){
		sorting(0,a.length-1);
		place++;
		if(place==4){
			return;
		}
	}
	public void sorting(int from,int to){
		if(from>=to) 
			return;
		int p=partition(from,to);
		sorting(p+1,to);
		sorting(from,p);
		}
		private int partition(int from,int to){
			String pivot=a[from];
			int ipivot=pivot.charAt(0);
			int j=to+1;
			int i=from-1;
			while(i<j){
				i++;
				while(a[i].charAt(place)<ipivot)
					i++;
				j--;
				while(a[j].charAt(place)>ipivot)
					j--;
				if(i<j)	
					swap(i,j);
			}
			return j;
			
		}
		private void swap(int i,int j){
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
		public void print(){
			for(String e:a)
				System.out.println(e);
		}
		private String[] a;
		private int number;
		private int place=0;
}
