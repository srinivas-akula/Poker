/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flare.poker;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Srinivas Akula
 */
public class PokerConstants {

    private static final Map<Character, Integer> rankMap = new HashMap<Character, Integer>() {
        {
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
            put('T', 10);
            put('J', 11);
            put('Q', 12);
            put('K', 13);
            put('A', 14);
        }
    };

    private static final Map<Integer, Character> reverseMap = new HashMap<Integer, Character>() {
        {
            put(2, '2');
            put(3, '3');
            put(4, '4');
            put(5, '5');
            put(6, '6');
            put(7, '7');
            put(8, '8');
            put(9, '9');
            put(10, 'T');
            put(11, 'J');
            put(12, 'Q');
            put(13, 'K');
            put(14, 'A');
        }
    };

    /**
     *
     * @param ch
     * @return
     */
    public static Integer getRank(Character ch) {
        return rankMap.get(ch);
    }
    
    /**
     * 
     * @param rank
     * @return 
     */
    public static Character getChar(int rank) {
        return reverseMap.get(rank);
    }
}
