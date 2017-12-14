package aug09HmwkCh20;

import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;

public class KochSnowflake2 extends JFrame{
	
	public KochSnowflake2(){
		add(new SnowflakePanel2());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KochSnowflake2 frame = new KochSnowflake2();
		frame.setTitle("Koch Snowflake");
		frame.setSize(519,546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class SnowflakePanel2 extends JPanel{
	ArrayList<Integer> xCoords = new ArrayList<Integer>();
	ArrayList<Integer> yCoords = new ArrayList<Integer>();
	int nCoords = 2;
	final int maxDepth = 0;
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int maxLength = Math.min(getWidth(), getHeight());
		int lengthDif = Math.max(getWidth(), getHeight()) - maxLength;
		int x = 250;//maxLength/2 + lengthDif/2;
		int y = 50;//maxLength/12 + lengthDif/2;
		int x1 = 193;//13*getWidth()/36 + lengthDif/2;
		int y1 = 150;//maxLength/3 + lengthDif/2;
		xCoords.add(x);
		xCoords.add(x1);
		yCoords.add(y);
		yCoords.add(y1);
		spawnTriangle1(x, y, x1, y1, 0);
		boolean goAhead = true; //do we proceed with the following code?
		if (goAhead){
		//add bottom left corner of triangle
		xCoords.add(78);
		yCoords.add(350);
		//add 1/3 line
		xCoords.add(193);
		yCoords.add(350);
		spawnTriangle1(78, 350, 193, 350, 0);
		// add bottom right corner of triangle
		xCoords.add(423);
		yCoords.add(350);
		//add 1/3 line
		xCoords.add(366);
		yCoords.add(250);
		spawnTriangle1(423, 350, 366, 350, 0);
		}
		int[] xPoints = new int[xCoords.size()];
		int[] yPoints = new int[yCoords.size()];
		for (int i = 0; i < xCoords.size(); i++){
			xPoints[i] = xCoords.get(i);
			yPoints[i] = yCoords.get(i);
		}
		g.drawPolygon(xPoints, yPoints, nCoords);
		//useless
		//g.setColor(Color.red);
		//g.drawLine(10, 10, 490, 10);
		//g.drawLine(490, 10, rotate(490,490,10,490,45)[0], 500-rotate(490,490,10,490,45)[1]);
		//g.drawLine(490, 10, 10, 490);
		//g.drawLine(10,10,10,490);
	}
	
	/**
	 * 
	 * @param startX
	 * @param startY
	 * @param startX1
	 * @param startY1
	 * @param lineLength the length of the PREVIOUS line
	 * @param isComplete  is the triangle complete or without a base?
	 * 
	 */
	protected void spawnTriangle1(int startX, int startY, int startX1, int startY1, int depth){
		int nowX; // endpoint variables
		int nowY;
		// rotate previous line 120 degrees CCW and shorten to 1/3 of original length NOTE rotate point is start1 variables
		nowX = rotate(startX1, getHeight()-startY1, startX, getHeight()-startY, 120)[0];  // rotate 120 degrees
		int tempNowX = startX1 - (startX1 - nowX)/3;     // shorten
		nowY = getHeight()-rotate(startX1, getHeight()-startY1, startX, getHeight()-startY, 120)[1];
		int tempNowY = startY1 + (nowY - startY1)/3;
		// add end point of that line to coords
		xCoords.add(tempNowX);
		yCoords.add(tempNowY);
		nCoords++;
		// call spawnTriangle with coord1's and end's points
		if (depth<maxDepth)
		spawnTriangle1(startX1, startY1, tempNowX, tempNowY, depth+1);
		// add end point of self triangle
		xCoords.add(nowX);
		yCoords.add(nowY);
		nCoords++;
		// rotate line by 60 degrees CW, shorten; NOTE rotate point is NOW variables
		int nextX = rotate(nowX, getHeight()-nowY, startX1, getHeight()-startY1, -60)[0];
		int tempNextX = nowX + (nextX - nowX)/3;     // shorten
		int nextY = getHeight()-rotate(nowX, getHeight()-nowY, startX1, getHeight()-startY1, -60)[1];
		int tempNextY = nowY + (nextY - nowY)/3;     // shorten
		// add to coords
		xCoords.add(tempNextX);
		yCoords.add(tempNextY);
		nCoords++;
		// call spawnTriangle on end point and rotated point
		if (depth<maxDepth)
		spawnTriangle1(nowX, nowY, tempNextX, tempNextY, depth+1);
		// add self triangle's third end point
		xCoords.add(nextX);
		yCoords.add(nextY);
		nCoords++;
	}
	
	/**
	 * POSITIVE NUMBERS ROTATE A LINE COUNTERCLOCKWISE
	 * @param x coord of point of rotation
	 * @param y coord of point of rotation
	 * @param x1 coord of point being rotated
	 * @param y1 coord of point being rotated
	 * @param degrees
	 * @return coordinates of endpoint of line after rotation
	 */
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
