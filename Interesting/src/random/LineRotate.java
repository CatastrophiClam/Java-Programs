package random;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LineRotate extends JFrame{
	
	public LineRotate(){
		setLayout(new GridLayout(2, 2));
		add(new linePanel());
		add(new linePanel());
		add(new linePanel());
		add(new linePanel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LineRotate frame = new LineRotate();
		frame.setTitle("Rotating Line");
		frame.setSize(1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	


	static class linePanel extends JPanel{
		int x = 200;
		int y = 200;
		int x1 = 250;
		int y1 = 250;
		int[] coords;
		
		public linePanel(){
			addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent e){
					coords = Rotate.rotate(x, getHeight()-y, x1, getHeight()-y1, 90);
					x1 = coords[0];
					y1 = getHeight()-coords[1];
					repaint();
				}
				
				@Override
				public void mouseEntered(MouseEvent e){
					
				}
				
				@Override
				public void mouseReleased(MouseEvent e){
					
				}
				
				@Override
				public void mousePressed(MouseEvent e){
					
				}
				
				@Override
				public void mouseExited(MouseEvent e){
					
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawLine(x, y, x1, y1);
		}
	}
}
