/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Henil Patel
 */

public class BlackjackGame {
    private final Deck deck;
    private final BlackjackPlayer player;
    private final BlackjackPlayer dealer;
    private final BlackjackTurnManager turnManager;

    public BlackjackGame() {
        deck = new Deck();
        player = new BlackjackPlayer("Player");
        dealer = new BlackjackPlayer("Dealer");
        turnManager = new BlackjackTurnManager(deck);
    }

     public void play() {
        System.out.println("Starting Blackjack...");

        // Initial dealing
        player.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());

        System.out.println(player);
        System.out.println("Dealer's Hand: [Hidden, " + dealer.getScore() + "]");

        // Handle player turn
        turnManager.handlePlayerTurn(player);
        if (!player.isBusted()) {
            // Handle dealer turn if player hasn't busted
            turnManager.handleDealerTurn(dealer);
            // Declare the winner
            turnManager.declareWinner(player, dealer);
        }
    }

   
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.play();
    }}