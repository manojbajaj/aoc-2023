package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PuzzleTest {

    private Calibrator calibrator = new Calibrator();
    @Test
    void day1Puzzle1() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("day1-puzzle-input.txt").toURI());
        Stream<String> lines = Files.lines(path);
       // lines.map(line -> calibrator.calibrationValue(line)).forEach(value -> System.out.println(value));
      //  System.out.println(lines.map(line -> calibrator.calibrationValue(line)).reduce(0, Integer::sum));
        assertThat(lines.map(line -> calibrator.calibrationValue(line)).reduce(0, Integer::sum)).isEqualTo(55607);
    }

    @Test
    void day1Puzzle2() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("day1-puzzle-input.txt").toURI());
        Stream<String> lines = Files.lines(path);
      //lines.map(line -> calibrator.calibrationValueWithLetters(line)).forEach(value -> System.out.println(value));
       //System.out.println(lines.map(line -> calibrator.calibrationValueWithLetters(line)).reduce(0, Integer::sum));

        assertThat(lines.map(line -> calibrator.calibrationValueWithLetters(line)).reduce(0, Integer::sum)).isEqualTo(55291);

    }

}
