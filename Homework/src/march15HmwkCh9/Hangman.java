package march15HmwkCh9;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		boolean going = true;  // is the game still going?
		boolean wordGenerated = false;  // did we generate a word yet?
		boolean checking;
		int index = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int timesOccured;
		String[] wordList = new String[]{"logorrhea", "absorbefacient", "abyssopelagic", "accrementition", "acritochromacy",
				"adiathermancy", "aggiornamento", "akeratophorous"};
		String word = "";  // word to guess
		String guessed = ""; // parts of word guessed
		String wordGuess;  // word user guessed
		String tempWord;
		int guessCount = 0;  // number of guesses
		while (going){
			if (!wordGenerated){  // if we haven't generated a word yet
				word = wordList[random.nextInt(8)];
				for (int i = 0; i < word.length(); i++){  //fill guess with asterisks
					guessed += "*";
				}
				wordGenerated = true; // now we have generated a word
			}
			System.out.printf("Enter a letter in word %s :", guessed);
			wordGuess = scan.nextLine();
			checking = true;
			while (checking){   // replace asterisks with correct letter, if any
				if (guessed.contains(wordGuess)){     // if user didn't already guess letter
					System.out.printf("%s is alread in the word", wordGuess);
				}else{
					if (word.contains(wordGuess)){  // if the letter is indeed in the word
						temp.clear();
						timesOccured = countInstances(word, wordGuess);
						for (int i = 0; i < timesOccured; i++){   // list of indices letter occurrences
							temp.add(word.indexOf(wordGuess, i));
						}
						tempWord = "";
						for (int i = 0; i < word.length(); i++){   // replace asterisks with right letter
							if (!temp.contains(i)){   
								tempWord += guessed.substring(i, i+1);
							}else{
								tempWord += wordGuess;
							}
						}
						guessed = tempWord;
						if (!guessed.contains("*")){
							System.out.print("You win!");
							going = false;
						}
					}else{
						checking = false; // word does not contain guess, stop checking
						guessCount++;
					}
				}
			}
		}
	}
	
	public static int countInstances(String word, String instance){
		int count = 0;
		for (int i = 0; i < word.length(); i ++){
			if (word.substring(i, i+1).equals(instance)){
				count++;
			}
		}
		return count;
	}

}
