package ccc;
import java.util.*;
import java.io.*;
import java.lang.Math;

public class s5_2000 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		int numSheep = reader.nextInt();
		ArrayList<Sheep> danger = new ArrayList<Sheep>();
		double x,y;
		Sheep temp;
		
		ArrayList<Integer> toRemove = new ArrayList<Integer>();
		int tempSize;
		
		//as the sheep are read in, compare them to each sheep in the danger array
		outer:
		for (int i = 0; i < numSheep; i++){
			x = reader.nextDouble();
			y = reader.nextDouble();
			temp = new Sheep(x,y);  //current sheep
			for (int j = 0; j < danger.size(); j++){
				//if the distance from the current sheep to the point directly below (south) the sheep being compared
				//is smaller than the distance from the compared sheep to that point, the current sheep is in danger and the other
				//isn't
				if (dist(temp.x,temp.y,danger.get(j).x,0)<danger.get(j).y){
					toRemove.add(j);
					danger.add(temp);
				}else if(dist(danger.get(j).x,danger.get(j).y,temp.x,0)<temp.y){
					continue outer;
				}
			}
			tempSize = toRemove.size();
			for (int j = 0; j < tempSize; j++){
				danger.remove(toRemove.get(j)-j);
			}
			toRemove.clear();
			danger.add(temp);
		}
		for (Sheep i:danger){
			System.out.println(i.x+" "+i.y);
		}
	}
	
	public static double dist(double x, double y, double x1, double y1){
		return Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
	}

}

class Sheep{
	double x,y;
	public Sheep(double x, double y){
		this.x = x;
		this.y = y;
	}
}
