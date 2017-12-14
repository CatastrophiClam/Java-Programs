package ccc;
import java.util.*;
import java.io.*;

public class s4_2008 {
	static HashSet<Character> ops = new HashSet<Character>();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		int numCases = reader.nextInt();
		ops.add('+');
		ops.add('-');
		ops.add('*');
		ops.add('/');
		for (int i = 0; i < numCases; i++){
			execute(reader);
		}
	}
	
	public static int eval(String equ){
		int val1;
		int val2;
		if (!ops.contains(equ.charAt(1))){
			//val1 = Integer.parseInt(equ.charAt(1));
			// (!ops.contains)
		}
		return 4;
	}
	
	public static void execute(Scanner reader){
		String numbers = "";
		for (int i = 0; i < 4; i++){
			numbers+=reader.nextLine();
		}
		String ops = "+_*/";
		String both = ops+numbers;
		String toEval = "";
		int minScore = -1;
		int tempScore;
		int numNums;
		int numOps;
		
		outer:
		for (int i = 0; i < 4; i++){
			numNums = 0;
			numOps = 1;
			toEval += ops.charAt(i);
			for (int j = 0; j < 8; j++){
				if(j<4){
					numOps++;
				}else{
					numNums++;
				}
				toEval += both.charAt(j);
				for (int k = 0; k < 8; k++){
					if(k<4){
						numOps++;
					}else{
						if (numNums==2){
							break;
						}else{
							numNums++;
						}
					}
					toEval+= both.charAt(k);
					for (int l = 0; l < 8; l++){
						if (l<4){
							if (numOps==3){
								continue;
							}else{
								numOps++;
							}
						}else{
							if (numNums==2){
								break;
							}else{
								numNums++;
							}
						}
						toEval += both.charAt(l);
						for (int m = 0; m < 8; m++){
							if (m<4){
								if (numOps==3){
									continue;
								}else{
									numOps++;
								}
							}else{
								if (numNums==2){
									break;
								}else{
									numNums++;
								}
							}
							toEval += both.charAt(m);
							for (int n = 0; n < 4; n++){
								toEval += numbers.charAt(n);
								for (int o = 0; o < 4; o++){
									toEval += numbers.charAt(o);
									tempScore = eval(numbers);
									if(tempScore == 24){
										break outer;
									}else{
										if (tempScore < 24 && tempScore > minScore){
											minScore = tempScore;
										}
									}
									toEval = toEval.substring(0,6);
								}
								toEval = toEval.substring(0,5);
							}
							toEval = toEval.substring(0,4);
							if (m<4){
								numOps--;
							}else{
								numNums--;
							}
						}
						toEval = toEval.substring(0,3);
						if (l<4){
							numOps--;
						}else{
							numNums--;
						}
					}
					toEval = toEval.substring(0,2);
					if (k<4){
						numOps--;
					}else{
						numNums--;
					}
				}
				toEval = toEval.substring(0,1);
				if (j<4){
					numOps--;
				}else{
					numNums--;
				}
			}
			toEval = toEval.substring(0, 0);
		}
	}

}
