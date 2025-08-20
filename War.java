import java.util.*;

public class Main {
	
	static Random rand = new Random();
	static Deque<Integer> p1 = new ArrayDeque<Integer>();
	static Deque<Integer> p2 = new ArrayDeque<Integer>();
	
	public static void main(String[] args) {
		int[] deck = new int[52];

		generateDeck(deck);
		shuffleDeck(deck);
		dealCards(deck, p1, p2);
		
		Scanner scanner = new Scanner(System.in);
		while(!p1.isEmpty() && !p2.isEmpty()) {
			System.out.println("______________________________");
			System.out.println("\nPress Enter for next turn...");
			System.out.println("______________________________");
			scanner.nextLine();
			compare();
		}
		if(p1.isEmpty()) {
			System.out.println("Player 2 wins!");
		} else if (p2.isEmpty()) {
			System.out.println("Player 1 wins!");
		}
	}
	
	private static void generateDeck(int[] arr) {
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j <= 14; j++) {
				arr[i * 13 + (j - 2)] = j;
			}
		}
	
	}
	
	private static void shuffleDeck(int[] arr) {
		for(int i = 0; i < 52; i++) {
			int temp = 0;
			// Pick two cards between index 0 - 51
			int c1 = rand.nextInt(52);
			int c2 = rand.nextInt(52);
			
			// Swap the cards
			temp = arr[c1];
			arr[c1] = arr[c2];
			arr[c2] = temp;
		}
	}
	
	private static void dealCards(int[] arr, Deque<Integer> s1, Deque<Integer> s2) {
		for(int i = 0; i < 52; i++) {
			if(i % 2 == 1) {
				s1.addFirst(arr[i]);
			} else {
				s2.addFirst(arr[i]);
			}
		}
	}
	
	private static void compare() {
		int c1 = p1.removeFirst();
		int c2 = p2.removeFirst();
			
		List<Integer> pile = new ArrayList<>();
		pile.add(c1);
		pile.add(c2);
		System.out.println("Player 1 card: " + c1);
		System.out.println("Player 2 card: " + c2);
			
		if (c1 < c2) {
			p2.addAll(pile);
			System.out.println("\nPlayer 2 won!");
			System.out.println("\nPlayer 1 hand size: " + p1.size());
			System.out.println("Player 2 hand size: " + p2.size() + "\n");
		} else if (c1 > c2) {
			p1.addAll(pile);
			System.out.println("\nPlayer 1 won!");
			System.out.println("\nPlayer 1 hand size: " + p1.size());
			System.out.println("Player 2 hand size: " + p2.size() + "\n");
		} else {
			System.out.println("\nWAR!\n");
				
			resolveWar(pile);
			
			}

	}
	
	private static void resolveWar(List<Integer> pile) {
		while (true) {
			for(int i = 0; i < 3; i++) {
				if (!p1.isEmpty()) pile.add(p1.removeFirst());
				if (!p2.isEmpty()) pile.add(p2.removeFirst());
			}
			if (p1.isEmpty()) {
				System.out.println("Player 1 cannot continue. Player 2 wins!");
				p2.addAll(pile);
			}
		    if (p2.isEmpty()) {
		    	System.out.println("Player 2 cannot continue. Player 1 wins!");
		    	p1.addAll(pile);
		    }
				
			int warC1 = p1.removeFirst();
			int warC2 = p2.removeFirst();
			pile.add(warC1);
			pile.add(warC2);
			
			System.out.println("Player 1 war card: " + warC1);
			System.out.println("Player 2 war card: " + warC2);
				
			if (warC1 > warC2) {
				p1.addAll(pile);
				System.out.println("\nPlayer 1 wins the war!");
				System.out.println("\nPlayer 1 hand size: " + p1.size());
				System.out.println("Player 2 hand size: " + p2.size() + "\n");
				return;
			} else if (warC1 < warC2) {
				p2.addAll(pile);
				System.out.println("\nPlayer 2 wins the war!");
				System.out.println("\nPlayer 1 hand size: " + p1.size());
				System.out.println("Player 2 hand size: " + p2.size() + "\n");
				return;
			} else {
				System.out.println("\nWar Continues");
			}
			
		}
	}
}

