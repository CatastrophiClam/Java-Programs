package geometry;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

public class VisualTester extends JFrame{
	
	public VisualTester(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VisualTester frame = new VisualTester();
		frame.setTitle("Tester");
		frame.setSize(519,546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class newPanel extends JPanel{
		final int numPoints = 100;
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			Random random = new Random();
			ArrayList<int[]> pointList = new ArrayList<int[]>();
		}
	}
	
}
