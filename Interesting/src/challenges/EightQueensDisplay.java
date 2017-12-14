package challenges;



public class EightQueensDisplay{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		EightQueensIterativeLogic logic = new EightQueensIterativeLogic(n);
		int[] position = new int[n];
		int start = 0;
		int count = 0;
		for (int k = 5; k < 20; k++){
			logic.setN(k);
			position = new int[k];
			n = k;
			logic.find(start,position);
			System.out.println(k+" queens: ");
			if (start!=-1){
				for (int i = 0; i < n; i++){
					for (int j = 0; j < n; j++){
						if (position[j]==i){
							System.out.print("M.");
						}else{
							System.out.print("_.");
						}
					}
					System.out.println();
				}
			}else{
				break;
			}
			System.out.printf("\n\n");
		}
	}
	
}

