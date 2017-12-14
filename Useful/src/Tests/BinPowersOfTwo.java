package Tests;

public class BinPowersOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 30; i++){
			System.out.println(i+1+": "+toBinary((int)(Math.pow(2, i))));
		}
	}
	
	public static String toBinary(int a){
		int rem;
		String result = "";
		
		while (a>0){
			rem = (a%2);
			a = a/2;
			result = String.valueOf(rem)+result;
		}
		return result;
	}

}
