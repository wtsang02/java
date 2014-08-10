package recursion;
import java.util.Scanner;
public class FibTester2{
public static void main(String[]args){
	Scanner in=new Scanner(System.in);
	System.out.print("Enter n:");
	int n=in.nextInt();
	for(int i=1;i<=n;i++){
		long f=fib(i);
		System.out.println("fib("+i+")="+f);
		}
	}
public static long fib(int n){
	System.out.println("Entering fib:n="+n);
	long f;
	if(n<=2) f=1;
	else 
		f=fib(n-1)+fib(n-2);
	System.out.println("Exiting fibs n="+n+"return value="+f);
	return f;
	}
}