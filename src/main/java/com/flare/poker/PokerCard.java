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
public class PokerCard {

    private final char suit;
    private final int rank;

    /**
     *
     * @param strCard
     * @throws NotAValidPokerCardException
     */
    public PokerCard(String strCard) throws NotAValidPokerCardException {

        if (strCard.length() > 2) {
            throw new NotAValidPokerCardException(strCard + ": A Poker Card can not be represented with more than two characters.");
        }
        suit = strCard.charAt(0);
        Integer cardRank = PokerConstants.getRank(strCard.charAt(1));
        if (null == cardRank) {
            throw new NotAValidPokerCardException(strCard + ": is not a valid Poker Card.");
        }
        rank = cardRank.intValue();
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.suit;
        hash = 29 * hash + this.rank;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PokerCard other = (PokerCard) obj;
        if (this.suit != other.suit) {
            return false;
        }
        return this.rank == other.rank;
    }

    @Override
    public String toString() {
        return new Character(suit).toString() + PokerConstants.getChar(rank);
    }
}
