package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Supplier;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RefactorTest {

    @Test
    public void allStringJoins() {
        List<Supplier<Refactor.LongTrackFinder>> finders = Arrays.<Supplier<Refactor.LongTrackFinder>>asList(
            Refactor.Step0::new,
            Refactor.Step1::new,
            Refactor.Step2::new,
            Refactor.Step3::new,
            Refactor.Step4::new
        );

        List<Album> albums = unmodifiableList(asList(SampleData.aLoveSupreme, SampleData.sampleShortAlbum));
        List<Album> noTracks = unmodifiableList(asList(SampleData.sampleShortAlbum));

        finders.forEach(finder -> {
            System.out.println("Testing: " + finder.toString());

            Refactor.LongTrackFinder longTrackFinder = finder.get();
            Set<String> longTracks = longTrackFinder.findLongTracks(albums);

	    List<String> result = new ArrayList<String>(longTracks);
	    Collections.sort(result);

            assertEquals("[Acknowledgement, Resolution]", result.toString());

            longTracks = longTrackFinder.findLongTracks(noTracks);

            assertTrue(longTracks.isEmpty());
        });
    }

}
