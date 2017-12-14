package aug09HmwkCh20;

import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;

public class KochSnowflake1 extends JFrame{
	
	public KochSnowflake1(){
		add(new SnowflakePanel1());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KochSnowflake1 frame = new KochSnowflake1();
		frame.setTitle("Koch Snowflake");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class SnowflakePanel1 extends JPanel{
	ArrayList<Integer> xCoords = new ArrayList<Integer>();
	ArrayList<Integer> yCoords = new ArrayList<Integer>();
	int nCoords = 2;
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int maxLength = Math.min(getWidth(), getHeight());
		int lengthDif = Math.max(getWidth(), getHeight()) - maxLength;
		int x = maxLength/2 + lengthDif/2;
		int y = maxLength/12 + lengthDif/2;
		int x1 = 13*getWidth()/36 + lengthDif/2;
		int y1 = maxLength/3 + lengthDif/2;
		xCoords.add(x);
		xCoords.add(x1);
		yCoords.add(y);
		yCoords.add(y1);
		spawnTriangle(x, y, x1, x1, 5*maxLength/18, 0);
		int[] xPoints = new int[xCoords.size()];
		int[] yPoints = new int[yCoords.size()];
		for (int i = 0; i < xCoords.size(); i++){
			xPoints[i] = xCoords.get(i);
			yPoints[i] = yCoords.get(i);
		}
		g.drawPolygon(xPoints, yPoints, nCoords);
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
	protected void spawnTriangle(int startX, int startY, int startX1, int startY1, int lineLength, int depth){
		lineLength = lineLength/3;   // length of current line
		int nowX; // endpoint variables
		int nowY;
		// rotate previous line 120 degrees CCW and shorten to 1/3 of original length NOTE rotate point is start1 variables
		nowX = rotate(startX1, -startY1, startX, -startY, 120)[0];  // rotate 120 degrees
		int tempNowX = startX1 + (nowX - startX1)/3;     // shorten
		nowY = Math.abs(rotate(startX1, -startY1, startX, -startY, 120)[1]);
		int tempNowY = startY1 + (nowY - startY1)/3;
		// add end point of that line to coords
		xCoords.add(tempNowX);
		yCoords.add(tempNowY);
		nCoords++;
		// call spawnTriangle with coord1's and end's points
		if (depth<6)
		spawnTriangle(startX1, startY1, tempNowX, tempNowY, lineLength, depth+1);
		// add end point of self triangle
		xCoords.add(nowX);
		yCoords.add(nowY);
		nCoords++;
		// rotate line by 60 degrees CW, shorten; NOTE rotate point is NOW variables
		int nextX = rotate(nowX, -nowY, startX1, -startY1, -60)[0];
		int tempNextX = nowX + (nextX - nowX)/3;     // shorten
		int nextY = Math.abs(rotate(nowX, -nowY, startX1, -startY1, -60)[1]);
		int tempNextY = nowY + (nextY - nowY)/3;     // shorten
		// add to coords
		xCoords.add(tempNextX);
		yCoords.add(tempNextY);
		nCoords++;
		// call spawnTriangle on end point and rotated point
		if (depth<6)
		spawnTriangle(nowX, nowY, tempNextX, tempNextY, lineLength, depth+1);
		// add self triangle's third end point
		xCoords.add(nextX);
		yCoords.add(nextY);
		nCoords++;
	}
	
	protected int[] rotate(int x, int y, int x1, int y1, int degrees){
		return new int[]{x + (x1 - x)*(int)Math.cos(Math.toRadians(degrees)) - y + (y1 - y)*(int)Math.sin(Math.toRadians(degrees)), x + (x1 - x)*(int)Math.cos(Math.toRadians(degrees)) - y + (y1 - y)*(int)Math.sin(Math.toRadians(degrees))};
	}
}
