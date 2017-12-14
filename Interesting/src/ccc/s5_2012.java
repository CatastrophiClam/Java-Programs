package ccc;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;
public class s5_2012 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(System.in);//file);
		int R = reader.nextInt();
		int C = reader.nextInt();
		int numCats = reader.nextInt();
		int[]cX = new int[numCats];
		int[]cY = new int[numCats];
		for (int i = 0; i < numCats;i++){
			cY[i] = reader.nextInt();
			cX[i] = reader.nextInt();
		}
		int ways = 0;
		Stack<int[]>s = new Stack<int[]>();
		s.push(new int[]{1,1});
		int[]temp;
		while (s.size()>0){
			temp = s.pop();
			if (temp[0]+1<=C){
				if (!(contains(cX,temp[0]+1)&&contains(cY,temp[1]))){
					if (temp[0]+1==C && temp[1]==R){
						ways++;
					}else{
						s.push(new int[]{temp[0]+1,temp[1]});
					}
				}
			}
			if (temp[1]+1<=R){
				if (!(contains(cY,temp[1]+1)&&contains(cX,temp[0]))){
					if (temp[0]==C && temp[1]+1==R){
						ways++;
					}else{
						s.push(new int[]{temp[0],temp[1]+1});
					}
				}
			}
		}
		System.out.print(ways);
	}
	
	public static boolean contains(int[]a,int regex){
		for (int i : a){
			if (i == regex){
				return true;
			}
		}
		return false;
	}

}
