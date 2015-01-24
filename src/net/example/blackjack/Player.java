package net.example.blackjack;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> cards = new ArrayList<Card>();

	public void addCardToHand(Card c) {
		cards.add(c);
	}
}
