package March1HmwkCh8;
import java.lang.Math;
public class QuadraticEquation {
	private double a;
	private double b;
	private double c;
	double discriminant;
	double root1;
	double root2;
	public QuadraticEquation(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
		discriminant = b*b - 4*a*c;
		if (discriminant >= 0){
			root1 = ((-b + Math.sqrt(discriminant))/2*a);
			root2 = ((-b - Math.sqrt(discriminant))/2*a);
		}else{
			root1 = 0;
			root2 = 0;
		}
	}
	
	public double getDiscriminant(){
		return discriminant;
	}
	
	public double getRoot1(){
		return root1;
	}
	
	public double getRoot2(){
		return root2;
	}
	
	public double getA(){
		return a;
	}
	public double getB(){
		return b;
	}
	public double getC(){
		return c;
	}
}
