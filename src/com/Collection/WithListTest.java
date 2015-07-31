package com.Collection;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class WithListTest {
	

	@Test
	public void test() {
		List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4));
		List<Integer> output = new ArrayList<>(Arrays.asList(4,3,2,1));
		WithList.reverse(input);
		for (int i=0;i<input.size();i++)
			assertEquals(output.get(i), input.get(i) );
	}
	@Test
	public void test2() {
		List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> output = new ArrayList<>(Arrays.asList(3,2,1));
		WithList.reverse(input);
		for (int i=0;i<input.size();i++)
			assertEquals(output.get(i), input.get(i) );
	}
	
	@Test
	public void test3() {
		List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> output = new ArrayList<>(Arrays.asList(3,2,1));
		WithList.reverse(input);
		
			assertEquals(input, output );
	}
}
