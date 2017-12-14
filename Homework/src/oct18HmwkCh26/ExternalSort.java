package oct18HmwkCh26;
import java.util.Scanner;


public class ExternalSort {
	java.io.File inputFile = new java.io.File("Numbers");
	public ExternalSort()throws Exception{
		Scanner reader = new Scanner(inputFile);
		
		reader.close();
	}
	
}
