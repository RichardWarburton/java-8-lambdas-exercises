package com.insightfullogic.java8.answers.chapter5;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import com.insightfullogic.java8.answers.chapter5.LongestName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestNameTest {

    @Test
    public void findsLongestNameByReduce() {
        Artist artist = com.insightfullogic.java8.answers.chapter5.LongestName.byReduce(SampleData.getThreeArtists());
        assertEquals(SampleData.johnColtrane, artist);
    }

    @Test
    public void findsLongestNameByCollecting() {
        Artist artist = LongestName.byCollecting(SampleData.getThreeArtists());
        assertEquals(SampleData.johnColtrane, artist);
    }

}
