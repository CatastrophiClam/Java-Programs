package random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class FileTryout {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File test = new File("Files/Test.txt");
		Scanner reader = new Scanner(test);
		System.out.println(reader.nextLine());
		reader.close();
	}

}
