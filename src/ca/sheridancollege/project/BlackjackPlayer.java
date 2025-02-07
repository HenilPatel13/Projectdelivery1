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
 * Represents a player in the Blackjack game.
 */
public class BlackjackPlayer extends Player {
    private ArrayList<BlackjackCard> hand;
    private int score;

    public BlackjackPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public void receiveCard(BlackjackCard card) {
        hand.add(card);
        updateScore();
    }

    private void updateScore() {
        int sum = 0;
        int aceCount = 0;

        for (BlackjackCard card : hand) {
            sum += card.getValue();
            if (card.getValue() == 11) aceCount++;
        }

        // Adjust Ace value if needed
        while (sum > 21 && aceCount > 0) {
            sum -= 10;
            aceCount--;
        }

        this.score = sum;
    }

    public int getScore() {
        return score;
    }

    public boolean isBusted() {
        return score > 21;
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing.");
    }

    @Override
    public String toString() {
        return getName() + "'s Hand: " + hand.toString() + " | Score: " + score;
    }
}