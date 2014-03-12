package com.insightfullogic.java8.exercises.chapter9;

import com.insightfullogic.java8.music.Artist;
import com.insightfullogic.java8.music.SampleData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BlockingArtistAnalyzerTest {

    private final BlockingArtistAnalyzer analyser = new BlockingArtistAnalyzer(new FakeLookupService()::lookupArtistName);

    @Test
    public void largerGroupsAreLarger() {
        assertTrue(analyser.isLargerGroup("The Beatles", "John Coltrane"));
    }

    @Test
    public void smallerGroupsArentLarger() {
        assertFalse(analyser.isLargerGroup("John Coltrane", "The Beatles"));
    }

}
