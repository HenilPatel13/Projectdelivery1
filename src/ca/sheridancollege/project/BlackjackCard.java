/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Henil Patel
 */

/**
 * Team project 
 * Description of code:- 
 * The BlackjackCard class extends the Card class and represents a card in Blackjack. 
 * It stores the card's rank, suit, and value, with a constructor to initialize these attributes. 
 * The getValue() method returns the card's value, and toString() provides a string representation in the format "rank of the suit". 
 * This class is used to manage cards in a Blackjack game
 */
public class BlackjackCard extends Card {
    private String suit;
    private String rank;
    private int value;

    public BlackjackCard(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return rank + " of the " + suit;
    }
}