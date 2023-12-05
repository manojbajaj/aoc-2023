package com.bajajma.aoc2023;

import java.util.Arrays;

public class CubeGame {
    int redLimit = 12;
    int blueLimit = 14;
    int greenLimit = 13;

    public boolean isSetValid(String input) {
       // Arrays.stream(input.split(",")).map(String::trim).forEach(System.out::println);
        long count = Arrays.stream(input.split(",")).map(String::trim).filter(s -> hasBallsBreachedLimit(s)).count();
        return count==0;
    }

     boolean hasBallsBreachedLimit( String input) {
        String[] balls = input.split(" ");
        if( balls[1].equals("red") && Integer.valueOf(balls[0] ) > redLimit)  {
            return true;
        } else if (balls[1].equals("blue") && Integer.valueOf(balls[0] ) > blueLimit) {
            return true;
        } else if (balls[1].equals("green") && Integer.valueOf(balls[0] ) > greenLimit) {
            return true;
        }


         return false;

     }

}
