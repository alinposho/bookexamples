package javaconcurrency;

import static org.junit.Assert.*;

import org.junit.Test;

public class BooleanTest {

	@SuppressWarnings("null")
	@Test(expected=NullPointerException.class)
	public void should_raise_exception_when_comparing_null_Boolean_instances() {
		Boolean a = null;
		Boolean b = false;
		
		assertTrue(a && b);
	}
	
	
}
