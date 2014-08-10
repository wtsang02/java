package recursion;
import java.util.Scanner;
public class FractionalTester {
public static void main(String[]args){
	Scanner in=new Scanner(System.in);
	System.out.print("Enter Fractional number");
	int n=in.nextInt();
	Fractional f=new Fractional(n);
	f.getFractional();
	System.out.println("Your number's fractorial is:  "+f.returnAnswer());
	}
}
