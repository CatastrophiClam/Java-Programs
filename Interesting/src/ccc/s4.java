package ccc;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class s4 {
	static int[][][] graph; //starts at 1
	static int[] degrees;
	static int destination;
	static int[] shortestCosts;
	static HashSet<Integer>notInTree;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));//System.in);
		int numCities = reader.nextInt();
		degrees = new int[numCities+1];
		graph = new int[numCities+1][numCities+1][2];
		shortestCosts = new int[numCities+1];
		notInTree = new HashSet<Integer>(numCities);
		for (int i = 1; i <= numCities; i++){
			shortestCosts[i] = 2000000001;
			notInTree.add(i);
		}
		
		int numRoutes = reader.nextInt();
		int tempA, tempB, tempCost;
		for (int i = 0; i < numRoutes; i++){
			tempA = reader.nextInt();
			tempB = reader.nextInt();
			tempCost = reader.nextInt();
			graph[tempA][degrees[tempA]][0] = tempB;
			graph[tempA][degrees[tempA]][1] = tempCost;
			degrees[tempA]++;
			graph[tempB][degrees[tempB]][0] = tempA;
			graph[tempB][degrees[tempB]][1] = tempCost;
			degrees[tempB]++;
		}
		
		int numSellingCities = reader.nextInt();
		int[] sellingCities = new int[numSellingCities];
		int[] prices = new int[numSellingCities];
		for (int i = 0; i < numSellingCities; i++){
			tempA = reader.nextInt();
			tempCost = reader.nextInt();
			sellingCities[i]=tempA;
			prices[i]=tempCost;
		}
		
		destination = reader.nextInt();
		shortestCosts[destination]=0;
		djykstra();
		
		int cheapestPrice = 2000000001;
		int tempPrice;
		for (int i = 0; i < numSellingCities; i++){
			tempPrice = shortestCosts[sellingCities[i]]+prices[i];
			if (tempPrice < cheapestPrice){
				cheapestPrice = tempPrice;
			}
		}
		System.out.println(cheapestPrice);
	}
	
	static public void djykstra(){
		int toProcess = destination;
		int tempDest;
		int tempCost;
		int minCost;
		while(notInTree.contains(toProcess)){
			notInTree.remove(toProcess);
			//update all costs for vertices connected vertex being processed
			for (int i = 0; i < degrees[toProcess];i++){
				tempDest = graph[toProcess][i][0];
				tempCost = shortestCosts[toProcess]+graph[toProcess][i][1];
				if (tempCost < shortestCosts[tempDest]){
					shortestCosts[tempDest]=tempCost;
				}
			}
			
			minCost = 2000000000;
			for (int i:notInTree){
				if (shortestCosts[i]<minCost){
					toProcess = i;
					minCost = shortestCosts[i];
				}
			}
		}
	}

}
