package com.insightfullogic.java8.exercises.chapter6;

import com.insightfullogic.java8.exercises.Exercises;
import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Just run this class's main method and it will time benchmarks using the harness
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class OptimisationExample {

    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {
                ".*OptimisationExample.*",
                "-wi",
                "10",
                "-i",
                "10",
                "-f",
                "1"
        };
        Main.main(args);
    }

    private List<Integer> linkedListOfNumbers;

    @Setup
    public void init() {
        linkedListOfNumbers = new LinkedList<>();
        addNumbers(linkedListOfNumbers);

        // TODO: put any additional setup code here
    }

    private void addNumbers(List<Integer> container) {
        IntStream.range(0, 1_000_000)
                 .forEach(container::add);
    }

    @GenerateMicroBenchmark
    // BEGIN slowSumOfSquares
    public int slowSumOfSquares() {
        return linkedListOfNumbers.parallelStream()
                                  .map(x -> x * x)
                                  .reduce(0, (acc, x) -> acc + x);
    }
    // END slowSumOfSquares

    @GenerateMicroBenchmark
    public int fastSumOfSquares() {
        return Exercises.replaceThisWithSolution();
    }

}
