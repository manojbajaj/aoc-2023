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

    @Test
    void calibrationValueWithLetters() {
        assertThat(calibrator.calibrationValueWithLetters("two1nine")).isEqualTo(29);
        assertThat(calibrator.calibrationValueWithLetters("eightwothree")).isEqualTo(83);
        assertThat(calibrator.calibrationValueWithLetters("abcone2threexyz")).isEqualTo(13);
        assertThat(calibrator.calibrationValueWithLetters("xtwone3four")).isEqualTo(24);
        assertThat(calibrator.calibrationValueWithLetters("4nineeightseven2")).isEqualTo(42);
        assertThat(calibrator.calibrationValueWithLetters("zoneight234")).isEqualTo(14);
        assertThat(calibrator.calibrationValueWithLetters("7pqrstsixteen")).isEqualTo(76);
        assertThat(calibrator.calibrationValueWithLetters("5eight34sckhhxrtwonem")).isEqualTo(51);
        assertThat(calibrator.calibrationValueWithLetters("eighthree")).isEqualTo(83);
    }

    @Test
    void convertStringToDigits() {
        assertThat(Calibrator.convertStringToDigits("one1nine")).isEqualTo("119");
        assertThat(Calibrator.convertStringToDigits("eightwothree")).isEqualTo("823");
        assertThat(Calibrator.convertStringToDigits("abcone2threexyz")).isEqualTo("123");
        assertThat(Calibrator.convertStringToDigits("eighthree")).isEqualTo("83");
        assertThat(Calibrator.convertStringToDigits("5eight34sckhhxrtwonem")).isEqualTo("583421");
    }

}
