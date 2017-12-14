import java.util.*;
import java.io.*;
import java.lang.Math;

public class Q4 {
	static int cX, cY;
	static ArrayList<House> map;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("DATA41.txt"));
		String[] buffer = new String[10];
		int tempX, tempY;
		int xDif;
		int r, d;
		
		for (int i = 0; i < 10; i++){
			map = new ArrayList<House>(100);
			buffer = reader.nextLine().split(" ");
			r = 0;
			d = 0;
			
			cX = Integer.parseInt(buffer[0]);
			cY = Integer.parseInt(buffer[1]);
			
			for (int j = 0; j < 100; j++){
				buffer= reader.nextLine().split(" ");
				map.add(new House(Integer.parseInt(buffer[0]),Integer.parseInt(buffer[1]), buffer[2].charAt(0)=='D'));
			}
			
			for (int j = 50; j >= -50; j--){
				xDif = (int)(Math.floor(Math.sqrt(2500-j*j)));
				for (int k = cX - xDif; k <= cX+xDif; k++){
					if (count(k,cY+j)){
						d++;
					}else{
						r++;
					}
				}
			}
			double result = ((d+0.0)/(d+r+0.0))*100;
			String res = String.valueOf(result);
			int ind = res.indexOf(".");
			char[] chars = res.toCharArray();
			//if (chars[ind+])
			System.out.println(result);
			System.out.println(Math.round(result*10)/10.0);
		}
	}
	
	public static boolean count(int x, int y){
		double distance;
		double d1,d2, d3;
		char N1, N2;
		N2 = 'z';
		N1 = 'z';
		ArrayList<Character> N3 = new ArrayList<Character>();
		d1 = 100000;
		d2 = 1000000;
		d3 = 10000000;
		
		for (House i:map){
			distance = Math.sqrt((i.x-x)*(i.x-x)+(i.y-y)*(i.y-y));
			if (distance < d1){
				if (d3 == d2){
					N3.add(N2);
				}else{
					d3 = d2;
					N3.clear();
					N3.add(N2);
				}
				
				d2 = d1;
				N2 = N1;
				d1 = distance;
				if (i.democrat){
					N1 = 'D';
				}else{
					N1 = 'R';
				}
			}else if(distance < d2){
				if (d3 == d2){
					N3.add(N2);
				}else{
					d3 = d2;
					N3.clear();
					N3.add(N2);
				}
				d2 = distance;
				if (i.democrat){
					N2 = 'D';
				}else{
					N2 = 'R';
				}
			}else if (distance == d3){
				if (i.democrat){
					N3.add('D');
				}else{
					N3.add('R');
				}
			}else if (distance < d3){
				d3 = distance;
				N3.clear();
				if (i.democrat){
					N3.add('D');
				}else{
					N3.add('R');
				}
			}
		}
		int numD = 0;
		int numR = 0;
		if (N1 == 'D'){
			numD++;
		}else{
			numR++;
		}
		
		if (N2 == 'D'){
			numD++;
		}else{
			numR++;
		}
		
		for (int i = 0; i < N3.size(); i++){
			if (N3.get(i) == 'D'){
				numD++;
			}else{
				numR++;
			}
		}
		
		return numD >= numR;
	}
	
	static class House{
		int x,y;
		boolean democrat;
		public House(int x, int y, boolean democrat){
			this.x = x;
			this.y = y;
			this.democrat = democrat;
		}
	}

}
