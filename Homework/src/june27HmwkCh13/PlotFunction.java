package june27HmwkCh13;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class PlotFunction extends JFrame{
	int a;
	String bPrep;
	int b;
	String cPrep;
	int c;
	int aTestVariable;
	
	public PlotFunction(String equation){
		getCoefficents(equation);
		add(new picPanel(a,b,c));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter equation: ");
		String equation = "2^2 + 2x + 2";//scan.nextLine();
		PlotFunction frame = new PlotFunction(equation);
		frame.setTitle("Quadratic Equation");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void getCoefficents(String equation){
		equation = equation.replaceAll(" ", "");  // remove all spaces
		equation = takePlusesOut(equation);
		a = Integer.parseInt(equation.substring(0, equation.indexOf("x^2")));
		aTestVariable = equation.indexOf("x");
		bPrep = equation.substring(equation.indexOf("x^2")+3, equation.indexOf("x", equation.indexOf("x^2")+3));
		if (bPrep.contains("+"))
			bPrep.replaceAll("+", "");  // remove plus sign if there is one
		b = Integer.parseInt(bPrep);
		cPrep = equation.substring(equation.indexOf("x",equation.indexOf("x^2")+3)+1, equation.length());
		if (cPrep.contains("+"))
			cPrep.replaceAll("+", "");  // remove plus sign if there is one
		c = Integer.parseInt(cPrep);
	}
	
	public String takePlusesOut(String equation){
		String result = "";
		for (int i = 0; i < equation.length(); i++){
			if (!equation.substring(i, i+1).equals("+")){
				result += equation.substring(i, i+1);
			}
		}
		return result;
	}
	
}

class picPanel extends JPanel{
	int a;
	int b;
	int c;
	public picPanel(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		// draw axes
		g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
		g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
		int pastX = -40;
		int pastY = a*1600 + b*-40 + c;
		int nowY;
		for (int x = -39; x <= 40; x++){
			nowY = a*x*x + b*x + c;
			g.drawLine(convertCoords(pastX, true), convertCoords(pastY, false), convertCoords(x, true), convertCoords(nowY, false));
			pastX = x;
			pastY = nowY;
		}
	}
	
	protected int convertCoords(int pastCoord, boolean isX){
		int originX = getWidth()/2;
		int originY = getHeight()/2;
		int result;
		if (isX){
			result = originX + pastCoord*20;
			return result;
		}else{
			result = originY - pastCoord*20;
			return result;
		}
	}
}
