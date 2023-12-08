package com.bajajma.aoc2023;

import java.util.HashMap;
import java.util.Map;

public class Node {
    String id;
    Map<Character,String> nodes = new HashMap<>();

    public Node(String nodes) {
        nodes = nodes.replace("(","");
        nodes = nodes.replace(")","");
         nodes.trim();
        String[] nodeslist = nodes.split(",");
        addLeft(nodeslist[0].trim());
        addRight(nodeslist[1].trim());

    }

    public void addLeft(String  node) {
        nodes.put('L', node);
    }

    public void addRight(String  node) {
        nodes.put('R', node);
    }

    public String left() {
        return nodes.get('L');
    }

    public String right() {
        return nodes.get('R');
    }

    public String nextNode(Character c) {
        return nodes.get(c);
    }
}
