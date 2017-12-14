package sept29HmwkCh22;
import java.util.ArrayList;

/**
 * 
 * @author Max
 * CPU logic for the card game 24 points
 */
public class TwentyFourPointLogic {
	public TwentyFourPointLogic(){
		
	}
	
	/**
	 * Finds every combination of cards and operations (4 card slots, 4 operation slots, brackets)
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return An expression involving a, b, c, and d evaluating to 24
	 */
	public String solve(int a, int b, int c, int d){
		ArrayList<String> cards = new ArrayList<String>();
		String expression;  // expression that works
		ArrayList<String> bracketExp = new ArrayList<String>();  // arraylist to make testing brackets easier
		Evaluate get = new Evaluate();
		// add cards to card list
		cards.add(String.valueOf(a));
		cards.add(String.valueOf(b));
		cards.add(String.valueOf(c));
		cards.add(String.valueOf(d));
		// list of operations
		String[] opList = new String[]{"+", "-", "*", "/"};
		// permutation placeholders
		String chosen1;
		String chosen2;
		String chosen3;
		String chosen4;
		// operator placeholders
		String firstOp;
		String secondOp;
		String thirdOp;
		//big multiloop
		
		//first card slot
		for (int spot1 = 0; spot1 < 4; spot1 ++){
			chosen1 = cards.get(spot1);
			cards.remove(spot1);
			// second card slot
			for (int spot2 = 0; spot2 < 3; spot2 ++){
				chosen2 = cards.get(spot2);
				cards.remove(spot2);
				// third card slot
				for (int spot3 = 0; spot3 < 2; spot3 ++){
					chosen3 = cards.get(spot3);
					cards.remove(spot3);
					// fourth card slot
					chosen4 = cards.get(0);
					// for each permutation of the 4 cards, permutate operators
					//first operator
					for (int op1 = 0; op1 < 4; op1++){
						// second operator
						for (int op2 = 0; op2 < 4; op2++){
							// third operator
							for (int op3 = 0; op3 < 4; op3++){
								// for each combination of cards and operators:
								// init holders for operators
								firstOp = opList[op1];
								secondOp = opList[op2];
								thirdOp = opList[op3];
								expression = chosen1 + firstOp + chosen2 + secondOp + chosen3 + thirdOp + chosen4;
								if (get.eval(expression) == 24)
									return expression;
								// for brackets
								if (expression.contains("+") || expression.contains("-")){
									//init bracketExp
									bracketExp.clear();
									bracketExp.add(chosen1);
									bracketExp.add(firstOp);
									bracketExp.add(chosen2);
									bracketExp.add(secondOp);
									bracketExp.add(chosen3);
									bracketExp.add(thirdOp);
									bracketExp.add(chosen4);
									// try brackets around every addition or subtraction statement
									for(int i = 0; i < bracketExp.size(); i++){
										if (bracketExp.get(i).equals("+") || bracketExp.get(i).equals("-")){
											bracketExp.add(i + 2,")");
											bracketExp.add(i - 1, "(");
											expression = "";
											// make a string out of contents from bracketExp
											for (int j = 0; j < bracketExp.size(); j ++){
												expression += bracketExp.get(j);
											}
											if (get.eval(expression) == 24)
												return expression;
											//remove brackets
											bracketExp.remove(i+2);
											bracketExp.remove(i-1);
										}
									}
								}
								
							}
						}
					}
					// end of fourth slot
					cards.add(spot3, chosen3);
				}
				cards.add(spot2, chosen2);
			}
			cards.add(spot1, chosen1);
		}
		return "None";
	}
}
