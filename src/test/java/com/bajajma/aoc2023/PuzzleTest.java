package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PuzzleTest {

    private Calibrator calibrator = new Calibrator();
    @Test
    void puzzle1() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("puzzle1-input.txt").toURI());
        Stream<String> lines = Files.lines(path);
       // lines.map(line -> calibrator.calibrationValue(line)).forEach(value -> System.out.println(value));
        System.out.println(lines.map(line -> calibrator.calibrationValue(line)).reduce(0, Integer::sum));
    }

    @Test
    void puzzle2() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("puzzle1-input.txt").toURI());
        Stream<String> lines = Files.lines(path);
      //lines.map(line -> calibrator.calibrationValueWithLetters(line)).forEach(value -> System.out.println(value));
       System.out.println(lines.map(line -> calibrator.calibrationValueWithLetters(line)).reduce(0, Integer::sum));
    }

}
