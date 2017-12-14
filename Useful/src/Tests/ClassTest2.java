package Tests;
import java.io.*;
public class ClassTest2 {
	int a = 7;
	private int d = 3;
	public static void main(String[] args) throws IOException{
		//System.out.println(type);
		//ClassTest t = new ClassTest2();
		//System.out.println(t.a);
		int i = 1;
		System.out.print((i++));
		System.out.print(i);
		
		BufferedOutputStream stream = new BufferedOutputStream(new BufferedOutputStream(new DataOutputStream(new BufferedOutputStream(new FileOutputStream("abc.txt")))));
	}
	
	public void get(){
		
	}
	
	
	public void go(int a) throws IOException{
		
	}
}
