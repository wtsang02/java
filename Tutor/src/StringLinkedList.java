
//ListNode -> Node
//head -> first
//link -> next

public class StringLinkedList {
	private Node first;

	public StringLinkedList() {
		first = null;//initlize
	}
//inner class for a node.
	public class Node {
		public String data;//data that will be stored
		public Node next;//reference to the next elment.

		//constructor for the node.
		public Node(String newData, Node linkValue) {
			data = newData;
			next = linkValue;
		}

		//getters and setters.
		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	//returns the first node.
	public Node getFirst() {
		return first;
	}

	//prints out the list by looping throught
	public void showList() {
		Node position = first; //
		while (position != null) {
			System.out.println(position.getData());
			position = position.getNext(); //
		}
	}

	//get the lenght of the list.
	public int length() {
		int count = 0;
		Node position = first; //starts from first
		while (position != null) { //check if node is null
			count++; //increments 
			position = position.getNext(); //sets node to the next one.
		}
		return count;//returns lenght.
	}

	//adds a node the head of the list
	public void addANodeToStart(String addData) {
		first = new Node(addData, first);//creates a new node with the data
	}
    //deletes the first node.                                   
	public void deleteHeadNode() {
		if (first != null)//cheks if first exsits.
			first = first.getNext(); //pushes the current first to its next.
		else {//exit if its a empty list.
			System.out.println("Deleting from an empty list.");
			System.exit(0);
		}
	}

	/*
	 * Returns a reference to the first node containing the target data. If
	 * target is not on the list, returns null.
	 */
	private Node find(String target) {
		boolean found = false; //
		Node position = first;
		while ((position != null) && !found) { //
			String dataAtPosition = position.getData();
			if (dataAtPosition.equals(target))
				found = true;
			else
				position = position.getNext(); //
		}
		return position;
	}
	//checks if this list contains target.
	public boolean onList(String target) {
		return find(target) != null;
	}

}
