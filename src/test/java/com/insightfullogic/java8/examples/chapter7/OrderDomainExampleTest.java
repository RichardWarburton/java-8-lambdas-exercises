package com.insightfullogic.java8.examples.chapter7;

import com.insightfullogic.java8.examples.chapter4.OrderDomain;
import com.insightfullogic.java8.examples.chapter1.Album;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

/**
 * Sample code for chapter7 OrderDomain from the
 * previous chapter.
 */
public class OrderDomainExampleTest {

    // BEGIN can_count_albums
    @Test
    public void canCountFeatures() {
        OrderDomain order = new OrderDomain(asList(
                newAlbum("Exile on Main St."),
                newAlbum("Beggars Banquet"),
                newAlbum("Aftermath"),
                newAlbum("Let it Bleed")));

        assertEquals(8, order.countFeature(album -> 2));
    }
    // END can_count_albums

    private Album newAlbum(String name) {
        return new Album(name, emptyList(), emptyList());
    }

}
