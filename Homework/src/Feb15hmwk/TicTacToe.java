package Feb15hmwk;
import java.util.Scanner;
public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[][] board = new String[3][3];
		String winGuy = "None";
		String turn = "X";
		int dropX;
		int dropY;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				board[i][j] = " ";
			}
		}
		for (int i = 0; i < 3; i++){
			System.out.print("|");
			for (int j = 0; j < 3; j++){
				System.out.print(board[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		while (winGuy == "None"){
			System.out.printf("%s's turn! /n", turn);
			System.out.println("Enter row and column of piece, separated by spaces: ");
			dropY = scan.nextInt();
			dropX = scan.nextInt();
			if (board [dropY][dropX] == " "){
				board [dropY][dropX] = turn;
			}else{
				System.out.println("Space taken!");
				continue;
			}
			
		}
	}

}
