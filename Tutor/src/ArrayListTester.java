import java.util.ArrayList;

public class ArrayListTester {

	public static void main(String[] args) {
		//CONSTANT change this to any in the list.
		String NAME_TO_SEARCH = "Kevin";

		// ************************
		ArrayList<String> friends = new ArrayList<String>();
		friends.add("Susan");
		friends.add("James");
		friends.add("Kevin");
		friends.add(1, "Tanya");
		friends.add("John");

		if (search(NAME_TO_SEARCH, friends) == -1) {
			System.out.println("Cannot find " + NAME_TO_SEARCH
					+ " in this List");

		} else {
			System.out.println(NAME_TO_SEARCH + " is at position "
					+ search(NAME_TO_SEARCH, friends) + " of this ArrayList");
		}
		 System.out.println(friends);// This list prints the whole list.

		// *************************
	}

	public static int search(String Key, ArrayList<String> a) {
		int count = 0;
		String temp =(String) (a.get(count));
		while (count < a.size() && !temp.equals(Key)) {
		
			temp = (String) (a.get(count));
			if(temp.equals(Key)){//check if the element is what you are looking for.
				return count;
			}
			count++;
		}
		//if you cannot find the element in the arraylist.
			return -1;
	}

	/*The code below is the most effiecent way of doing this. You can see the produce the
	 * same results but more effiecnt code.
	 * 
	 * 
	 * public static int search(String key,ArrayList<String> list){
	 * 
	 * for(int i=0;i<list.size();i++){ if(list.get(i).equals(key)){ return i; }
	 * 
	 * } return -1; }
	 */
}
