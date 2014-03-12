package com.insightfullogic.java8.concurrency;

import com.insightfullogic.java8.music.Artist;
import com.insightfullogic.java8.music.SampleData;
import org.junit.Test;
import rx.Observable;
import rx.observables.BlockingObservable;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RxExamplesTest {

    @Test
    public void filtersAlbums() throws InterruptedException {
        RxExamples examples = new RxExamples(SampleData.getThreeArtists());
        Artist artist = examples.search("John", "UK", 5)
                                .toBlockingObservable()
                                .single();

        assertEquals(SampleData.johnLennon, artist);
    }

}
