package aug09HmwkCh20;

import javax.swing.*;
import java.awt.*;

public class KnightTour extends JFrame{
	JButton[][] buttonArray = new JButton[8][8];
	public KnightTour(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnightTour frame = new KnightTour();
		frame.setTitle("");
		frame.setSize(1,1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class newPanel extends JPanel{
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
