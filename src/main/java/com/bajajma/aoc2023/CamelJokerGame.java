package com.bajajma.aoc2023;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CamelJokerGame {
    TreeSet<CamelJokerGameHand> hands ;
    public CamelJokerGame(String filename) throws Exception {
       hands =  extractHandMap(filename);

    }

    private TreeSet<CamelJokerGameHand> extractHandMap(String filename) throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        Stream<String> lines = Files.lines(path);
        TreeSet<CamelJokerGameHand> camelJokerGameHands = lines.map(s -> new CamelJokerGameHand(s)).collect(Collectors.toCollection(TreeSet::new));
        return camelJokerGameHands;
    }

    public long totalWinnings() {
        int rank = 0;
        long totalWinning = 0;

        for( CamelJokerGameHand hand : hands){
            ++rank;

            long winning = hand.bid*rank;
            totalWinning = totalWinning+ winning;
            System.out.println(hand + "  Rank : " + rank + " Hand Win : " + winning + "   Total Winning : " + totalWinning);
        }
        return totalWinning;
    }
}
