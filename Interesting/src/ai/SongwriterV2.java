package ai;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class SongwriterV2 {
	//--------------AI SPECIFIC SETTINGS AND VARIABLES------------------//
	private final int NUM_INPUTS = 5500;
	private final int NUM_HIDDEN_LEVELS = 2;
	private final int[] HIDDEN_LEVEL_SIZES;
	private final int NUM_OUTPUTS = 55;
	private final double ETA = 2;
	private final int NUM_REPS = 1;   //number of times the same training case is repeated consecutively
	private final int NUM_TRAINING_REPS = 2000;  //number of times the whole set of training cases is cycled through
	private final int BATCH_SIZE = 10;
	private boolean readFromSave = true;
	private int keyLength;
	private String key = "!,?'.abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ %"; //the % is a sentinel and isn't used for the key
	private HashMap<Character,Integer> keyDict = new HashMap<Character,Integer>();
	private double spacing;
	private final int linesToWrite = 20;
	
	{
		HIDDEN_LEVEL_SIZES = new int[]{50,50,50,50,100,100,100,100,100,100};
		keyLength = key.length()-1;
		for (int i = 0; i < keyLength; i++){
			keyDict.put(key.charAt(i), i);
		}
		spacing = 1.0/keyLength;
	}
	
	//-----------------------GENERAL AI STUFF---------------------------//
	
	private double[][] biases; //first index is layer, second index is node
	private double[][][] weights; //first indicates from which layer to which (0 indicates from input to 1st hidden layer), second index is the to layer, third is the from layer
	private int[] network;
	
	private double[][] a;
	private double[][] z;
	private double[][] error;
	
	//----------------------------------------------------------------//
	
	public SongwriterV2() throws IOException{
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
	
	public void train(String file) throws IOException{
		BatchManager manager = new BatchManager();
		double[] averageCosts = new double[NUM_OUTPUTS];
		ArrayList<double[]> answers = new ArrayList<double[]>();
		ArrayList<double[]> inputs;
		ArrayList<double[]> correctOutputs;
		int batchSize;
		
		//repeat for every rep
		for (int i = 0; i < NUM_TRAINING_REPS; i++){
			if (i%(NUM_TRAINING_REPS/100)==0){
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
				//for (int j = 0; j < batchSize; j++){ //for each element in the batch
					next(inputs.get(0));
					update(averageCosts);
				//}
				averageCosts = new double[NUM_OUTPUTS];
				answers.clear();
			}
			manager.reset();
		}
	}
	
	/**
	 * Prepares, formats and returns input and output batches
	 * @author maxda
	 *
	 */
	private class BatchManager{
		
		ArrayList<double[]> inputArray;
		ArrayList<double[]> outputArray;
		ArrayList<String> currentSong;
		String input;
		boolean songsDone;
		boolean linesDone;
		Scanner scan;
		File songs;
		int lineCounter;
		
		BatchManager() throws IOException{
			inputArray = new ArrayList<double[]>();
			outputArray = new ArrayList<double[]>();
			input = "";
			songs = new File("Songs");
			scan = new Scanner(songs);
			songsDone = false;
			linesDone = false;
			lineCounter = 0;
			currentSong = new ArrayList<String>();
			readNextSong();
		}
		
		boolean hasNextBatch(){
			return !(songsDone&&linesDone);
		}
		
		ArrayList<double[]> getNextInputs(){
			String temp;
			for (int i = 0; i < BATCH_SIZE; i++){
				if (lineCounter < currentSong.size()-1){
					inputArray.add(convertToInput(input+=currentSong.get(lineCounter)));
					outputArray.add(convertToOutput(currentSong.get(lineCounter+1)));
					lineCounter++;
				}else{
					linesDone = true;
					if (!songsDone){
						readNextSong();
					}
				}
			}
			return inputArray;
		}
		
		ArrayList<double[]> getNextOutputs(){
			return outputArray;
		}
		
		void readNextSong(){
			currentSong.clear();
			lineCounter = 0;
			String temp;
			input = "";
			songsDone = true;  //assume this song is the last one unless proven otherwise
			while (scan.hasNextLine()){
				temp = scan.nextLine();
				if (temp.equals("")){
					songsDone = false;
					break;
				}
				currentSong.add(temp);
			}
			linesDone = false;
		}
		
		//reset batches
		void reset() throws IOException{
			scan = new Scanner(songs);
			inputArray.clear();
			outputArray.clear();
			songsDone = false;
			linesDone = false;
			readNextSong();
		}
		
	}
	
	/**
	* Output final interpreted result of neural net
	* @param input: input into the neural net
	* @throws IOException
	*/
	public void output(String in) throws IOException{
		BufferedWriter writer = new BufferedWriter(new PrintWriter(new File("Output")));
		String temp = "";
		String input = in;
		for (int i = 0; i < linesToWrite; i++){
			temp = convertRawOutput(next(convertToInput(input+=temp)));
			writer.write(temp+"\n");
		}
		writer.close();
	}
	
	public String convertRawOutput(double[] output){
		String answer = "";
		for (int i = 0; i < output.length; i++){
			answer += key.charAt((int)Math.round(output[i]/spacing));
		}
		return answer;
	}
	
	public double[] convertToInput(String a){
		double[] answer = new double[NUM_INPUTS];
		for (int i = 0; i < a.length(); i++){
			answer[i] = spacing/2 + keyDict.get(a.charAt(i))*spacing;
		}
		return answer;
	}
		
	/**
	* convert a processed output to a raw output
	* @param a
	 * @return
	 */
	public double[] convertToOutput(String a){
		return convertToInput(a);
	}

	
//-----------------------------------------------------------------------------------------------//
//                                   IMMUTABLE SECTION                                           //
//-----------------------------------------------------------------------------------------------//
	
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
}

