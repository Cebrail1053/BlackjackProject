package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Player;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean keepGoing = false;
		
		welcome();
		
		Dealer dealer = new Dealer("Dealer");
		Player player = new Player("Player 1");

		do {
			dealer.deal(player);
			dealer.deal(dealer);
			if (player.getHand().isBlackjack()) {
				System.out.println("BlackJack! " + player.getName() + " Wins!");
			} else if (player.getHand().isBust()) {
				System.out.println(player.getName() + " Busts!");
			} else {
				playTurns(player, dealer, sc);
			}
			player.getHand().clearHand();
			dealer.getHand().clearHand();
			
			System.out.print("\nPlay Again? (Y or N) ");
			String choice = sc.nextLine();
			keepGoing = keepPlaying(choice);
			
		} while (keepGoing);
	}

	public void playTurns(Player player, Dealer dealer, Scanner sc) {
		boolean dealerTurn = false;
		String winner = null;

		printValues(player, dealer, dealerTurn);
		while (winner == null) {
			if (dealerTurn) {
				if (dealer.getHand().getHandValue() < 17) {
					dealer.hit(dealer);
					System.out.println();
					printValues(player, dealer, dealerTurn);
				} else {
					winner = checkWinner(player, dealer, dealerTurn);
				}
			} else {
				printMenu();
				int choice = sc.nextInt();
				sc.nextLine();

				if (choice == 1) {
					dealer.hit(player);
					printValues(player, dealer, dealerTurn);
					winner = checkWinner(player, dealer, dealerTurn);
				} else if (choice == 2){
					dealerTurn = true;
					System.out.println("\n\t ******** Dealers Turn ********");
					printValues(player, dealer, dealerTurn);
				} else {
					System.out.println("Invalid Selection! Please Try Again");
				}
			}
		}

		if(winner.equals("Draw")) {
			System.out.println("\nNo Winner! It is a Draw");
		} else {
			System.out.println(winner + " Wins!");
		}
	}

	public String checkWinner(Player player, Dealer dealer, boolean turn) {
		String winner = null;
		if (turn == true) {
			if (dealer.getHand().isBlackjack()) {
				System.out.print("\n21! ");
				winner = dealer.getName();
			} else if (dealer.getHand().isBust()) {
				System.out.println(dealer.getName() + " Busts!\n");
				winner = player.getName();
			} else if (dealer.getHand().getHandValue() > player.getHand().getHandValue()) {
				System.out.println();
				winner = dealer.getName();
			} else if (dealer.getHand().getHandValue() < player.getHand().getHandValue()){
				System.out.println();
				winner = player.getName();
			} else {
				winner = "Draw";
			}
		} else {
			if (player.getHand().isBlackjack()) {
				System.out.print("\n21! ");
				winner = player.getName();
			} else if (player.getHand().isBust()) {
				System.out.println(player.getName() + " Busts!\n");
				winner = dealer.getName();
			}
		}
		return winner;
	}

	public void printMenu() {
		System.out.println("------- Menu -------");
		System.out.println("1. Hit");
		System.out.println("2. Stay");
	}

	public void printValues(Player player, Dealer dealer, boolean turn) {
			player.printCurrentValue();
			dealer.printCurrentValue(turn);
	}
	
	public void welcome() {
		System.out.println("\t********************************");
		System.out.println("\t*     Welcome to BlackJack     *");
		System.out.println("\t********************************");
		System.out.println();
	}
	
	public boolean keepPlaying(String input) {
		boolean choice = false;
		switch(input) {
		case "Y":
		case "y":
		case "Yes":
		case "yes":
			choice = true;
			break;
		case "N":
		case "n":
		case "No":
		case "no":
			choice = false;
			break;
		}
		
		return choice;
	}
}
