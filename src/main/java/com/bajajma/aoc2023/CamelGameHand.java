package com.bajajma.aoc2023;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CamelGameHand {

    final Integer bid;
    private Map<Long, Long> strengthMap = new HashMap<>();

    public CamelGameHand(String hand) {
        String[] items = hand.split(" ");
        this.bid = Integer.valueOf(items[1].trim());
        extractStrength(items[0]);

    }

    private void extractStrength(String hand) {
        strengthMap = hand.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting())).values().stream().collect(groupingBy(i -> i, counting()));
        System.out.println(strengthMap);
    }

    boolean isPair() {
        return strengthMap.containsKey(2L) && strengthMap.get(2L) == 1;
    }


    boolean isDoublePair() {
        return strengthMap.containsKey(2L) && strengthMap.get(2L) == 2;
    }

    boolean isThreeOfKind() {
        return strengthMap.containsKey(3L) && !strengthMap.containsKey(2l);
    }

    boolean isFullHouse() {
        return strengthMap.containsKey(3l) && strengthMap.containsKey(2l);
    }

    boolean isFourOfKind() {
        return strengthMap.containsKey(4l);
    }

    boolean isFiveOfKind() {
        return strengthMap.containsKey(5l);
    }
}
