package com.insightfullogic.java8.answers.chapter9;

import com.insightfullogic.java8.answers.chapter9.BlockingArtistAnalyzer;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BlockingArtistAnalyzerTest {

    private final com.insightfullogic.java8.answers.chapter9.BlockingArtistAnalyzer analyser = new BlockingArtistAnalyzer(new FakeLookupService()::lookupArtistName);

    @Test
    public void largerGroupsAreLarger() {
        assertTrue(analyser.isLargerGroup("The Beatles", "John Coltrane"));
    }

    @Test
    public void smallerGroupsArentLarger() {
        assertFalse(analyser.isLargerGroup("John Coltrane", "The Beatles"));
    }

}
