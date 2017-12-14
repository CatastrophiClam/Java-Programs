package geometry;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopWatch watch = new StopWatch();
		double[]a = new double[]{3, 2};
		double[]b = Point.convertToPolar(a[0], a[1]);
		double[]c = Point.convertToRectangular(b[0], b[1]);
		for (double i: c){
			System.out.println(i);
		}
	}

}
