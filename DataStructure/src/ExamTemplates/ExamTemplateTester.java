package ExamTemplates;
import utility.ArrayUtil;
import java.util.ArrayList;
import java.util.Arrays;

public class ExamTemplateTester {
	static int n=0;
	public static void main(String[] args) {
		ArrayUtil array=new ArrayUtil();
		int[] arrayInt;
		arrayInt=array.randomIntArray(20, 20);
		ArrayList arr=new ArrayList(Arrays.asList(arrayInt));
		for(int i=0; i<arr.size()-1; i++){
			if(arr.get(i).equals(arr.get(i+1))){
				arr.remove(i);
			}
		}
		for(Object i:arr){
			System.out.print(arr.get(n));
			n++;
		}
		
		
	}
	




	}
