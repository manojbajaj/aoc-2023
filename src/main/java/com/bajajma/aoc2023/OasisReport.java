package com.bajajma.aoc2023;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class OasisReport {

    String filename ="";

    public OasisReport(String filename) throws Exception{
        this.filename = filename;


    }

    public long sumOfExtrapolatedValues() throws Exception{
        return sumOfExtrapolatedSequenceNumber(false);
    }

    public long sumOfReverseExtrapolatedValues() throws Exception{
        return sumOfExtrapolatedSequenceNumber(true);
    }

    private long sumOfExtrapolatedSequenceNumber(boolean reverse) throws URISyntaxException, IOException {
        long sum = 0;
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        List<String> lines = Files.readAllLines(path);
        for(String line : lines) {
            LinkedList<Long> lineMap  =  Arrays.stream(line.split(" ")).map(s -> Long.valueOf(s)).collect(Collectors.toCollection(LinkedList::new));
            sum = sum + predictNextSequenceItem( lineMap, reverse);
        }
        return sum;
    }


    private static long predictNextSequenceItem(List<Long> input, boolean reverse) {
        LinkedList<List<Long>> derivedSequences = getDerivedSequences(input);
        Iterator<List<Long>> listIterator = derivedSequences.descendingIterator();

        List<Long> next ;

        long extrapolatedSequenceNumber = 0;
        Long item = 0l;
        while (listIterator.hasNext()) {
            next = listIterator.next();
            if(reverse) {
                //first in sequence
                item = next.get(0);
                extrapolatedSequenceNumber = item - extrapolatedSequenceNumber;
            } else{
                //last in sequence
                item = next.get(next.size()-1);
                extrapolatedSequenceNumber = item + extrapolatedSequenceNumber;
            }

        }
        return extrapolatedSequenceNumber;
    }

    private static LinkedList<List<Long>> getDerivedSequences(List<Long> input) {
        LinkedList<List<Long>>derivedSequences = new LinkedList<>();

        boolean lastSequenceFound = false;

        while ( !lastSequenceFound) {
            derivedSequences.add(input);
            LinkedList<Long> derivedSeq = new LinkedList<>();
            long lastItem = 0;
            boolean lastItemExists = false;
            for( Long item : input) {
                if(lastItemExists) {
                    long difference = item - lastItem;
                    derivedSeq.add(difference);
                    lastItem = item;
                } else {
                    lastItem = item;
                    lastItemExists = true;
                }
            }

            lastSequenceFound = true;
            for (Long item : derivedSeq) {
                if (item != 0) {
                    lastSequenceFound = false;
                    input = derivedSeq;
                }
            }
        }
        return derivedSequences;
    }


}
