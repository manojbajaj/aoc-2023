package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CalibratorTest {

    private Calibrator calibrator = new Calibrator();

    @Test
    void calibrationValue() {
        assertThat(calibrator.calibrationValue("1abc2")).isEqualTo(12);
        assertThat(calibrator.calibrationValue("pqr3stu8vwx")).isEqualTo(38);
        assertThat(calibrator.calibrationValue("a1b2c3d4e5f")).isEqualTo(15);
        assertThat(calibrator.calibrationValue("treb7uchet")).isEqualTo(77);
    }


}
