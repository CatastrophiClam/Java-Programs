import java.util.*;
import java.io.*;
import java.lang.Math;
public class s3 {
	static int[][]people = new int[50][50];
	static int[] friends = new int[50];

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("In"));
		String[] input = new String[5];
		HashSet<Integer>fOF = new HashSet<Integer>();
		int x,y;
		while (true){
			input = reader.nextLine().split(" ");
			if (input[0].equals("q")){
				break;
			}
			if (input[0].equals("i")){
				x = Integer.parseInt(input[1]);
				y = Integer.parseInt(input[2]);
				if (people[x][y]!=1){
					people[x][y] = 1;
					people[y][x] = 1;
					friends[x]++;
					friends[y]++;
				}
			}else if(input[0].equals("d")){
				x = Integer.parseInt(input[1]);
				y = Integer.parseInt(input[2]);
				if (people[x][y]!=0){
					people[x][y] = 0;
					people[y][x] = 0;
					friends[x]--;
					friends[y]--;
				}
			}else if(input[0].equals("n")){
				x = Integer.parseInt(input[1]);
				System.out.println("Friends of "+x+": "+friends[x]);
			}else if(input[0].equals("f")){
				x = Integer.parseInt(input[1]);
				for (int i = 0; i < 50; i ++){
					if (people[x][i]==1){
						for (int j = 0; j < 50; j++){
							if (people[i][j]==1&&people[x][j]!=1&&!fOF.contains(j)){
								fOF.add(j);
							}
						}
					}
				}
				System.out.println(x+" has "+fOF.size()+" friends of friends!");
				fOF.clear();
			}else if(input[0].equals("s")){
				x = Integer.parseInt(input[1]);
				y = Integer.parseInt(input[2]);
				System.out.println("The degree of separation between "+x+" and "+y+" is: "+bfs(x,y));
			}
		}
	}
	
	public static int bfs(int a, int b){
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		int count = 0; 
		int tempCount = 0;
		queue.add(a);
		int current;
		while(!queue.isEmpty()){
			current = queue.remove();
			if (tempCount!=0){
				tempCount--;
			}
			for (int i = 1; i < 50; i++){
				if (people[current][i]==1){
					if (!visited.contains(i)){
						visited.add(i);
						if (i==b){
							return count+1;
						}else{
							queue.add(i);
						}
					}
				}
			}
			
			if (tempCount==0){
				count++;
				tempCount=queue.size();
			}
		}
		return -1;
	}

}


