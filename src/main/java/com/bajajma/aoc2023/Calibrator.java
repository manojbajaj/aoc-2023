package com.bajajma.aoc2023;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calibrator {

    private static String getLastDigit(String text) {
        StringBuilder builder = new StringBuilder();
        return getFirstDigit(builder.append(text).reverse().toString());
    }

    private static String getFirstDigit(String text) {
        return text.chars().mapToObj(c -> (char) c).filter(c -> Character.isDigit(c)).findFirst().map(c -> String.valueOf(c)).get();
    }

    static String convertStringToDigits(String text) {
        Map<Integer, String> indexes = new TreeMap();
        String[] numbers = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<String,Integer> textDigitMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            textDigitMap.put(numbers[i], i+1);
        }

        Map<String,String> digitTextMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            digitTextMap.put(String.valueOf(i+1), numbers[i]);
        }

        for (String digit : digitTextMap.keySet() ) {
            text = text.replaceAll(digit, digitTextMap.get(digit));
        }

     //   System.out.println(text);




        for (int i = 0; i < numbers.length; i++) {
            int index = 0;
            while( index != -1) {
                index = text.indexOf(numbers[i], index);
                if( index != -1) {
                    indexes.put(index, numbers[i]);
                    index++;
                }
            }
        }


        String digits = "";
        for (String value : indexes.values() ) {
               digits = digits.concat(String.valueOf(textDigitMap.get(value)));
        }

        return digits;
    }

    public int calibrationValue(String text) {
        String firstDigit = getFirstDigit(text);
        String lastDigit = getLastDigit(text);
        return Integer.valueOf(firstDigit + lastDigit);

    }

    public int calibrationValueWithLetters(String text) {
        text = convertStringToDigits(text);
        return calibrationValue(text);
    }
}
