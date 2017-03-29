/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{   try {
		emptyList.remove(2);
		fail("Check out of bounds");
	     }
	     catch (IndexOutOfBoundsException e) {
		
	      }
	try {
		emptyList.remove(-1);
		fail("Check out of bounds");
	     }
	     catch (IndexOutOfBoundsException e) {
		
	      }
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		assertEquals("Check previous of first node ",null,list1.head.prev);
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try{
			emptyList.add(null);
			fail("Null Entry");
		}
		catch(NullPointerException e){
			
		}
	
		assertEquals("check first add",true,emptyList.add(5));
		assertEquals("end element",(Integer)5,emptyList.get(0));
		assertEquals("end element",1,emptyList.size());
		
		
		emptyList.remove(0);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("check empty list size",0,emptyList.size());
		assertEquals("check longerList size",10,longerList.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try{
			emptyList.add(0,null);
			fail("null element added");
		}
		catch(NullPointerException e){
			
		}
		try{
			emptyList.add(2,5);
			fail("index out of bouds");
		}
        catch(IndexOutOfBoundsException e){
			
		}
		try{
			emptyList.add(-1,5);
			fail("index out of bouds");
		}
        catch(IndexOutOfBoundsException e){
			
		}
		emptyList.add(0,5);
		assertEquals("check element added at startIndex",(Integer)5,emptyList.get(0));
		assertEquals("check size updation",1,emptyList.size);
		//assertEquals("tail is not updated",emptyList.tail,emptyList.head);
		emptyList.remove(0);
		//list1.add(0,65);
		list1.add(list1.size,20);
		assertEquals("check add at begining",(Integer)65,list1.get(0));
		assertEquals("check add at last",(Integer)20,list1.get(3));
		assertEquals("check add at mid",(Integer)21,list1.get(1));
		assertEquals("check size updation",4,list1.size);
		
		list1.remove(3);
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try{
			list1.set(0,null);
			fail("null element added");
		}
		catch(NullPointerException e){
			
		}
		try{
			emptyList.set(2,5);
			fail("index out of bouds");
		}
        catch(IndexOutOfBoundsException e){
			
		}
		try{
			emptyList.set(-1,5);
			fail("index out of bouds");
		}
        catch(IndexOutOfBoundsException e){
			
		}
		int a = list1.set(0,25);
		assertEquals("check set at begining",(Integer)25,list1.get(0));
		assertEquals("check return of set ",65,a);
		list1.set(0,65);
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
