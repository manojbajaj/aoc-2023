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

    SeedingAlmanac(String filename) throws Exception {

        extractMaps(filename);

//        seedSoilMap = buildMap(filenames[0]);
//        soilFertlizerMap = buildMap(filenames[1]);
//        fertilizerWaterMap = buildMap(filenames[2]);
//        waterLightMap = buildMap(filenames[3]);
//        lightTempMap = buildMap(filenames[4]);
//        tempHumidityMap = buildMap(filenames[5]);
//        humidityLocationMap = buildMap(filenames[6]);


    }

    private void extractMaps(String filename) throws Exception{
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        List<String> lines = Files.readAllLines(path);
        boolean seedToSoilMapReadyForMapping = false;
        boolean soilToFertiliserMapReadyForMapping = false;
        boolean fertiliserToWaterMapReadyForMapping = false;
        boolean waterToLightMapReadyForMapping = false;
        boolean lightToTemperatureMapReadyForMapping = false;
        boolean temperatureToHumidityMapReadyForMapping = false;
        boolean humidityToLocationMapReadyForMapping = false;

        for (String line : lines) {
            if(line.contains("seeds:")) {
                seeds = extractSeeds(line);
            }
            else if(line.contains("seed-to-soil map")) {
                seedToSoilMapReadyForMapping = true;
            }
            else if(line.contains("soil-to-fertilizer map")) {
                seedToSoilMapReadyForMapping = false;
                soilToFertiliserMapReadyForMapping = true;
            }
            else if(line.contains("fertilizer-to-water map")) {
                soilToFertiliserMapReadyForMapping = false;
                fertiliserToWaterMapReadyForMapping= true;
            }
            else if(line.contains("water-to-light map")) {
                fertiliserToWaterMapReadyForMapping = false;
                waterToLightMapReadyForMapping = true;
            }
            else if(line.contains("light-to-temperature map")) {
                waterToLightMapReadyForMapping = false;
                lightToTemperatureMapReadyForMapping= true;
            }
            else if(line.contains("temperature-to-humidity map")) {
                lightToTemperatureMapReadyForMapping = false;
                temperatureToHumidityMapReadyForMapping = true;
            }
            else if(line.contains("humidity-to-location map")) {
                temperatureToHumidityMapReadyForMapping = false;
                humidityToLocationMapReadyForMapping= true;
            }
            else if(line.isBlank()) {

            }
            else if(seedToSoilMapReadyForMapping) {
                seedSoilMap.add( new SourceDestRange(line));
            }
            else if(soilToFertiliserMapReadyForMapping) {
                soilFertlizerMap.add( new SourceDestRange(line));
            }
            else if(fertiliserToWaterMapReadyForMapping) {
                fertilizerWaterMap.add( new SourceDestRange(line));
            }
            else if(waterToLightMapReadyForMapping) {
                waterLightMap.add( new SourceDestRange(line));
            }
            else if(lightToTemperatureMapReadyForMapping) {
                lightTempMap.add( new SourceDestRange(line));
            }
            else if(temperatureToHumidityMapReadyForMapping) {
                tempHumidityMap.add( new SourceDestRange(line));
            }
            else if(humidityToLocationMapReadyForMapping) {
                humidityLocationMap.add( new SourceDestRange(line));
            }

        }



    }


    private List<Long> extractSeeds(String line) {

        return Arrays.stream(line.split(":")[1].split(" "))
                .filter(s -> !s.isBlank())
                .map( s -> Long.valueOf(s))
                .collect(Collectors.toList());

    }

    public long findFinalLocation() {
        return  seeds.stream().mapToLong(s -> this.findLocation(s)).min().orElse(0);

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
