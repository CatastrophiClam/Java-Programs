package dynamicProgramming;

public class KnapsackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnapsackLogic logic = new KnapsackLogic();
		logic.setWeights(new int[]{1});
		logic.setBenefits(new int[]{1});
		for (int i:logic.solve(6)){
			System.out.print(i);
		}
	}

}
