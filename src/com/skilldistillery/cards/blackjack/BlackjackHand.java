package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand{
	
	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int sum = 0;
		
		for(Card card : getCards()) {
			sum += card.getValue();
		}
		
		return sum;
	}
	
	public int getHandValue(boolean dealer) {
		int sum = 0;
		if(dealer) {
			for(Card card : getCards()) {
				sum += card.getValue();
			}
			return sum;
		} else {
			sum = getCards().get(1).getValue();
			return sum;
		}
	}
	
	public boolean isBlackjack() {
		if(getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBust() {
		if(getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}
}
