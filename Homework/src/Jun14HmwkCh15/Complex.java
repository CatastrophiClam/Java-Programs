package Jun14HmwkCh15;

import java.lang.Math;

public class Complex {
	private double a;
	private double b;
	
	public Complex(){
		a = 0;
		b = 0;
	}
	
	public Complex(double real){
		a = real;
		b = 0;
	}
	
	public Complex(double real, double imaginary){
		a = real;
		b = imaginary;
	}
	
	public double getRealPart(){
		return a;
	}
	
	public double getImaginaryPart(){
		return b;
	}
	
	public Complex add(Complex z){
		return new Complex(a + z.getRealPart(), b + z.getImaginaryPart());
	}
	
	public Complex subtract(Complex z){
		return new Complex(a - z.getRealPart(), b - z.getImaginaryPart());
	}
	
	public Complex multiply(Complex z){
		return new Complex(a*z.getRealPart() - b*z.getImaginaryPart(), b*z.getRealPart() + a*z.getImaginaryPart());
	}
	
	public Complex divide(Complex z){
		return new Complex((a*z.getRealPart()+b*z.getImaginaryPart())/(z.getRealPart()*z.getRealPart()*z.getImaginaryPart()*z.getImaginaryPart()), (b*z.getRealPart()-a*z.getImaginaryPart())/(z.getRealPart()*z.getRealPart()*z.getImaginaryPart()*z.getImaginaryPart()));
	}
	
	public double abs(){
		return Math.sqrt(a*a+b*b);
	}
}
