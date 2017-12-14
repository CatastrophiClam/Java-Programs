package random;
import java.lang.Math;
import java.util.*;

public class PrimeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p = 103;
		int q = 61;
		int n = p*q;
		
		int[] pArray = {97, 101, 103, 107, 109, 113, 127, 131};
		int[] qArray = {61, 61, 61, 61, 61, 61, 61, 61};
		int[] nArray = new int[pArray.length];
		for (int i = 0; i < pArray.length; i++){
			nArray[i] = pArray[i]*qArray[i];
		}
		ArrayList<ArrayList<double[]>> all = new ArrayList<ArrayList<double[]>>();
		
		double t1, t2, k1, k2;
		for (int i = 0; i < pArray.length; i++){
			ArrayList<double[]> temp = new ArrayList<double[]>();
			for (int d = 0; d < (pArray[i]-qArray[i])*2; d+=2){
				t1 = Math.sqrt(d*d+4*nArray[i]);
				t2 = nArray[i]-Math.sqrt(d*d+4*nArray[i])+1;
				k1 = Math.floor(t1);
				k2 = Math.ceil(t1);
				temp.add(new double[]{d*d+4*nArray[i]-Math.pow((k1%2==0)?k1:--k1, 2),(Math.pow((k2%2==0)?k2:--k2, 2)-d*d+4*n)});
				//System.out.println(d*d+4*n-Math.pow((k1%2==0)?k1:--k1, 2)+", "+(Math.pow((k2%2==0)?k2:--k2, 2)-d*d+4*n));
			}
			all.add(temp);
		}
		int count = 1;
		for (int i = 0; i < pArray.length; i++){
			ArrayList<double[]> current = all.get(i);
			System.out.println("n: "+nArray[i]);
			
			//print starts
			System.out.print("Starts:        ");
			System.out.printf("%-6.1f ", current.get(0)[0]);
			for (int j = 1; j < current.size(); j++){
				if (current.get(j)[0] < current.get(j-1)[0]){
					System.out.printf("%-6.1f ", current.get(j)[0]);
				}
			}
			System.out.println();
			
			//print lengths
			System.out.print("Lengths:       ");
			for (int j = 1; j < current.size(); j++){
				if (current.get(j)[0] > current.get(j-1)[0]){
					count++;
					if (j == current.size()-1){
						System.out.printf("%-6d ",count);
						count = 1;
					}
				}else{
					System.out.printf("%-6d ",count);
					count = 1;
				}
			}
			System.out.println();
			
			//print accelerations
			System.out.print("Accelerations: ");
			count = 1;
			for (int j = 1; j < current.size(); j++){
				if (current.get(j)[0] > current.get(j-1)[0]){
					count++;
				}else{
					if (count > 2){
						System.out.printf("%-6.1f ",(current.get(j-1)[0]-current.get(j-2)[0])-(current.get(j-2)[0]-current.get(j-3)[0]));
						count = 1;
					}else{
						count = 1;
						System.out.print("NONE   ");
					}
				}
			}
			System.out.println();
			System.out.println();
		}
		/**
		for (int i = 0; i < all.get(0).size(); i++){
			System.out.println(all.get(0).get(i)[0]);
		}
		**/
	}

}
