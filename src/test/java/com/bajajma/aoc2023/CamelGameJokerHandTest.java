package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamelGameJokerHandTest {
    @Test
    void camelGameHandPairTest() throws Exception{
        CamelJokerGameHand hand = new CamelJokerGameHand("32T3K 765");
        assertThat(hand.type).isEqualTo(2);
        assertThat(hand.handValue).isEqualTo(403110413);


    }

    @Test
    void camelGameHandDoublePairTest() throws Exception{
        CamelJokerGameHand hand = new CamelJokerGameHand("KK677 28");
        assertThat(hand.bid).isEqualTo(28);
        assertThat(hand.type).isEqualTo(3);
      assertThat(hand.handValue).isEqualTo(1313070808);
        assertThat(hand.strength).isEqualTo(31313070808L);
    }

    @Test
    void camelGameHandThreeOfKindWithJokerTest() throws Exception{
        CamelJokerGameHand hand = new CamelJokerGameHand("KJ677 28");
        assertThat(hand.bid).isEqualTo(28);
        assertThat(hand.type).isEqualTo(4);
        assertThat(hand.handValue).isEqualTo(1302070808);
        assertThat(hand.strength).isEqualTo(41302070808L);
    }

    @Test
    void camelGameHandFourOfKindWithJokerTest() throws Exception{
        CamelJokerGameHand hand = new CamelJokerGameHand("QQQJA 483");
        assertThat(hand.type).isEqualTo(6);
        assertThat(hand.handValue).isEqualTo(1212120214);
        assertThat(hand.strength).isEqualTo(61212120214L);
    }

    @Test
    void camelGameHandFiveOfKindWithJoker2Test() throws Exception{
        CamelJokerGameHand hand = new CamelJokerGameHand("QJQQJ 483");
        assertThat(hand.type).isEqualTo(7);
    }


    @Test
    void camelGameHandFiveOfKindWithJokerTest() throws Exception{
        CamelJokerGameHand hand = new CamelJokerGameHand("QQQQJ 483");
        assertThat(hand.type).isEqualTo(7);
    }

    @Test
    void camelGameHandFiveOfKindTest() throws Exception{
        CamelJokerGameHand hand = new CamelJokerGameHand("QQQQQ 483");
         assertThat(hand.type).isEqualTo(7);
        //assertThat()
    }

    @Test
    void camelThreeOfKindWithDoubleJokerTest() throws Exception{
        CamelJokerGameHand hand = new CamelJokerGameHand("JJ62A 440");
        assertThat(hand.type).isEqualTo(4);
        //assertThat()
    }



}
