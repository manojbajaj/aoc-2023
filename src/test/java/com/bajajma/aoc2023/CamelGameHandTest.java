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
        assertThat(hand.type).isEqualTo(2);
        assertThat(hand.highCard).isEqualTo("3210313");


    }

    @Test
    void camelGameHandDoublePairTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("KK677 28");
        assertThat(hand.bid).isEqualTo(28);
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isDoublePair()).isTrue();
        assertThat(hand.type).isEqualTo(3);
        assertThat(hand.highCard).isEqualTo("1313677");
        assertThat(hand.strength).isEqualTo(30001313677L);
    }

    @Test
    void camelGameHandThreeOfKindTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("QQQJA 483");
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isThreeOfKind()).isTrue();
        assertThat(hand.isFullHouse()).isFalse();
        assertThat(hand.type).isEqualTo(4);
        assertThat(hand.highCard).isEqualTo("1212121114");
        assertThat(hand.strength).isEqualTo(41212121114L);
    }

    @Test
    void camelGameHandFullHouseTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("QJQQJ 483");
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isThreeOfKind()).isFalse();
        assertThat(hand.isFullHouse()).isTrue();
        assertThat(hand.type).isEqualTo(5);
    }


    @Test
    void camelGameHandFourOfKindTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("QQQQJ 483");
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isThreeOfKind()).isFalse();
        assertThat(hand.isFullHouse()).isFalse();
        assertThat(hand.isFourOfKind()).isTrue();
        assertThat(hand.isFiveOfKind()).isFalse();
        assertThat(hand.type).isEqualTo(6);
    }

    @Test
    void camelGameHandFiveOfKindTest() throws Exception{
        CamelGameHand hand = new CamelGameHand("QQQQQ 483");
        assertThat(hand.isPair()).isFalse();
        assertThat(hand.isThreeOfKind()).isFalse();
        assertThat(hand.isFullHouse()).isFalse();
        assertThat(hand.isFourOfKind()).isFalse();
        assertThat(hand.isFiveOfKind()).isTrue();
        assertThat(hand.type).isEqualTo(7);
        //assertThat()
    }

}
