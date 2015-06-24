package com.cybercoders.interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Houses the code for Coding Interview Exercise 2: Print Multiplication Table up to 12.
 */
public class Exercise2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Exercise2.class);
    private static int MAXIMUM_MULTIPLICAND = 12;

    public static String printMultiplicationTable(int maximumMultiplier) {
        Map<Integer, List<Integer>> multiplicationTable = calculateMultiplicationTable(maximumMultiplier);

        StringBuilder formattedMultiplicationTableBuilder = new StringBuilder();
        for (Map.Entry<Integer, List<Integer>> entry : multiplicationTable.entrySet()) {
            int multiplicand = 0;
            Integer multiplier = entry.getKey();
            for (Integer multiplicationResult : multiplicationTable.get(multiplier)) {
                formattedMultiplicationTableBuilder.append(String.format("%d x %d = %d\n",
                    multiplier, multiplicand++, multiplicationResult));
            }
        }

        String formattedMultiplicationTable = formattedMultiplicationTableBuilder.toString();

        LOGGER.info("Generated this Formatted Multiplication Table:\n{}", formattedMultiplicationTable);

        return formattedMultiplicationTable;
    }

    public static Map<Integer, List<Integer>> calculateMultiplicationTable(int maximumMultiplier) {
        Map<Integer, List<Integer>> multiplicationTable = new LinkedHashMap<Integer, List<Integer>>();

        for (int multiplier = 1; multiplier <= maximumMultiplier; multiplier++) {
            multiplicationTable.put(multiplier, new ArrayList<Integer>());
            for (int multiplicand = 0; multiplicand <= MAXIMUM_MULTIPLICAND; multiplicand++) {
                multiplicationTable.get(multiplier).add(multiplier * multiplicand);
            }
        }

        return multiplicationTable;
    }
}