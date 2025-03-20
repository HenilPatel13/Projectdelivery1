/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Henil Patel
 */

import java.util.ArrayList;

/**
 * Team project blackjack's player code.
 * The BlackjackPlayer class extends Player and represents a player in a Blackjack game. 
 * It manages the player's hand and score, updating the score when a card is received. 
 * The score is adjusted for Aces if necessary, and the isBusted() method checks if the score exceeds 21.
 */

public class BlackjackPlayer {
    private final Hand hand;
    private final String name;

    public BlackjackPlayer(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public void receiveCard(BlackjackCard card) {
        hand.addCard(card);
    }

    public int getScore() {
        return hand.getScore();
    }

    public boolean isBusted() {
        return hand.isBusted();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "'s Hand: " + hand;
    }
}