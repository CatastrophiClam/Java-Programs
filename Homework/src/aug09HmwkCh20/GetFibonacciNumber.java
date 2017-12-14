package aug09HmwkCh20;

public class GetFibonacciNumber {
	
	public GetFibonacciNumber(){
		
	}
	
	public int getTerm(int n){
		int int1 = 0;
		int int2 = 1;
		int total = 1;
		for (int i = 0; i < n-2; i++){
			total = int1 + int2;
			int1 = int2;
			int2 = total;
		}
		return total;
	}
}
