/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flare.poker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Srinivas Akula <srinivas.akula@thomsonreuters.com>
 */
public class Poker {

    public static void main(String[] args) {

        if (args.length <= 0 || null == args[0]) {
            System.out.println("Please give the input file location..");
            System.exit(1);
        }
        String content = null;
        try {
            final Path path = Paths.get(args[0]);
            content = new String(Files.readAllBytes(path));
        } catch (IOException ex) {
            System.err.println("Given file is not valid..");
        }

        if (null != content) {

            String[] patterns = content.split(";");
            List<PokerHand> handList = new ArrayList<>();
            for (String pattern : patterns) {
                handList.add(new PokerHand(pattern));
            }

            //Compare Hand based on the given Poker Hand Rules.
            Collections.sort(handList, new PokerHandComparator());
            System.out.println("\nHands are printed in their rank order starting from Higher to Lower.");
            System.out.println("#######################################################################");
            System.out.println("No.\t Given Hand \t\t Sorted Hand \t\t Rank");
            System.out.println("#######################################################################");
            int i = 1;
            for (PokerHand hand : handList) {
                System.out.println(i + "\t" + hand.displayGivenCards() + "  " + hand.displaySortedCards() + "  " + hand.getCategory());
                i++;
            }
        }
    }
}
