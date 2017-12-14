package graphicsTemplates;
import javax.swing.*;
import java.awt.*;

public class Template extends JFrame{
	
	public Template(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Template frame = new Template();
		frame.setTitle("");
		frame.setSize(519,546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class newPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
		}
	}
	
}

