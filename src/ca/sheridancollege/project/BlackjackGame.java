/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Henil Patel
 */

import java.util.Scanner;

/**
 * Controls the flow of the Blackjack game.
 */
public class BlackjackGame extends Game {
    private Deck deck;
    private BlackjackPlayer player;
    private BlackjackPlayer dealer;

    public BlackjackGame(String playerName) {
        super("Blackjack");
        deck = new Deck();
        player = new BlackjackPlayer(playerName);
        dealer = new BlackjackPlayer("Dealer");
    }

    @Override
    public void play() {
        System.out.println("Starting Blackjack...");

        // Initial dealing
        player.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());

        System.out.println(player);
        System.out.println("Dealer's Hand: [Hidden, " + dealer.getScore() + "]");

        // Player's turn
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

        // Dealer's turn
        System.out.println("Dealer reveals hand: " + dealer);
        while (dealer.getScore() < 17) {
            dealer.receiveCard(deck.drawCard());
            System.out.println(dealer);
        }

        // Determine winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
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

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame("Player1");
        game.play();
    }
}