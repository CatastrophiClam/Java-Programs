package june27HmwkCh13;

import javax.swing.*;
import java.awt.*;

public class PolygonTester extends JFrame{
	
	public PolygonTester(){
		add (new PolygonCreator(5));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolygonTester frame = new PolygonTester();
		frame.setTitle("Polygon");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
