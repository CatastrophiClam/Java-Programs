import java.util.*;
import java.io.*;
public class s1_2016 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		String a = reader.nextLine();
		String b = reader.nextLine();
		if (a.length()!=b.length()){
			System.out.println("N");
			return;
		}
		HashMap<Character,int[]> map1 = new HashMap<Character,int[]>();
		HashMap<Character,int[]> map2 = new HashMap<Character,int[]>();
		char temp;
		for (int i = 0; i < a.length(); i++){
			temp = a.charAt(i);
			if (map1.containsKey(temp)){
				map1.get(temp)[0]++;
			}else{
				map1.put(temp, new int[1]);
				map1.get(temp)[0]++;
			}
		}
		for (int i = 0; i < b.length(); i++){
			temp = b.charAt(i);
			if (temp != '*'){
				if (map1.containsKey(temp)){
					map1.get(temp)[0]--;
					if (map1.get(temp)[0]<0){
						System.out.println("N");
						return;
					}
				}else{
					System.out.println("N");
					return;
				}
			}
		}
		System.out.println("A");
		return;
		/**
		for (int i = 0; i < a.length(); i++){
			temp = a.charAt(i);
			if (map1.containsKey(temp)){
				if (map2.containsKey(temp)){
					if (map2.get(temp)[0]> map1.get(temp)[0]){
						System.out.println("N");
						return;
					}else{
						map1.remove(temp);
						map2.remove(temp);
					}
				}else{
					System.out.println("N");
					return;
				}
			}
		}
		if (map1.isEmpty()){
			if (map2.size()==0){
				System.out.println("A");
				return;
			}
			if (map2.size()==1 && map2.containsKey('*')){
				System.out.println("A");
				return;
			}
			System.out.println("N");
			return;
		}else{
			System.out.println("N");
		}
		**/
	}

}
