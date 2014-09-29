package com.insightfullogic.java8.answers.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 1
 */
public class FilterUsingReduce {

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial,
                             (List<I> acc, I x) -> {
                                if (predicate.test(x)) {
                                	// We are copying data from acc to new list instance. It is very inefficient,
                                	// but contract of Stream.reduce method requires that accumulator function does
                                	// not mutate its arguments.
                                	// Stream.collect method could be used to implement more efficient mutable reduction,
                                	// but this exercise asks to use reduce method explicitly.
                                	List<I> newAcc = new ArrayList<>(acc);
                                    newAcc.add(x);
                                    return newAcc;
                                } else {
                                	return acc;
                                }
                             },
                             FilterUsingReduce::combineLists);
    }

    private static <I> List<I> combineLists(List<I> left, List<I> right) {
    	// We are copying left to new list to avoid mutating it. 
    	List<I> newLeft = new ArrayList<>(left);
    	newLeft.addAll(right);
        return newLeft;
    }

}
