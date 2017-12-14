package Jun14HmwkCh15;
import java.lang.Math;
public class eval {
	//String equation; // equation to solve
	String equation;    // length of equation
	String val = "";
	String valOne;
	String valTwo;
	public String evaluate(String equation){
		equation = equation.replaceAll(" ", "");  // get rid of all spaces in the equation
		String numbers = "1234567890."; // pretty self explanatory
		String solving = "none";    // the bit we are currently trying to calculate
		boolean flag = true; // should we continue calculating?
		while (flag){
			solving = findPriority(equation);
			val = val + solving + ", ";
			equation = equation.replace(solving, calculate(solving));
			flag = false;   // stop calculating unless there's something more to do eg. there's still some sort of sign
			for (int i = 0; i<equation.length(); i++){
			if (! numbers.contains(equation.substring(i, i+1))){
					flag = true;
				}
			}
		}
		//return solving;
		return val;
	}
	public String calculate(String expression){
		String numO = findNum(1, expression);
		String numT = findNum(0, expression);
		String result = "";
		switch (expression.substring(expression.length()-numT.length()-1, expression.length()-numT.length())){
		case "+":
			result = String.valueOf(Integer.parseInt(numO)+Integer.parseInt(numT));
		break;
		case "-":
			result = String.valueOf(Integer.parseInt(numO)-Integer.parseInt(numT));
		break;
		case "*":
			//val = "1";
			result = String.valueOf(Integer.parseInt(numO)*Integer.parseInt(numT));
		break;
		case "/":
			result = String.valueOf(Double.parseDouble(numO)/Integer.parseInt(numT));
		break;
		case "^":
			result = String.valueOf(Math.pow(Integer.parseInt(numO), Integer.parseInt(numT)));
		break;
		}
		return result;
	}
	
	public String findPriority(String sentence){     // find the first most important thing in the equation (bedmas)
		int indexOne;   // index values
		int indexTwo;
		String origiSentence = sentence;
		String symbol;  // symbol
		String numValOne;
		String numValTwo;
		// if brackets are found, call itself on itself 
		if (sentence.contains("(") && sentence.contains(")")){
			sentence = findPriority(sentence.substring(sentence.indexOf("(")+1, sentence.indexOf(")")));
		}
		if (sentence.contains("^")){     // if a power is found, do power first
			numValOne = findNum(0, sentence.substring(0, sentence.indexOf("^")));
			numValTwo = findNum(1, sentence.substring(sentence.indexOf("^") +1 , sentence.length()));
			return numValOne+"^"+numValTwo;
		}else if (sentence.contains("*") && ! sentence.contains("/")){    // if there is only either multiplication or division, do that first
			numValOne = findNum(0, sentence.substring(0, sentence.indexOf("*")));
			numValTwo = findNum(1, sentence.substring(sentence.indexOf("*") + 1, sentence.length()));
			return numValOne+"*"+numValTwo;
		}else if (sentence.contains("/") && ! sentence.contains("*")){
			numValOne = findNum(0, sentence.substring(0, sentence.indexOf("/")));
			numValTwo = findNum(1, sentence.substring(sentence.indexOf("/")+ 1 , sentence.length()));
			return numValOne+"/"+numValTwo;
		}else if (sentence.contains("/") && sentence.contains("*")){    // if sentence contains multiplication and division, do whichever comes first
			indexOne = sentence.indexOf("/");
			indexTwo = sentence.indexOf("*");
			if (indexOne < indexTwo){         // if division comes first:
				numValOne = findNum(0, sentence.substring(0, sentence.indexOf("/")));
				numValTwo = findNum(1, sentence.substring(sentence.indexOf("/") + 1, sentence.length()));
				symbol = "/";
			}else{                             // if multiplication comes first:
				numValOne = findNum(0, sentence.substring(0, sentence.indexOf("*")));
				numValTwo = findNum(1, sentence.substring(sentence.indexOf("*") + 1, sentence.length()));
				symbol = "*";
			}
			return numValOne+symbol+numValTwo;
		}else if (sentence.contains("+") && ! sentence.contains("-")){    // if there is only either addition or subtraction:
			numValOne = findNum(0, sentence.substring(0, sentence.indexOf("+")));
			numValTwo = findNum(1, sentence.substring(sentence.indexOf("+")+1, sentence.length()));
			return numValOne+"+"+numValTwo;
		}else if (sentence.contains("-") && ! sentence.contains("+")){
			numValOne = findNum(0, sentence.substring(0, sentence.indexOf("-")));
			numValTwo = findNum(1, sentence.substring(sentence.indexOf("-") + 1, sentence.length()));
			return numValOne+"-"+numValTwo;
		}else{    // if sentence contains addition and subtraction, do whichever comes first
			indexOne = sentence.indexOf("+");
			indexTwo = sentence.indexOf("-");
			if (indexOne < indexTwo){         // if addition
				numValOne = findNum(0, sentence.substring(0, sentence.indexOf("+")));
				numValTwo = findNum(1, sentence.substring(sentence.indexOf("+") + 1, sentence.length()));
				symbol = "+";
			}else{                             // if subtraction comes first:
				numValOne = findNum(0, sentence.substring(0, sentence.indexOf("-")));
				numValTwo = findNum(1, sentence.substring(sentence.indexOf("-") + 1, sentence.length()));
				symbol = "-";
			}
			//val = numValOne + symbol + numValTwo;
			return numValOne+symbol+numValTwo;
		}		
			
		
	}
	
	public String findNum(int specifier, String expression){  // find the number at the start or end of expression; 0 means end, 1 means start 
		boolean found = false;  // have we found the number?
		String numbers = "1234567890.";
		String num = expression;  // the result
		switch (specifier){
		case 0:     // if searching from the end
			for (int i = expression.length() - 1; i >-1 && found == false; i--){
				if (! numbers.contains(expression.substring(i, i+1))){
					found = true;
					num = expression.substring(i+1, expression.length());
				}
			}
			break;
		case 1:
			for (int i = 0; i < expression.length() && found == false; i++){
				if (! numbers.contains(expression.substring(i, i+1))){
					found = true;
					num = expression.substring(0, i);
				}
			}
			break;
		}
		return num;
	}
}
