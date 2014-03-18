package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
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
        List<Integer> values = StreamExercises.map(Stream.of(1, 2, 3), x -> x + 1);
        assertEquals(Arrays.asList(2, 3, 4), values);
    }

}
