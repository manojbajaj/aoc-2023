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



        List<String> nodeListForEvaluation = nodes.keySet().stream().filter(s -> s.endsWith("A")).collect(Collectors.toList());
        System.out.println("Nodelist for evaluation : " + nodeListForEvaluation);
        List<Long> steps  = new ArrayList<>();


        for (String nextNodeId : nodeListForEvaluation) {
           long step = 0l;
            boolean lastElementFound = false;
            while (!lastElementFound) {
                for (int i = 0; i < instructionsArray.length; i++) {
                    Node node = nodes.get(nextNodeId);
                    ++step;
                    nextNodeId = node.nextNode(instructionsArray[i]);
                    if (nextNodeId.endsWith("Z")) {
                        System.out.println( "Node ID : " + nextNodeId + " Steps : " + step);
                        lastElementFound = true;
                        steps.add(step);
                    }

                }
            }
        }

        return lcm(steps);
    }

    private long lcm(List<Long> steps) {
        int size = steps.size();
        long lcm  = steps.get(0);

        for (int i = 1; i < size; i++) {
            lcm = lcm( lcm, steps.get(i));

        }
        return lcm;
    }

    private long lcm(long firstNumber, long secondNumber) {


        boolean isFirstStepGreater= firstNumber > secondNumber;
        long higherNumber =  0l;
        long  lowerNumber = 0l;
        if(isFirstStepGreater) {
            higherNumber = firstNumber;
            lowerNumber = secondNumber;
        } else {
            higherNumber = secondNumber;
            lowerNumber = firstNumber;
        }

        long lcm = higherNumber;

        while(!( lcm % lowerNumber ==0)) {
            lcm = lcm + higherNumber;
        }

        System.out.println( " Lcm of " + firstNumber + " & " + secondNumber + " is :" + lcm);
        return lcm;

    }


    public int humanSteps() {
        char[] instructionsArray = instructions.toCharArray();

        boolean lastElementFound = false;
        String nextNodeId = "AAA";
        int step = 0;
        while (!lastElementFound) {
            for (int i = 0; i < instructionsArray.length; i++) {
                Node node = nodes.get(nextNodeId);
                ++step;
                nextNodeId = node.nextNode(instructionsArray[i]);
                if (nextNodeId.equals("ZZZ")) {
                    lastElementFound = true;
                    return step;
                }

            }
        }
        return 0;
    }

    void addNode(String line) {
        String[] nodeParts = line.split("=");
        nodes.put(nodeParts[0].trim(), new Node(nodeParts[1].trim()));
    }
}
