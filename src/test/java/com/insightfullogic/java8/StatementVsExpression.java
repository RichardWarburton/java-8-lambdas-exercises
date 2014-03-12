package com.insightfullogic.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StatementVsExpression {

    @Test
    public void printStream() {
        Stream.of(1, 2, 3)
              .forEach(x -> System.out.println(x));

        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.forEach(x -> {
            System.out.println(x);
        });
    }

}
