package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	public TicTacToe t;
	@Before
	public void setup(){
		t = new TicTacToe();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				assertEquals(TicTacToe.Mark.EMPTY, t.getMark(row,col));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		t.setMark(0,2);
		assertEquals(TicTacToe.Mark.XMARK, t.getMark(0,2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		t.setMark(0,0);
		t.setMark(2,0);
		assertEquals(TicTacToe.Mark.OMARK, t.getMark(2,0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		t.setMark(0,1);
		TicTacToe.Mark markOne = t.getMark(0,1);
		t.setMark(0,1);
		assertEquals(markOne, t.getMark(0,1));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		t.setMark(1,2);
		TicTacToe.WinCheck c = t.getCheck();
		assertEquals(TicTacToe.WinCheck.NOTOVER, c);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToe.WinCheck c ;
		t.setMark(0,0);
		t.setMark(1,0);
		t.setMark(0,2);
		t.setMark(1,2);
		t.setMark(0,1);
		c = t.getCheck();
		assertEquals(TicTacToe.WinCheck.XWIN, c);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToe.WinCheck c;
		t.setMark(0,0);
		t.setMark(1,0);
		t.setMark(0,2);
		t.setMark(0,1);
		t.setMark(1,1);
		t.setMark(2,2);
		t.setMark(1,2);
		t.setMark(2,0);
		t.setMark(2,1);
		c = t.getCheck();
		assertEquals(TicTacToe.WinCheck.DRAW, c);
	}	
}
