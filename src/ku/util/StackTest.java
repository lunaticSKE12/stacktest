package ku.util;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
	private Stack stack;

	/** "Before" method is run before each test. */
	@Before
	public void setUp(){
		//set stack type 0 or 1
		StackFactory.setStackType( 1 ) ;
		stack = StackFactory.makeStack( 2 );
	}

	@Test
	public void newStackIsEmpty() {
		assertTrue( stack.isEmpty() );
		assertFalse( stack.isFull() );
		assertEquals( 0, stack.size() );
	}
	
	/** pop() should throw an exception if stack is empty */
	@Test( expected = java.util.EmptyStackException.class )
	public void testPopEmptyStack() {
		Assume.assumeTrue( stack.isEmpty() );
		stack.pop();
		// this is unnecessary. For documentation only.
		fail("Pop empty stack should throw exception");
	}

	@Test
	public void testPeek(){
		stack.push("a");
		stack.push("s");
		assertEquals( "s", stack.peek() );
		assertEquals( 2, stack.size() );
	}
	
	@Test
	public void testPop(){
		stack.push("a");
		stack.push("s");
		assertEquals( "s", stack.pop() );
		assertEquals( 1, stack.size() );
	}
	
	@Test
	public void testSize(){
		stack.push("a");
		assertEquals(1, stack.size());
		stack.push("s");
		assertEquals(2, stack.size());
		stack.pop();
		assertEquals(1, stack.size());
	}
	
	@Test
	public void testCapacity(){
		assertEquals( 2, stack.capacity() );
	}
	
	@Test( expected = java.util.EmptyStackException.class )
	public void testOverflow(){
		stack.push("a");
		stack.push("s");
		stack.push("d");
		
		
	}
	
	@Test( expected=IllegalArgumentException.class )
	public void testPushNull(){
		stack.push(null);
	}
	
	@Test
	public void TestIsFull(){
		stack.push("a");
		stack.push("s");
		assertTrue(stack.isFull());
		assertEquals(stack.size(),stack.capacity());
	}
		
	@Test
	public void testPeekAndPop(){
		stack = StackFactory.makeStack( 3 );
		stack.push("a");
		assertEquals( "a", stack.peek() );
		stack.push("s");
		stack.push("d");
		assertEquals("d",stack.pop());
		assertEquals(2,stack.size());
		assertEquals("s",stack.peek());
		assertEquals(2,stack.size());
		assertEquals("s",stack.pop());
		assertEquals("a",stack.peek());
		
	}
	
}
