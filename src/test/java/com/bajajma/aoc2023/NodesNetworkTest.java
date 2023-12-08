package com.bajajma.aoc2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NodesNetworkTest {

    @Test
    void nodeNetworkStepsTest() throws Exception{
        NodeNetwork nodeNetwork = new NodeNetwork("day8-puzzle-test1-input.txt");
        assertThat(nodeNetwork.steps()).isEqualTo(2);
    }

    @Test
    void nodeNetworkSteps2Test() throws Exception{
        NodeNetwork nodeNetwork = new NodeNetwork("day8-puzzle-test2-input.txt");
        assertThat(nodeNetwork.steps()).isEqualTo(6);
    }

    @Test
    void nodeNetworkPuzzleTest() throws Exception{
        NodeNetwork nodeNetwork = new NodeNetwork("day8-puzzle-input.txt");
        assertThat(nodeNetwork.steps()).isEqualTo(17621);
    }
}
