import java.util.Scanner;


public class SortedLocator {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Insert how long the deck will be: ");
		int length = reader.nextInt();
		int[] deck = new int[length];
		
		for(int i = 0; i < deck.length; i++) {
			
			System.out.println("Insert a number: ");
			deck[i] = reader.nextInt();
			
		}
		
		System.out.println("What number are you looking for:");
		int number = reader.nextInt();
		
		int[] range = {0, deck.length - 1};
		int middleOfRange = (deck.length - 1) / 2;
		int rangeDifference = deck.length;
		
		
		while(deck[middleOfRange] != number && rangeDifference > 1) {
			
			if(deck[middleOfRange] < number) {
				
				range[0] = middleOfRange;
				
			}else {
				
				range[1] = middleOfRange;
				
			}
			
			middleOfRange = (range[1] + range[0]) / 2;
			rangeDifference = Math.abs(range[1] - range[0]);
			
		}
		
		if(deck[middleOfRange] == number) {
			System.out.println(middleOfRange);
		}else if(deck[range[0]] == number) {
			System.out.println(range[0]);
		}else if(deck[range[1]] == number) {
			System.out.println(range[1]);
		}else {
			System.out.println("-1");
		}

	}

}
