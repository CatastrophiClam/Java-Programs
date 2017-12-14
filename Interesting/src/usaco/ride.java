package usaco;

/*
ID: Max
LANG: JAVA
TASK: ride
*/

import java.io.*;

class ride {

	public static void main(String[] args) throws IOException{ 
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		int cometProduct;
		int groupProduct;
		String comet = reader.readLine();
		String group = reader.readLine();
		cometProduct = calc(comet);
		groupProduct = calc(group);
		if (cometProduct%47 == groupProduct%47){
			out.println(cometProduct);
			out.println(groupProduct);
			out.println("GO");
		}else{
			out.println("STAY");
		}
		reader.close();
		out.close();
		System.exit(0);
	}
	
	public static int calc(String regex){
		int product = 1;
		regex = regex.toLowerCase();
		for (int i = 0; i < regex.length();i++){
			switch(regex.charAt(i)){
				case 'a': product *=1 ; break;
				case 'b': product *=2 ; break;
				case 'c': product *=3 ; break;
				case 'd': product *=4 ; break;
				case 'e': product *=5 ; break;
				case 'f': product *=6 ; break;
				case 'g': product *=7 ; break;
				case 'h': product *=8 ; break;
				case 'i': product *=9 ; break;
				case 'j': product *=10 ; break;
				case 'k': product *=11 ; break;
				case 'l': product *=12 ; break;
				case 'm': product *=13 ; break;
				case 'n': product *=14 ; break;
				case 'o': product *=15 ; break;
				case 'p': product *=16 ; break;
				case 'q': product *=17 ; break;
				case 'r': product *=18 ; break;
				case 's': product *=19 ; break;
				case 't': product *=20 ; break;
				case 'u': product *=21 ; break;
				case 'v': product *=22 ; break;
				case 'w': product *=23 ; break;
				case 'x': product *=24 ; break;
				case 'y': product *=25 ; break;
				case 'z': product *=26 ; break;
			}
			System.out.print(product);
		}
		return product;
	}

}
