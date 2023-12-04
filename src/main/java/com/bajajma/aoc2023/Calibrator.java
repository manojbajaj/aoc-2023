package com.bajajma.aoc2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calibrator {

    public int[] execute(String input) {
        int[] numbers = covertInputToArray(input);
        if(numbers[0] == 1) {
            numbers[numbers[3]] = numbers[numbers[1]] + numbers[numbers[2]];
        }
        if(numbers[0] == 2) {
            numbers[numbers[3]] = numbers[numbers[1]] * numbers[numbers[2]];
        }
        return numbers;
    }

    int[] covertInputToArray( String input) {
        return Arrays.stream(input.split(",")).mapToInt(s -> Integer.valueOf(s)).toArray();
    }

    public int calibrationValue(String text) {
       String firstDigit= getFirstDigit(text);
        String lastDigit= getLastDigit(text);
       return Integer.valueOf(firstDigit+lastDigit);

    }

    private static String getLastDigit(String text) {
        StringBuilder builder = new StringBuilder();
        return  getFirstDigit(builder.append(text).reverse().toString());
    }

    private static String getFirstDigit(String text) {
        return text.chars().mapToObj(c -> (char) c).filter(c -> Character.isDigit(c)).findFirst().map(c -> String.valueOf(c)).get();
    }



}
