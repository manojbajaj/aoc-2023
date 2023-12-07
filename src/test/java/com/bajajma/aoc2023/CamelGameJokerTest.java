package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamelGameJokerTest {
    @Test
    void camelGameTotalWinningTest() throws Exception{
        CamelJokerGame camelGame = new CamelJokerGame("day7-puzzle-test-input.txt");
        assertThat(camelGame.totalWinnings()).isEqualTo(5905);
    }

    @Test
    void camelGamePuzzleTotalWinning() throws Exception{
        CamelJokerGame camelGame = new CamelJokerGame("day7-puzzle-input.txt");
        assertThat(camelGame.totalWinnings()).isEqualTo(249515436L);
    }
}
