package graphicsTemplates;

import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.*;
import java.lang.Math;

public class DrawTester extends JFrame{
	
	public DrawTester(){
		add(new Panel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawTester frame = new DrawTester();
		frame.setTitle("Tester");
		frame.setSize(519,546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class Panel extends JPanel{
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int x = 193;
		int y = 150;
		int x1 = 250;
		int y1 = 50;
		//Graphics2D g2D = (Graphics2D) g;
		g.drawLine(x,y,x1,y1);
		g.setColor(Color.RED);
		//g2D.rotate(120, x, y);
		int[] coords;
		for (int i = 0; i < 120; i++){
			coords = rotate(x,getHeight()-y, x1, getHeight()-y1, i);
			g.drawLine(x, y, coords[0], getHeight()-coords[1]);
		}
		//g.drawRect(0, 0, 500, 500);
	}
	
	protected int[] rotate(int x, int y, int x1, int y1, int degrees){
		int newX1 = x1 - x;
		int newY1 = y1 - y;
		double lineLength = Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
		double degreesFromHorizontal = Math.toDegrees(Math.atan(newY1/newX1));
		if (y1 == y){
			if (newX1 < 0){
				degreesFromHorizontal = 180;
			}
		}
		double toAngle = degrees + degreesFromHorizontal;
		int returnX = (int)(x + lineLength*Math.cos(Math.toRadians(toAngle)));
		int returnY = (int)(y + lineLength*Math.sin(Math.toRadians(toAngle)));
		return new int[]{returnX, returnY};
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param x1
	 * @param y1
	 * @return returns -1 for a negative slope and 1 for a positive slope
	 */
	protected int checkSlope(int x, int y, int x1, int y1){
		y = getHeight()-y;
		y1 = getHeight()-y1;
		if(x-x1 != 0 && (y-y1)/(x-x1) != 0)
		return ((y-y1)/(x-x1))/Math.abs((y-y1)/(x-x1));
		return 1;
	}
}
