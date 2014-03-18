package com.insightfullogic.java8.exercises.chapter9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ArtistAnalyzerTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        FakeLookupService lookupService = new FakeLookupService();
        Object[][] data = new Object[][] {
            { new CallbackArtistAnalyser(lookupService::lookupArtistName) },
            { new CompletableFutureArtistAnalyser(lookupService::lookupArtistName) },
        };
        return Arrays.asList(data);
    }

    private final ArtistAnalyzer analyser;

    public ArtistAnalyzerTest(ArtistAnalyzer analyser) {
        this.analyser = analyser;
    }

    @Test
    public void largerGroupsAreLarger() {
        assertLargerGroup(true, "The Beatles", "John Coltrane");
    }

    @Test
    public void smallerGroupsArentLarger() {
        assertLargerGroup(false, "John Coltrane", "The Beatles");
    }

    private void assertLargerGroup(boolean expected, String artistName, String otherArtistName) {
        AtomicBoolean isLarger = new AtomicBoolean(!expected);
        analyser.isLargerGroup(artistName, otherArtistName, isLarger::set);
        assertEquals(expected, isLarger.get());
    }

}
