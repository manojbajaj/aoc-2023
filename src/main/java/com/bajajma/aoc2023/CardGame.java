package com.bajajma.aoc2023;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public int calculateWinningCount(String input) {
        List<String> winningCards = Arrays.stream(input.split(":")[1].replace('|', ';')
                        .split(";")[0].split(" "))
                .filter(s -> !s.isBlank())
                .collect(Collectors.toList());


        // int winningPoints = 0;
        long winningCount = Arrays.stream(input.split(":")[1].replace('|', ';').split(";")[1].split(" "))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .filter(s -> winningCards.contains(s))
                .map(s -> 1)
                .count();


        return (int) winningCount;

    }

    public int calculateTotalCards(List<String> suppliedCards) {
        Map<Integer, Card> cardsForProcessing = new TreeMap<>();
        for(String cardline : suppliedCards) {
            cardsForProcessing.put(id(cardline), new Card(cardline));
        }

        for (int cardId : cardsForProcessing.keySet())  {
            Card card= cardsForProcessing.get(cardId);
            int winningCount = calculateWinningCount(card.cardLine());
            for (int i = 0; i < card.count; i++) {
                for (int j = 0; j < winningCount; j++) {
                    int key = cardId+j+1;
                    if(cardsForProcessing.containsKey(key)) {
                        cardsForProcessing.get(cardId+j+1).increment();
                    }
                }
            }
        }

        return cardsForProcessing.values().stream().mapToInt(c -> c.count).sum();

    }



    int id(String line) {
        return Integer.valueOf(line.split(":")[0].replace("Card", "").trim());
    }

    class Card {
        int id;
        String line ;

        int count = 1;
        Card(String cardLine) {
            this.line = cardLine;
            this.id = Integer.valueOf(line.split(":")[0].replace("Card", "").trim());
        }

        int id() {
           return id;
        }

        String cardLine() {
            return line;
        }

        int increment() {
            ++count;
            return count;
        }

        int count() {
            return count;
        }
    }



}
