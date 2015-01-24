package net.example.blackjack;

import java.util.Random;

public class Deck {
	final Card cards[];
	private int nextCard = 0;

	public Deck() {
		int index = 0;
		cards = new Card[52];
		for (int i = 0; i < 4; i++)
			for (Rank r : Rank.values())
				cards[index++] = new Card(r);
	}

	public void shuffle(Random r) {
		nextCard = 0;
		for (int i = 0; i < 1000; i++) {
			final int pos1 = r.nextInt(52);
			final int pos2 = r.nextInt(52);
			Card tmp = cards[pos1];
			cards[pos1] = cards[pos2];
			cards[pos2] = tmp;
		}
	}

	public Card getTopCard() {
		if (nextCard == cards.length)
			return null;
		return cards[nextCard++];
	}

	public void deal(int ncards, Player... players) {
		for (int i = 0; i < ncards; i++)
			for (Player p : players)
				p.addCardToHand(getTopCard());
	}

}
