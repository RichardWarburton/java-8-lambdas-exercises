package com.insightfullogic.java8.exercises.chapter6;

import java.util.stream.IntStream;

public class SerialToParallel {

    public static int sumOfSquares(IntStream range) {
        return range.parallel()
                    .map(x -> x * x)
                    .sum();
    }

    // BEGIN sequentialSumOfSquares
    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x)
                    .sum();
    }
    // END sequentialSumOfSquares

}
