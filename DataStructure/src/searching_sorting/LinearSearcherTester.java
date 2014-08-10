package searching_sorting;

import java.util.Scanner;

import utility.ArrayUtil;
public class LinearSearcherTester {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[] a=ArrayUtil.randomIntArray(20,100);
		ArrayUtil.print(a);
		LinearSearcher searcher=new LinearSearcher(a);
		boolean done=false;
		while(!done){
			System.out.println("enter number to search for,-1 to quit:");
			int i=in.nextInt();
			if(i==-1)
				done=true;
			else{
				int pos=searcher.search(i);
				System.out.println("Found in psotion"+pos);
			
			}
		}
	}
}
