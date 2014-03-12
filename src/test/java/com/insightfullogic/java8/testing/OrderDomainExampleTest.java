package com.insightfullogic.java8.testing;

import com.insightfullogic.java8.libraries.OrderDomain;
import com.insightfullogic.java8.music.Album;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Sample code for testing OrderDomain from the
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
