package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PuzzleTest {

    private Calibrator calibrator = new Calibrator();
    CubeGame cubeGame = new CubeGame();
    CardGame cardGame = new CardGame();
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

    @Test
    void day2Puzzle1() throws Exception{
        Path path = Paths.get(getClass().getClassLoader().getResource("day2-puzzle-input.txt").toURI());
        Stream<String> lines = Files.lines(path);
        int result = lines.filter(cubeGame::isGameSetValid).mapToInt(cubeGame::gameId).sum();
        System.out.println(result);
        assertThat(result).isEqualTo(2685);

    }

    @Test
    void day2Puzzle2() throws Exception{
        Path path = Paths.get(getClass().getClassLoader().getResource("day2-puzzle-input.txt").toURI());
        Stream<String> lines = Files.lines(path);
        int result = lines.mapToInt(cubeGame::cubePower).sum();
        System.out.println(result);
        assertThat(result).isEqualTo(83707);

    }

    @Test
    void day4Puzzle1() throws Exception{
        Path path = Paths.get(getClass().getClassLoader().getResource("day4-puzzle-input.txt").toURI());
        Stream<String> lines = Files.lines(path);
        int result = lines.mapToInt(cardGame::calculateWinningPoints).sum();
        System.out.println(result);
        assertThat(result).isEqualTo(23235);

    }

    @Test
    void day4Puzzle2() throws Exception{
        Path path = Paths.get(getClass().getClassLoader().getResource("day4-puzzle-input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        int result = cardGame.calculateTotalCards(lines);
        System.out.println(result);
        assertThat(result).isEqualTo(5920640);

    }

}
