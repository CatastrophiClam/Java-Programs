package june27HmwkCh13;

import javax.swing.*;
import java.awt.*;
import java.lang.Math;


public class PolygonCreator extends JPanel{
	int numsides;
	public PolygonCreator(int n){
		numsides = n;
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int centerX = getWidth()/2;
		int centerY = getHeight()/2;
		int radius = 4*centerX/5;  // each vertex of the polygon should be equidistant from center
		int angle = 360/numsides;  // angle between each point
		Polygon polygon = new Polygon();  // create polygon
		for (int i = 0; i < numsides; i++){  // add points
			polygon.addPoint((int)(centerX + Math.cos(Math.toRadians(i*angle))*radius), (int)(centerY + Math.sin(Math.toRadians(i*angle))*radius));
		}
		g.drawPolygon(polygon);
	}
}
