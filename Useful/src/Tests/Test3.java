package Tests;
import java.lang.Math;
import java.util.regex.*;
import java.io.*;
public class Test3 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("arrayStore"));
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("arrayStore"));
		int[][][] a = (int[][][])in.readObject();
		//System.out.print(a[0][3][4]);
		//a[0][3][4] = 23;
		//out.writeObject(a);
		//out.flush();
		//out.close();
		Pattern pattern = Pattern.compile("X*");
		Matcher matcher = pattern.matcher("1234");
		while(matcher.find()){
			System.out.println(matcher.group());
		}
	}
	

}
