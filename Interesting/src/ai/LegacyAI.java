package ai;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class LegacyAI {
	//--------------GENERAL AI SETTINGS AND VARIABLES------------------//
	private ArrayList<Integer> inputArray;
	private final int NUM_INPUTS = 5500;
	private final int NUM_HIDDEN_LEVELS = 2;
	private final int[] HIDDEN_LEVEL_SIZES;
	private final int NUM_OUTPUTS = 55;
	private final double ETA = 2;
	private final int NUM_REPS = 1;
	private final int NUM_TRAINING_REPS = 20;
	private final int BATCH_SIZE = 10;
	private boolean readFromSave = false;
	
	private double[][] biases; //first index is layer, second index is node
	private double[][][] weights; //first indicates from which layer to which (0 indicates from input to 1st hidden layer), second index is the to layer, third is the from layer
	private int[] network;
	private int[] answer;
	private ArrayList<int[]> answers;
	
	private double[][] a;
	private double[][] z;
	private double[][] error;
	
	private ArrayList<String> desiredBatch;
	private ArrayList<String> answerBatch;
	//----------------------------------------------------------------//
	
	private final int LINES_TO_GENERATE = 20;
	
	{
		HIDDEN_LEVEL_SIZES = new int[]{50,50,50,50,100,100,100,100,100,100};
		inputArray = new ArrayList<Integer>(NUM_INPUTS);
		desiredBatch = new ArrayList<String>();
		answerBatch = new ArrayList<String>();
		answers = new ArrayList<int[]>();
	}
	
	public LegacyAI() throws IOException{
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
		//Option to do multiple reps on the same cost
		for (int r = 0; r < NUM_REPS; r++){
			//determine final error
			for (int i = 0; i < NUM_OUTPUTS; i++){
				//error[error.length-1][i] = costDerivative(answer[i],toInt(desired.charAt(i)))*sigmoidPrime(z[error.length-1][i]);
				error[error.length-1][i] = averageCosts[i]*sigmoidPrime(z[error.length-1][i]);
			}
			
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
						weights[i-1][j][k] = weights[i-1][j][k] - ETA*a[i-1][k]*error[i-1][j];
					}
				}
				//update biases
				for (int j = 0; j < biases[i-1].length; j++){
					biases[i-1][j] = biases[i-1][j] - ETA*error[i-1][j];
				}
			}
		}
	}
	
	public void write(String input) throws IOException{
		inputArray.clear();
		String toWrite;
		double[] rawOutput;
		File output = new File("Output");
		BufferedWriter out = new BufferedWriter(new FileWriter(output));
		
		for (int i = 0; i < input.length(); i++){
			inputArray.add(toInt(input.charAt(i)));
		}
		for (int i = 0; i < LINES_TO_GENERATE; i++){
			rawOutput = next(inputArray);
			toWrite = convertRawOutput(rawOutput);
			//update input array
			for (int j = 0; j < toWrite.length(); j++){
				inputArray.add(toInt(toWrite.charAt(j)));
			}
			out.write(toWrite);
			out.newLine();
		}
		out.close();
	}
	
	public String convertRawOutput(double[] output){
		int[] answer = interpret(output);
		String returnString = "";
		for (int i = 0; i < answer.length; i++){
			returnString += toChar(answer[i]);
		}
		return returnString;
	}
	
	/**
	 * 
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
	
	public char toChar(int a){
		String key = "!?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ,'";
		return key.charAt(a);
	}
	
	public int toInt(char a){
		int n = (int)a;
		if (n == 33){
			return 0;
		}else if (n == 32){
			return 55;
		}else if (n == 44){
			return 56;
		}else if (n == 39){
			return 57;
		}else{
			if (n < 97){
				return n-62;
			}else{
				return n-97+29;
			}
		}
	}
	
	public int[] interpret(double[] a){
		int[] answer = new int[a.length];
		for (int i = 0; i < a.length; i++){
			answer[i]=(int)(Math.round(a[i]*100)%58);
		}
		return answer;
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
		File template = new File(file);
		Scanner reader = new Scanner(template);
		String temp,line;
		double[] averageCosts = new double[NUM_OUTPUTS];
		temp = reader.nextLine();
		int record = 1;
		boolean clear = false;
		ArrayList<Integer> inputArrayClone = new ArrayList<Integer>();
		//repeat for every rep
		for (int i = 0; i < NUM_TRAINING_REPS; i++){
			if (i%20==0){
				System.out.println((i+0.0)/NUM_TRAINING_REPS*100+"% done.");
			}
			while(reader.hasNextLine()){
				//get batch
				for (int j = 0; j < BATCH_SIZE && reader.hasNextLine(); j++){
					record = j;
					answerBatch.add(temp);
					desiredBatch.add(temp = reader.nextLine());
					if (temp.equals("")){
						answerBatch.remove(answerBatch.size()-1);
						desiredBatch.remove(desiredBatch.size()-1);
						record--;
						if (reader.hasNextLine()){
							clear = true;
							temp = reader.nextLine();
						}
						break;
					}
				}
				//calculate average costs
				for (int k = 0; k <= record; k++){ //for each case
					//add current activition into input array
					for (int l = 0; l < answerBatch.get(k).length(); l++){
						inputArrayClone.add(toInt(answerBatch.get(k).charAt(l)));
					}
					answers.add(interpret(next(inputArrayClone)));
					for (int j = 0; j < NUM_OUTPUTS; j++){ //for each output in the output vector
						if (j >= desiredBatch.get(k).length()){
							averageCosts[j] += answers.get(k)[j];
						}else{
							averageCosts[j] += costDerivative(answers.get(k)[j],toInt(desiredBatch.get(k).charAt(j)));
						}
					}
				}
				for (int j = 0; j < averageCosts.length; j++){
					averageCosts[j]/=(record+1);
				}
				//train
				for (int j = 0; j <= record; j++){ //for each element in the batch
					for (int k = 0; k < answerBatch.get(j).length(); k++){ // for every answer in that element
						inputArray.add(toInt(answerBatch.get(j).charAt(k)));
					}
					answers.add(interpret(next(inputArray)));
					update(averageCosts);
				}
				answerBatch.clear();
				desiredBatch.clear();
				answers.clear();
				if (clear){
					inputArray.clear();
					inputArrayClone.clear();
					clear = false;
				}
			}
			reader.close();
			reader = new Scanner(template);
		}
		reader.close();
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
				
		//generate initial biases
		biases = new double[network.length-1][];
		for (int i = 0; i < network.length-1; i++){
			biases[i]=new double[network[i+1]];
			for (int j = 0; j < biases[i].length; j++){
				biases[i][j]=rand.nextDouble()*(rand.nextInt(2)-0.5)/0.5;
			}
		}
				
		//generate initial weights
		weights = new double[network.length-1][][];
		for (int i = 0; i < weights.length; i++){
			weights[i] = new double[network[i+1]][network[i]];
			for (int j = 0; j < weights[i].length; j++){
				for (int k = 0; k < weights[i][j].length; k++){
					weights[i][j][k]=rand.nextDouble()*(rand.nextInt(2)-0.5)/0.5;
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
	
	public void sigmoidPrime(double[] z){
		for (int i = 0; i < z.length; i++){
			z[i]=sigmoidPrime(z[i]);
		}
	}
	
	public void printArray(double[] arr){
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

