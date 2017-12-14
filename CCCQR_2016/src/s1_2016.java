import java.util.*;

public class s1_2016 {
	static int numPoints;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		numPoints = scan.nextInt();
		int x,y;
		Point temp;
		
		HashMap<Integer,Integer> xMap = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> yMap = new HashMap<Integer,Integer>();
		ArrayList<ArrayList<Point>> xList = new ArrayList<ArrayList<Point>>();
		ArrayList<ArrayList<Point>> yList = new ArrayList<ArrayList<Point>>();
		
		for (int i = 0; i < numPoints; i++){
			x = scan.nextInt();
			y = scan.nextInt();
			temp = new Point(x,y);
			if (xMap.containsKey(x)){
				xList.get(xMap.get(x)).add(findInsertPosY(temp,xList.get(xMap.get(x))),temp);
			}else{
				xList.add(new ArrayList<Point>());
				xMap.put(x,xList.size()-1);
				xList.get(xList.size()-1).add(temp);
			}
			if (yMap.containsKey(y)){
				yList.get(yMap.get(y)).add(findInsertPosX(temp,yList.get(yMap.get(y))),temp);
			}else{
				yList.add(new ArrayList<Point>());
				yMap.put(y,yList.size()-1);
				yList.get(yList.size()-1).add(temp);
			}
		}
		long numTriangles = 0;
		long tempNum;
		
		int tempIndex,yListInd;
		for (ArrayList<Point> i:xList){
			//for every vertical line in xList
			if (i.size()>= 3){
				//if there are more than 3 dots
				for (int j = 1; j < i.size()-1; j++){
					//see if a horizontal line exists for every dot in the vertical line
					yListInd = yMap.get(i.get(j).y);
					if (yList.get(yListInd).size()>=3){
						tempIndex = binSearchX(i.get(j),yList.get(yListInd));
						if (tempIndex > 0 && tempIndex < yList.get(yListInd).size()-1){
							// found one
							tempNum = (j*tempIndex*(i.size()-j-1)*(yList.get(yListInd).size()-tempIndex-1))*2;
							numTriangles+=tempNum;
						}
					}
				}
			}
		}
		System.out.println(numTriangles);
	}
	
	public static int findInsertPosX(Point a, ArrayList<Point> list){
		int min = 0;
		int max = list.size();
		int findIndex;
		while (true){
			if (max==0){
				return 0;
			}else if(max == 1){
				if (a.x >= list.get(0).x){
					return 1;
				}else{
					return 0;
				}
			}else{
				findIndex = (min+max)/2;
				if (findIndex == 0){
					if (a.x <= list.get(0).x){
						return 0;
					}else{
						min = 1;
					}
				}else if (findIndex == list.size()-1){
					if (list.get(findIndex).x>=a.x){
						if (list.get(findIndex-1).x<=a.x){
							return findIndex;
						}else{
							max = findIndex-1;
						}
					}else{
						return findIndex+1;
					}
				}else if (list.get(findIndex-1).x<=a.x){
					if (list.get(findIndex).x>=a.x){
						return findIndex;
					}else{
						min = findIndex;
					}
				}else{
					max = findIndex;
				}
			}
		}
	}
	
	public static int findInsertPosY(Point a, ArrayList<Point> list){
		int min = 0;
		int max = list.size();
		int findIndex;
		while (true){
			if (max==0){
				return 0;
			}else if(max == 1){
				if (a.y >= list.get(0).y){
					return 1;
				}else{
					return 0;
				}
			}else{
				findIndex = (min+max)/2;
				if (findIndex == 0){
					if (a.y <= list.get(0).y){
						return 0;
					}else{
						min = 1;
					}
				}else if (findIndex == list.size()-1){
					if (list.get(findIndex).y>=a.y){
						if (list.get(findIndex-1).y<=a.y){
							return findIndex;
						}else{
							max = findIndex-1;
						}
					}else{
						return findIndex+1;
					}
				}else if (list.get(findIndex-1).y<=a.y){
					if (list.get(findIndex).y>=a.y){
						return findIndex;
					}else{
						min = findIndex;
					}
				}else{
					max = findIndex;
				}
			}
		}
	}
	
	public static int binSearchX(Point a, ArrayList<Point> list){
		int min = 0;
		int max = list.size();
		int findIndex;
		while (true){
			findIndex = (min+max)/2;
			if (list.get(findIndex).x==a.x){
				return findIndex;
			}else if (list.get(findIndex).x<a.x){
					min = findIndex+1;
			}else{
				max = findIndex;
			}
		}
	}
	
	public static int binSearchY(Point a, ArrayList<Point> list){
		int min = 0;
		int max = list.size();
		int findIndex;
		while (true){
			findIndex = (min+max)/2;
			if (list.get(findIndex).y==a.y){
				return findIndex;
			}else if (list.get(findIndex).y<a.y){
					min = findIndex+1;
			}else{
				max = findIndex;
			}
		}
	}
	
	

}

class Point{
	int x,y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
}
