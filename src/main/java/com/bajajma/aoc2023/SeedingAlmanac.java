package com.bajajma.aoc2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeedingAlmanac {

    List<Long> seeds ;
    List<SourceDestRange> seedSoilMap = new ArrayList<>();
    List<SourceDestRange> soilFertlizerMap = new ArrayList<>();
    List<SourceDestRange> fertilizerWaterMap = new ArrayList<>();
    List<SourceDestRange> waterLightMap = new ArrayList<>();
    List<SourceDestRange> lightTempMap = new ArrayList<>();
    List<SourceDestRange> tempHumidityMap = new ArrayList<>();
    List<SourceDestRange> humidityLocationMap = new ArrayList<>();

    SeedingAlmanac(String almanac) {

//         seeds = almanac.filter(s -> s.contains("seeds: ")).map(s -> s.split(":"))
//                .flatMap(Arrays::stream)
//                .filter(s -> !s.contains("seeds")).map(s -> s.split(" "))
//                .flatMap(Arrays::stream).map(String::trim).filter(s -> !s.isBlank()).map(s -> Long.valueOf(s)).collect(Collectors.toList());
//
//        //.map(s -> Long.valueOf(s)).collect(Collectors.toList());
//        System.out.println(seeds);

        String[] strings = almanac.split("\n");
        System.out.println(Arrays.toString(strings));


    }

    private void captureSeedList(String line) {
    }

    class SeedItem {
        long seed, soil, fertilizer, water, light, temperature, humidity, location;

    }


}
