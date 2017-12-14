package aug09HmwkCh20;

import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class KochSnowflake extends JFrame{
	
	public KochSnowflake(){
		add(new snowFlakePanel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KochSnowflake frame = new KochSnowflake();
		frame.setTitle("Koch Snowflake");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class snowFlakePanel extends JPanel{
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		spawnSnowflake(g);
		
	}
	
	protected void spawnSnowflake(Graphics g){
		drawTriangle(getWidth()/12, 5*getHeight()/24, 11*getWidth()/12, 5*getHeight()/24, 1, true, 0, g);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param isUp determines orientation of triangle : 1 means pointing up, -1 means pointing down
	 * @param isComplete: determines whether we draw the base or not
	 * @param g
	 * @param depth: times function has been called
	 * Draws triangle without the middle third of each side length
	 */
	protected void drawTriangle(int x, int y, int x1, int y1, int isUp, boolean isComplete, int depth, Graphics g){
		int lineLength = (int)Math.sqrt(Math.pow(x1-x, 2) + Math.pow(y1-y, 2)); // use pythagorean to determine base length
		int segmentLength = lineLength/3;
		int xCoord = (int)(x + (x1 - x)*Math.cos(isUp*60));
		int yCoord = (int)(getHeight()-y + (y1 - y)*Math.sin(isUp*60));
		g.drawLine(x, y, x + (xCoord-x)/3, y + (yCoord-y)/3);
		g.drawLine(x1, y1, x1 + (xCoord-x1)/3, y1 + (yCoord-y1)/3);
		g.drawLine(xCoord, yCoord, xCoord + (x-xCoord)/3, yCoord + (y-yCoord)/3);
		g.drawLine(xCoord, yCoord, xCoord + (x1-xCoord)/3, yCoord + (y1-yCoord)/3);
		if (depth <= 6){
		drawTriangle(x + (xCoord-x)/3, y + (yCoord-y)/3, xCoord + (x-xCoord)/3, yCoord + (y-yCoord)/3, isUp, false, depth+1, g);
		drawTriangle(x1 + (xCoord-x1)/3, y1 + (yCoord-y1)/3, xCoord + (x1-xCoord)/3, yCoord + (y1-yCoord)/3, isUp, false, depth+1, g);
		}
		if (isComplete){
			g.drawLine(x, y, x + (x1-x)/3, y + (y1-y)/3);
			g.drawLine(x1, y1, x1 + (x-x1)/3, y1 + (y-y1)/3);
			drawTriangle(x + (x1-x)/3, y + (y1-y)/3, x1 + (x-x1)/3, y1 + (y-y1)/3, -1, false, depth+1, g);
		}
	}
}
