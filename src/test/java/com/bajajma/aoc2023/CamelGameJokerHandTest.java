package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamelGameJokerHandTest {
    @Test
    void camelGameHandPairTest() throws Exception{
        CamelGameJokerHand hand = new CamelGameJokerHand("32T3K 765");
        assertThat(hand.type).isEqualTo(2);
        assertThat(hand.handValue).isEqualTo(403110413);


    }

    @Test
    void camelGameHandDoublePairTest() throws Exception{
        CamelGameJokerHand hand = new CamelGameJokerHand("KK677 28");
        assertThat(hand.bid).isEqualTo(28);
        assertThat(hand.type).isEqualTo(3);
      assertThat(hand.handValue).isEqualTo(1313070808);
        assertThat(hand.strength).isEqualTo(31313070808L);
    }

    @Test
    void camelGameHandThreeOfKindWithJokerTest() throws Exception{
        CamelGameJokerHand hand = new CamelGameJokerHand("KJ677 28");
        assertThat(hand.bid).isEqualTo(28);
        assertThat(hand.type).isEqualTo(4);
        assertThat(hand.handValue).isEqualTo(1302070808);
        assertThat(hand.strength).isEqualTo(41302070808L);
    }

    @Test
    void camelGameHandFourOfKindWithJokerTest() throws Exception{
        CamelGameJokerHand hand = new CamelGameJokerHand("QQQJA 483");
        assertThat(hand.type).isEqualTo(6);
        assertThat(hand.handValue).isEqualTo(1212120214);
        assertThat(hand.strength).isEqualTo(61212120214L);
    }

    @Test
    void camelGameHandFiveOfKindWithJoker2Test() throws Exception{
        CamelGameJokerHand hand = new CamelGameJokerHand("QJQQJ 483");
        assertThat(hand.type).isEqualTo(7);
    }


    @Test
    void camelGameHandFiveOfKindWithJokerTest() throws Exception{
        CamelGameJokerHand hand = new CamelGameJokerHand("QQQQJ 483");
        assertThat(hand.type).isEqualTo(7);
    }

    @Test
    void camelGameHandFiveOfKindTest() throws Exception{
        CamelGameJokerHand hand = new CamelGameJokerHand("QQQQQ 483");
         assertThat(hand.type).isEqualTo(7);
        //assertThat()
    }

    @Test
    void camelThreeOfKindWithDoubleJokerTest() throws Exception{
        CamelGameJokerHand hand = new CamelGameJokerHand("JJ62A 440");
        assertThat(hand.type).isEqualTo(4);
        //assertThat()
    }



}
