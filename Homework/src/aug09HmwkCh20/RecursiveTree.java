package aug09HmwkCh20;

import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class RecursiveTree extends JFrame{
	
	public RecursiveTree(){
		add(new Tree());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursiveTree frame = new RecursiveTree();
		frame.setTitle("Recursive Tree");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class Tree extends JPanel{
	final int MAX_ITERATIONS = 10;
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(getWidth()/2, 5*getHeight()/6, getWidth()/2, 3*getHeight()/7);
		spawnTree(g, 0, 17*getHeight()/42, 0, getWidth()/2, 5*getHeight()/6, getWidth()/2, 3*getHeight()/7);
	}
	
	protected void spawnTree(Graphics g, int iterations, int pastLength, int pastAngle, int x1, int y1, int x2, int y2){
		if (iterations < MAX_ITERATIONS){  // if we can still go:
			iterations ++;
			int lineLength =  8*pastLength/15;  // length of line to draw
			// draw two lines 
			for (int i = -1; i <=1; i+= 2){
				int thisAngle = pastAngle + i*30; // angle FROM VERTICAL of line to be drawn
				thisAngle = convertAngle(thisAngle);
				// the coords of the endpoint of the next line
				int thisX = x2 - (int)(Math.sin(Math.toRadians(thisAngle))*lineLength);  
				int thisY = y2 - (int)(Math.cos(Math.toRadians(thisAngle))*lineLength);
				//draw next line
				g.drawLine(x2, y2, thisX, thisY);
				spawnTree(g, iterations, lineLength, thisAngle, x2, y2, thisX, thisY);
			}
		}
	}
	
	public int convertAngle(int angle){
		if (angle < 0){
			angle = 360 + angle;
		}
		return angle;
	}
}