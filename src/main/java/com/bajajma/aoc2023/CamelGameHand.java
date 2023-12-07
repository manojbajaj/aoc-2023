package com.bajajma.aoc2023;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CamelGameHand {

    final Integer bid;
     int type =1;

     long strength = 0;

     String highCard = "";
    private Map<Long, Long> strengthMap = new HashMap<>();
    final Character[] cardList = new Character[]{'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2'};

    Map<Character, Integer> highCardValueMap = new HashMap<>();

    public CamelGameHand(String hand) {
        String[] items = hand.split(" ");
        this.bid = Integer.valueOf(items[1].trim());
        extractStrength(items[0]);




    }

    private void mapHighCard(String item) {
        int highCardValue = cardList.length+1;

        for (int i = 0; i < cardList.length; i++) {
            highCardValueMap.put(cardList[i],highCardValue-i);
        }

    }

    private void extractStrength(String hand) {
        mapHighCard(hand);
    //    System.out.println(highCardValueMap);
        strengthMap = hand.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting())).values().stream().collect(groupingBy(i -> i, counting()));
      //  System.out.println(strengthMap);
        if(isPair()) type = 2;
        if(isDoublePair()) type =3;
        if(isThreeOfKind()) type = 4;
        if(isFullHouse()) type =5;
        if(isFourOfKind()) type =6;
        if(isFiveOfKind()) type =7;

        highCard = hand.chars().mapToObj(c ->(char) c).map( c -> highCardValueMap.get(c)).map(i -> String.valueOf(i)).reduce(String::concat).get();
        strength = 10000000000L*type+ Long.valueOf(highCard);

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
}
