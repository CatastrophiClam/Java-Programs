package geometry;
import java.lang.Math;

public class Point {
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @returns the polar coordinates of point x,y as an array {r, theta} (theta is in degrees)
	 */
	public static double[] convertToPolar(double x, double y){
		double r = Math.sqrt(x*x+y*y);
		double theta = Math.toDegrees(Math.acos(x/r));
		return new double[]{r, theta};
	}
	
	/**
	 * 
	 * @param r
	 * @param theta in degrees
	 * @return the rectangular coordinates of the point r,theta as an array {x, y}
	 */
	public static double[] convertToRectangular(double r, double theta){
		return new double[]{r*Math.cos(Math.toRadians(theta)), r*Math.sin(Math.toRadians(theta))};
	}
	
	public static double[] convertToPolar(double[] a){
		return convertToPolar(a[0], a[1]);
	}
	
	public static double[] convertToRectangular(double[] a){
		return convertToRectangular(a[0], a[1]);
	}
}
