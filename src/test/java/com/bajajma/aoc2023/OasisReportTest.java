package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OasisReportTest {

    @Test
    void oasisReportTest() throws Exception{
        OasisReport report = new OasisReport("day9-puzzle-test-input.txt");
        assertThat(report.sumOfExtrapolatedValues()).isEqualTo(114);
    }

    @Test
    void oasisReportPuzzleTest() throws Exception{
        OasisReport report = new OasisReport("day9-puzzle-input.txt");
        assertThat(report.sumOfExtrapolatedValues()).isEqualTo(2101499000l);
    }

    @Test
    void oasisReportReverseExtrapolatedTest() throws Exception{
        OasisReport report = new OasisReport("day9-puzzle-test-input.txt");
        assertThat(report.sumOfReverseExtrapolatedValues()).isEqualTo(2);
    }

    @Test
    void oasisReportPuzzleReverseExtrapolatedTest() throws Exception{
        OasisReport report = new OasisReport("day9-puzzle-input.txt");
        assertThat(report.sumOfReverseExtrapolatedValues()).isEqualTo(1089);
    }

}
