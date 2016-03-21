/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flare.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Srinivas Akula
 */
public class PokerHand {

    private final List<PokerCard> cards;
    private List<PokerCard> sortedCards;
    private Category category;
    private final Map<Integer, Integer> dupCount = new HashMap<>();

    /**
     *
     * @param pattern
     */
    public PokerHand(String pattern) {

        String[] cardTokens = pattern.trim().split(",");
        if (cardTokens.length != 5) {
            throw new NotAValidPokerHandException(pattern + ": Not A valid Poker Hand.");

        }
        cards = new ArrayList<>();
        for (String token : cardTokens) {
            PokerCard card = new PokerCard(token.trim());
            cards.add(card);
        }
        processCards();
    }

    /**
     *
     * @param cards
     */
    private void sortCards() {

        sortedCards = new ArrayList<>(cards);
        Collections.sort(sortedCards, new Comparator<PokerCard>() {
            @Override
            public int compare(PokerCard card1, PokerCard card2) {
                Integer rank1 = card1.getRank();
                Integer rank2 = card2.getRank();
                return rank1.compareTo(rank2);
            }
        });
    }

    /**
     *
     */
    private void processCards() {

        sortCards();
        prepareDupMap();
        decideCategory();
    }

    /**
     *
     */
    private void decideCategory() {

        boolean straight = checkConsecutive();
        boolean flush = checkSuite();
        boolean straightFlush = straight && flush;

        if (straightFlush) {
            this.category = Category.STRAIGHT_FLUSH;
            return;
        }
        if (straight) {
            this.category = Category.STRAIGHT;
            return;
        }
        if (flush) {
            this.category = Category.FLUSH;
            return;
        }
        if (checkCount(4)) {
            this.category = Category.FOUR_OF_KIND;
            return;
        }

        if (checkCount(3) && checkCount(2)) {
            this.category = Category.FULL_HOUSE;
            return;
        }

        if (checkCount(3)) {
            this.category = Category.THREE_OF_KIND;
            return;
        }
        if (checkPairs(2)) {
            this.category = Category.TWO_PAIRS;
            return;
        }
        if (checkPairs(1)) {
            this.category = Category.ONLY_ONE_PAIR;
            return;
        }
        this.category = Category.HIGH_CARD;
    }

    /**
     *
     */
    private void prepareDupMap() {
        for (PokerCard card : sortedCards) {
            Integer count = dupCount.get(card.getRank());
            dupCount.put(card.getRank(), null == count ? 1 : count + 1);
        }
    }

    /**
     *
     *
     */
    private boolean checkConsecutive() {
        for (int i = 0; i < sortedCards.size() - 1; i++) {
            final PokerCard card = sortedCards.get(i);
            final PokerCard nextCard = sortedCards.get(i + 1);
            if ((card.getRank() + 1) != (nextCard.getRank())) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return
     */
    private boolean checkSuite() {

        for (int i = 1; i < sortedCards.size() - 1; i++) {
            final PokerCard firstCard = sortedCards.get(0);
            final PokerCard nextCard = sortedCards.get(i);
            if (firstCard.getSuit() != (nextCard.getSuit())) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param count
     * @return
     */
    private boolean checkCount(Integer count) {
        return dupCount.values().contains(count);
    }

    /**
     *
     * @param min
     * @return
     */
    private boolean checkPairs(int min) {
        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : dupCount.entrySet()) {
            if (entry.getValue() == 2) {
                pairs++;
            }
        }
        return pairs == min;
    }

    /**
     *
     * @return
     */
    public List<PokerCard> getCards() {
        return sortedCards;
    }

    public Category getCategory() {
        return category;
    }

    /**
     *
     * @return
     */
    public String displayGivenCards() {
        return printCards(cards);
    }

    /**
     *
     * @return
     */
    public String displaySortedCards() {
        return printCards(sortedCards);
    }

    /**
     *
     * @param list
     * @return
     */
    private String printCards(List<PokerCard> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        int i = 0;
        for (PokerCard card : list) {
            builder.append(card.toString());
            if (i < list.size() - 1) {
                builder.append(", ");
            }
            i++;
        }
        builder.append(" ]");
        return builder.toString();
    }

    @Override
    public String toString() {
        return displayGivenCards() + category;
    }

    /**
     *
     * @return
     */
    public List<Integer> getSortedRanks() {
        Map<Integer, Integer> map = sortByValueAndKey(dupCount);
        return new ArrayList<>(map.keySet());
    }
    
    private static Map<Integer, Integer> sortByValueAndKey(Map<Integer, Integer> map) {

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e2.getValue().equals(e1.getValue())) {
                    return e2.getKey().compareTo(e1.getKey());
                } else {
                    return (e2.getValue()).compareTo(e1.getValue());
                }
            }
        });

        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
