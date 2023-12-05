package com.bajajma.aoc2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CubeGame {
    int redLimit = 12;
    int blueLimit = 14;
    int greenLimit = 13;

    public boolean isSetValid(String input) {
        // Arrays.stream(input.split(",")).map(String::trim).forEach(System.out::println);
        long count = Arrays.stream(input.split(",")).map(String::trim).filter(s -> hasBallsBreachedLimit(s)).count();
        return count == 0;
    }

    boolean hasBallsBreachedLimit(String input) {
        String[] balls = input.split(" ");
        if (balls[1].equals("red") && Integer.valueOf(balls[0]) > redLimit) {
            return true;
        } else if (balls[1].equals("blue") && Integer.valueOf(balls[0]) > blueLimit) {
            return true;
        } else if (balls[1].equals("green") && Integer.valueOf(balls[0]) > greenLimit) {
            return true;
        }


        return false;

    }


    public int gameId(String input) {
        return Integer.valueOf(input.split(":")[0].split(" ")[1]);
    }

    public boolean isGameSetValid(String input) {
         return Arrays.stream(input.split(":")[1].split(";")).map(String::trim).filter(s -> !isSetValid(s)).count()==0;
    }


    public int minimumBlue(String input) {
        return getMinimum(input, "blue");
    }

    private static int getMinimum(String input, String color) {
        List<String> ballList = extractColorList(input, color);
        int minimum = 0;
        for( String balls : ballList) {
           int ballNumber =  Integer.valueOf(balls.split(" ")[0]);
           if(ballNumber> minimum) {
               minimum = ballNumber;
           }
        }
        return minimum;
    }

    static List<String> extractColorList(String input, String color) {
        return Arrays.stream(input.split(":")[1].split(";"))
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(String::trim)
                .filter(s -> s.contains(color)).collect(Collectors.toList());

    }

    public int cubePower(String input) {
        return minimumBlue(input)*minimumRed(input)*minimumGreen(input);
    }

    public int minimumGreen(String input) {
        return getMinimum(input, "green");
    }

    public int minimumRed(String input) {
        return getMinimum(input, "red");
    }
}
