package dataStructures;
import java.util.ArrayList;
import java.util.Random;
import stopwatch.StopWatch;

public class Tester1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NUMVERTICES = 10000;
		final int NUMEDGES = 100000;
		//Integer[] vertices = new Integer[NUMVERTICES];
		//Integer[][] edges = new Integer[NUMEDGES][2];
		Integer[] vertices = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[][] edges = new Integer[][]{{1,2}, {2,5}, {5,4}, {4,7}, {7,10}, {10,9}, {9,8}, {8,6}, {6,3}, {3,2}};
		//Random random = new Random();
		StopWatch watch = new StopWatch();
		//for (int i = 0; i < NUMVERTICES; i++){
		//	vertices[i] = i;
		//}
		//for (int i = 0; i < NUMEDGES; i++){
		//	edges[i] = new Integer[]{random.nextInt(NUMVERTICES), random.nextInt(NUMVERTICES)};
		//}
		Graph<Integer> graph = new Graph<Integer>(vertices);
		graph.addEdges(edges);
		//new Integer[][]{{1,2}, {2,5}, {5,4}, {4,7}, {7,10}, {10,9}, {9,8}, {8,6}, {6,3}}
		//ArrayList<Integer> n = graph.findShortestPath(10, 1);
		//for (int i:n){
		//	System.out.println(i);
		//}
		watch.start();
		System.out.println(graph.allCycles());
		watch.stop();
		System.out.println(watch.timeElapsed());
	}

}
