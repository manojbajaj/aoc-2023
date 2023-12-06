package com.bajajma.aoc2023;

public class BoatRace {


    public long calculateButtonHoldCount(String record) {
        long time=Long.valueOf(record.split(",")[0]);
        long distance=Long.valueOf(record.split(",")[1]);

        int count = 0;

        for (int i = 0; i <= time; i++) {
            long raceDistance = i * (time-i);
           // System.out.println(raceDistance);
            if(raceDistance > distance) {
                ++count;
            }
        }
        return count;
    }
}
