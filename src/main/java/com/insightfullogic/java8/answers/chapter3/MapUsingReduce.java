package com.insightfullogic.java8.answers.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 1
 */
public class MapUsingReduce {

    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<O>(), (acc, x) -> {
        	// We are copying data from acc to new list instance. It is very inefficient,
        	// but contract of Stream.reduce method requires that accumulator function does
        	// not mutate its arguments.
        	// Stream.collect method could be used to implement more efficient mutable reduction,
        	// but this exercise asks to use reduce method.
        	List<O> newAcc = new ArrayList<>(acc);
        	newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
        	// We are copying left to new list to avoid mutating it. 
        	List<O> newLeft = new ArrayList<>(left);
        	newLeft.addAll(right);
            return newLeft;
        });
    }
    /**
     * This method solves advanced exercise 1, but returning a stream instead of a list
     * @param stream
     * @param mapper
     * @param <T>
     * @param <R>
     * @return
     */    
     public static <T, R> Stream<R> mapToStream(Stream<T> stream, Function<? super T, ? extends R> mapper) {

        Spliterator<T> iterT = stream.spliterator();
        Spliterator<R> iter = new Spliterators.AbstractSpliterator<R>(iterT.estimateSize(), Spliterator.ORDERED) {
            @Override
            public boolean tryAdvance(Consumer<? super R> action) {
                return iterT.tryAdvance(r -> action.accept(mapper.apply(r)));

            }
        };
        return StreamSupport.stream(iter, false);
    }
    
    

}
