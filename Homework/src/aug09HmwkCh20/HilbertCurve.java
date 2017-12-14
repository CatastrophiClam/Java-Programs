package aug09HmwkCh20;

import javax.swing.*;
import java.awt.*;

public class HilbertCurve extends JFrame{
	
	public HilbertCurve(){
		add(new CurvePanel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HilbertCurve frame = new HilbertCurve();
		frame.setTitle("Hilbert Curve");
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class CurvePanel extends JPanel{
	final int ORDER = 3;
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int border = (getWidth()/10 + getHeight()/10) /2;
	}
}
