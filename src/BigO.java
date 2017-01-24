import java.util.Scanner;

public class BigO {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		System.out.println("Insert how long the deck will be: ");
		int length = reader.nextInt();
		int[] deck = new int[length];
		
		for(int i = 0; i < deck.length; i++) {
			
			System.out.println("Insert a number: ");
			deck[i] = reader.nextInt();
			
		}
		
		int[] shuffledDeck = new int[deck.length];
		for(int i = 0; i < deck.length; i++) {
			shuffledDeck[i] = deck[i];
		}
		
		shuffledDeck = shuffle(shuffledDeck);
		
		displayArray(shuffledDeck);
		
		int[] reversedDeck = new int[deck.length];
		for(int i = 0; i < deck.length; i++) {
			shuffledDeck[i] = deck[i];
		}
		
		reversedDeck = reverse(deck);
		
		displayArray(reversedDeck);
		
		System.out.println(hasAFullHouse(deck));
		
	}
	
	public static int[] shuffle(int[] cards) {
		
		int[] shuffleDeck = cards;
		int tempPlace = 0;
		int tempVal = 0;
		
		for(int i = 0; i < cards.length; i++) {
			tempPlace = (int) (Math.random() * (cards.length));
			tempVal = shuffleDeck[i];
			
			shuffleDeck[i] = cards[tempPlace];
			shuffleDeck[tempPlace] = tempVal;
			
		}
		
		return shuffleDeck;
		
	}
	
	public static int[] reverse(int[] cards) {
		
		int[] reverseDeck = new int[cards.length];
		
		for(int i = 0; i < (int) ((cards.length + 1)/ 2); i++) {
			
			reverseDeck[i] = cards[cards.length - i - 1];
			reverseDeck[cards.length - i - 1] = cards[i];
			
		}
		
		return reverseDeck;
	}
	
	public static boolean hasAFullHouse(int[] cards){
		
		boolean hasDouble = false;
		double numberWithDouble = .1;
		boolean hasTripple = false;
		double numberWithTripple = .1;
		int multiples = 0;
		
		for(int i = 0; i < cards.length; i++) {
			multiples = 0;
			if(cards[i] != numberWithDouble && cards[i] != numberWithTripple) {
				for(int j = 0; j < cards.length; j++) {
					if(cards[i] == cards[j]) {
						multiples ++;
					}
				}
			}
			if(multiples >= 2) {
				if(multiples == 2) {
					hasDouble = true;
					numberWithDouble = cards[i];
				} else if(multiples >= 3 && hasTripple) {
					hasDouble = true;
					numberWithDouble = cards[i];
				} else {
					hasTripple = true;
					numberWithTripple = cards[i];
				}
			}
			
		}
		
		return (hasDouble && hasTripple);
		
	}
	
	public static void displayArray(int[] ary) {
		for(int i = 0; i < ary.length; i++) {
			System.out.print(ary[i] + "   ");
		}
		System.out.println("");
	}

}