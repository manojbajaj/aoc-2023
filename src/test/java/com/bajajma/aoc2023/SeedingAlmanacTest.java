package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SeedingAlmanacTest {

    @Test
    void seedSoilMapTest() {

        String suppliedMapping = "52 50 48";
        SourceDestRange sourceDestRange =    new SourceDestRange(suppliedMapping);


        assertThat(sourceDestRange.isSourceInRange(76)).isTrue();
        assertThat(sourceDestRange.isSourceInRange(98)).isFalse();
        assertThat(sourceDestRange.isSourceInRange(50)).isTrue();
        assertThat(sourceDestRange.isSourceInRange(49)).isFalse();

        assertThat(sourceDestRange.getDest(76)).isEqualTo(78);
        assertThat(sourceDestRange.getDest(97)).isEqualTo(99);
        assertThat(sourceDestRange.getDest(98)).isEqualTo(-1);
        assertThat(sourceDestRange.getDest(50)).isEqualTo(52);
        assertThat(sourceDestRange.getDest(49)).isEqualTo(-1);

    }

    @Test
    void seedLocationPuzzleTest() throws Exception{

        SeedingAlmanac almanac = new SeedingAlmanac("day5-puzzle-input.txt");
        assertThat(almanac.findFinalLocation()).isEqualTo(278755257l);

    }

    @Test
    void seedLocationTest() throws Exception{

        SeedingAlmanac almanac = new SeedingAlmanac("day5-puzzle-test-input.txt");
        assertThat(almanac.findLocation(79)).isEqualTo(82);
        assertThat(almanac.findLocation(14)).isEqualTo(43);
        assertThat(almanac.findLocation(55)).isEqualTo(86);
        assertThat(almanac.findLocation(13)).isEqualTo(35);


        assertThat(almanac.findFinalLocation()).isEqualTo(35);
    }
}
