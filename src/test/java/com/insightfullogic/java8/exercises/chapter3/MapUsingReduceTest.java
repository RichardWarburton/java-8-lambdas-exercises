package com.insightfullogic.java8.exercises.chapter3;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

public class MapUsingReduceTest {

    @Test
    public void emptyList() {
        assertMapped(Function.<Object>identity(), Collections.<Object>emptyList(), Collections.<Object>emptyList());
    }

    @Test
    public void identityMapsToItself() {
        assertMapped((Integer x) -> x, asList(1, 2, 3), asList(1, 2, 3));
    }

    @Test
    public void incrementingNumbers() {
        assertMapped((Integer x) -> x + 2, asList(1, 2, 3), asList(3, 4, 5));
    }

    private <I, O> void assertMapped(Function<I, O> mapper, List<I> input, List<O> expectedOutput) {
        List<O> output = MapUsingReduce.map(input.stream(), mapper);
        assertEquals(expectedOutput, output);

        List<O> parallelOutput = MapUsingReduce.map(input.parallelStream(), mapper);
        assertEquals(expectedOutput, parallelOutput);
    }

}
