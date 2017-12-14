package jan18hmwk;
import java.util.Random;
import java.util.ArrayList;
public class BeanMachineLogic {
	Random random = new Random();
	int slots;     
	int balls;
	ArrayList<ArrayList<String>> ballPaths = new ArrayList<ArrayList<String>>();
	ArrayList<Integer> frequencies = new ArrayList<Integer>();
	
	public BeanMachineLogic(int slots, int balls){
		this.slots = slots;
		this.balls = balls;
		for (int i = 0; i < slots; i++){   // add a frequency for each slot
			frequencies.add(0);
		}
		findPath();
	}
	
	public ArrayList<Integer> getFrequencies(){
		return frequencies;
	}
	
	public ArrayList<ArrayList<String>> getPaths(){
		return ballPaths;
	}
	
	public void findPath(){
		int temp;
		for (int i = 0; i < balls; i++){   // for every ball:
			ballPaths.add(new ArrayList<String>());  // allot one arraylist for path
			findNextPath(slots-2);  // find its path
		}
		double start;
		for (ArrayList<String> i :ballPaths){
			start = (slots+1)/2.0;
			for (String j:i){
				if (j.equals("0")){
					start -= 0.5;
				}else{
					start += 0.5;
				}
			}
			temp = frequencies.get((int)(start)-1)+1;    //update frequencies
			frequencies.remove((int)start-1);
			frequencies.add((int)start-1,temp);
		}
	}
	
	public void findNextPath(int nailsLeft){    // make ball either go left or right
		ballPaths.get(ballPaths.size()-1).add(String.valueOf(random.nextInt(2)));  // 0 indicates left, 1 indicates right
		if (nailsLeft > 0){     // if there are still more nails to bounce off of, bounce
			findNextPath(nailsLeft-1);
		}
	}
}
