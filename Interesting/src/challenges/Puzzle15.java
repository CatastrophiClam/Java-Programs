package challenges;
import java.io.*;

public class Puzzle15 {
	
	static int[][]game = new int[4][4];

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		
		String[] temp = new String[5];
		int oi,oj;	//coords of hole
		oi = 0;
		oj = 0;
		int outOfPlace = 0; //number of out of place tiles
		
		for (int i = 0; i < 4; i++){
			temp = reader.readLine().split(" ");
			for (int j = 0; j < 4; j++){
				game[i][j]= Integer.parseInt(temp[j]);
				if (game[i][j]==0){
					oi=i;
					oj=j;
				}
				if (game[i][j]!=4*i+j){
					outOfPlace++;
				}
			}
		}
		char[]moves = new char[60];
		if (find(moves, 'n', 0, outOfPlace,oi,oj)){
			for (int i = 0; i < moves.length; i++){
				writer.print(moves[i]);
			}
		}else{
			writer.print("No solution");
		}
	}
	
	public static boolean swap(int i, int j, int i1, int j1){
		if (i1 < 4 && j1 < 4 && i1 >= 0 && j1 >= 0){
			int temp = game[i][j];
			game[i][j]=game[i1][j1];
			game[i1][j1] = temp;
			return true;
		}else{
			return false;
		}
		
	}
	
	public static boolean isDone(){
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				if (game[i][j]!=4*i+j){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean find(char[] moves, char lastMove, int numMoves, int outOfPlace, int oi, int oj){
		if (outOfPlace == 0){
			//check if game is done
			if (isDone()){
				return true;
			}else{
				outOfPlace = 0;
				for (int i = 0; i < 4; i++){
					for (int j = 0; j < 4; j++){
						if (game[i][j]!=4*i+j){
							outOfPlace++;
						}
					}
				}
			}
		}else{
			outOfPlace--;
		}
		if (numMoves<50){
			numMoves++;
			if (lastMove != 'U'){
				if (swap(oi,oj,oi-1,oj)){
					moves[numMoves-1]='U';
					if (find(moves,'U',numMoves,outOfPlace,oi-1,oj)){
						return true;
					}
					swap(oi,oj,oi-1,oj);
				}
			}
			if (lastMove != 'D'){
				if (swap(oi,oj,oi+1,oj)){
					moves[numMoves-1]='D';
					if (find(moves,'D',numMoves,outOfPlace,oi+1,oj)){
						return true;
					}
					swap(oi,oj,oi,oj+1);
				}
			}
			if (lastMove != 'L'){
				if (swap(oi,oj,oi,oj-1)){
					moves[numMoves-1]='L';
					if (find(moves,'L',numMoves,outOfPlace,oi,oj-1)){
						return true;
					}
					swap(oi,oj,oi,oj-1);
				}
			}
			if (lastMove != 'R'){
				if (swap(oi,oj,oi,oj+1)){
					moves[numMoves-1]='R';
					if (find(moves,'R',numMoves,outOfPlace,oi,oj+1)){
						return true;
					}
					swap(oi,oj,oi,oj+1);
				}
			}
			
		}else{
			return false;
		}
		return false;
	}

}
