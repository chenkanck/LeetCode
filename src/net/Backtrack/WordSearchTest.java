package net.Backtrack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {
	private static WordSearch ws = new WordSearch();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		char[][] board = {"ABCE".toCharArray(),"SFES".toCharArray(),"ADEE".toCharArray()};
		String s = "ABCESEEEFS";
		boolean ret = ws.exist(board, s);
		assertEquals(ret, true);
	}

}
