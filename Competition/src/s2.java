import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class s2 {
	/**
	 * Logic as follows: record number of small medium, and large jerseys
	 * For each request, give the smallest possible jersey with correct number
	 * If right fitting jersey is unavailible, give next largest size
	 * update number of jerseys and record the jersey number taken
	 * update maximum number of jerseys givable
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("s2.in");
		Scanner reader = new Scanner(file);
		int numJerseys = reader.nextInt();
		int numAthletes = reader.nextInt();
		int maxSatisfiable = 0;     // maximum number of satisfyable requests
		HashSet<Integer> set = new HashSet<Integer>();  // set recording all the jersey numbers we've used
		int numSmall=0;   // number of each type of jersey
		int numMed=0;
		int numLarge=0;
		String currentJersey;  // jersey we're currently looking at
		// read in all jersey types
		for (int i = 0; i < numJerseys; i++){
			currentJersey = reader.nextLine();
			if (currentJersey.equals("S")){
				numSmall++;
			}else if (currentJersey.equals("M")){
				numMed++;
			}else{
				numLarge++;
			}
		}
		reader.nextLine();
		String size;
		int number;
		// look at each request
		// if we can fullfill it, fullfill it
		for (int i = 0; i < numAthletes; i++){
			size = reader.nextLine();
			number = Integer.parseInt(size.substring(2,3));
			size = size.substring(0,1);
			if (size.equals("S")){
				if (numSmall > 0){
					if (!set.contains(number)){
						set.add(number);
						numSmall--;
						maxSatisfiable++;
					}
				}else if (numMed > 0){
					if (!set.contains(number)){
						set.add(number);
						numMed--;
						maxSatisfiable++;
					}
				}else if (numLarge > 0){
					if (!set.contains(number)){
						set.add(number);
						numLarge--;
						maxSatisfiable++;
					}
				}
			}else if (size.equals("M")){
				if (numMed > 0){
					if (!set.contains(number)){
						set.add(number);
						numMed--;
						maxSatisfiable++;
					}
				}else if (numLarge > 0){
					if (!set.contains(number)){
						set.add(number);
						numLarge--;
						maxSatisfiable++;
					}
				}
			}else{
				if (numLarge > 0){
					if (!set.contains(number)){
						set.add(number);
						numLarge--;
						maxSatisfiable++;
					}
				}
			}
			
		}
		System.out.print(maxSatisfiable);
	}

}
