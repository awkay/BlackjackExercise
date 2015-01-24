package net.example.blackjack;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankSpec {
	@Test
	public void has_13_distinct_ranks() {
		assertEquals(13, Rank.values().length);
	}
}
