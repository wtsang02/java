import java.util.LinkedList;


public class LinkedListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//constant
		String PROGII="CSCI185";
		
		//Creates a Linkedlist.
		LinkedList<String> courses=new LinkedList<String>();
		
		//Adds to the list
		courses.add("CSCI100");
		courses.add("CSCI111");
		courses.add("CSCI125");
		courses.add("CSCI137");
		courses.add("CSCI149");
		courses.add("CSCI156");
		courses.add("CSCI167");
		courses.add("CSCI173");
		courses.add("CSCI185");
		courses.add("CSCI192");
		
		
		//Check if list has something.
		if(courses.contains(PROGII)){
			System.out.println("It has "+PROGII);
			
		}else{
			System.out.println("This list DOESN'T have "+PROGII);
			
		}
		
		//Show all in the list
		System.out.println("This list has :");
		System.out.println(courses);
		
		//delete the first
		courses.remove();
		System.out.println("This list has (after removed first element in the list) :");
		
		//check if deleted.
		System.out.println(courses);
	}

}
