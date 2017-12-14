package ccc;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class s5_2011 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int k = reader.nextInt();
		boolean[] a = new boolean[k];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int temp;
		for (int i=0;i<k;i++){
			temp = reader.nextInt();
			if (temp == 0){
				a[i] = false;
			}else{
				a[i] = true;
				list.add(i);
			}
		}
		int r = 0;
		int count = 0;
		for (int i = 0; i < k; i++){
			if (a[i]){
				r++;
			}else{
				if (r==0 && a[i+1] && a[i+2] && a[i+3]){
					count ++;
					i += 3;
					a[i] = false;
					a[i+1] = false;
					a[i+2] = false;
					a[i+3] = false;
				}
				if (r== 1 && a[i+1] && a[i+2]){
					count ++;
					i += 2;
					a[i-1] = false;
					a[i] = false;
					a[i+1] = false;
					a[i+2] = false;
				}
				if (r== 2 && a[i+1]){
					count ++;
					i+= 1;
					a[i-2] = false;
					a[i-1] = false;
					a[i] = false;
					a[i+1] = false;
				}
				if (r==3){
					count++;
					a[i-3] = false;
					a[i-2] = false;
					a[i-1] = false;
					a[i] = false;
				}
				r = 0;
			}
		}
	}

}
