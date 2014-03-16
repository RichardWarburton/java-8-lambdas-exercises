package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.music.Album;
import com.insightfullogic.java8.examples.music.SampleData;
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
    public void internal() {
        assertEquals(4, countBandMembersInternal(Arrays.asList(SampleData.johnColtrane, SampleData.theBeatles)));
    }

    @Test
    public void addsUpExample() {
        assertEquals(6, addUp(Stream.of(1, 2, 3)));
    }

    @Test
    public void formattingExample() {
        List<String> formatted = formattedArtists(SampleData.threeArtists());
        assertEquals("John Coltrane: US", formatted.get(0));
    }

    @Test
    public void epsExample() {
        List<Album> eps = StreamExercises.onlyEps(SampleData.albums);
        assertEquals(1, eps.size());
    }

    @Test
    public void mapExample() {
        List<Integer> values = StreamExercises.map(Stream.of(1, 2, 3), x -> x + 1);
        assertEquals(Arrays.asList(2, 3, 4), values);
    }

}
