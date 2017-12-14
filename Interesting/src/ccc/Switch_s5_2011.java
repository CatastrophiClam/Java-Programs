package ccc;
import java.util.*;
import java.io.*;
import java.lang.Math;

public class Switch_s5_2011 {
	static HashSet<Integer> visited = new HashSet<Integer>();
	static ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
	static int k;
	static int count = 0; //number of switches needed to be flicked
	static int tempCounter = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);//new File("Files/In"));
		//read in info
		k = reader.nextInt();
		boolean[] lights = new boolean[k];
		for (int i = 0; i < k; i++){
			lights[i]=(reader.nextInt()==1);
		}
		queue.add(value(lights));
		//if all lights were off already
		if (queue.contains(0)){
			System.out.println("0");
			return;
		}
		find();
		System.out.println(count+1);
	}
	
	public static int value(boolean[]lights){
		int total = 0;
		for (int i = 0; i < lights.length; i++){
			if (lights[i]){
				total += (int)(Math.pow(2, i));
			}
		}
		return total;
	}
	
	public static boolean[] convert(int bin){
		boolean[] result = new boolean[k];
		for (int i = 0; i < k; i++){
			result[i] = ((bin%2)==1);
			bin = bin/2;
		}
		return result;
	}
	
	//returns true if lights are all off
	public static boolean process(boolean[]lights, int changed){
		int lCount = 0;
		int rCount = 0;
		int i = changed-1;
		while (i>=0){
			if (lights[i]){
				lCount++;
			}else{
				break;
			}
			i--;
		}
		i = changed+1;
		while(i<k){
			if (lights[i]){
				rCount++;
			}else{
				break;
			}
			i++;
		}
		//for (i = 0; i < k; i++){
		//	System.out.print(lights[i]+" ");
		//}
		//System.out.println();
		//System.out.println("Count: "+lCount+" "+rCount);
		int j;
		if (lCount+rCount+1>=4){
			lights[changed]=false;
			for (i = changed-1,j = 0; j < lCount; j++,i--){
				lights[i]=false;
			}
			for (i = changed+1,j=0;j<rCount;j++,i++){
				lights[i]=false;
			}
			for (i = 0; i < k; i++){
				if (lights[i]){
					return false;
				}
			}
			return true;
		}else{
			return false;
		}
	}
	
	//kinda like bfs
	public static void find(){
		boolean record = false;
		boolean[] lights;
		boolean[] tempLights = new boolean[k];
		int tempVal;
		while(!queue.isEmpty()){
			//process then next position
			int temp = queue.remove();
			visited.add(temp);
			lights = convert(temp);
			//System.out.println("Array: ");
			//for (int i = 0; i < k; i++){
			//	System.out.print(lights[i]+" ");
			//}
			//System.out.println();
			//System.out.println("Count: "+count+" TempCounter: "+tempCounter);
			
			if (tempCounter > 0){
				tempCounter--;
			}
			
			for (int i = 0; i < k; i++){
				if (!lights[i]){
					lights[i] = true;
					tempVal = value(lights);
					if (!visited.contains(tempVal)){
						for (int j = 0; j < k; j++){
							tempLights[j] = lights[j];
						}
						if (process(tempLights,i)){
							return;
						}
						queue.add(value(tempLights));
					}
					lights[i] = false;
				}
			}
			if (tempCounter==0){
				count++;
				tempCounter = queue.size();
			}
		}
	}

}
