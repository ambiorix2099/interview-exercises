package com.cybercoders.interview;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class Exercise2Test {
    @Test
    public void testPrintMultiplicationTable() throws Exception {
        Assert.assertThat(Exercise2.printMultiplicationTable(12), is(notNullValue()));
    }

    @Test
    public void testCalculateMultiplicationTable() throws Exception {
        // Given:
        int maximumMultiplier = 12;

        // When:
        Map<Integer, List<Integer>> multiplicationTable = Exercise2.calculateMultiplicationTable(maximumMultiplier);

        // Then:
        assertThat(multiplicationTable, is(notNullValue()));
        assertThat(multiplicationTable.entrySet(), hasSize(maximumMultiplier));
        for (int multiplier = 1; multiplier <= multiplicationTable.size(); multiplier++) {
            for (int multiplicand = 0; multiplicand <= multiplicationTable.get(multiplier).size() - 1; multiplicand++) {
                assertEquals(multiplier * multiplicand, multiplicationTable.get(multiplier).get(multiplicand).intValue());
            }
        }
    }
}