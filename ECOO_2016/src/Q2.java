import java.util.*;
import java.io.*;


public class Q2 {
	
	static ArrayList<Integer> spinner;
	static HashSet<Integer> checkList;
	static HashSet<Integer> doubles;
	static int[] targets;
	static ArrayList<Integer> multiples;
	static ArrayList<Integer> secondMultiples;
	static int N;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("DATA21.txt"));
		int temp;
		for (int i = 0; i < 10; i++){
			
			N = reader.nextInt();
			spinner = new ArrayList<Integer>(N);
			checkList = new HashSet<Integer>(N);
			for (int j = 0; j < N; j++){
				temp = reader.nextInt();
				spinner.add(temp);
				checkList.add(temp);
			}
			
			targets = new int[5];
			for (int j = 0; j < 5; j++){
				targets[j]=reader.nextInt();
			}
			
			doubles = new HashSet<Integer>(N*(N-1)/2);
			for (int j = 0; j < N-1; j++){
				for (int k = 1; k < N; k++){
					doubles.add(spinner.get(j)+spinner.get(k));
				}
			}
			
			multiples = new ArrayList<Integer>();
			secondMultiples = new ArrayList<Integer>();
			
			for (int j = 0; j < 5; j++){
				multiples.clear();
				secondMultiples.clear();
				if (check3(targets[j])){
					System.out.print("T");
				}else{
					System.out.print("F");
				}
			}
			System.out.println();
		}
	}
	
	public static boolean check3(int target){
		for (int i = 0; i < N; i++){
			if (target%spinner.get(i)==0){
				multiples.add(spinner.get(i));
			}
		}
		
		for (int i = 0; i < multiples.size(); i++){
			if ((target%multiples.get(i)==0)&&check2(target/multiples.get(i))){
				//System.out.println("CHECK1ONE: "+multiples.get(i));
				return true;
			}
		}
		
		for (int i = 0; i < N; i++){
			if (check2(target - spinner.get(i))){
				//System.out.println("CHECK1TWO: "+spinner.get(i));
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean check2(int target){
		
		if (doubles.contains(target)){
			return true;
		}
		
		for (int i = 0; i < multiples.size(); i++){
			if ((target%multiples.get(i)==0)&&multiples.contains(target/multiples.get(i))){
				//System.out.println("CHECK2ONE: "+secondMultiples.get(i)+" TARGET: "+target+" RESULT: "+target/secondMultiples.get(i));
				return true;
			}
		}
		
		return false;
	}

}
