package july12HmwkCh12;
import javax.swing.*;
import java.awt.*;
public class Checkerboard extends JFrame{
	public Checkerboard(){
		Color beforeColor = Color.WHITE;
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				JButton temp = new JButton("");
				if (j != 0){
					if (beforeColor.equals(Color.WHITE)){
						beforeColor = Color.BLACK;
					}else{
						beforeColor = Color.WHITE;
					}
				}
				temp.setBackground(beforeColor);
				add(temp);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Checkerboard frame = new Checkerboard();
		frame.setTitle("Checkerboard");
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(8,8));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
