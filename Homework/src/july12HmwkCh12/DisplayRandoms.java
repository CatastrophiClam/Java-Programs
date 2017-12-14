package july12HmwkCh12;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DisplayRandoms extends JFrame {
	public DisplayRandoms(){
		Random random = new Random();
		setLayout(new GridLayout(10,10));
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				add(new JLabel(String.valueOf(random.nextInt(2)), JLabel.CENTER));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisplayRandoms mainFrame = new DisplayRandoms();
		mainFrame.setTitle("Random 1's and 0's");
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

}
