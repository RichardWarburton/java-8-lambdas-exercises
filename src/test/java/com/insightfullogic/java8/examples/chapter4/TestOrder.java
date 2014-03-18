package com.insightfullogic.java8.examples.chapter4;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import com.insightfullogic.java8.examples.chapter1.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestOrder {

    private final OrderFactory factory;

    private Order order;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { of(OrderImperative::new), of(OrderStreams::new), of(OrderDomain::new) };
        return asList(data);
    }

    private static interface OrderFactory extends Function<List<Album>, Order> {}

    private static Object[] of(OrderFactory factory) {
        return new Object[] { factory };
    }

    public TestOrder(OrderFactory factory) {
        this.factory = factory;
    }

    @Before
    public void initOrder() {
        List<Track> tracks = asList(new Track("Acknowledgement", 467), new Track("Resolution", 442));
        Album aLoveSupreme = new Album("A Love Supreme", tracks, asList(SampleData.johnColtrane));
        order = factory.apply(asList(aLoveSupreme));
    }

    @Test
    public void countsRunningTime() {
        assertEquals(909, order.countRunningTime());
    }

    @Test
    public void countsArtists() {
        assertEquals(1, order.countMusicians());
    }

    @Test
    public void countsTracks() {
        assertEquals(2, order.countTracks());
    }

}
