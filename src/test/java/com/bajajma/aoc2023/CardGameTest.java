package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardGameTest {

    private CardGame cardGame = new CardGame();

    @Test
    void winningPointsTest() {
        assertThat(cardGame.calculateWinningPoints("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")).isEqualTo(8);
        assertThat(cardGame.calculateWinningPoints("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19")).isEqualTo(2);
        assertThat(cardGame.calculateWinningPoints("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1")).isEqualTo(2);
        assertThat(cardGame.calculateWinningPoints("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83")).isEqualTo(1);
        assertThat(cardGame.calculateWinningPoints("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36")).isEqualTo(0);
        assertThat(cardGame.calculateWinningPoints("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11")).isEqualTo(0);
    }

    @Test
    void winningCountTest() {
        assertThat(cardGame.calculateWinningCount("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")).isEqualTo(4);
        assertThat(cardGame.calculateWinningCount("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19")).isEqualTo(2);
        assertThat(cardGame.calculateWinningCount("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1")).isEqualTo(2);
        assertThat(cardGame.calculateWinningCount("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83")).isEqualTo(1);
        assertThat(cardGame.calculateWinningCount("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36")).isEqualTo(0);
        assertThat(cardGame.calculateWinningCount("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11")).isEqualTo(0);
    }
}
