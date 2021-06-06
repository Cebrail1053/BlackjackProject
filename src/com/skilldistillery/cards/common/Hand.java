package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public void clearHand() {
		cards.clear();
	}

	public List<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		String cardHand = "";
		for (Card card : cards) {
			cardHand += card.toString() + "\n";
		}
		return cardHand;
	}

	public abstract int getHandValue();
}
