package ccc;
import java.io.*;

public class Uses {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		PrintWriter writer = new PrintWriter(file);
		int max = 1000000;
		writer.print(max);
		writer.print(" ");
		writer.print(max-1);
		writer.println();
		for (int i = 1; i < max; i++){
			writer.print(i);
			writer.print(" ");
			writer.print(i+1);
			writer.println();
		}
		writer.print(1);
		writer.print(" ");
		writer.print(max);
		writer.close();
	}

}
