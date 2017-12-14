import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
public class s3 {
	
	/**
	 * assign each plane to largest gate possible
	 * map tracks blocks of unavailable gates
	 * rev maps map's keys to map's values
	 * set tracks taken gates
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("testing");
		Scanner reader = new Scanner(file);
		int numGates = reader.nextInt();
		int numPlanes = reader.nextInt();
		int currentGate;
		int maxLanded = 0;
		int key;
		int a;
		int value;
		int as; //next avaliable spot
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> rev = new HashMap<Integer,Integer>();
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < numPlanes; i++){
			currentGate = reader.nextInt();
			//if currentGate is availiable
			if (!set.contains(currentGate)){
				set.add(currentGate);
				maxLanded++;
				// update maps
				if (!map.containsValue(currentGate)){
					if (!map.containsKey(currentGate+1)){
						// if currentGate is not consecutive with any other taken numbers
						map.put(currentGate,currentGate+1);
						rev.put(currentGate-1, currentGate);
					}else{
						//current is right before another block
						value = map.get(currentGate+1);
						map.remove(value);
						rev.remove(rev.get(value));
						map.put(currentGate, value);
						rev.put(value, currentGate);
					}
				}else if (map.containsKey(currentGate+1)){
					// map contains value and key
					key = rev.get(currentGate);
					value = map.get(currentGate+1);
					map.remove(value);
					map.remove(currentGate);
					rev.remove(key);
					rev.remove(currentGate+1);
					map.put(key,value);
					rev.put(value,key);
				}else{
					//map contains value but not key
					value = currentGate+1;
					key = rev.get(currentGate);
					map.remove(currentGate);
					rev.remove(key);
					map.put(key, value);
					rev.put(value,key);
				}
			}else{
				while (!rev.containsKey(currentGate) && currentGate >0 ){
					currentGate--;
				}
				if (currentGate != 0){
					as = rev.get(currentGate)-1;
					if (as!=-1){
						set.add(as);
						maxLanded++;
						if (!map.containsValue(as)){
							//current is right before another block
								value = map.get(as+1);
								map.remove(value);
								rev.remove(rev.get(value));
								map.put(as, value);
								rev.put(value, as);
						}else if (map.containsKey(as+1)){
							// map contains value and key
							key = rev.get(as);
							value = map.get(as+1);
							map.remove(value);
							map.remove(as);
							rev.remove(key);
							rev.remove(as+1);
							map.put(key,value);
							rev.put(value,key);
						}else{
							//map contains value but not key
							value = as+1;
							key = rev.get(as);
							map.remove(as);
							rev.remove(key);
							map.put(key, value);
							rev.put(value,key);
						}
					}
				}
			}
		System.out.print(maxLanded);
		}
	}	

}
