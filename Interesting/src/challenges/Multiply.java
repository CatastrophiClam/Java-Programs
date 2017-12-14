package challenges;
import java.util.Scanner;
public class Multiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter number 1: ");
		String a = scan.nextLine();
		System.out.println("Enter number 2: ");
		String b = scan.nextLine();
		System.out.println(mult(a,b));
		
		//System.out.println(mult('2','2')[0]);
	}
	
	public static String mult(String a, String b){
		String result = "0";
		String zerosToAdd = "";
		for (int i = b.length()-1; i >= 0; i--){
			result = add(result, mult(a,b.charAt(i))+zerosToAdd);
			zerosToAdd += "0";
		}
		return result;
	}
	
	public static String mult(String a, char b){
		String result = "0";
		String zerosToAdd = "";
		String[] temp;
		for (int i = a.length()-1; i>= 0; i--){
			temp = mult(a.charAt(i),b);
			result = add(result, temp[0]+zerosToAdd);
			result = add(result, temp[1]+zerosToAdd+"0");
			zerosToAdd += "0";
		}
		return result;
	}
	
	//ind 1 is the carry
	public static String[] mult(char a, char b){
		String answer = String.valueOf(((int)(a)-(int)('0'))*((int)(b)-(int)('0')));
		if (answer.length()==1){
			return new String[]{answer, "0"};
		}else{
			return new String[]{answer.substring(1,2), answer.substring(0,1)};
		}
	}
	
	public static String add(String a, String b){
		String x,y;
		if (a.length()>b.length()){
			x = a;
			y = b;
		}else{
			y = a;
			x = b;
		}
		int dif = a.length() - b.length();
		String answer = "";
		boolean carry = false;
		String temp;
		int tempInt;
		for (int i = x.length()-1, j = y.length()-1; i >=dif-1; i--,j--){
			if (j>=0){
				tempInt = (int)x.charAt(i)+(int)(y.charAt(j)-2*(int)('0'));
			}else{
				if (i >= 0){
					tempInt = (int)x.charAt(i)-(int)('0');
				}else{
					tempInt = 0;
				}
			}
			if (carry){
				tempInt++;
			}
			if (tempInt != 0){
				temp = String.valueOf(tempInt);
			}else{
				temp = "";
			}
			if (carry = temp.length()==2){
				answer = temp.substring(1, 2)+answer;
			}else{
				answer = temp + answer;
			}
		}
		if (dif > 0){
			answer = x.substring(0, dif-1)+answer;
		}
		return answer;
	}

}
