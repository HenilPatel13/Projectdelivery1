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
 * Team group project main game code with having logic of game and everything
 */
public class BlackjackGame extends Game {
    private Deck deck;
    private BlackjackPlayer player;
    private BlackjackPlayer dealer;

    public BlackjackGame(String playerName) {
        super("Blackjack Game");
        deck = new Deck();
        player = new BlackjackPlayer(playerName);
        dealer = new BlackjackPlayer("Dealer");
    }

    @Override
    public void play() {
        System.out.println("Beginning of blackjack game:- ");
        //giving cards at beginning of game
        player.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());

        System.out.println(player);
        System.out.println("Dealer's Hand: [Unknown card, " + dealer.getScore() + "]");

        // ckeking game rules and player's turn and giving two option hit and stand according to game
        Scanner scanner = new Scanner(System.in);
        while (player.getScore() < 21) {
            System.out.print("Hit or Stand? (h/s): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.receiveCard(deck.drawCard());
                System.out.println(player);
                if (player.isBusted()) {
                    System.out.println("Busted! Dealer Wins the game.");
                    System.out.println("Better luck next time!");
                    return;
                }
            } else {
                break;
            }
        }

        // Dealer's turn if game will still can't decide who wins according to points
        System.out.println("Dealer reveals hand(his card): " + dealer);
        while (dealer.getScore() < 17) {
            dealer.receiveCard(deck.drawCard());
            System.out.println(dealer);
        }

        // Declaring winner
        declareWinner();
    }
    
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame("Player1");
        game.play();
    }

    @Override
    public void declareWinner() {
        if (player.isBusted()) {
            System.out.println("Dealer Wins the game!");
        } else if (dealer.isBusted() || player.getScore() > dealer.getScore()) {
            System.out.println(player.getName() + " Wins the game!");
        } else if (player.getScore() < dealer.getScore()) {
            System.out.println("Dealer Wins the game!");
        } else {
            System.out.println("It's a Tie of game!");
        }
    }

}