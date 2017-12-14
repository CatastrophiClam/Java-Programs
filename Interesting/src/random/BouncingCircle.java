package random;

import javax.swing.*;
import java.awt.*;

public class BouncingCircle extends JFrame{
	
	public BouncingCircle(){
		add(new CirclePanel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BouncingCircle frame = new BouncingCircle();
		frame.setTitle("Bouncing Circle");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class CirclePanel extends JPanel{
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int radius = 50;
		int circleX = 0;
		int circleY = getHeight()-50;
		boolean goingRight = true;
		while (true){
			g.drawOval(circleX, circleY, radius*2, radius*2);
			if (goingRight){
				circleX++;
				if (circleX + radius >= getWidth()){
					goingRight = false;
				}
			}else{
				circleX--;
				if (circleX <= 0){
					goingRight = true;
				}
			}
			repaint();
		}
	}
}
