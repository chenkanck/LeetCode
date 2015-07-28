package net.Unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	private static Calculator cal = new Calculator();
	@Before
	public void setUp() throws Exception {
		cal.clear();
	}

	@Test
	public void testAdd() {
		cal.add(2);
		cal.add(3);
		assertEquals(5, cal.getResult());
//		fail("Not yet implemented");
	}

	@Test
	public void testSubstract() {
		cal.add(10);
		cal.substract(2);
		assertEquals(8,cal.getResult());
//		fail("Not yet implemented");
	}

	@Ignore("Mutiply is not implemented")
	@Test
	public void testMultiply() {
//		fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		cal.add(8);
		cal.divide(2);
		assertEquals(4,cal.getResult());
//		fail("Not yet implemented");
	}

}
