package com.insightfullogic.java8.examples.chapter5;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

// BEGIN class_def
public class StringCollector implements Collector<String, StringCombiner, String> {
// END class_def

    private static final Set<Characteristics> characteristics = Collections.emptySet();

    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    // BEGIN supplier
public Supplier<StringCombiner> supplier() {
    return () -> new StringCombiner(delim, prefix, suffix);
}
    // END supplier

    @Override
    // BEGIN accumulator
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }
    // END accumulator

    @Override
    // BEGIN combiner
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }
    // END combiner

    @Override
    // BEGIN finisher
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }
    // END finisher

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

}
