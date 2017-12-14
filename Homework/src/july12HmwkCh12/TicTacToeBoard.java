package july12HmwkCh12;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TicTacToeBoard extends JFrame {
	public TicTacToeBoard(){
		Random random = new Random();
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (random.nextInt(2) == 0){
					add(new JLabel("X", JLabel.CENTER));
				}else{
					add(new JLabel("O", JLabel.CENTER));
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToeBoard frame = new TicTacToeBoard();
		frame.setTitle("Tic Tac Toe");
		frame.setSize(300, 300);
		frame.setLayout(new GridLayout(3,3));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
