import java.util.*;
import java.io.*;
public class q2 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("DATA22.txt"));
		int Aw = 0;
		int Ah = 0;
		int Bx = 0;
		int By = 0;
		int Sx = 0;
		int Sy = 0;
		int Tx = 0;
		int Ty = 0;
		int Th = 0;
		double m = 0;
		double b = 0;
		double yAtTx = 0;
		
		for (int c = 0; c < 10; c++) { //change this to < 10 later
			Aw = in.nextInt();
			Ah = in.nextInt();
			Bx = in.nextInt();
			By = in.nextInt();
			Sx = in.nextInt();
			Sy = in.nextInt();
			in.nextLine();
			
			m = (double)Sy/(double)Sx;
			b = (double)By - m * (double)Bx;
			
			for (int i = 0; i < 5; i++) {
				Th = in.nextInt();
				Tx = in.nextInt();
				Ty = in.nextInt();
				in.nextLine();
				
				yAtTx = m*Tx + b;
				
				int currentTy = Ty;
				int counter = 0;
				boolean flag = true;
				if (Sx == 0) {
					flag = false;
				} else if (m >= 0) {	
					while (!(yAtTx <= currentTy && yAtTx >= currentTy - Th)) {
						if (counter % 2 == 0) {
							currentTy += 2*(Ah - Ty) + Th;
						} else {
							currentTy += 2*(Ty - Th) + Th;
						}
						if (yAtTx < currentTy - Th) {
							flag = false;
							break;
						}
						counter++;
					}
				} else if (m < 0) {
					while (!(yAtTx <= currentTy && yAtTx >= currentTy - Th)) {
						if (counter % 2 != 0) {
							currentTy -= 2*(Ah - Ty) + Th;
						} else {
							currentTy -= 2*(Ty - Th) + Th;
						}
						if (yAtTx > currentTy) {
							flag = false;
							break;
						}
						counter++;
					}
				}
				if (flag) {
					System.out.printf("H");
				} else {
					System.out.printf("M");
				}
			}
			
			System.out.printf("\n");
		}

	}
}
