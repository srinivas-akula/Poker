/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flare.poker;

/**
 *
 * @author Srinivas Akula
 */
public enum Category {

    STRAIGHT_FLUSH(10), //5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.

    FOUR_OF_KIND(9), //4 cards with the same value. Ranked by the value of the 4 cards.

    FULL_HOUSE(8), //3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.

    FLUSH(7), //Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.

    STRAIGHT(6), //Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.

    THREE_OF_KIND(5), //Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.

    TWO_PAIRS(4), //The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. 
                //Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.

    ONLY_ONE_PAIR(3), // 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. 
                       //If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
    
    HIGH_CARD(2); //Hands which do not fit any higher category are ranked by the value of their highest card. 
                  //If the highest cards have the same value, the hands are ranked by the next highest, and so on.

    private final Integer rank;

    Category(Integer rank) {
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
    }
}
