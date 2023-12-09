package com.bajajma.aoc2023;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OasisReport {

    String filename ="";

    public OasisReport(String filename) throws Exception{
        this.filename = filename;


    }

    public long sumOfExtrapolatedValues() throws Exception{
        long sum = 0;
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        List<String> lines = Files.readAllLines(path);
        for(String line : lines) {
            ArrayList<Long> lineMap  =  Arrays.stream(line.split(" ")).map(s -> Long.valueOf(s)).collect(Collectors.toCollection(ArrayList::new));
       //     System.out.println(lineMap);
            sum = sum + predictNextItem( lineMap);
        }
        return sum;

    }

    private long predictNextItem(ArrayList<Long> input) {

        LinkedList<List<Long>>derivedSequences = new LinkedList<>();


        boolean lastSequenceFound = false;

        while ( !lastSequenceFound) {
            derivedSequences.add(input);
            ArrayList<Long> derivedSeq = new ArrayList<Long>();
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

    //    System.out.println("Derived Sequence : " + derivedSequences);

        Iterator<List<Long>> listIterator = derivedSequences.descendingIterator();


        List<Long> next ;

        long extrapolatedSequenceNumber = 0;
        while (listIterator.hasNext()) {
            next = listIterator.next();
             Long lastItem = next.get(next.size()-1);
            extrapolatedSequenceNumber = lastItem + extrapolatedSequenceNumber;
        }

      //  System.out.println(" Input : " + input + "; Derived Number :" + extrapolatedSequenceNumber  );


        return extrapolatedSequenceNumber;
    }

    public long sumOfReverseExtrapolatedValues() throws Exception{
        long sum = 0;
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        List<String> lines = Files.readAllLines(path);
        for(String line : lines) {
            LinkedList<Long> lineMap  =  Arrays.stream(line.split(" ")).map(s -> Long.valueOf(s)).collect(Collectors.toCollection(LinkedList::new));
            sum = sum + reversePredictNextItem( lineMap);
        }
        return sum;

    }

    private long reversePredictNextItem(LinkedList<Long> input) {

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

   //         System.out.println("Derived Sequence : " + derivedSequences);

        Iterator<List<Long>> listIterator = derivedSequences.descendingIterator();


        List<Long> next ;

        long extrapolatedSequenceNumber = 0;
        while (listIterator.hasNext()) {
            next = listIterator.next();
            Long firstItem = next.get(0);
            extrapolatedSequenceNumber = firstItem - extrapolatedSequenceNumber;
        }

        //  System.out.println(" Input : " + input + "; Derived Number :" + extrapolatedSequenceNumber  );


        return extrapolatedSequenceNumber;
    }


}
