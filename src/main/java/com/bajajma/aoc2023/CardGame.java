package com.bajajma.aoc2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardGame {
    public int calculateWinningPoints(String input) {

        List<String> winningCards = Arrays.stream(input.split(":")[1].replace('|', ';')
                        .split(";")[0].split(" "))
                .filter(s -> !s.isBlank())
                .collect(Collectors.toList());


        // int winningPoints = 0;
        int winningPoints = Arrays.stream(input.split(":")[1].replace('|', ';').split(";")[1].split(" "))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .filter(s -> winningCards.contains(s))
                .map(s -> 1)
                .reduce(0, (points, i) -> points == 0 ? 1 : points * 2);


        return winningPoints;
    }
}
