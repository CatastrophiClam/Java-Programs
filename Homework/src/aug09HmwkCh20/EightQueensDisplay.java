package aug09HmwkCh20;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EightQueensDisplay extends JFrame{
	
	public EightQueensDisplay(){
		add(new DisplayPanel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightQueensDisplay frame = new EightQueensDisplay();
		frame.setTitle("Eight Queens");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class DisplayPanel extends JPanel{
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		EightQueensLogic logic = new EightQueensLogic();
		ArrayList<int[]> positions = logic.queenPositions();
		setLayout(new GridLayout(8,8));
		for(int y = 7; y >=0; y--){
			for(int x = 0; x <= 7; x++){  //for every square
				JButton temp = new JButton();
				temp.setBackground(Color.white);
				// check if there should be a queen
				for (int[] i:positions){  
					if(x == i[0] && y == i[1]){
						// if there should be, set background to black
						temp.setBackground(Color.black);
					}
				}
				add(temp);
			}
		}
	}
}
