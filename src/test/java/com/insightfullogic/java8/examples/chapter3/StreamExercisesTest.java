package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.SampleData;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.insightfullogic.java8.examples.chapter3.StreamExercises.*;
import static org.junit.Assert.assertEquals;

public class StreamExercisesTest {

    @Test
    public void external() {
        assertEquals(4, countBandMembersExternal(Arrays.asList(SampleData.johnColtrane, SampleData.theBeatles)));
    }



    @Test
    public void mapExample() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
		List<Integer> values = StreamExercises.map(stream, x -> x + 1);
        assertEquals(Arrays.asList(2, 3, 4), values);
    }

    @Test
    public void mapExampleParallel() {
        Stream<Integer> parallelStream = Stream.of(1, 2, 3).parallel();
		List<Integer> values = StreamExercises.map(parallelStream, x -> x + 1);
        assertEquals(Arrays.asList(2, 3, 4), values);
    }
    
}
