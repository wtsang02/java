package linkedList;
import java.util.LinkedList;
import java.util.ListIterator;
public class LinkedListDemoTester {

	public static void main(String[] args) {
		LinkedList<String> staff=new LinkedList<String>();
		staff.addLast("Dick");
		staff.addLast("Harry");
		staff.addLast("Romeo");
		staff.addLast("Tom");
		ListIterator<String> iterator=staff.listIterator();
		iterator.next();
		iterator.next();
		iterator.add("Juliet");
		iterator.add("Nina");
		iterator.next();
		iterator.remove();
		for(String name:staff)
			System.out.println(name);

	}

}
