/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flare.poker;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Srinivas Akula
 */
public class PokerHandComparator implements Comparator<PokerHand> {

    @Override
    public int compare(PokerHand ph1, PokerHand ph2) {

        Category c1 = ph1.getCategory();
        Category c2 = ph2.getCategory();
        //In case of tie.
        if (c1.getRank().equals(c2.getRank())) {
            switch (c1) {

                case STRAIGHT_FLUSH:
                case STRAIGHT:
                    Integer highestRC2 = ph2.getCards().get(4).getRank();
                    Integer highestRC1 = ph1.getCards().get(4).getRank();
                    return highestRC2.compareTo(highestRC1);

                case FOUR_OF_KIND:
                case FULL_HOUSE:
                case THREE_OF_KIND:
                    //Get 3rd card.
                    Integer thirdRank2 = ph2.getCards().get(2).getRank();
                    Integer thirdRank1 = ph1.getCards().get(2).getRank();
                    return thirdRank2.compareTo(thirdRank1);

                case FLUSH:
                    return compareFlush(ph1, ph2);

                case TWO_PAIRS:
                case ONLY_ONE_PAIR:
                case HIGH_CARD:
                    return comparePairsAndCards(ph1, ph2);
            }
        }
        return c2.getRank().compareTo(c1.getRank());
    }

    /**
     *
     * @return
     */
    private int compareFlush(PokerHand ph1, PokerHand ph2) {

        for (int i = 4; i >= 0; i--) {
            Integer rank2 = ph2.getCards().get(i).getRank();
            Integer rank1 = ph1.getCards().get(i).getRank();
            if (!rank2.equals(rank1)) {
                return rank2.compareTo(rank1);
            }
        }
        return 0;
    }

    /**
     *
     * @param ph1
     * @param ph2
     * @return
     */
    private int comparePairsAndCards(PokerHand ph1, PokerHand ph2) {

        List<Integer> list1 = ph1.getRanksByReverseOrder();
        List<Integer> list2 = ph2.getRanksByReverseOrder();
        for (int i = 0; i < list1.size(); i++) {
            if (!list2.get(i).equals(list1.get(i))) {
                return list2.get(i).compareTo(list1.get(i));
            }
        }
        return 0;
    }
}
