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
 * Team group project:- 
 * Description:-
 * The Deck class represents a deck of 52 cards used in Blackjack. 
 * It initializes the deck with all possible combinations of ranks and suits, 
 * assigning appropriate values to each card. The constructor adds the deck and shuffles the cards.
 * The drawCard() method removes and returns the top card from the deck.
 */

public final class Deck {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    private ArrayList<BlackjackCard> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (String suit : SUITS) {
            for (int i = 0; i < RANKS.length; i++) {
                cards.add(new BlackjackCard(RANKS[i], suit, VALUES[i]));
            }
        }
        shuffle();
    }

    public BlackjackCard drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty! Reshuffling...");
            refillDeck();
        }
        return cards.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    private void refillDeck() {
        cards.clear();
        for (String suit : SUITS) {
            for (int i = 0; i < RANKS.length; i++) {
                cards.add(new BlackjackCard(RANKS[i], suit, VALUES[i]));
            }
        }
        shuffle();
    }
}