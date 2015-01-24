package net.example.blackjack;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class DeckSpec {
	@Test
	public void has_four_of_each_rank_when_created() {
		Deck d = new Deck();
		assertHasFourOfEachSuit(d);
	}

	@Test
	public void has_four_of_each_rank_after_shuffling() {
		Deck d = new Deck();
		d.shuffle(new Random());
		assertHasFourOfEachSuit(d);
	}

	@Test
	public void can_be_asked_for_the_top_card() {
		Deck d = new Deck();
		assertNotNull(d.getTopCard());
	}

	@Test
	public void will_return_null_after_running_out_of_the_52_cards() {
		Deck d = new Deck();

		for (int i = 0; i < 52; i++)
			assertNotNull(d.getTopCard());

		assertNull(d.getTopCard());
	}
	
	@Test
	public void shuffling_assumes_all_cards_are_returned_to_deck() {
		can_be_reshuffled_to_return_another_52_cards();
	}

	@Test
	public void can_be_reshuffled_to_return_another_52_cards() {
		Deck d = new Deck();

		for (int i = 0; i < 52; i++)
			assertNotNull(d.getTopCard());
		assertNull(d.getTopCard());
		
		d.shuffle(new Random());
		
		for (int i = 0; i < 52; i++)
			assertNotNull(d.getTopCard());
		assertNull(d.getTopCard());
	}

	@Test
	public void can_deal_n_cards_to_an_arbitrary_number_of_players() {
		fail("TODO");
	}

	@Test
	public void initial_deck_is_unshuffled() {
		Deck d = new Deck();
		
		assertEquals(Rank.Ace, d.cards[0].rank);
		assertEquals(Rank.Two, d.cards[1].rank);
		assertEquals(Rank.Three, d.cards[2].rank);
	}

	@Test
	public void shuffling_causes_cards_to_be_in_a_randomized_order() {
		Deck d = new Deck();
		Random r = new Random();
		r.setSeed(42);
		
		d.shuffle(r);

		assertEquals(Rank.Three, d.cards[0].rank);
		assertEquals(Rank.Six, d.cards[1].rank);
		assertEquals(Rank.Jack, d.cards[2].rank);
		assertEquals(Rank.Seven, d.cards[3].rank);
		assertEquals(Rank.Eight, d.cards[4].rank);
	}

	private void assertHasFourOfEachSuit(Deck d) {
		int rankSeen[] = new int[13];

		for (int i = 0; i < 52; i++) {
			Card c = d.getTopCard();
			Rank r = c.rank;
			int n = r.ordinal();
			rankSeen[n]++;
		}

		for (int i = 0; i < rankSeen.length; i++)
			assertEquals(4, rankSeen[i]);
	}

}
