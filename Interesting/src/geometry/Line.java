package geometry;
import java.lang.Math;

public class Line {
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @returns true if c is above and to the left of ab
	 */
	public static boolean isAbove(double[]a, double[]b, double[]c){
		return c[1] > (b[1] - a[1])*c[0]/(b[0] - a[0]) + a[1] - (b[1] - a[1])*a[0]/(b[0] - a[0]);
	}
	
	public static boolean isBelow(double[]a, double[]b, double[]c){
		return c[1] < (b[1] - a[1])*c[0]/(b[0] - a[0]) + a[1] - (b[1] - a[1])*a[0]/(b[0] - a[0]);
	}
	
	
	
	
	
}
