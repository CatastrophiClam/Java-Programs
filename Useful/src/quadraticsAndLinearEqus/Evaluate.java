package quadraticsAndLinearEqus;
import java.lang.Math;
import java.util.ArrayList;

public class Evaluate {
	private String originalEquation;  // the original, unchanged equation
	private String[] equation;          // this equation will be modified
	//StopWatch watch = new StopWatch();
	
	public Evaluate(){
		
	}
	
	/**
	 * 
	 * @param equation Equation can contain multiple brackets, powers, etc
	 * @return Returns result of equation
	 **/
	public double eval(String equation){
		//watch.start();
		this.equation = splitTerms(equation);
		solve();
		//watch.stop();
		//return watch.timeElapsed();
		return Double.parseDouble(this.equation[0]);
	}
	/**
	 * While there is still something to solve:
	 *  
	 */
	private void solve(){    // while there is still something to solve:
		while(equation.length>1){
			findPriority();
			
		}
	}
	/**
	 * Find the most important operation to execute
	 * execute it
	 * replace it in the equation
	 */
	private void findPriority(){ // startIndex is inclusive, endIndex is exclusive
	// First, look for brackets
		if(contains(equation, "(")){  // if there are brackets:
			// call eval on the things inside the brackets 
			// insert the total of the value inside the brackets back into the equation
			Evaluate ev = new Evaluate();
			String toEvaluate = "";
			for(int i = lastIndex(equation, "(")+1; i < indexOf(equation, ")", lastIndex(equation, "(")); i++){
				toEvaluate+= equation[i];
				toEvaluate += " ";
			}
			equation = insert(equation, String.valueOf(ev.eval(toEvaluate)), lastIndex(equation, "("));
			//remove useless stuff (brackets and stuff inside brackets)
			equation = remove(equation, lastIndex(equation,"("), indexOf(equation, ")", lastIndex(equation, "("))+1);
		// look for powers
		}else if(contains(equation, "^")){
			//insert result               toString     the power of:                the first number                                         the second number                     where you insert
			equation = insert(equation, String.valueOf(Math.pow(Double.parseDouble(equation[indexOf(equation, "^")-1]), Double.parseDouble(equation[indexOf(equation, "^")+1]))), indexOf(equation, "^")-1);
			//remove useless stuff
			equation = remove(equation, indexOf(equation, "^")-1, indexOf(equation, "^")+2);
			// if there's no more powers or brackets:
		}else{
			// if there's multiplication or division:
			if (contains(equation, "*") || contains(equation, "/")){
				// do whichever comes first
				for(int i = 1; i < equation.length; i++){
					if (equation[i].equals("*")){
						//insert result               
						equation = insert(equation, String.valueOf(Double.parseDouble(equation[i-1])* Double.parseDouble(equation[i+1])), i-1);
						//remove useless stuff
						equation = remove(equation, indexOf(equation, "*")-1, indexOf(equation, "*")+2);
					}else if(equation[i].equals("/")){
						//insert result               
						equation = insert(equation, String.valueOf(Double.parseDouble(equation[i-1])/ Double.parseDouble(equation[i+1])), i-1);
						//remove useless stuff
						equation = remove(equation, indexOf(equation, "/")-1, indexOf(equation, "/")+2);
					}
				}
				// if the equation contains addition or subtraction:
			}else if(contains(equation, "+") || contains(equation, "-")){
				// do whichever comes first
				for(int i = 1; i < equation.length; i++){
					if (equation[i].equals("+")){
						//insert result               
						equation = insert(equation, String.valueOf(Double.parseDouble(equation[i-1])+ Double.parseDouble(equation[i+1])), i-1);
						//remove useless stuff
						equation = remove(equation, indexOf(equation, "+")-1, indexOf(equation, "+")+2);
					}else if(equation[i].equals("-")){
						//insert result               
						equation = insert(equation, String.valueOf(Double.parseDouble(equation[i-1])- Double.parseDouble(equation[i+1])), i-1);
						//remove useless stuff
						equation = remove(equation, indexOf(equation, "-")-1, indexOf(equation, "-")+2);
					}
				}
			}
			
		}
	}
	
	/**
	 * Performs a basic operation on 2 numbers and returns the results
	 * @param unit String
	 * @return Double
	 */
	private Double calculate(String unit){
		if (unit.contains("+")){
			return Double.parseDouble(unit.substring(0, unit.indexOf("+")))+Double.parseDouble(unit.substring(unit.indexOf("+")+1, unit.length()));
		}
		if (unit.contains("-")){
			return Double.parseDouble(unit.substring(0, unit.indexOf("-")))-Double.parseDouble(unit.substring(unit.indexOf("-")+1, unit.length()));
		}
		if (unit.contains("*")){
			return Double.parseDouble(unit.substring(0, unit.indexOf("*")))*Double.parseDouble(unit.substring(unit.indexOf("*")+1, unit.length()));
		}
		if (unit.contains("/")){
			return Double.parseDouble(unit.substring(0, unit.indexOf("/")))/Double.parseDouble(unit.substring(unit.indexOf("/")+1, unit.length()));
		}
		if (unit.contains("^")){
			return Math.pow(Double.parseDouble(unit.substring(0, unit.indexOf("^"))),Double.parseDouble(unit.substring(unit.indexOf("^")+1, unit.length())));
		}
		return 0.0;
		
	}
	
	private boolean contains(String[] target, String regex){
		for (String i:target){
			if (i.equals(regex)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param target
	 * @param startIndex Removes starting from the string at this index (inclusive)
	 * @param endIndex   Removes up to the string at this index (exclusive)
	 * @return
	 */
	private String[] remove(String[] target, int startIndex, int endIndex){
		String[] result = new String[target.length - (endIndex-startIndex)];
		int addIndex = 0;  // index of result you add to
		for (int i = 0; i < target.length; i ++){
			if (i < startIndex || i >= endIndex){
				result[addIndex] = target[i];
				addIndex++;
			}
		}
		return result;
	}
	
	// Pushes back current string occupying index
	private String[] insert(String[]target, String regex, int index){
		String[]result = new String[target.length+1];
		for(int i = 0; i < target.length+1; i++){
			if (i < index){
				result[i] = target[i];
			}else if(i > index){
				result[i] = target[i-1];
			}else{
				result[i] = regex;
			}
		}
		return result;
	}
	
	private int lastIndex(String[] array, String regex){
		for (int i = array.length-1; i >= 0; i--){
			if (array[i].equals(regex)){
				return i;
			}
		}
		return 0;
	}
	
	private int indexOf(String[]array, String regex){
		for (int i = 0; i < array.length; i++){
			if (array[i].equals(regex)){
				return i;
			}
		}
		return 0;
	}
	
	private int indexOf(String[]array, String regex, int afterInt){
		for (int i = afterInt; i < array.length; i++){
			if (array[i].equals(regex)){
				return i;
			}
		}
		return 0;
	}
	/**
	 * 
	 * @param sentence  any equation
	 * @return  the terms of sentence in an array
	 */
	public String[] splitTerms(String sentence){
		sentence = sentence.replaceAll(" ", "");
		String pastTerms = sentence.substring(0, 1);   // set pastTerm as first character of sentence
		String pastType = findType(sentence.substring(0, 1));  //set pastType as its type
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 1; i < sentence.length(); i++){   // for every character in the equation:
			// see if it is of the same type as the previous character
			if (findType(sentence.substring(i, i+1)).equals(pastType)){  //if it is the same:
				pastTerms += sentence.substring(i, i+1);
				if (i == sentence.length()-1){    // if it's the last character:
					array.add(pastTerms);
				}
			}else{   // if it isn't the same:
				array.add(pastTerms);
				pastTerms = sentence.substring(i, i+1);
				pastType = findType(sentence.substring(i, i+1));
				if (i == sentence.length()-1){    // if it's the last character:
					array.add(pastTerms);
				}
			}
		}
		String[] result = new String[array.size()];  // turn arraylist into an array
		for(int i = 0; i < result.length; i++){
			result[i] = array.get(i);
		}
		return result;
	}
	
	public String findType(String term){
		String numbers = "1234567890.";
		String brackets = "()";
		if (numbers.contains(term)){
			return "number";
		}else if(brackets.contains(term)){
			return "bracket";
		}else{
			return "operator";
		}
	}
	
}
