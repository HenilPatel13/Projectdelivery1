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
import java.util.Collections;

/**
 * Represents a deck of 52 cards used in Blackjack.
 */
public class Deck extends GroupOfCards {

    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    public Deck() {
        super(52);
        cards = new ArrayList<>();
        for (int i = 0; i < RANKS.length; i++) {
            for (String suit : SUITS) {
                cards.add(new BlackjackCard(RANKS[i], suit, VALUES[i]));
            }
        }
        shuffle();
    }

    public BlackjackCard drawCard() {
        return (BlackjackCard) cards.remove(0);
    }
}