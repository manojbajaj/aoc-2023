package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamelGameTest {
    @Test
    void camelGameTotalWinningTest() throws Exception{
        CamelGame camelGame = new CamelGame("day7-puzzle-test-input.txt");
        assertThat(camelGame.totalWinnings()).isEqualTo(6440);
    }

    @Test
    void camelGamePuzzleTotalWinning() throws Exception{
        CamelGame camelGame = new CamelGame("day7-puzzle-input.txt");
        assertThat(camelGame.totalWinnings()).isEqualTo(248105065);
    }
}
