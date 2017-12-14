package quadraticsAndLinearEqus;

public class Matrix {
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	private double g;
	private double h;
	private double i;
	private int type;
	
	public Matrix (double a, double b, double c, double d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		type = 2;
	}
	
	public Matrix (double a, double b, double c, double d, double e, double f, double g, double h, double i){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
		this.i = i;
		type = 3;
	}
	
	public Matrix add(Matrix otherMatrix){
		return new Matrix(a + otherMatrix.getA(), b + otherMatrix.getB(), c + otherMatrix.getC(), d + otherMatrix.getD());
	}
	
	public Matrix subtract(Matrix otherMatrix){
		return new Matrix(a - otherMatrix.getA(), b - otherMatrix.getB(), c - otherMatrix.getC(), d - otherMatrix.getD());
	}
	
	public Matrix multiply(Matrix otherMatrix){
		if (otherMatrix.getType() == 2){
			double newA = a*otherMatrix.getA() + b*otherMatrix.getC();
			double newB = a*otherMatrix.getB() + b*otherMatrix.getD();
			double newC = c*otherMatrix.getA() + d*otherMatrix.getC();
			double newD = c*otherMatrix.getB() + d*otherMatrix.getD();
			return new Matrix(newA, newB, newC, newD);
		}else{
			double newA = a*otherMatrix.getA() + b*otherMatrix.getD() + c*otherMatrix.getG();
			double newB = a*otherMatrix.getB() + b*otherMatrix.getE() + c*otherMatrix.getH();
			double newC = a*otherMatrix.getC() + b*otherMatrix.getF() + c*otherMatrix.getI();
			double newD = d*otherMatrix.getA() + e*otherMatrix.getD() + f*otherMatrix.getG();
			double newE = d*otherMatrix.getB() + e*otherMatrix.getE() + f*otherMatrix.getH();
			double newF = d*otherMatrix.getC() + e*otherMatrix.getF() + f*otherMatrix.getI();
			double newG = g*otherMatrix.getA() + h*otherMatrix.getD() + i*otherMatrix.getG();
			double newH = g*otherMatrix.getB() + h*otherMatrix.getE() + i*otherMatrix.getH();
			double newI = g*otherMatrix.getC() + h*otherMatrix.getF() + i*otherMatrix.getI();
			return new Matrix(newA, newB, newC, newD, newE, newF, newG, newH, newI);
		}
	}
	
	public Matrix multiply(double k){
		return new Matrix(a*k, b*k, c*k, d*k);
	}
	
	public Vector multiply(Vector v){
		return new Vector(v.getA()*a + v.getB()*b, v.getA()*c+v.getB()*d);
	}
	
	//public Matrix invert(){
	//	return new Matrix
	//}
	
	public double getDet(){
		return a*d-b*c;
	}
	
	public int getType(){
		return type;
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
	
	public double getD(){
		return d;
	}
	
	public double getE(){
		return e;
	}
	
	public double getF(){
		return f;
	}
	
	public double getG(){
		return g;
	}
	
	public double getH(){
		return h;
	}
	
	public double getI(){
		return i;
	}
}
