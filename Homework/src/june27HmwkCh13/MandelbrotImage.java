package june27HmwkCh13;

import javax.swing.*;
import java.awt.*;

public class MandelbrotImage extends JFrame{
	
	public MandelbrotImage(){
		add(new MandelbrotCanvas());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MandelbrotImage frame = new MandelbrotImage();
		frame.setTitle("Mandelbrot Set");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class MandelbrotCanvas extends JPanel{
	final static int COUNT_LIMIT = 60;
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for (double x = -2.0; x < 2.0; x += 0.01)
			for (double y = -2.0; y < 2.0; y += 0.01) {
			int c = count(new Complex(x, y));
			if (c == COUNT_LIMIT)
			g.setColor(Color.BLACK); // c is in a Mandelbrot set
			else
			g.setColor(new Color(
			c * 77 % 256, c * 58 % 256, c * 159 % 256));
			
			g.drawRect((int)(x * 100) + 200, (int)(y * 100) + 200,
			1, 1); // Fill a tiny rectangle with the specified color
			}
			}
		
			/** Return the iteration count */
			static int count(Complex c) {
			Complex z = new Complex(0, 0); // z0
			
			for (int i = 0; i < COUNT_LIMIT; i++) {
			z = z.multiply(z).add(c); // Get z1, z2, . . .
			if (z.abs() > 2) return i; // The sequence is unbounded
			}
			
			return COUNT_LIMIT; // Indicate a bounded sequence
	}
}


