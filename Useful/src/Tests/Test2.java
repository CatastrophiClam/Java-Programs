package Tests;
import javax.swing.*;
import java.awt.*;

public class Test2 extends JFrame{
	public Test2(){
		add(new Panel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 frame = new Test2();
		frame.setTitle("Test");
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class Panel extends JPanel{
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(0,0,50,50);
	}
}
