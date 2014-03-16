package com.insightfullogic.java8.exercises.chapter4;

import com.insightfullogic.java8.examples.music.Artist;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/** A Performance by some musicians - eg an Album or Gig. */
public interface PerformanceFixed {

    public String getName();

    public Stream<Artist> getMusicians();

    public default Stream<Artist> getAllMusicians() {
        return getMusicians()
              .flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }

}
