package com.insightfullogic.java8.exercises.chapter4;

import com.insightfullogic.java8.music.Artist;
import com.insightfullogic.java8.music.SampleData;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class PerformanceTest {

    @Test
    public void findsAllTheBeatles() {
        PerformanceFixed stub = new PerformanceFixed() {
            @Override
            public String getName() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Stream<Artist> getMusicians() {
                return Stream.of(SampleData.theBeatles);
            }
        };

        List<Artist> allMusicians = stub.getAllMusicians().collect(toList());
        assertThat(allMusicians, hasItem(SampleData.theBeatles));
        // There really must be a better way than this
        assertThat(allMusicians, hasItems(SampleData.membersOfTheBeatles.toArray(new Artist[0])));
    }

}
