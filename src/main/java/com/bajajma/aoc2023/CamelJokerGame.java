package com.bajajma.aoc2023;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CamelJokerGame {
    TreeSet<CamelGameJokerHand> hands ;
    public CamelJokerGame(String filename) throws Exception {
       hands =  extractHandMap(filename);

    }

    private TreeSet<CamelGameJokerHand> extractHandMap(String filename) throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        Stream<String> lines = Files.lines(path);
        TreeSet<CamelGameJokerHand> CamelGameJokerHands = lines.map(s -> new CamelGameJokerHand(s)).collect(Collectors.toCollection(TreeSet::new));
        return CamelGameJokerHands;
    }

    public long totalWinnings() {
        int rank = 0;
        long totalWinning = 0;

        for( CamelGameJokerHand hand : hands){
            ++rank;

            long winning = hand.bid*rank;
            totalWinning = totalWinning+ winning;
            System.out.println(hand + "  Rank : " + rank + " Hand Win : " + winning + "   Total Winning : " + totalWinning);
        }
        return totalWinning;
    }
}
