package quadraticsAndLinearEqus;
import java.util.ArrayList;

public class PostfixEval {
	public PostfixEval(){
		
	}
	
	/**
	 * 
	 * @param sentence math statement to be evaluated (postfix form)
	 * @return result
	 */
	public double eval(String sentence){
		String[] termArray = sentence.split(" ");
		String numbers = "1234567890";
		String operators = "+-*/";
		int firstOperatorIndex = 0;  // index of first operator
		for (int i = 0; i < termArray.length; i++){
			if (!numbers.contains(termArray[i])){
				firstOperatorIndex = i;
				break;
			}
		}
		int firstNum = Integer.parseInt(termArray[firstOperatorIndex-2]);
		int secondNum = Integer.parseInt(termArray[firstOperatorIndex-1]);
		int result = 0;
		String operator = termArray[firstOperatorIndex];
		if (operator.equals("+")){
			result = firstNum + secondNum;
		}else if(operator.equals("-")){
			result = firstNum - secondNum;
		}else if(operator.equals("*")){
			result = firstNum*secondNum;
		}else if(operator.equals("/")){
			result = firstNum / secondNum;
		}
		String returnSentence = "";
		for (int i = 0; i < termArray.length; i++){
			if (i == firstOperatorIndex-2){
				returnSentence += result;
			}else if(i != firstOperatorIndex - 1 && i != firstOperatorIndex){
				returnSentence += termArray[i];
			}
		}
		
	}
}
