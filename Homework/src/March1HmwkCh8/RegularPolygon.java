package March1HmwkCh8;
import java.lang.Math;
public class RegularPolygon {
	private int n;
	private double side;
	private double x;
	private double y;
	
	public RegularPolygon(){
		n = 3;
		side = 1;
		x = 0;
		y = 0;
	}
	
	public RegularPolygon(int number, double sides){
		n = number;
		side = sides;
		x = 0;
		y = 0;
	}
	
	public RegularPolygon(int number, double sides, double x, double y){
		n = number;
		side = sides;
		this.x = x;
		this.y = y;
	}
	
	public double getPerimeter(){
		return n*side;
	}
	
	public double getArea(){
		return (n*side*side)/(4*Math.tan(Math.PI/n));
	}
	
	public void changeSideNumber(int sides){
		n = sides;
	}
	
	public int getSideNumber(){
		return n;
	}
	
	public void changeSideLength(double length){
		side = length;
	}
	
	public double getSideLength(){
		return side;
	}
	
	public void changeXCoord(double x){
		this.x = x;
	}
	
	public double getXCoord(){
		return x;
	}
	
	public void changeYCoord(double y){
		this.y = y;
	}
	
	public double getYCoord(){
		return y;
	}
}
