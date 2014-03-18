package com.insightfullogic.java8.exercises.chapter3;

import java.util.stream.Stream;

public class Question1 {
    public static int addUp(Stream<Integer> empty) {
        return empty.reduce(0, (acc, x) -> acc + x);
    }
}
