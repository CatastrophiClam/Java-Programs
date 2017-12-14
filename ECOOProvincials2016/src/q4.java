import java.util.*;
import java.io.*;
import java.lang.Math;
public class q4 {
	static HashMap<Integer,String> visited;
	static ArrayList<Integer> intsAvailable;
	static ArrayList<Character> opsAvailable;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(new File("DATA42.txt"));
		BufferedWriter writer = new BufferedWriter(new PrintWriter(new File("OUTPUT42.txt")));
		String buttons;
		int N; 
		
		for (int c = 0; c < 10; c++){
			try{
			buttons = reader.nextLine();
			N = Integer.parseInt(reader.nextLine());
			visited = new HashMap<Integer,String>();
			intsAvailable=new ArrayList<Integer>();
			opsAvailable=new ArrayList<Character>();
			
			for (int i = 0; i < buttons.length(); i++){
				if (buttons.charAt(i)>= '0'&& buttons.charAt(i)<='9'){
					intsAvailable.add(Integer.parseInt(buttons.substring(i,i+1)));
				}else{
					opsAvailable.add(buttons.charAt(i));
				}
			}
			if (find(N)){
				System.out.println(visited.get(N)+" +");
				writer.write(visited.get(N)+" +");
			}else{
				System.out.println("no idea");
				writer.write("no idea");
			}
			}catch(Error e){
				System.out.println("no idea");
				writer.write("no idea");
				continue;
			}
			
		}
		reader.close();
		writer.close();
		System.exit(0);
		
	}
	
	public static boolean find(int N){
		String answer = "";
		
		String str = String.valueOf(N);
		
		//check if number can be typed
		boolean containsAll = true;
		for (int i = 0; i < str.length(); i++){
			if (!intsAvailable.contains(str.charAt(i))){
				containsAll = false;
				break;
			}
		}
		if (containsAll){
			for (int i = 0; i < str.length(); i++){
				answer += str.charAt(i);
				answer += " ";
			}
			visited.put(N,answer);
			return true;
		}
		
		if (opsAvailable.contains('*')){
			ArrayList<int[]> factors = findFactors(N);
			for (int[] i:factors){
				if (find(i[0])&&find(i[1])){
					answer = visited.get(i[0])+" ms "+visited.get(i[1])+" * mr";
					visited.put(N, answer);
					return true;
				}
			}
		}
		/**
		if (opsAvailable.contains('s')){
			int temp = (int)Math.sqrt(N);
			if (N%temp == 0){
				if (find(temp)){
					answer = visited.get(temp)+" ms mr s";
					return true;
				}
			}
		}
		**/
		
		if (opsAvailable.contains('+')){
			for (int i : intsAvailable){
				if (i!=0)
				if (N%i == 0){
					for (int j= 0; j < N/i-1; j++){
						answer += i+" + ";
					}
					answer += i;
					visited.put(N, answer);
					return true;
				}
			}
		}
		
		visited.put(N, "");
		return false;
	}
	
	public static ArrayList<int[]> findFactors(int n){
		ArrayList<int[]>answer = new ArrayList<int[]>();
		for (int i = 2; i < Math.sqrt(n)+1; i++){
			if (n%i==0){
				answer.add(new int[]{i,n/i});
			}
		}
		return answer;
	}

}
