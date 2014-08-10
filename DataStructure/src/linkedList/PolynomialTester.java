package linkedList;

import java.util.LinkedList;
import java.util.ListIterator;


import linkedList.LinkedList.LinkedListIterator;




public class PolynomialTester {

	public static void main(String[] args) {
		LinkedList<Polynomial> list=new LinkedList<Polynomial>();
		ListIterator<Polynomial> iterator=list.listIterator();
		Polynomial a=new Polynomial(5,10);
		Polynomial b=new Polynomial(9, 7);
		Polynomial c=new Polynomial(-1, 1);
		Polynomial d=new Polynomial(-10, 0);
		list.addLast(a);
		list.addLast(b);
		list.addLast(c);
		list.addLast(d);

		System.out.println(list.getFirst());

	}

}
//(5, 10), (9, 7), (-1, 1), (-10, 0)