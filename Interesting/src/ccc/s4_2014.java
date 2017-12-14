package ccc;
import java.util.*;
public class s4_2014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int numGlass = scan.nextInt();
		int minTint = scan.nextInt();
		int[] input = new int[5];
		ArrayList<Rect> rectangles = new ArrayList<Rect>();
		int counter;
		Rect current;
		Rect tempRect;
		int[] temp;
		for (int i = 0; i < numGlass; i++){
			for (int j = 0; j < 5; j++){
				input[j]=scan.nextInt();
			}
			current = new Rect(input[0],input[1],input[2],input[3],input[4]);
			counter = rectangles.size();
			outer:
			for (int j = 0; j < counter; j++){
				temp = rectSect(current,rectangles.get(j));
				if (temp[0]==1){
					tempRect = new Rect(temp[1],temp[2],temp[3],temp[4],current.tint+rectangles.get(j).tint);
					tempRect.addParent(current);
					tempRect.addParent(rectangles.get(j));
					for (int k = 0; k < rectangles.size(); k++){
						if (tempRect.tl.x==rectangles.get(k).tl.x && tempRect.tl.y==rectangles.get(k).tl.y && tempRect.br.x==rectangles.get(k).br.x && tempRect.br.y==rectangles.get(k).br.y){
							continue outer;
						}
					}
					rectangles.add(tempRect);
				}//else if(temp[0]==2){
					
				//}
			}
			rectangles.add(current);
		}
		int totalArea = 0;
		Rect toProcess;
		Rect parent;
		for (int i = 0; i < rectangles.size(); i++){
			toProcess = rectangles.get(i);
			if (toProcess.tint >= minTint){
				totalArea += (toProcess.br.y-toProcess.tl.y)*(toProcess.br.x-toProcess.tl.x);
			}
			for (int j = 0; j < toProcess.parents.size(); j++){
				parent = toProcess.getParent(j);
				if (parent.tint >= minTint){
					totalArea -= (toProcess.br.y-toProcess.tl.y)*(toProcess.br.x-toProcess.tl.x);
				}
			}
		}
		System.out.println(totalArea);
	}
	
	public static int min(int a, int b){
		if (a < b){
			return a;
		}
		return b;
	}
	
	public static int max(int a, int b){
		if (a > b){
			return a;
		}
		return b;
	}
	
	public static int[] rectSect(Rect a, Rect b){
		int right,left,top,bot;
		left = max(a.tl.x,b.tl.x);
		right = min(a.br.x,b.br.x);
		top = max(a.tl.y,b.tl.y);
		bot = min(a.br.y,b.br.y);
		int[] answer = new int[5];
		
		if (left < right && bot > top){
			answer[0] = 1; //there's an intersection
			answer[1]=left;
			answer[2]=top;
			answer[3]=right;
			answer[4]=bot;
		}else{
			answer[0] = 0;
		}
		return answer;
	}

}

class Rect{
	Point tl,br;
	long tint;
	ArrayList<Rect>parents = new ArrayList<Rect>();
	public Rect(int x,int y, int x1, int y1, long tint){
		tl = new Point(x,y);
		br = new Point(x1,y1);
		this.tint = tint;
	}
	
	public void addParent(Rect a){
		parents.add(a);
	}
	
	public Rect getParent(int i){
		return parents.get(i);
	}
}

class Point{
	int x,y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}