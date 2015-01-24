package net.example.blackjack;

public class Deck {
	final Card cards[];
	private int nextCard = 0;

	public Deck() {
		cards = new Card[52];
		for (int i = 0; i < 4; i++)
			for (Rank r : Rank.values())
				cards[i] = new Card(r);
	}

	public void shuffle() {

	}

	public Card getTopCard() {
		// FIXME: next card can go past end of deck!
		return cards[nextCard++];
	}

	public void deal(int ncards, Player... players) {
		for (int i = 0; i < ncards; i++)
			for (Player p : players)
				p.addCardToHand(getTopCard());
	}

}
