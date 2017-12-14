package sept29HmwkCh22;

public class BracketSortLogic {
	
	public BracketSortLogic(){
		
	}
	
	public boolean verify(String regex){
		Stack bracketStack = new Stack();
		String open = "({[";
		String closed = ")}]";
		String verifier;
		for (int i = 0; i < regex.length(); i ++){
			// if bracket is open, push into stack
			if (open.contains(regex.substring(i, i+1))){
				bracketStack.push(regex.substring(i, i+1));
			}else{
				verifier = bracketStack.pop();
				if (verifier != null){
					if (open.indexOf(verifier) != closed.indexOf(regex.substring(i, i+1))){
						return false;
					}
				}else{
					return false;
				}
			}
		}
		return true;
	}
}
