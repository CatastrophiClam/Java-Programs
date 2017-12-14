package jan18hmwk;
import java.util.Random;
public class CardPickFullCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		boolean spades = false;
		boolean clubs = false;
		boolean hearts = false;
		boolean diamonds = false;
		String [] cards = {"Ace of ", "Two of ", "Three of ", "Four of ","Five of ","Six of ","Seven of ","Eight of ", "Nine of ","Ten of ","Jack of ","Queen of ","King of "};
		String [] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
		int card;
		int suit;
		int counter = 0;
		while (!spades||!clubs||!hearts||!diamonds){   // while we haven't found all four suits
			counter += 1;
			card = random.nextInt(13);   // random card
			suit = random.nextInt(4);    
			switch (suit){
			case 0:
				spades = true;
				break;
			case 1:
				clubs = true;
				break;
			case 2:
				hearts = true;
				break;
			case 3:
				diamonds = true;
				break;
			}
			System.out.println(cards[card]+suits[suit]);
		}
		System.out.println("Number of picks: "+counter);
	}

}
