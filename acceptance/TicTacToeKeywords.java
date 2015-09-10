import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToe t;
	
	public void startNewGame() {
		t = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		t.setMark(row, col);
	}
	
	public String getMark(int row, int col) {
		TicTacToe.Mark m = t.getMark(row, col);
		if (m == TicTacToe.Mark.XMARK){
			return "X";
		}
		else if (m == TicTacToe.Mark.OMARK){
			return "O";
		}
		else{
			return "";
		}
	}
    
	public String getWinner() {
		TicTacToe.WinCheck c = t.getCheck();
		if (c == TicTacToe.WinCheck.XWIN){
			return "X";
		}
		else if (c == TicTacToe.WinCheck.OWIN){
			return "O";
		}
		else{
			return "TIE";
		}
	}
}
