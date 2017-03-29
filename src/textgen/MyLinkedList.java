package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head=null;
		tail=null;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		
		if (head == null)
			{head = new LLNode<E>(element);
		    tail = head;
		    size++;
		    return true;
			}
		LLNode<E> temp = head;
		while(temp.next!=null)
			 temp = temp.next;
		tail = new LLNode<E>(element,temp);
		size++;
		return true;
		

			}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index<0 || index>=this.size())
			throw new IndexOutOfBoundsException();
		LLNode<E> temp= head;
		 for (int i = 1;i<=index;i++)
			 temp = temp.next;
		
		return temp.data ;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(element==null)
			throw new NullPointerException();
		if(size==0){
			head = new LLNode<E>(element);
			tail= head;
			size++;
		}
		else{
			 LLNode<E> temp = head;
			if(index==0){
				head = new LLNode<E>(element);
			    head.next = temp;
			    temp.prev = head;
			    size++;
			    return;
			}
			LLNode<E> previous = null;
			for(int i=1;i<=index;i++){
				previous = temp;
				temp = temp.next;
			}
			if(temp==null)
				tail = new LLNode<E>(element,previous);
			else
				temp.prev = new LLNode<E>(element,previous);
			size++;	
			
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		int count = 0;
		LLNode<E> temp=head;
		while(temp!=null)
		{  count++;
			temp = temp.next;
		}
		return count;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index<0 || index>=this.size())
			throw new IndexOutOfBoundsException();
		LLNode<E> temp = head,previous=null;
		if(index==0){
			
			head = head.next;
			if(size!=1)
			 head.prev = null;
			if(index==size-1)
			  tail=head;
			temp.next=null;
			size--;			
			return temp.data;
		}
		for(int i =1;i<=index;i++){
			 previous = temp;
			temp=temp.next;
		}
		
		previous.next=temp.next;
		if(index==size-1)
			tail = previous;
		if(index!=size-1)
		    temp.next.prev=previous;
		 temp.next=null;
		size--;
		
		return temp.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index<0 || index>=this.size())
			throw new IndexOutOfBoundsException();
		if(element == null)
			throw new NullPointerException();
		
		LLNode<E> temp =head;
		for(int i=1;i<=index; i++)
			temp = temp.next;
		E val = temp.data;
		temp.data = element;
		return val;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	public LLNode(E e,LLNode<E> previous) 
	{
		this.data = e;
		this.next=previous.next ;
		previous.next = this;
		this.prev=previous;
	}

}
