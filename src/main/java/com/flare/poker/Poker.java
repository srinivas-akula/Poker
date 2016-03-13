/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flare.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Srinivas Akula <srinivas.akula@thomsonreuters.com>
 */
public class Poker {

    public static void main(String[] args) {

        //Read from System.in
        args = new String[]{"DT, D3, D5, D8, D2", "H9, D7, H9, H9, S7",  "DK, D3, D5, D8, D2", "CT, C3, C5, C8, C2", "CT, C3, CA, C8, C2", "ST, S3, SQ, S8, S2",
            "C5, D3, DA, CK, HJ", "DK, DQ, DJ, DT, D9",  "DJ, SJ, CJ, HJ, D2", "D9, S9, C9, H9, DA", "ST, C7, S8, H6, C9", "DT, CK, D4, H6, SK", "DT, CQ, D3, H6, SQ",
            "CK, HA, D3, H9, S2", "CK, CA, CQ, CT, CJ",  "D2, C5, S3, H4, C6", "D3, S2, C7, H3, D3", "DQ, CK, D3, HQ, SK",  "DJ, CK, D3, HJ, SK", "DJ, CK, D4, HJ, SK",
            "DT, ST, CT, HT, D2", "D2, S2, C2, HT, D7", "D2, D7, C2, H7, S2", "DA, CK, D3, HA, SK", "DT, CK, D3, H6, SK", "ST, C7, S8, H6, C9", "DT, CK, D3, H6, SQ", "DT, CK, D7, H6, SQ"};

        List<PokerHand> handList = new ArrayList<>();
        for (String pattern : args) {
            handList.add(new PokerHand(pattern));
        }
        Collections.sort(handList, new PokerHandComparator());
        for (PokerHand hand : handList) {
            System.out.println(hand.displayGivenCards() + "  " + hand.displaySortedCards() + "  " + hand.getCategory());
        }
    }
}