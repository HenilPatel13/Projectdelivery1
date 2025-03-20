/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Henil Patel
 */
public class Hand {
    private ArrayList<BlackjackCard> cards;
    private int score;

    public Hand() {
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    public void addCard(BlackjackCard card) {
        cards.add(card);
        updateScore();
    }

    private void updateScore() {
        int sum = 0;
        int aceCount = 0;

        for (BlackjackCard card : cards) {
            sum += card.getValue();
            if (card.getValue() == 11) aceCount++;
        }

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
    public String toString() {
        return cards.toString() + " | Score: " + score;
    }
}