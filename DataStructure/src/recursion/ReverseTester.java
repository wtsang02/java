package recursion;
import java.util.Scanner;
public class ReverseTester {
public static void main(String args[]){
	Scanner in=new Scanner(System.in);
	String sentence=in.nextLine();
	Reverse r=new Reverse(sentence);
	r.splitSentence();
	r.reverse();
	}
}
