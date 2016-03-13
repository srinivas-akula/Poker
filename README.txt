# Poker
A java project to compare Poker Hands

This Program compares the given Poker Hands.
Suites: {Clubs: C, Diamonds: D, Hearts: H, Spades: S}
Royals: {Ace: A, King: K, Queen: Q, Jack: J, Ten: T}
A Poker Hand can be defined in the following way.
A Poker Hand should contain 5 Poker Cards. Each Poker Card should be represented with 2 characters.
Poker Card: HT - Heart 10
Poker Card: D3 - Diamond 3
Poker Hand: D2, CA, SK, D5, H4 

How To Run this Program
Download source.
Run "mvn clean install" on the project.
From Command line goto target directory of the project.
And run 
java -jar target\poker.jar $input_file

Input File:
Each Poker Hands should be seperated by ';'
