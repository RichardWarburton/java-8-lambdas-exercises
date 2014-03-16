package com.insightfullogic.java8.examples.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayExamples {

    // BEGIN simpleMovingAverage
public static double[] simpleMovingAverage(double[] values, int n) {
    double[] sums = Arrays.copyOf(values, values.length); // <1>
    Arrays.parallelPrefix(sums, Double::sum); // <2>
    int start = n - 1;
    return IntStream.range(start, sums.length) // <3>
                    .mapToDouble(i -> {
                        double prefix = i == start ? 0 : sums[i - n];
                        return (sums[i] - prefix) / n; // <4>
                    })
                    .toArray(); // <5>
}
    // END simpleMovingAverage

    // BEGIN parallelInitialize
public static double[] parallelInitialize(int size) {
    double[] values = new double[size];
    Arrays.parallelSetAll(values, i -> i);
    return values;
}
    // END parallelInitialize

    // BEGIN imperativeInitilize
public static double[] imperativeInitilize(int size) {
    double[] values = new double[size];
    for(int i = 0; i < values.length;i++) {
        values[i] = i;
    }
    return values;
}
    // END imperativeInitilize

}
