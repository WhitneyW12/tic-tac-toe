package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToe {
	
	public enum Mark {XMARK, OMARK, EMPTY};
	public enum WinCheck {XWIN, OWIN, DRAW, NOTOVER};
	private Mark[][] board;
	private WinCheck check;
	private int moveCount;
	private boolean xTurn;
	
	public TicTacToe(){
		board = new Mark[3][3];
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				board[row][col] = Mark.EMPTY;
			}
		}
		xTurn = true;
		moveCount = 0;
		check = WinCheck.NOTOVER;
	}
	
	public Mark getMark(int row, int col){
		return board[row][col];
	}

	public void setMark(int row, int col){
		Mark mark;
		if (xTurn){
			mark = Mark.XMARK;
		}
		else{
			mark = Mark.OMARK;
		}
		if (board[row][col] == Mark.EMPTY) {
			board[row][col] = mark;
			moveCount++;
			xTurn = !xTurn;
		}
		check = checkForWin(row, col, mark);
	}
	
	private WinCheck checkForWin(int row, int col, Mark mark){
		boolean win = false;
		win = checkForWinHorizontally(row, mark);
		if (!win){
			win = checkForWinVertically(col, mark);
		}
		if (!win){
			win = checkForWinDiagonally(row, col, mark);
		}
		if (!win){
			win = checkForWinAntidiagonally(row, col, mark);
		}
		if (win){
			if (mark == Mark.XMARK){
				return WinCheck.XWIN;
			}
			else{
				return WinCheck.OWIN;
			}
		}
		if (moveCount == (board.length*board.length)){
			return WinCheck.DRAW;
		}
		return WinCheck.NOTOVER;
	}
	
	private boolean checkForWinHorizontally(int row, Mark mark){
		for (int i = 0; i < board.length; i++){
			if (board[row][i] != mark){
				break;
			}
			if (i == board.length - 1){
				return true;
			}
		}
		return false;
	}
	
	private boolean checkForWinVertically(int col, Mark mark){
		for (int i = 0; i < board.length; i++){
			if (board[i][col] != mark){
				break;
			}
			if (i == board.length - 1){
				return true;
			}
		}
		return false;
	}
	
	private boolean checkForWinDiagonally(int row, int col, Mark mark){
		for (int i = 0; i < board.length; i++){
			if (board[i][i] != mark){
				break;
			}
			if (i == board.length - 1){
				return true;
			}
		}
		return false;
	}
	
	private boolean checkForWinAntidiagonally(int row, int col, Mark mark){
		for (int i = 0; i < board.length; i++){
			if (board[i][(board.length - 1) - i] != mark){
				break;
			}
			if (i == board.length - 1){
				return true;
			}
		}
		return false;
	}

	public WinCheck getCheck(){
		return check;
	}
	
	public boolean getTurn(){
		return xTurn;
	}
	
	private void printBoard(){
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				if (board[i][j] ==  Mark.XMARK){
					System.out.print("X");
				}
				else if (board[i][j] == Mark.OMARK){
					System.out.print("O");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TicTacToeFrame frame = new TicTacToeFrame();
	}
}
