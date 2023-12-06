package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoatRaceTest {

    BoatRace boatRace = new BoatRace();

    @Test
    void calculateButtonHoldCountTest() {

        assertThat(boatRace.calculateButtonHoldCount("7,9")).isEqualTo(4);
        assertThat(boatRace.calculateButtonHoldCount("15,40")).isEqualTo(8);
        assertThat(boatRace.calculateButtonHoldCount("30,200")).isEqualTo(9);
        assertThat(boatRace.calculateButtonHoldCount("47,282")).isEqualTo(32);
        assertThat(boatRace.calculateButtonHoldCount("47707566,282107911471062")).isEqualTo(33875953);


    }

}
