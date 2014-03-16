package com.insightfullogic.java8.examples.chapter3;

import java.util.stream.Stream;

public class GeneratingStreams {

    public static void main(String[] args) {
        iterate();
    }

    static void generate() {
        Stream.generate(() -> "hello world")
              .limit(3)
              .forEach(System.out::println);
    }

    static void iterate() {
        Stream.iterate(0, x -> x + 1)

              .limit(5)
              .forEach(System.out::println);
    }

}
