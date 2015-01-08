package com.insightfullogic.java8.exercises.chapter4;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ArtistsTest {

    private final Artists optionalExamples = new Artists(SampleData.getThreeArtists());

    @Test
    public void indexWithinRange() {
        Artist artist = optionalExamples.getArtist(0);
        assertNotNull(artist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void indexOutsideRange() {
        optionalExamples.getArtist(4);
    }

    @Test
    public void nameIndexInsideRange() {
        String artist = optionalExamples.getArtistName(0);
        Assert.assertEquals("John Coltrane", artist);
    }

    @Test
    public void nameIndexOutsideRange() {
        String artist = optionalExamples.getArtistName(4);
        assertEquals("unknown", artist);
    }

}
