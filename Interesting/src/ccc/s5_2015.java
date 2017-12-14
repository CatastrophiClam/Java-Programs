package ccc;
import java.util.*;
import java.io.*;
import java.lang.Math;

public class s5_2015 {
	static ArrayList<Integer> odd = new ArrayList<Integer>();
	static ArrayList<Integer> even = new ArrayList<Integer>();
	static ArrayList<Integer> nPies = new ArrayList<Integer>();
	static ArrayList<Integer> mPies = new ArrayList<Integer>();
	static int N,M;
	static int[][] maxSugars;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		N = reader.nextInt();
		int numIn;
		for (int i = 0; i < N; i++){
			numIn = reader.nextInt();
			if (i%2==0){
				even.add(numIn);
			}else{
				odd.add(numIn);
			}
			nPies.add(numIn);
		}
		maxSugars = new int[N][2]; //the ith position contains the total max sugar obtainable from pie i to n-1 inclusive.
		//0 indicates excluding ith pie and 1 indicates including ith pie
		M = reader.nextInt();
		for (int i = 0; i < M; i++){
			mPies.add(reader.nextInt());
		}
		mPies.sort(null);
		System.out.println(maxSugar(0,0,true));
	}
	
	public static int max(int a, int b){
		if (a > b){
			return a;
		}
		return b;
	}
	
	//start indicates which pie we start evaluating from
	//parity indicates "odd" pies or "even" pies
	//include indicates whether we can include start in our calculations or not
	public static int maxSugar(int start, int parity, boolean include){
		int maximum = -1;
		int tempMax;
		//check if value exists already
		if (include){
			if (maxSugars[start][1]!=0){
				return max(maxSugars[start][1],maxSugar(start,parity,false));
			}
		}else{
			if (maxSugars[start][0]!=0){
				return maxSugars[start][0];
			}
		}
		
		//check for base case
		if (start == N-1){
			if (include){
				maximum = nPies.get(start);
				for (int i = mPies.size()-1; i >mPies.size()-1-mPies.size()/2; i--){
					maximum += mPies.get(i);
				}
			}
			tempMax = 0;
			for (int i = mPies.size()-1; i >mPies.size()-1-Math.round(mPies.size()/2.0);i--){
				tempMax += mPies.get(i);
			}
			if (tempMax > maximum){
				maximum = tempMax;
			}
			maxSugars[start][0]=maximum;
			maxSugars[start][1]=maximum;
			return maximum;
		}
		if (include){
			maximum = nPies.get(start)+maxSugar(start+1,parity,false);
			if (mPies.size()>0){
				tempMax = nPies.get(start)+maxSugar(start+1,parity,false);
			}
		}
	}

}
