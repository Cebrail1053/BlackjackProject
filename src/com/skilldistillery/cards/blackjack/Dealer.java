package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Player;

public class Dealer extends Player {
	private Deck deck;
	
	public void deal(Player player) {
		deck.shuffle();
		for(int i = 0; i < 2; i++) {
			player.addCardToHand(deck.dealCard());
		}
	}
	
	public void hit(Player player) {
		player.addCardToHand(deck.dealCard());
	}
	
	public void printCurrentValue(boolean turn) {
		System.out.println("\tDealer Hand Value: " + getHand().getHandValue(turn));
	}

	public Dealer() {
		super();
	}

	public Dealer(String name) {
		super(name);
		deck = new Deck();
	}

}
