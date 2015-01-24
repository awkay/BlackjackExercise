package net.example.blackjack;

import java.util.Random;

public class Blackjack {
	final Deck deck;
	final Player human, dealer;

	public Blackjack() {
		deck = new Deck();
		human = new Player();
		dealer = new Player();
	}

	public void play() {
		deck.shuffle(new Random());
		deck.deal(2, human, dealer);
	}

}
