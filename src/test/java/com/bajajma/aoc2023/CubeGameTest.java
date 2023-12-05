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

}
