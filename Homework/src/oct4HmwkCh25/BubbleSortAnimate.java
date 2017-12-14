package oct4HmwkCh25;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BubbleSortAnimate extends JFrame{
	int[] numbers;
	SortPanel panel = new SortPanel();
	JButton stepButton = new JButton("Step");
	JButton resetButton = new JButton("Reset");
	
	public BubbleSortAnimate(int[] numbers){
		//this.setLayoutManager(new GridLayout())
		this.numbers = numbers;
		add(panel);
		stepButton.addActionListener(new stepListener());
		resetButton.addActionListener(new resetListener());
	}
	
	public static void main(String[] args){
		int[] numbers = new int[]{20, 4, 6, 15, 17, 3, 8, 13, 2, 3, 15, 12, 7, 3, 9, 1, 19, 5, 2, 6};
		BubbleSortAnimate frame = new BubbleSortAnimate(numbers);
		frame.setTitle("Bubble Sort Animation");
		frame.setSize(519,546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class stepListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class resetListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	public class SortPanel extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			drawBars(g);
		}
		
		public void drawBars(Graphics g){
			
		}
	}
}
