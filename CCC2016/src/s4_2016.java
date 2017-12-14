import java.util.*;
import java.io.*;
public class s4_2016 {
	static int N;
	static ArrayList<Integer>balls;
	static HashMap<ArrayList<Integer>,Integer> visited;
	static int timesRun = 0;
	static int checks = 0;
	static int baseCases = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test"));
		N = reader.nextInt();
		balls = new ArrayList<Integer>();
		visited = new HashMap<ArrayList<Integer>,Integer>();
		String rep = "";
		for (int i = 0; i < N; i++){
			balls.add(reader.nextInt());
			rep+=String.valueOf(balls.get(i));
		}
		StopWatch watch = new StopWatch();
		watch.start();
		System.out.println(eval());
		watch.stop();
		System.out.println("Time: "+watch.timeElapsed());
		System.out.println("Iterations: "+timesRun);
		System.out.println("Calls: "+checks);
		System.out.println("Base cases: "+baseCases);
		//System.out.println(visited);
	}
	
	public static int eval(){
		int max = 0;
		int tempMax;
		int temp1, temp2;
		checks++;
		if (visited.containsKey(balls)){
			return visited.get(balls);
		}
		
		timesRun++;
		//System.out.println(timesRun+": "+balls);
		boolean isBaseCase = true;
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
				isBaseCase = false;
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
				isBaseCase = false;
			}
		}
		if(isBaseCase){
			baseCases++;
		}
		visited.put(balls, max);
		//System.out.println(balls+": "+max);
		return max;
	}
	

}
