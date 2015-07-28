package net.Unittest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTestSquare {
	private static Calculator cal = new Calculator();
	private int param;
	private int result;
	
	public CalculatorTestSquare(int param, int result){
		this.param = param;
		this.result = result;
	}
	
//	@Before
//	public void setUp() throws Exception {
//	}
	
	@Parameters
	public static List<Object[]> GetData() {
		return Arrays.asList(new Object[][] {
				{2,4},
				{0,0},
				{-3,9},
		});
	}
	@Test
	public void test() {
//		fail("Not yet implemented");
		cal.square(param);
		assertEquals(result, cal.getResult());
	}

}
