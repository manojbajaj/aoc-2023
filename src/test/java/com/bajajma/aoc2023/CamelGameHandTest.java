package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamelGameHandTest {
    @Test
    void camelGameHandPairTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("32T3K 765");
        assertThat(hand.bid).isEqualTo(765);
        assertThat(hand.isPair()).isTrue();
        assertThat(hand.isDoublePair()).isFalse();
        assertThat(hand.strength).isEqualTo(2);


    }

    @Test
    void camelGameHandDoublePairTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("KK677 28");
        assertThat(hand.bid).isEqualTo(28);
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isDoublePair()).isTrue();
        assertThat(hand.strength).isEqualTo(3);
    }

    @Test
    void camelGameHandThreeOfKindTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("QQQJA 483");
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isThreeOfKind()).isTrue();
        assertThat(hand.isFullHouse()).isFalse();
        assertThat(hand.strength).isEqualTo(4);
    }

    @Test
    void camelGameHandFullHouseTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("QJQQJ 483");
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isThreeOfKind()).isFalse();
        assertThat(hand.isFullHouse()).isTrue();
        assertThat(hand.strength).isEqualTo(5);
    }


    @Test
    void camelGameHandFourOfKindTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("QQQQJ 483");
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isThreeOfKind()).isFalse();
        assertThat(hand.isFullHouse()).isFalse();
        assertThat(hand.isFourOfKind()).isTrue();
        assertThat(hand.isFiveOfKind()).isFalse();
        assertThat(hand.strength).isEqualTo(6);
    }

    @Test
    void camelGameHandFiveOfKindTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("QQQQQ 483");
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isThreeOfKind()).isFalse();
        assertThat(hand.isFullHouse()).isFalse();
        assertThat(hand.isFourOfKind()).isFalse();
        assertThat(hand.isFiveOfKind()).isTrue();
        assertThat(hand.strength).isEqualTo(7);
        //assertThat()
    }

}
