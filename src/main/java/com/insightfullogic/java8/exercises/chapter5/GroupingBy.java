package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    private final Function<? super T, ? extends K> classifier;

    public GroupingBy(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return Exercises.replaceThisWithSolution();
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return Exercises.replaceThisWithSolution();
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return Exercises.replaceThisWithSolution();
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return Exercises.replaceThisWithSolution();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Exercises.replaceThisWithSolution();
    }

}
