package random;

public class Mods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < 200; i++){
			System.out.print(i+": ");
			for (int j = 2; j < 100; j++){
				System.out.print(i%j+" ");
				sum+= i%j;
			}
			System.out.print("For: "+i+" Sum: "+sum);
			System.out.println();
			sum = 0;
		}
	}

}
