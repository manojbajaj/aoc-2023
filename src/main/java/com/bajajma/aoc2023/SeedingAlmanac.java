package com.bajajma.aoc2023;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeedingAlmanac {

    List<Long> seeds;
    List<SourceDestRange> seedSoilMap = new ArrayList<>();
    List<SourceDestRange> soilFertlizerMap = new ArrayList<>();
    List<SourceDestRange> fertilizerWaterMap = new ArrayList<>();
    List<SourceDestRange> waterLightMap = new ArrayList<>();
    List<SourceDestRange> lightTempMap = new ArrayList<>();
    List<SourceDestRange> tempHumidityMap = new ArrayList<>();
    List<SourceDestRange> humidityLocationMap = new ArrayList<>();

    SeedingAlmanac(String[] filenames) throws Exception {

        seedSoilMap = buildMap(filenames[0]);
        soilFertlizerMap = buildMap(filenames[1]);
        fertilizerWaterMap = buildMap(filenames[2]);
        waterLightMap = buildMap(filenames[3]);
        lightTempMap = buildMap(filenames[4]);
        tempHumidityMap = buildMap(filenames[5]);
        humidityLocationMap = buildMap(filenames[6]);


    }

    private List<SourceDestRange> buildMap(String filename) throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        Stream<String> lines = Files.lines(path);
        return lines.map(s -> new SourceDestRange(s)).collect(Collectors.toList());
    }

    public long findLocation(long seed) {
        SeedItem item = new SeedItem();
        item.seed = seed;
        item.soil = findNextItem(item.seed, seedSoilMap);
        item.fertilizer = findNextItem(item.soil, soilFertlizerMap);
        item.water = findNextItem(item.fertilizer, fertilizerWaterMap);
        item.light = findNextItem(item.water, waterLightMap);
        item.temperature = findNextItem(item.light, lightTempMap);
        item.humidity = findNextItem(item.temperature, tempHumidityMap);
        item.location = findNextItem(item.humidity, humidityLocationMap);

//System.out.println(item);
        return item.location;

    }

    private long findNextItem(long item, List<SourceDestRange> map) {
        return map.stream().filter(r -> r.isSourceInRange(item)).mapToLong(r -> r.getDest(item)).findAny().orElse(item);
    }


    class SeedItem {
        long seed, soil, fertilizer, water, light, temperature, humidity, location;
        @Override
        public String toString() {
            return "seed:" + seed + " soil " + soil + " fertilizer "
                    + fertilizer + " water " + water + " light " + light + " location " + location;
        }
    }


}
