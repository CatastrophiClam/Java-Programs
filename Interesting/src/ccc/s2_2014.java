package ccc;
import java.util.*;

public class s2_2014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int numStudents = Integer.parseInt(scan.nextLine());
		String[] line1 = scan.nextLine().split(" ");
		String[] line2 = scan.nextLine().split(" ");
		HashMap<String,String> map = new HashMap<String,String>();
		for (int i = 0; i < line1.length; i++){
			if (line1[i].equals(line2[i])){
				System.out.println("bad");
				return;
			}
			if (!map.containsKey(line1[i])){
				if (map.containsKey(line2[i])){
					if (!map.get(line2[i]).equals(line1[i])){
						System.out.println("bad");
						return;
					}else{
						map.remove(line2[i]);
					}
				}else{
					map.put(line1[i], line2[i]);
				}
			}else{
				if (!map.get(line1[i]).equals(line2[i])){
					System.out.println("bad");
					return;
				}else{
					map.remove(line2[i]);
				}
			}
		}
		if (map.size()==0)
		System.out.println("good");
	}

}
