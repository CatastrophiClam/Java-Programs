package usaco;

/*
ID: Max
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

/**
 * Convert the necklace into an array of the lengths of the different sections of red/blue beads 
 * The lengths of the sections of white beads are added to the adjacent red/blue bead sections
 * Find the two longest consecutive lengths
 */

class beads {

	public static void main(String[] args) throws IOException{ 
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));  //reader
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out"))); //writer
		ArrayList<Integer> lengths = new ArrayList<Integer>();  // array of section lengths
		HashMap<Integer,Integer>overlap = new HashMap<Integer,Integer>(); // for when two sections share the same white section
		int numBeads; //number of beads
		int currentLength = 0; //lenght of current section
		int maxLength = 0; // maximum length of two consecutive sections
		char firstChar; //first char in the string - we need this to see if the last section can 'connect' with the first section
		boolean lookingForFirstChar; // if the first char is white, we need to keep looking until we find a red or blue
		char currentChar; //current char we're dealing with
		char prevChar; //previous char we just read
		char prevColour; //previous colour we just read (not including white)
		
		//read number of beads
		numBeads = Integer.parseInt(reader.readLine());
		
		//make sure there are actually chars to read
		if (numBeads == 0){
			out.println(0);
			out.close();
			return;
		}
		
		//read the first character
		prevChar = (char)reader.read();
		firstChar = prevChar;
		prevColour = prevChar;  
		currentLength ++;
		if (firstChar == 'w'){
			lookingForFirstChar = true;
		}else{
			lookingForFirstChar = false;
			lengths.add(0);  //create new section
		}
		
		//read rest of the characters
		if (numBeads != 1){
			for (int i = 1; i < numBeads; i++){
				currentChar = (char)reader.read();
				//if the char we're currently looking at is the same as the previous char, increase the current length
				if (currentChar == prevChar){
					currentLength++;
				}else{
					// otherwise
					if (currentChar == 'w'){
						prevColour = prevChar;
						lengths.add(lengths.remove(lengths.size()-1)+currentLength); //update past section's length
						currentLength = 1;
					}else{
						//current bead is either red or blue; we're creating a new section
						if (lookingForFirstChar){
							firstChar = currentChar;
							lookingForFirstChar = false;
						}
						//add a new slot in arraylist: lengths
						//if the previous char was white
						if (prevChar == 'w'){
							// this is the case where we have two sections of the same colour separated by a white section
							if (prevColour == currentChar){
								// this is just one big section
								lengths.add(lengths.remove(lengths.size()-1)+currentLength);
							}else{
								//otherwise
								if (lengths.size() > 0)
								lengths.add(lengths.remove(lengths.size()-1)+currentLength); //update past section's length
								//create a new section; its length is as long as the previous white section
								lengths.add(currentLength);
								//there will be overlap
								overlap.put(lengths.size()-1, currentLength);
							}
						}else{
							//previous section was a different colour
							lengths.add(lengths.remove(lengths.size()-1)+currentLength); //update past section's length
							lengths.add(0); //create current section
						}
						currentLength = 1;
						prevColour = currentChar;
					}
				}
				prevChar = currentChar;
			}
			//update last section's length
			if (lengths.size() > 0){
				lengths.add(lengths.remove(lengths.size()-1)+currentLength); //update past section's length
				if (lengths.size() == 1){
					maxLength = currentLength;
				}
			}else{
				lengths.add(currentLength);
				maxLength = currentLength;
			}
			
			
			//because necklace is circular, see if end and beginning of string are one big section
			if (!lookingForFirstChar){
				if (lengths.size()>1){
					if (firstChar == prevColour){
						// if they are, set them both to their sum
						lengths.add(0,lengths.remove(0)+lengths.remove(lengths.size()-1));
						lengths.add(lengths.get(0));
					}
				}
			}
			
			int tempLength;
			//find longest consecutive section
			for (int i = 0; i < lengths.size()-1;i++){
				tempLength = lengths.get(i)+lengths.get(i+1);
				if (overlap.containsKey(i+1)){
					tempLength -= overlap.get(i+1);
				}
				if (tempLength>maxLength){
					maxLength = tempLength;
				}
			}
			
			out.println(maxLength);
			
		}else{
			out.println(1);
		}
		reader.close();
		out.close();
		System.exit(0);
	}

}