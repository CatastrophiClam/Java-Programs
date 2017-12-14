package ccc;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;
public class s3_2011 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int T = Integer.parseInt(reader.nextLine());
		//Logic logic = new Logic();
		int x;
		int y;
		int m;
		for (int i = 0; i < T; i++){
			m = reader.nextInt();
			x = reader.nextInt();
			y = reader.nextInt();
			while (true){
				if (x >= Math.pow(5, m)/5 && x < 4*Math.pow(5, m)/5){
					if (y < Math.pow(5, m)/5){
						System.out.println("Crystal");
						break;
					}else if(y < 2*Math.pow(5,m)/5){
						if (x >= 2*Math.pow(5, m)/5 && x < 3*Math.pow(5, m)/5){
							System.out.println("Crystal");
							break;
						}else{
							x = x%(int)(Math.pow(5,m));
							y = y%(int)(Math.pow(5,m));
							m--;
							if (m == 0){
								if (((x==1 || x==2||x==3)&&y==0)||(x==2&&y==1)){
									System.out.println("Crystal");
								}else{
									System.out.println("Empty");
								}
								break;
							}
						}
					}else if(y < 3*Math.pow(5,m)/5 && x >= 2*Math.pow(5, m)/5 && x < 3*Math.pow(5, m)/5){
						x = x%(int)(Math.pow(5,m));
						y = y%(int)(Math.pow(5,m));
						m--;
						if (m == 0){
							if (((x==1 || x==2||x==3)&&y==0)||(x==2&&y==1)){
								System.out.println("Crystal");
							}else{
								System.out.println("Empty");
							}
							break;
						}
					}else{
						System.out.println("Empty");
						break;
					}
				}else{
					System.out.println("Empty");
					break;
				}
			}
		}
		
		class Logic{
			//public boolean check(int x, int y, int m){
				
			//}
		}
	}

}
