import java.util.*;
import java.io.*;

public class problem3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("DATA11.txt"));
		String[]buffer = reader.nextLine().split(" ");
		int size = Integer.parseInt(buffer[0]);
		int length = Integer.parseInt(buffer[1]);
		
		
		
		Random rand = new Random();
		for (int i = 0; i < 10; i++){
			System.out.println(rand.nextInt(100));
		}
		
	}

}





















