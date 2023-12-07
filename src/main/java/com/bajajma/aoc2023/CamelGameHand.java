package com.bajajma.aoc2023;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CamelGameHand implements Comparable<CamelGameHand> {

    final Integer bid;
    final static Character[] cardList = new Character[]{'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2'};
    private final String hand;
    int type = 1;
    Long strength = 0l;
    Long handValue = 0l;
    final static Map<Character, Integer> cardValueMap = new HashMap<>();
    private Map<Long, Long> strengthMap = new HashMap<>();

    static {
        int highCardValue = cardList.length + 1;

        for (int i = 0; i < cardList.length; i++) {
            cardValueMap.put(cardList[i], highCardValue - i);
        }
    }

    public CamelGameHand(String hand) {
        this.hand = hand;
        String[] items = hand.split(" ");
        this.bid = Integer.valueOf(items[1].trim());
        extractStrength(items[0]);


    }



    private void extractStrength(String hand) {

        //    System.out.println(highCardValueMap);
        strengthMap = hand.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting())).values().stream().collect(groupingBy(i -> i, counting()));
        //  System.out.println(strengthMap);
        if (isPair()) type = 2;
        if (isDoublePair()) type = 3;
        if (isThreeOfKind()) type = 4;
        if (isFullHouse()) type = 5;
        if (isFourOfKind()) type = 6;
        if (isFiveOfKind()) type = 7;

        char[] chars = hand.toCharArray();


        long seeding = 100000000L;
        for (int i = 0; i < chars.length; i++) {
            Integer cardValue = cardValueMap.get(chars[i]);
            handValue = handValue + cardValue * seeding;
            seeding = seeding / 100;
        }
        // System.out.println( " HandValue : " + handValue);
        strength = 10000000000L * type + handValue;

    }

    boolean isPair() {
        return strengthMap.containsKey(2L) && !isFullHouse() && !isDoublePair();
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


    @Override
    public int compareTo(CamelGameHand anotherHand) {

        return strength.compareTo(anotherHand.strength);

    }

    @Override
    public String toString() {
        return "Hand : " + hand + " Bid : " + bid + " Strength : " + strength;
    }
}
