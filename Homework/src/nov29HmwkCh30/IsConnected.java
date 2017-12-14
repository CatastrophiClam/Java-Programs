package nov29HmwkCh30;

import dataStructures.Graph;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class IsConnected {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Graph<Integer> graph = new Graph<Integer>();
		System.out.print("Enter file location: ");
		String fileName = scan.nextLine();
		Scanner reader = new Scanner(new File(fileName));
		int numLines = Integer.parseInt(reader.nextLine());
		// add vertices
		for (int i = 0; i < numLines; i++){
			graph.addVertex(i);
		}
		String[] temp;
		// add edges
		for (int i = 0; i < numLines; i++){
			// split each line into its components
			temp = reader.nextLine().split(" ");
			for (int j = 1; j < temp.length; j++){
				graph.addEdge(new Integer[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[j])});
			}
		}
	}

}
