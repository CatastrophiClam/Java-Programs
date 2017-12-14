package ai;
import java.util.*;
import java.lang.Math;
import java.io.*;

/**
 * Uses binary search to find the optimal biases and weights
 * bDir is the past direction the biases are going in, and bTimes is the number of times it went in that direction; if the number of times exceeds 3 the increment doubles
 * @author maxda
 *
 */
public abstract class BinaryLearningAI {
	//--------------GENERAL AI SETTINGS AND VARIABLES------------------//
	private final int NUM_INPUTS = 5500;
	private final int NUM_HIDDEN_LEVELS = 2;
	private final int[] HIDDEN_LEVEL_SIZES;
	private final int NUM_OUTPUTS = 55;
	private final double ETA = 2;
	private final double INCREMENT = 0.5;
	private final int NUM_REPS = 1;   //number of times the same training case is repeated consecutively
	private final int NUM_TRAINING_REPS = 20;  //number of times the whole set of training cases is cycled through
	private final int BATCH_SIZE = 10;
	private boolean readFromSave = false;
	
	private double[][] biases; //first index is layer, second index is node
	private boolean[][] bDir; //true is positive, false is negative
	private double[][] bIncr;
	private int[][] bTimes;
	private double[][][] weights; //first indicates from which layer to which (0 indicates from input to 1st hidden layer), second index is the to layer, third is the from layer
	private boolean[][][] wDir;
	private double[][][]wIncr;
	private int[][][] wTimes;
	private int[] network;
	private int[] answer;
	private final int DOUBLING_TIME = 3;
	
	private double[][] a;
	private double[][] z;
	private double[][] error;
	
	{
		HIDDEN_LEVEL_SIZES = new int[]{50,50,50,50,100,100,100,100,100,100};
	}
	
	//----------------------------------------------------------------//
	
	public BinaryLearningAI() throws IOException{
		setupNetwork();
		//train initial AI
		if (!readFromSave){
			train("Songs");
			save("Save");
		}else{
			read("Save");
		}
	}
	
	/**
	 * Update all weights and biases based on the given costs
	 * @param averageCosts
	 */
	public void update(double[] averageCosts){
		boolean temp;
		//Option to do multiple reps on the same cost
		for (int r = 0; r < NUM_REPS; r++){
			//determine final error
			error[error.length-1] = mult(averageCosts,sigmoidPrime(z[error.length-1]));
			
			//update weights and biases
			for (int i = network.length-1; i > 0; i--){ // i indicates which layer in the network is being processed
				//determine current layer error
				if (i < network.length-1){
					for (int j = 0; j < error[i-1].length; j++){ // j indicates the error node
						for (int k = 0; k < error[i].length; k++){ // k indicates the nodes on the next layer
							error[i-1][j] += weights[i][k][j]*error[i][k];
						}
						error[i-1][j] = error[i-1][j]*sigmoidPrime(z[i-1][j]);
					}
				}
				//update weights
				for (int j = 0; j < weights[i-1].length; j++){ // j indicates which node in the current layer is being processed
					for (int k = 0; k < weights[i-1][j].length; k++){ // k indicates the node in the previous layer onto which the weight applies
						temp = a[i-1][k]*error[i-1][j] > 0;
						if (temp == wDir[i-1][j][k]){
							if (temp){
								weights[i-1][j][k] += wIncr[i-1][j][k];
							}else{
								weights[i-1][j][k] -= wIncr[i-1][j][k];
							}
							wTimes[i-1][j][k]++;
							if (wTimes[i-1][j][k]==DOUBLING_TIME){
								wIncr[i-1][j][k] *= 2;
								wTimes[i-1][j][k] = 0;
							}
						}else{
							wIncr[i-1][j][k] /= 2;
							wTimes[i-1][j][k] = 0;
							if (temp){
								weights[i-1][j][k] += wIncr[i-1][j][k];
							}else{
								weights[i-1][j][k] -= wIncr[i-1][j][k];
							}
							wDir[i-1][j][k] = temp;
						}
					}
				}
				//update biases
				for (int j = 0; j < biases[i-1].length; j++){
					temp = error[i-1][j] > 0;
					if (temp == bDir[i-1][j]){
						if (temp){
							biases[i-1][j] += bIncr[i-1][j];
						}else{
							biases[i-1][j] -= bIncr[i-1][j];
						}
						bTimes[i-1][j]++;
						if (bTimes[i-1][j]==DOUBLING_TIME){
							bIncr[i-1][j] *= 2;
							bTimes[i-1][j] = 0;
						}
					}else{
						bIncr[i-1][j] /= 2;
						bTimes[i-1][j] = 0;
						if (temp){
							biases[i-1][j] += bIncr[i-1][j];
						}else{
							biases[i-1][j] -= bIncr[i-1][j];
						}
						bDir[i-1][j] = temp;
					}
				}
			}
		}
	}
	
	/**
	 * Output final interpreted result of neural net
	 * @param input: input into the neural net
	 * @throws IOException
	 */
	public void output(String input) throws IOException{
		
	}
	
	public String convertRawOutput(double[] output){
		return "";
	}
	
	/**
	 * convert a processed output to a raw output
	 * @param a
	 * @return
	 */
	public double[] convertToOutput(int a){
		return new double[1];
	}
	
	/**
	 * Takes an acceptable input and outputs raw neural net outputs, also updating the a and z arrays
	 * @param inputArray array of raw integer inputs
	 * @return array of raw integer outputs
	 */
	public double[] next(ArrayList<Integer> inputArray){
		//convert inputArray into a double array
		double[] fromNodes = new double[NUM_INPUTS];
		for (int i = 0; i < inputArray.size(); i++){
			fromNodes[i]=inputArray.get(i);
			a[0][i] = fromNodes[i];
		}
		
		return next(fromNodes);
	}
	
	/**
	 * Takes an acceptable input and outputs raw neural net outputs, also updating the a and z arrays
	 * @param inputArray array of raw integer inputs
	 * @return array of raw integer outputs
	 */
	public double[] next(double[] inputArray){
		double[] fromNodes = inputArray.clone();
		double[] toNodes = new double[1];
		
		for (int i = 0; i < weights.length; i++){ // i indicates which 2 layers are interacting, i=0 means layers 0 and 1
			toNodes = new double[network[i+1]];
			for (int j = 0; j < toNodes.length; j++){ //j indicates the node on the to layer being processed
				z[i][j] = dot(weights[i][j],fromNodes)+biases[i][j];
				a[i+1][j] = sigmoid(z[i][j]);
				toNodes[j]=a[i+1][j];
			}
			fromNodes = toNodes.clone();
		}
		return toNodes;
	}
	
	public void save(String file) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(file)));
		for (int i = 0; i < biases.length; i++){
			for (int j = 0; j < biases[i].length; j++){
				writer.write(biases[i][j]+" ");
			}
			writer.newLine();
		}
		for (int i = 0; i < weights.length; i++){
			for (int j = 0; j < weights[i].length; j++){
				for (int k = 0; k < weights[i][j].length; k++){
					writer.write(weights[i][j][k]+" ");
				}
				writer.write("\n");
			}
		}
		writer.close();
	}
	
	public void read(String file) throws IOException{
		Scanner scan = new Scanner(new File("Save"));
		for (int i = 0; i < biases.length; i++){
			for (int j = 0; j < biases[i].length; j++){
				biases[i][j]=scan.nextDouble();
			}
		}
		for (int i = 0; i < weights.length; i++){
			for (int j = 0; j < weights[i].length; j++){
				for (int k = 0; k < weights[i][j].length; k++){
					weights[i][j][k] = scan.nextDouble();
				}
			}
		}
		scan.close();
	}
	
	public void train(String file) throws IOException{
		BatchManager manager = new BatchManager();
		double[] averageCosts = new double[NUM_OUTPUTS];
		ArrayList<double[]> answers = new ArrayList<double[]>();
		ArrayList<double[]> inputs;
		ArrayList<double[]> correctOutputs;
		int batchSize;
		
		//repeat for every rep
		for (int i = 0; i < NUM_TRAINING_REPS; i++){
			if (i%20==0){
				System.out.println((i+0.0)/NUM_TRAINING_REPS*100+"% done.");
			}
			while(manager.hasNextBatch()){
				//get batch
				inputs = manager.getNextInputs();
				correctOutputs = manager.getNextOutputs();
				batchSize = inputs.size();
				
				//calculate average costs
				for (int k = 0; k < batchSize; k++){ //for each case
					//calculate and save answer
					answers.add(next(inputs.get(k)));
					averageCosts = add(averageCosts,costDerivative(answers.get(k),correctOutputs.get(k)));
				}
				for (int j = 0; j < averageCosts.length; j++){
					averageCosts[j]/=(batchSize);
				}
				
				//train
				for (int j = 0; j < batchSize; j++){ //for each element in the batch
					next(inputs.get(j));
					update(averageCosts);
				}
				answers.clear();
			}
		}
	}
	
	public double[][] getBiases(){
		return biases;
	}
	
	public double dot(double[] a, double[]b){
		double sum = 0.0;
		for (int i = 0; i < a.length; i++){
			sum += a[i]*b[i];
		}
		return sum;
	}
	
	public double costDerivative(double output, double actual){
		return output-actual;
	}
	
	public double[] costDerivative(double[] output, double[] actual){
		double[] answer = new double[output.length];
		for (int i = 0; i < output.length; i++){
			answer[i] = costDerivative(output[i],actual[i]);
		}
		return answer;
	}
	
	public double softMax(double[] z, int ind){
		double sum = 0;
		for (int i = 0; i < z.length; i++){
			sum+=z[i];
		}
		return Math.exp(z[ind])/Math.exp(sum);
	}
	
	public void setupNetwork(){
		Random rand = new Random();
		//set up network size
		network = new int[NUM_HIDDEN_LEVELS+2];
		network[0]=NUM_INPUTS;
		for (int i = 0; i < NUM_HIDDEN_LEVELS; i++){
			network[i+1]=HIDDEN_LEVEL_SIZES[i];
		}
		network[NUM_HIDDEN_LEVELS+1]=NUM_OUTPUTS;
				
		//generate initial biases and bias values
		biases = new double[network.length-1][];
		bDir = new boolean[network.length-1][];
		bIncr = new double[network.length-1][];
		bTimes = new int[network.length-1][];
		for (int i = 0; i < network.length-1; i++){
			biases[i] = new double[network[i+1]];
			bDir[i] = new boolean[network[i+1]];
			bIncr[i] = new double[network[i+1]];
			bTimes[i] = new int[network[i+1]];
			for (int j = 0; j < biases[i].length; j++){
				biases[i][j] = rand.nextDouble()*(rand.nextInt(2)-0.5)/0.5;
				bDir[i][j] = true;
				bIncr[i][j] = INCREMENT;
				bTimes[i][j] = 0;
			}
		}
				
		//generate initial weights and weight values
		weights = new double[network.length-1][][];
		wDir = new boolean[network.length-1][][];
		wIncr = new double[network.length-1][][];
		wTimes = new int[network.length-1][][];
		for (int i = 0; i < weights.length; i++){
			weights[i] = new double[network[i+1]][network[i]];
			wDir[i] = new boolean[network[i+1]][network[i]];
			wIncr[i] = new double[network[i+1]][network[i]];
			wTimes[i] = new int[network[i+1]][network[i]];
			for (int j = 0; j < weights[i].length; j++){
				for (int k = 0; k < weights[i][j].length; k++){
					weights[i][j][k] = rand.nextDouble()*(rand.nextInt(2)-0.5)/0.5;
					wDir[i][j][k] = true;
					wIncr[i][j][k] = INCREMENT;
					wTimes[i][j][k] = 0;
				}
			}
		}
		
		//generate activation, weighted input and error arrays
		a = new double[network.length][];
		z = new double[network.length-1][];
		error = new double[network.length-1][];
		a[0] = new double[NUM_INPUTS];
		for (int i = 0; i < NUM_HIDDEN_LEVELS; i++){
			a[i+1] = new double[HIDDEN_LEVEL_SIZES[i]];
			z[i] = new double[HIDDEN_LEVEL_SIZES[i]];
			error[i] = new double[HIDDEN_LEVEL_SIZES[i]];
		}
		a[a.length-1] = new double[NUM_OUTPUTS];
		z[z.length-1] = new double[NUM_OUTPUTS];
		error[error.length-1] = new double[NUM_OUTPUTS];	
	}
	
	public double sigmoid(double z){
		return 1.0/(1.0+Math.exp(-z));
	}
	
	public void sigmoid(double[] z){
		for (int i = 0; i < z.length; i++){
			z[i]=sigmoid(z[i]);
		}
	}
	
	public double sigmoidPrime(double z){
		return sigmoid(z)*(1-sigmoid(z));
	}
	
	public double[] sigmoidPrime(double[] z){
		double[] a = new double[z.length];
		for (int i = 0; i < z.length; i++){
			a[i]=sigmoidPrime(z[i]);
		}
		return a;
	}
	
	public void printArray(double[] arr){
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public double[] add(double[] a, double[] b){
		double[] c = new double[a.length];
		for (int i = 0; i < a.length; i++){
			c[i]=a[i]+b[i];
		}
		return c;
	}
	
	public double[] mult(double[] a, double[] b){
		double[] c = new double[a.length];
		for (int i = 0; i < a.length; i++){
			c[i]=a[i]*b[i];
		}
		return c;
	}
	
	public double[] mult(double[][]a, double[]b){
		double[] c = new double[a.length];
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < b.length; j++){
				c[i] += a[i][j]*b[j];
			}
		}
		return c;
	}

	/**
	 * Prepares, formats and returns input and output batches
	 * @author maxda
	 *
	 */
	private class BatchManager{
		
		BatchManager(){
			
		}
		
		boolean hasNextBatch(){
			return true;
		}
		
		ArrayList<double[]> getNextInputs(){
			return new ArrayList<double[]>();
		}
		
		ArrayList<double[]> getNextOutputs(){
			return new ArrayList<double[]>();
		}
		
		//reset batches
		void reset(){
			
		}
		
	}
}

