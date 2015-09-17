package edu.jsu.mcis;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;

public class TicTacToeFrame extends JFrame{
	
	private JButton[][] move;
	private TicTacToe t;
	private JFrame frame = new JFrame("Tic Tac Toe");
	private JPanel panel = new JPanel();
	
	
	public TicTacToeFrame(){
		t = new TicTacToe();
		panel.setLayout (new GridLayout(3, 3, 3, 3));
		panel.setPreferredSize(new Dimension(400,400));
		move = new JButton[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				move[i][j] = new JButton();
				move[i][j].setName("Location" + i + j);
				move[i][j].addActionListener(new ButtonListener());
				panel.add(move[i][j]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private class ButtonListener implements ActionListener{
		private TicTacToe.WinCheck check;
		private boolean xTurn;
		private TicTacToe.Mark mark = TicTacToe.Mark.EMPTY;
		JOptionPane optionPane = new JOptionPane();
		
		@Override
		public void actionPerformed(ActionEvent event){
			JButton source = (JButton)event.getSource();
			check = t.getCheck();
			if (check == TicTacToe.WinCheck.NOTOVER){
				for (int i = 0; i < 3; i++){
					for (int j = 0; j < 3; j++){
						if (source == move[i][j]){
							xTurn = t.getTurn();
							mark = t.getMark(i, j);
							t.setMark(i, j);
							move[i][j].setFont(new Font("Arial", Font.PLAIN, 50));
							if (mark == TicTacToe.Mark.EMPTY){
								if (xTurn){
									move[i][j].setText("X");
								}
								else{
									move[i][j].setText("O");
								}
							}
						}
					}
				}
			}
			check = t.getCheck();
			if (check == TicTacToe.WinCheck.XWIN){
				optionPane.showMessageDialog(optionPane, "The winner is X", "Game Over", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (check == TicTacToe.WinCheck.OWIN){
				optionPane.showMessageDialog(optionPane, "The winner is O", "Game Over", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (check == TicTacToe.WinCheck.DRAW){
				optionPane.showMessageDialog(optionPane, "The winner is TIE", "Game Over", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}