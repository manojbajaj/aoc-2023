package com.bajajma.aoc2023;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NodeNetwork {

    Map<String, Node> nodes = new HashMap<>();
    private String instructions;

    public NodeNetwork(String filename) throws Exception {

        setupNodeNetwork(filename);


    }

    private void setupNodeNetwork(String filename) throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        List<String> lines = Files.readAllLines(path);

        boolean instructionLine = true;
        for (String line : lines) {
            if (instructionLine) {
                instructions = line;
                instructionLine = false;
            } else if (line.isBlank()) {

            } else {
                addNode(line);
            }
        }


    }

    public long ghostSteps() {
        char[] instructionsArray = instructions.toCharArray();

        boolean lastElementFound = false;

        List<String> startNodeListForEvaluation = nodes.keySet().stream().filter(s -> s.endsWith("A")).collect(Collectors.toList());
        List<String> nextNodeListForEvaluation =  new ArrayList<>();


        long step=0l;
        while (!lastElementFound) {
            for (int i = 0; i < instructionsArray.length; i++) {
                ++step;
                nextNodeListForEvaluation =  new ArrayList<>();
                for ( String nextNodeId : startNodeListForEvaluation) {
                    Node node = nodes.get(nextNodeId);
                    nextNodeListForEvaluation.add(node.nextNode(instructionsArray[i]));
                }
                System.out.println("Step " + step + "    " + nextNodeListForEvaluation);



                if ( verifyGhostStepEnded( nextNodeListForEvaluation) ) {
                    lastElementFound = true;
                    return step;
                } else {
                    startNodeListForEvaluation = nextNodeListForEvaluation;
                }

            }
        }
        return 0;
    }

    private boolean verifyGhostStepEnded(List<String> nextNodeListForEvaluation) {
        for(String nodeId : nextNodeListForEvaluation) {
            if(!nodeId.endsWith("Z")) {
                return false;
            }
        }

        return true;

    }

    public int humanSteps() {
        char[] instructionsArray = instructions.toCharArray();

        boolean lastElementFound = false;
        String nextNodeId = "AAA";
        int step=0;
        while (!lastElementFound) {
            for (int i = 0; i < instructionsArray.length; i++) {
                Node node = nodes.get(nextNodeId);
                ++step;
                nextNodeId = node.nextNode(instructionsArray[i]);
                if (nextNodeId.equals("ZZZ")) {
                    lastElementFound=true;
                    return step;
                }

            }
        }
        return 0;
    }

    void addNode(String line ) {
        String[] nodeParts = line.split("=");
        nodes.put(nodeParts[0].trim(), new Node(nodeParts[1].trim()));
    }
}
