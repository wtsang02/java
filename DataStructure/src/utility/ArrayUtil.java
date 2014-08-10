package utility;
import java.util.Random;
public class ArrayUtil {
	
	private static Random generator= new Random();
	
	public static int[] randomIntArray(int length,int n){
		int[] a=new int[length];
		for(int i=0;i<a.length;i++)
			a[i]=generator.nextInt(n);
			return a;
	}
	
	public static void print(int[]a){
		for(int e:a)
			System.out.print(e+" ");
		System.out.println();
	}
	public static void checkRange(int i){
		if(i>5000000){
			System.out.print("Too long");
			System.exit(0);
		}
		else return;
	}
	
		
	}

