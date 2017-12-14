package aug09HmwkCh20;

import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.util.*;

public class KochSnowflake3 extends JFrame {

	public KochSnowflake3() {
		add(new SnowflakePanel3());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KochSnowflake3 frame = new KochSnowflake3();
		frame.setTitle("Koch Snowflake");
		frame.setSize(519, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}

class SnowflakePanel3 extends JPanel {
	final int MIN_LENGTH = 2; // every line is minimum 2 pixels long
	ArrayList<Integer> xCoords = new ArrayList<Integer>();
	ArrayList<Integer> yCoords = new ArrayList<Integer>();
	int nCoords = 0;
	int count = 0;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x, x1, x2, y, y1, y2; // coordinates of 3 verticies of main triangle
		int minSquare; // minimum square that contains the triangle - useful in
						// resizing window
		int triangleHeight; // height of main triangle

		if (getHeight() < getWidth()) {
			minSquare = getHeight();
		} else {
			minSquare = getWidth();
		}
		minSquare -= 3 * minSquare / 8;

		triangleHeight = (int) Math.sqrt(minSquare * minSquare
				- (minSquare / 2) * (minSquare / 2));
		x = getWidth() / 2;
		x1 = x - minSquare / 2;
		x2 = x + minSquare / 2;
		y = getHeight() / 2 - triangleHeight / 2 - getHeight() / 8;
		y1 = getHeight() / 2 + triangleHeight / 2 - getHeight() / 8;
		y2 = y1;

		xCoords.clear();
		yCoords.clear();
		nCoords = 0;

		xCoords.add(x);
		yCoords.add(y);
		nCoords++;

		addTriangle(x, y, x1, y1, x2, y2, g);

		xCoords.add(x1);
		yCoords.add(y1);
		nCoords++;

		addTriangle(x1, y1, x2, y2, x, y, g);

		xCoords.add(x2);
		yCoords.add(y2);
		nCoords++;

		addTriangle(x2, y2, x, y, x1, y1, g);

		for (int i = 0; i < nCoords; i++) {
			g.drawLine(xCoords.get(i), yCoords.get(i),
					xCoords.get((i + 1) % nCoords),
					yCoords.get((i + 1) % nCoords));
		}

	}

	protected void addTriangle(int x, int y, int x1, int y1, int x2, int y2,
			Graphics g) {
		double triangleRatio = 4 / 7.0;
		if (distance(x, y, x1, y1) >= MIN_LENGTH * (1 / triangleRatio)) {
			// current triangle values
			int X, X1, X2, Y, Y1, Y2;
			/**
			 * X = (int)(x-(x-x1)/(1/triangleRatio)); insane bug Y =
			 * (int)(y-(y-y1)/(1/triangleRatio)); X2 =
			 * (int)(x-2*(x-x1)/(1/triangleRatio)); Y2 =
			 * (int)(y-2*(y-y1)/(1/triangleRatio));
			 **/
			X = (int) (x - (((x - x1) - (x - x1) / (1 / triangleRatio)) / 2));
			Y = (int) (y - (((y - y1) - (y - y1) / (1 / triangleRatio)) / 2));
			X2 = (int) (x - (((x - x1) - (x - x1) / (1 / triangleRatio)) / 2) - (x - x1)
					/ (1 / triangleRatio));
			Y2 = (int) (y - (((y - y1) - (y - y1) / (1 / triangleRatio)) / 2) - (y - y1)
					/ (1 / triangleRatio));
			boolean go = false;
			// helper variables
			int pX = (X + X2) / 2;
			int pY = (Y + Y2) / 2;
			double d = distance(X, Y, X2, Y2);
			double D = distance(pX, pY, x2, y2);
			double H = Math.sqrt(d * d - Math.pow(d / 2, 2));
			double xRatio;
			if (Math.abs(pX - x2) > 2) {
				xRatio = (pX - x2) / D;
			} else {
				xRatio = 0;
			}
			double yRatio;
			if (Math.abs(pY - y2) > 2) {
				yRatio = (pY - y2) / D;
			} else {
				yRatio = 0;
			}
			X1 = (int) (pX + H * xRatio);
			Y1 = (int) (pY + H * yRatio);
			/**
			 * System.out.println("X of triangle"+count+"is: "+X);
			 * System.out.println("Y of triangle"+count+"is: "+Y);
			 * g.drawOval(X,Y,5,5);
			 * System.out.println("X1 of triangle"+count+"is: "+X1);
			 * System.out.println("Y1 of triangle"+count+"is: "+Y1);
			 * g.drawOval(X1,Y1,5,5);
			 * System.out.println("X2 of triangle"+count+"is: "+X2);
			 * System.out.println("Y2 of triangle"+count+"is: "+Y2);
			 * g.drawOval(X2,Y2,5,5);
			 **/

			xCoords.add(X);
			yCoords.add(Y);
			nCoords++;

			addTriangle(X, Y, X1, Y1, X2, Y2, g);

			xCoords.add(X1);
			yCoords.add(Y1);
			nCoords++;

			addTriangle(X1, Y1, X2, Y2, X, Y, g);

			xCoords.add(X2);
			yCoords.add(Y2);
			nCoords++;

		} else {
			return;
		}
	}

	protected double distance(int x, int y, int x1, int y1) {
		return Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
	}
}
