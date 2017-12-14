package ch14;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.*;

public class FilesExp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()){
				System.out.print(scan.nextLine());
			}
		}
	}

}
