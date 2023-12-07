package com.bajajma.aoc2023;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CamelGame {
    TreeSet<CamelGameHand> hands ;
    public CamelGame(String filename) throws Exception {
       hands =  extractHandMap(filename);

    }

    private TreeSet<CamelGameHand> extractHandMap(String filename) throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        Stream<String> lines = Files.lines(path);
        TreeSet<CamelGameHand> camelGameHands = lines.map(s -> new CamelGameHand(s)).collect(Collectors.toCollection(TreeSet::new));
        return camelGameHands;
    }

    public long totalWinnings() {
        int rank = 0;
        long totalWinning = 0;

        for( CamelGameHand hand : hands){
            ++rank;

            totalWinning = totalWinning+ (hand.bid*rank);
            System.out.println(hand + "  Rank : " + rank + "   Winning : " + totalWinning);
        }
        return totalWinning;
    }
}
