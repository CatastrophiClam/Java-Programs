import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class s4 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("testing");
		Scanner reader = new Scanner(file);
		int thick;
		int numIslands;
		int numRoutes;
		int a;
		int b;
		int t;
		int h;
		String bestTime = "-1";
		int[][][]all; //third array: haspath, time, damage
		thick = reader.nextInt();
		numIslands = reader.nextInt();
		numRoutes = reader.nextInt();
		all = new int[numIslands][numIslands][3];
		for (int i = 0; i < numRoutes; i++){
			a = reader.nextInt()-1;
			b = reader.nextInt()-1;
			t = reader.nextInt();
			h = reader.nextInt();
			all[a][b][0] = 1;// one signals theres a path
			all[a][b][1] = t;//time
			all[a][b][2] = h;//damage
		}
		a = reader.nextInt()-1;
		b = reader.nextInt()-1;
		System.out.print(Do(a,0,0,b,all, bestTime, thick));
	}
	
	public static int Do(int which, int timetaken, int damageTaken, int goal, int[][][]all, String bestTime, int maxDamage){
		ArrayList<Integer> neighbours = findN(which,all);
		int time;
		int damage;
		if (neighbours.contains(goal)){
			time = all[which][goal][1] + timetaken;
			damage = all[which][goal][2];
			if (damage + damageTaken < maxDamage){
				if (Integer.parseInt(bestTime)!=-1){
					if (time < Integer.parseInt(bestTime)){
						bestTime = String.valueOf(time);
					}
				}else{
					bestTime = String.valueOf(time);
				}
			}
		}else{
			for (int i = 0; i < neighbours.size(); i++){
				time = all[which][neighbours.get(i)][1];
				damage = all[which][neighbours.get(i)][2];
				if (damage + damageTaken < maxDamage){
					Do(neighbours.get(i), timetaken+time, damage+damageTaken, goal, all, bestTime, maxDamage);
				}
			}
		}
		return Integer.parseInt(bestTime);
	}
	
	public static ArrayList<Integer> findN(int which, int[][][]all){
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		for (int z = 0; z<all[which].length;z++){
			int[]i = all[which][z];
			if (i[0]==1){
				neighbours.add(z);
			}
		}
		return neighbours;
	}

}
