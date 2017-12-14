package june27HmwkCh13;

import javax.swing.*;
import java.awt.*;

public class DrawCheckerBoard extends JFrame{
	
	public DrawCheckerBoard(){
		add (new newPanel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawCheckerBoard frame = new DrawCheckerBoard();
		frame.setTitle("Checker Board");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class newPanel extends JPanel{
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int xUnit = getWidth()/8;
		int yUnit = getHeight()/8;
		g.setColor(Color.white);
		Color pastColor = Color.white;
		for (int i = 0; i < 8; i ++){
			for (int j = 0; j < 8; j++){
				if (j != 0){
					if (pastColor.equals(Color.white)){
						g.setColor(Color.black);
						pastColor = Color.black;
					}else{
						g.setColor(Color.white);
						pastColor = Color.white;
					}
				}
				g.fillRect(i*xUnit, j*yUnit, xUnit, yUnit);
			}
		}
	}
}
