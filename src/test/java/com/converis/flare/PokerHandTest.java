/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.converis.flare;

import com.flare.poker.Category;
import com.flare.poker.NotAValidPokerCardException;
import com.flare.poker.NotAValidPokerHandException;
import com.flare.poker.PokerHand;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Srinivas Akula
 */
@Test
public class PokerHandTest {

    @Test(expectedExceptions = NotAValidPokerCardException.class)
    public void noValidCard() {
        String pattern = "CK1, CJ, CA, CQ, CT";
        PokerHand hand = new PokerHand(pattern);
    }

    @Test(expectedExceptions = NotAValidPokerHandException.class)
    public void noValidHand() {
        String pattern = "CK1, CA, CQ, CT";
        PokerHand hand = new PokerHand(pattern);
    }

    @Test
    public void testStraightFlush() {
        String pattern = "CK, CJ, CA, CQ, CT";
        PokerHand hand = new PokerHand(pattern);
        Assert.assertEquals(hand.getCategory(), Category.STRAIGHT_FLUSH);

    }

    @Test
    public void testStraight() {
        String pattern = "D2, C5, S3, H4, C6";
        PokerHand hand = new PokerHand(pattern);
        Assert.assertEquals(hand.getCategory(), Category.STRAIGHT);
    }

    @Test
    public void testFlush() {
        String pattern = "DT, D3, D5, D8, D2";
        PokerHand hand = new PokerHand(pattern);
        Assert.assertEquals(hand.getCategory(), Category.FLUSH);
    }

    @Test
    public void testFourOfKind() {
        String pattern = "DT, ST, CT, HT, D2";
        PokerHand hand = new PokerHand(pattern);
        Assert.assertEquals(hand.getCategory(), Category.FOUR_OF_KIND);
    }

    @Test
    public void testThreeOfKind() {
        String pattern = "D2, S2, C2, HT, D7";
        PokerHand hand = new PokerHand(pattern);
        Assert.assertEquals(hand.getCategory(), Category.THREE_OF_KIND);

    }

    @Test
    public void testFullHouse() {
        String pattern = "D2, D7, C2, H7, S2";
        PokerHand hand = new PokerHand(pattern);
        Assert.assertEquals(hand.getCategory(), Category.FULL_HOUSE);

    }

    @Test
    public void testTwoPairs() {
        String pattern = "DA, CK, D3, HA, SK";
        PokerHand hand = new PokerHand(pattern);
        Assert.assertEquals(hand.getCategory(), Category.TWO_PAIRS);

    }

    @Test
    public void testOnlyOnePair() {
        String pattern = "DT, CK, D3, H6, SK";
        PokerHand hand = new PokerHand(pattern);
        Assert.assertEquals(hand.getCategory(), Category.ONLY_ONE_PAIR);
    }

    @Test
    public void testHighCard() {
        String pattern = "DT, CK, D3, H6, SQ";
        PokerHand hand = new PokerHand(pattern);
        Assert.assertEquals(hand.getCategory(), Category.HIGH_CARD);
    }
}
