package ccc;
import java.io.*;
import java.util.*;

public class s5_2001 {
	static String[]a;
	static String[]b;
	static int m,n,k;
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		m = Integer.parseInt(reader.nextLine());
		n = Integer.parseInt(reader.nextLine());
		a = new String[n];
		b = new String[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++){
			a[i] = reader.nextLine();
		}
		for (int i = 0; i < n; i++){
			b[i] = reader.nextLine();
		}
		for (int i = 1; i <= m;i++){
			k=0;
			list.clear();
			if (find(list,i)){
				System.out.println(k);
				for (int j = 0; j < k; j++){
					System.out.println(list.get(j)+1);
				}
				reader.close();
				return;
			}
		}
		System.out.println("No solution.");
		
		reader.close();
	}
	
	public static boolean find(ArrayList<Integer>list,int m){
		if (k>m){
			return false;
		}
		k++;
		
		int ver;
		for (int i = 0; i < n; i++){
			list.add(i);
			ver = check(list);
			if (ver==1){
				return true;
			}else if (ver==2){
				if (find(list,m)){
					return true;
				}
			}
			list.remove(list.size()-1);
		}
		k--;
		return false;
	}
	
	public static int check(ArrayList<Integer>list){
		int minLen;
		String s1 = "";
		String s2 = "";
		for (int i:list){
			s1 = s1 + a[i];
			s2 = s2 + b[i];
		}
		if (s1.length()<s2.length()){
			minLen = s1.length();
		}else{
			minLen = s2.length();
		}
		for (int i = 0; i < minLen; i++){
			if (s1.charAt(i)!=s2.charAt(i)){
				return 3;
			}
		}
		if (s1.length()==s2.length()){
			return 1;
		}else{
			return 2;
		}
	}

}
