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

	/**
	 * Tests should, in general, have three sections/steps:
	 * 
	 * Arrange
	 * Act
	 * Assert
	 */
	@Test
	public void has_four_of_each_rank_after_shuffling() {
		Deck d = new Deck(); // arrange

		d.shuffle(new Random()); // do the action under test

		assertHasFourOfEachSuit(d); // assert what should have happened
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
		// these mean the same thing, but it is nice to say so
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
		r.setSeed(42); // predictable sequence of "random numbers"
		
		d.shuffle(r);

		// Assert that the deck is indeed randomized given the above sequence of random numbers
		// This makes the test "stable" while still proving that shuffle mixes the cards
		// Note that since we're using the same "random sequence" every time the test runs, the
		// resulting card order in the deck will be fixed as well. 
		assertEquals(Rank.Three, d.cards[0].rank);
		assertEquals(Rank.Six, d.cards[1].rank);
		assertEquals(Rank.Jack, d.cards[2].rank);
		assertEquals(Rank.Seven, d.cards[3].rank);
		assertEquals(Rank.Eight, d.cards[4].rank);
	}

	private void assertHasFourOfEachSuit(Deck d) {
		int rankSeen[] = new int[13]; // 13 different ranks

		for (int i = 0; i < 52; i++) {
			Card c = d.getTopCard();
			Rank r = c.rank; 
			int n = r.ordinal(); // Java enumerations "come with" a function named ordinal which returns 0..# items in enum
			rankSeen[n]++;
		}

		for (int i = 0; i < rankSeen.length; i++)
			assertEquals(4, rankSeen[i]);
	}

}
