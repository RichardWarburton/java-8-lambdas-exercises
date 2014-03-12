package com.insightfullogic.java8.exercises.chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void fibonacciMatchesOpeningSequence() {
        List<Long> fibonacciSequence = Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L);

        IntStream.range(0, fibonacciSequence.size())
                 .forEach(x -> {
                     Fibonacci fibonacci = new Fibonacci();
                     long result = fibonacci.fibonacci(x);
                     long expectedResult = fibonacciSequence.get(x);
                     assertEquals(expectedResult, result);
                 });
    }

}
