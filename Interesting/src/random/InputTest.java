package random;

import javax.swing.*;
import java.awt.*;

public class InputTest extends JFrame{
	
	public InputTest(){
		add(new newPanel());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputTest frame = new InputTest();
		frame.setTitle("");
		frame.setSize(519,546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class newPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			int num = 1;
			int pastNum = 2;
			for (int i = 0; i < 500; i++){
				outer:
				while(true){
					num += 2;
					for (int j = 3; j < Math.sqrt(num);j++){
						if (num%j==0){
							continue outer;
						}
					}
					g.drawLine(i, 500, i, 500-(num-pastNum)*8);
					pastNum = num;
					break;
				}
			}
		}
	}
	
}


