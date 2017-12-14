package geometry;
import java.util.ArrayList;

public class ConvexHull {
	double[] topMost;    // topmost point in points
	double[] bottomMost; // etc.
	double[] leftMost;
	double[] rightMost;
	ArrayList<double[]> pointList;
	
	public ConvexHull(){
		
	}
	
	public ArrayList<double[]> wrapPoints(ArrayList<double[]> points){
		double mostTop=points.get(0)[1];
		double mostBottom=points.get(0)[1];
		double mostRight=points.get(0)[0];
		double mostLeft=points.get(0)[0];
		for (double[] i:points){
			if (i[1] > mostTop){
				topMost = i;
				mostTop = i[1];
			}else if(i[1] < mostBottom){
				bottomMost = i;
				mostBottom = i[1];
			}else if(i[0] < mostLeft){
				leftMost = i;
				mostLeft = i[0];
			}else if(i[0] > mostRight){
				rightMost = i;
				mostRight = i[0];
			}
		}
		processPoints(topMost, leftMost, points, 1);
		processPoints(leftMost, bottomMost, points, 0);
		processPoints(bottomMost, rightMost, points, 1);
		processPoints(rightMost, topMost, points, 0);
		return pointList;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param points
	 * @param direction check for points DIRECTION OF line ab. 1 means above, 0 means below.
	 */
	public void processPoints(double[] a, double[] b, ArrayList<double[]> points, int direction){
		if (direction == 1){
			for (double []i : points){
				// for each point, if it is above line ab, call processpoints on ai and ib
				if (Line.isAbove(a, b, i)){
					processPoints(a, i, points, 1);
					pointList.add(i);
					processPoints(i, b, points, 1);
				}else{
					points.remove(i);
				}
			}
		}else{ // direction is 0
			for (double []i : points){
				// for each point, if it is above line ab, call processpoints on ai and ib
				if (Line.isBelow(a, b, i)){
					processPoints(a, i, points, 0);
					pointList.add(i);
					processPoints(i, b, points, 0);
				}else{
					points.remove(i);
				}
			}
		}
	}
}
