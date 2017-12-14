package special;

public class MultipleForLoopImitator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//to iterate over an n dimensional array:
		int n = 10;
		int[] position = new int[n]; //position[0] changes the fastest
		for (int i = 0; i < Math.pow(n, n);i++){
			for (int j = 0; j < n; j++){
				position[j]=(i/(int)(Math.pow(n,j)))%n;
			}
		}
		
		//for combinations take C from N without repeats:
		
		//with nested for loops:
		n = 10;
		int c = 4;
		for (int i = 0; i < n-c+1;i++){
			for (int j = i+1; j < n-c+2;j++){
				for (int k = j+1; k<n-c+3;k++){
					for (int l = k+1; l < n-c+4; l++){
						
					}
				}
			}
		}
		
		//with one for loop

	}

}
