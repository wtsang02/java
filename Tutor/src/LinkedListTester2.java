
public class LinkedListTester2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// constant
		String PROGII = "CSCI185";

		// Creates a Linkedlist.
		StringLinkedList courses = new StringLinkedList();

		// addANodeToStarts to the list
		courses.addANodeToStart("CSCI100");
		courses.addANodeToStart("CSCI111");
		courses.addANodeToStart("CSCI125");
		courses.addANodeToStart("CSCI137");
		courses.addANodeToStart("CSCI149");
		courses.addANodeToStart("CSCI156");
		courses.addANodeToStart("CSCI167");
		courses.addANodeToStart("CSCI173");
		courses.addANodeToStart("CSCI185");
		courses.addANodeToStart("CSCI192");

		// Check if list has something.
		if (courses.onList(PROGII)) {
			System.out.println("It has " + PROGII);

		} else {
			System.out.println("This list DOESN'T have " + PROGII);

		}

		// Show all in the list
		System.out.println("This list has :");
		courses.showList();

		// delete the first
		courses.deleteHeadNode();
		System.out
				.println("This list has (after removed first element in the list) :");

		// check if deleted.
		courses.showList();

	}

}
