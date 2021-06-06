package com.skilldistillery.cards.common;

import com.skilldistillery.cards.blackjack.BlackjackHand;

public class Player {
	private String name;
	private BlackjackHand hand;
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	public Player(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addCardToHand(Card card) {
		hand.addCard(card);
	}
	
	public void fold() {
		hand.clearHand();
	}
	
	public void printCurrentValue() {
		System.out.print("Player Hand Value: " + hand.getHandValue() + "\t");
	}

	public BlackjackHand getHand() {
		return hand;
	}
}
