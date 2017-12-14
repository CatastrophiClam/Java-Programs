package ccc;
import java.util.Scanner;
import java.io.*;

public class s4_2011 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int[] avaliable = new int[8];
		int[] wanted = new int[8];
		int totalNum = 0;
		for (int i = 0; i < 8; i++){
			avaliable[i] = reader.nextInt();
		}
		for (int i = 0; i < 8; i++){
			wanted[i] = reader.nextInt();
		}
		for (int i = 0; i < 2; i++){
			if (avaliable[i]>wanted[i]){
				avaliable[i]-=wanted[i];
				totalNum += wanted[i];
			}else{
				wanted[i] -= avaliable[i];
				totalNum += avaliable[i];
				avaliable[i] = 0;
				if (i==1){
					if (avaliable[0]>0){
						if (avaliable[0]>wanted[1]){
							avaliable[0] -= wanted[1];
							totalNum += wanted[1];
						}else{
							wanted[1] -= avaliable[0];
							totalNum += avaliable[0];
							avaliable[0] = 0;
						}
					}
				}
			}
		}
		System.out.print(totalNum);
	}

}
