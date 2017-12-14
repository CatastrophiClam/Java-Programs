package March1HmwkCh8;

public class Location {
	double[][]array;
	int row;
	int column;
	double maxValue;
	public Location(double[][]array){
		this.array = array;
	}
	
	public void findLocation(){
		maxValue = array[0][0];
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				if (array[i][j] > maxValue){
					maxValue = array[i][j];
					row = i;
					column = j;
				}
			}
		}
	}
}
