
public class Chopsticks {
	
	private static int[][][][][] positions = new int[5][5][5][5][2];// 0 = unvisited, 1 = visited, 2 = win, 3 = lose, for player with a and b

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int a = 0; a < 5; a++){
			for (int b = 0; b < 5; b++){
				for (int c = 0; c < 5; c++){
					for (int d = 0; d < 5; d++){
						if (a == 0 && b == 0){
							positions[a][b][c][d][0] = 3;
							if (c == 0 && d == 0){
								positions[a][b][c][d][0] = 1;
							}
						}else if(c == 0 && d == 0){
							positions[a][b][c][d][0] = 2;
						}else{
							positions[a][b][c][d][0] = find(a,b,c,d, 1);
						}
					}
				}
			}
		}
		System.out.println(positions[1][1][1][1][0]);
			
	}
	
	public static int find(int a, int b, int c, int d, int turn){
		if (positions[a][b][c][d][turn]!= 0){
			return positions[a][b][c][d][turn];
		}
		positions[a][b][c][d][turn] = 1; //visited
		int result;
		if (turn == 0){
			result = process(a,b,c,d, 1-turn);
		}else{
			result = process(c,d,a,b, 1-turn);
		}
		positions[a][b][c][d][turn] = result;
		return result;
	}
	
	public static int process(int a, int b, int c, int d, int turn){
		boolean tie = false;
		int num;
		int ver;
		
		num = c+a;
		if (num > 4){
			num = 0;
		}
		ver = find(a,b,num,d,turn);
		if (ver == 2){
			return 2;
		}else if(ver == 1){
			tie = true;
		}
		
		num = c+b;
		if (num > 4){
			num = 0;
		}
		ver = find(a,b,num,d,turn);
		if (ver == 2){
			return 2;
		}else if(ver == 1){
			tie = true;
		}
		
		num = d+a;
		if (num > 4){
			num = 0;
		}
		ver = find(a,b,c,num,turn);
		if (ver == 2){
			return 2;
		}else if(ver == 1){
			tie = true;
		}
		
		num = d+b;
		if (num > 4){
			num = 0;
		}
		ver = find(a,b,c,num,turn);
		if (ver == 2){
			return 2;
		}else if(ver == 1){
			tie = true;
		}
		
		
		
		if (tie) return 1;
		
		return 3;
	}

}
