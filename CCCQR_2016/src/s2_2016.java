import java.util.*;
import java.io.*;
public class s2_2016 {
	static int numV;
	static int count;
	static boolean End;
	static HashMap<Integer,ArrayList<Integer>> map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Test"));
		numV = scan.nextInt();
		map = new HashMap<Integer,ArrayList<Integer>>();
		
		int nChildren, temp;
		for (int i = 1; i <= numV; i++){
			map.put(i, new ArrayList<Integer>());
			nChildren = scan.nextInt();
			for (int j = 0; j < nChildren; j++){
				temp = scan.nextInt();
				map.get(i).add(0,temp);
			}
		}
		
		int Q = scan.nextInt();
		int start;
		int max;
		for (int i = 0; i < Q; i++){
			End = false;
			count = 0;
			max = 0;
			start = scan.nextInt();
			System.out.println("FIND "+start);
			for (int j = 0; j < map.get(start).size(); j++){
				End = false;
				dfs(start,map.get(start).get(j),start);
				if (count > max){
					max = count;
				}
				count = 0;
			}
			System.out.println(max);
		}
	}
	
	public static void dfs(int from, int start, int end){
		if (End){
			return;
		}
		System.out.println("Visited "+start);
		count++;
		if (from == -1){
			dfs(start,map.get(start).get(0),end);
		}else{
			ArrayList<Integer> currentChildren = map.get(start);
			if (currentChildren.size()==1){
				count++;
				return;
			}
			int startIndex = linSearch(from,currentChildren);
			int i = startIndex;
			//System.out.println("StartIndex: "+startIndex);
			while(true){
				i++;
				i = i%currentChildren.size();
				if (i == startIndex){
					count++;
					return;
				}
				if (currentChildren.get(i).equals(end)){
					End = true;
					return;
				}else{
					dfs(start,currentChildren.get(i),end);
				}
			}
		}
	}
	
	public static int linSearch(int a, ArrayList<Integer> list){
		for (int i = 0; i < list.size(); i++){
			if (list.get(i)==a){
				return i;
			}
		}
		return -1;
	}

}
