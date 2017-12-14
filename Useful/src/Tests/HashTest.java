package Tests;
import java.util.*;

public class HashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		a.add(1);
		System.out.println(a+": "+a.hashCode());
		a.add(2);
		System.out.println(a+": "+a.hashCode());
		b.add(2);
		b.add(1);
		System.out.println(b+": "+b.hashCode());
		a.add(3);
		c.add(3);
		a.clear();
		System.out.println(c+": "+c.hashCode());
		System.out.println(a+": "+a.hashCode());
	}

}
