import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static ArrayList<Integer>balls;
	static HashMap<ArrayList<Integer>,Integer> visited;
	static int timesRun = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		N = reader.nextInt();
		balls = new ArrayList<Integer>();
		visited = new HashMap<ArrayList<Integer>,Integer>();
		for (int i = 0; i < N; i++){
			balls.add(reader.nextInt());
		}
		System.out.println(eval());
	}
	
	public static int eval(){
		int max = 0;
		int tempMax;
		int temp1, temp2;
		if (visited.containsKey(balls)){
			return visited.get(balls);
		}
		
		//timesRun++;
		//System.out.println(timesRun+": "+balls);
		
		for (int i = 0; i < balls.size(); i++){
			if (balls.get(i)>max){
				max = balls.get(i);
			}
			if (i <balls.size()-1&&balls.get(i).equals(balls.get(i+1))){
				temp1 = balls.get(i);
				balls.remove(i);
				balls.remove(i);
				balls.add(i,temp1*2);
				tempMax = eval();
				if (tempMax > max){
					max = tempMax;
				}
				balls.remove(i);
				balls.add(i,temp1);
				balls.add(i,temp1);
			}
			if (i < balls.size()-2&&balls.get(i).equals(balls.get(i+2))){
				temp1 = balls.get(i);
				temp2 = balls.get(i+1);
				balls.remove(i);
				balls.remove(i);
				balls.remove(i);
				balls.add(i,temp1*2+temp2);
				tempMax = eval();
				if (tempMax > max){
					max = tempMax;
				}
				balls.remove(i);
				balls.add(i,temp1);
				balls.add(i,temp2);
				balls.add(i,temp1);
			}
		}
		visited.put(balls, max);
		return max;
	}
	

}
