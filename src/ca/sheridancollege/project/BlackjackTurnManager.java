/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Henil Patel
 */
public class BlackjackTurnManager {
    private Deck deck;
    
    public BlackjackTurnManager(Deck deck) {
        this.deck = deck;
    }

    public void handlePlayerTurn(BlackjackPlayer player) {
        Scanner scanner = new Scanner(System.in);
        while (player.getScore() < 21) {
            System.out.print("Hit or Stand? (h/s): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.receiveCard(deck.drawCard());
                System.out.println(player);
                if (player.isBusted()) {
                    System.out.println("Busted! Dealer Wins.");
                    return;
                }
            } else {
                break;
            }
        }
    }

    public void handleDealerTurn(BlackjackPlayer dealer) {
        System.out.println("Dealer reveals hand: " + dealer);
        while (dealer.getScore() < 17) {
            dealer.receiveCard(deck.drawCard());
            System.out.println(dealer);
        }
    }
    
      public void declareWinner(BlackjackPlayer player, BlackjackPlayer dealer) {
        if (player.isBusted()) {
            System.out.println("Dealer Wins!");
        } else if (dealer.isBusted() || player.getScore() > dealer.getScore()) {
            System.out.println(player.getName() + " Wins!");
        } else if (player.getScore() < dealer.getScore()) {
            System.out.println("Dealer Wins!");
        } else {
            System.out.println("It's a Tie!");
        }
    }
}