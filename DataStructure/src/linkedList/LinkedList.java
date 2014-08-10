package linkedList;
import java.util.NoSuchElementException;

public class LinkedList {
	private class Node{
		public Object data;
		public Node next;
	}
	public LinkedList(){
		first=null;
	}
	public Object getFirst(){
		if(first==null)
			throw new NoSuchElementException();
		return first.data;
	}//data type-node-private.
	private Node first;
	
	public void addFirst(Object obj){
		Node newNode=new Node();//step 1
		newNode.data=obj;
		newNode.next=first;//step 2
		first=newNode;
	}
	public Object removeFirst(){
		if(first==null)
			throw new NoSuchElementException();
		Object obj=first.data;
		first=first.next;
		return obj;
	}
public LinkedListIterator listIterator(){
	return new LinkedListIterator();
}
class LinkedListIterator implements ListIteratorInterface{
	public LinkedListIterator(){
		position=null;
		previous=null;
	}
	private Node position;
	private Node previous;
	public Object Objectnext(){
		if(!hasNext())
			throw new NoSuchElementException();
		previous=position;
		if(position==null)
			position=first;
		else 
			position=position.next;
		return position.data;
	}
	public boolean hasNext(){
		if(position==null)
			return first!=null;
		else
			return position.next!=null;
	}
	public void remove(){
		if (previous==position)
			throw new IllegalStateException();
		if(position==first){
			removeFirst();
		}
		else{
			previous.next=position.next;
		}
		position=previous; 
	}
	public void set(Object obj){
		if(position==null)
			throw new NoSuchElementException();
		position.data=obj;
		}
	public void add(Object obj){
		if(position==null){
			addFirst(obj);
			position=first;
		}
		else{
			Node newNode=new Node();
			newNode.data=obj;
			newNode.next=position.next;
			position=newNode;
		}
		previous=position;
	}
	public boolean hasPrevious() {
		return false;
	}
	@Override
	public Object next() {
		return null;
	}
	
	
	
	}
}

