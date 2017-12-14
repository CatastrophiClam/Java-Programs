package ai;
import java.io.*;
import java.util.*;
public class SongwriterExec {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		SongwriterV2 writer = new SongwriterV2();
		Scanner scan = new Scanner(System.in);
		
		String input;
		while (true){
			System.out.println("Enter the first line of a song: ");
			input = scan.nextLine();
			if (!input.equals("")){
				writer.output(input);
			}else{
				break;
			}
		}
	}

}
