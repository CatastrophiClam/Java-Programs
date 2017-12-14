package jan18hmwk;

public class LockerPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean [] lockers = new boolean[100];
		for (int i = 0; i<100; i++){
			lockers[i] = false;     // false means closed
		}
		for (int i = 0; i < 100; i++){
			for (int j = i+1; j <= 100; j += j){
				if (lockers[j-1]){
					lockers[j-1] = false;
				}else{
					lockers[j-1] = true;
				}
			}
		}
		System.out.print("Open lockers: ");
		for (int i = 0; i < 100; i++){
			if (lockers[i]){
				System.out.print((i+1)+" ");
			}
		}
	}

}
