package Feb15hmwk;
import java.util.Scanner;
import java.util.ArrayList;
public class Connectfour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[][]board = new String[6][7];   // playing board
		String turn = "red";      // player red's turn?
		String winGuy = "None";
		int dropColumn;     // column disk is dropped in
		boolean canDrop;
		for (int i = 0; i < 6; i++){   // init board
			for (int j = 0; j < 7; j++)
				board[i][j] = " ";
		}
		for (int i = 0; i < 6; i++){
			System.out.print("|");
			for (int j = 0; j < 7; j++){
				System.out.print(board[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		while (winGuy == "None"){
			canDrop = false;
			System.out.printf("Drop a %s disk at column (0-6): %n", turn); // prompt for column drop number
			dropColumn = scan.nextInt();
			for (int i = 5; i >= 0; i --){         // check board to see if the disk can be dropped
				if (board[i][dropColumn] == " "){    // if it can, drop it
					if (turn == "red"){  // drop color accord to turn
						board[i][dropColumn] = "R";
						canDrop = true;
						break;
					}else{
						board[i][dropColumn] = "Y";
						canDrop = true;
						break;
					}
				}
			}
			if (!canDrop){                          // if it can't get user to enter another column number
				System.out.println("Column full.");
				continue;
			}
			for (int i = 0; i < 6; i++){   // print the board
				System.out.print("|");
				for (int j = 0; j < 7; j ++){
					System.out.print(board[i][j]+"|");
				}
				System.out.println();
			}
			if (checkWin(board)){          // check for a win
				winGuy = turn;
				System.out.println(winGuy + " wins!");
			}else if (checkTie(board)){    // check for a tie
				winGuy = "Tie";
				System.out.println("Tie");
			}else{                       // otherwise next turn
				if (turn == "red"){
					turn = "yellow";
				}else{
					turn = "red";
				}
			}
		}
	}
	
	public static boolean checkWin(String[][]board){
		ArrayList<String> tempArray = new ArrayList<String>();
		String[] temp;
		int[][][] coords = new int[][][]{{{0,3}, {0, 4}, {0, 5}, {5, 3}, {5, 4}, {5,5}}, {{0, 1}, {0,2}, {0,3}, {5, 1}, {5, 2}, {5, 3}}};
		for (String[]i : board){   // check every row
			if (checkArray(i))
				return true;
		}
		for (int i = 0; i < 7; i++){  // check every column
			for (String[]j : board){
				tempArray.add(j[i]);
			}
			temp = tempArray.toArray(new String[tempArray.size()]);  // convert tempArray to array
			if (checkArray(temp)){
				return true;
			}
			tempArray.clear();  // clear tempArray
		}
		for (int i = 0; i < 2; i++){   // check all diagonals going left, then all diagonals going right
			for (int[] pair: coords[i]){
				tempArray = findDiagonal(board, pair[0], pair[1], i);
				temp = tempArray.toArray(new String[tempArray.size()]);
				if (checkArray(temp)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean checkArray(String[] array){
		int count = 0;
		String lastDisk = " ";
for (String i : array){
			if (i == lastDisk && i != " "){  // if the current disk is the same as the previous disk, add 1 to count
				count += 1;
			}else if (i != " "){
				count = 1;
				lastDisk = i;  // update lastDisk
			}
			if (count == 4){
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<String> findDiagonal(String[][]board, int y, int x, int val){  // val of 0 means check to the left, 1 means check to the right
		ArrayList<String> answer = new ArrayList<String>();
		answer.add(board[y][x]);
		if (val == 0){
			if (y == 0){  // top of square
				while (y + 1 <= 5 && x - 1 >= 0){
					y++;
					x--;
					answer.add(board[y][x]);
				}
			}else{
				while (y - 1 >= 0 && x - 1 >= 0){
					y--;
					x--;
					answer.add(board[y][x]);
				}
			}	
		}else{
			if (y == 0){  // top of square
				while (y + 1 <= 5 && x + 1 <= 6){
					y++;
					x++;
					answer.add(board[y][x]);
				}
			}else{
				while (y - 1 >= 0 && x + 1 <= 6){
					y--;
					x++;
					answer.add(board[y][x]);
				}
			}
		}
		return answer;
	}
	
	public static boolean checkTie(String[][]board){
		boolean full = true;    // assume board is full until proved otherwise
		for (int i = 0; i < 7; i++){  // only need to look at top of board
			if (board[0][i] == " ")
				full = false;
		}
		return full;
	}

}
