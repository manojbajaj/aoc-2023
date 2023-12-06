package com.bajajma.aoc2023;

import static  java.util.stream.Collectors.*;

public class LetterCount {


    public static void main(String[] args) {
        String letters = "abcdddggjhgjgsawiufswqeadscxbvcbchdgsraaaakkjhcbvdfrtrvjvjzalkimuytre";

        System.out.println( letters.chars()
                .mapToObj(c-> (char)c)
                .collect( groupingBy(c->c, counting())));

    }
}
