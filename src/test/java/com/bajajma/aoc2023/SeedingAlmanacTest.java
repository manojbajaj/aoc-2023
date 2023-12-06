package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

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

        SeedingAlmanac almanac = new SeedingAlmanac(new String[] {"day5-seed-soil.txt","day5-soil-fertilizer.txt","day5-fertilizer-water.txt","day5-water-light.txt","day5-light-temp.txt","day5-temp-humidity.txt","day5-humidity-location.txt" });
        assertThat(almanac.findLocation(3489262449l)).isEqualTo(78);
        //seed:3489262449 soil 4257386054 fertilizer 3968824009 water 3355998766 light 3400670940 location 4114099082



    }

    @Test
    void seedLocationTest() throws Exception{

        SeedingAlmanac almanac = new SeedingAlmanac(new String[] {"day5-seed-soil-test.txt","day5-soil-fertilizer-test.txt","day5-fertilizer-water-test.txt","day5-water-light-test.txt","day5-light-temp-test.txt","day5-temp-humidity-test.txt","day5-humidity-location-test.txt" });
        assertThat(almanac.findLocation(79)).isEqualTo(82);
        assertThat(almanac.findLocation(14)).isEqualTo(43);
        assertThat(almanac.findLocation(55)).isEqualTo(86);
        assertThat(almanac.findLocation(13)).isEqualTo(35);
        //seed:3489262449 soil 4257386054 fertilizer 3968824009 water 3355998766 light 3400670940 location 4114099082



    }
}
