package sets_maps;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class setTester {

	public static void main(String[] args) {
		Set<String>	names=new HashSet<String>();
		Scanner in=new Scanner(System.in);
		boolean done=false;
		while(!done){
			System.out.print("add name, q when done:");
			String input=in.next();
			if(input.equalsIgnoreCase("Q"))
				done=true;
			else{
				names.add(input);
				print(names);
			}
		}
		done=false;
		while(!done){
			System.out.println("Remove name, Q when done: ");
			String input=in.next();
			if(input.equalsIgnoreCase("Q"))
				done=true;
			else{
				names.remove(input);
				print(names);
			}
			
		
		}}
		private static void print(Set<String> s){
			System.out.print("{");
			for(String element:s){
				System.out.print(element);
			System.out.print(" ");
		}
		System.out.println("}");
		
		}
		
}


