package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CubeGameTest {

    CubeGame cubeGame = new CubeGame();

    @Test
    void isSetValid() {
     assertThat( cubeGame.isSetValid("3 blue, 4 red")).isTrue();
     assertThat( cubeGame.isSetValid("1 red, 2 green, 6 blue")).isTrue();
     assertThat( cubeGame.isSetValid("8 green, 6 blue, 20 red")).isFalse();
     assertThat( cubeGame.isSetValid("5 blue, 4 red, 14 green")).isFalse();
    assertThat( cubeGame.isSetValid("15 blue, 4 red, 1 green")).isFalse();


    }

    @Test
    void hasBallsBreachedLimit() {
        assertThat( cubeGame.hasBallsBreachedLimit("3 blue")).isFalse();
        assertThat( cubeGame.hasBallsBreachedLimit("2 green")).isFalse();
       assertThat( cubeGame.hasBallsBreachedLimit("10 red")).isFalse();
        assertThat( cubeGame.hasBallsBreachedLimit("20 red")).isTrue();
        assertThat( cubeGame.hasBallsBreachedLimit("14 green")).isTrue();
        assertThat( cubeGame.hasBallsBreachedLimit("15 blue")).isTrue();

    }

    @Test
    void gameIdTest() {
        assertThat(cubeGame.gameId("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red")).isEqualTo(4);
        assertThat(cubeGame.gameId("Game 5: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red")).isEqualTo(5);
    }

    @Test
    void isGameSetValid() {
        assertThat( cubeGame.isGameSetValid("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red")).isFalse();
        assertThat( cubeGame.isGameSetValid("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")).isTrue();
        assertThat( cubeGame.isGameSetValid("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")).isTrue();
        assertThat( cubeGame.isGameSetValid("Game 5: 17 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")).isFalse();
    }

}
