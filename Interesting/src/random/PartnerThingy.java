package random;
import java.util.Scanner;

public class PartnerThingy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of people: ");
		int numPeople = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter line 1:");
		String firstLine = scan.nextLine();
		System.out.println("Enter line 2:");
		String secondLine = scan.nextLine();
		String[] firstPeople = firstLine.split(" ");
		String[] secondPeople = secondLine.split(" ");
		String goodVar = "good";
		if (matches(firstPeople, secondLine)){
		//verify matching
			for (int i = 0; i < numPeople; i++){
				if (!firstPeople[i].equals(secondPeople[getIndex(firstPeople, secondPeople[i])]) || firstPeople[i].equals(secondPeople[i])){
					goodVar = "bad";
					break;
				}
			}
		}else{
			goodVar = "bad";
		}
		System.out.print(goodVar);
	}
	
	public static int getIndex(String[] array, String regex){
		for(int i = 0; i < array.length; i++){
			if (array[i].equals(regex)){
				return i;
			}
		}
		return -1;
	}
	
	public static boolean matches(String[] array, String otherArray){
		for (String i:array){
			if(!otherArray.contains(i)){
				return false;
			}
		}
		return true;
	}

}
