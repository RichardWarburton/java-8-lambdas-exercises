package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Track;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HigherOrderFunctionExamplesTest {

    @Test
    public void collectToList() {
        // BEGIN collect_to_list_1
List<String> collected = Stream.of("a", "b", "c") // <1>
                               .collect(Collectors.toList()); // <2>

assertEquals(Arrays.asList("a", "b", "c"), collected); // <3>
        // END collect_to_list_1
    }

    @Test
    public void mapToUpperCase() {
        // BEGIN map_to_uppercase
List<String> collected = Stream.of("a", "b", "hello")
                               .map(string -> string.toUpperCase()) // <1>
                               .collect(toList());

assertEquals(asList("A", "B", "HELLO"), collected);
        // END map_to_uppercase
    }

    @Test
    public void forToUpperCase() {
        // BEGIN for_to_uppercase
List<String> collected = new ArrayList<>();
for (String string : asList("a", "b", "hello")) {
    String uppercaseString = string.toUpperCase();
    collected.add(uppercaseString);
}

assertEquals(asList("A", "B", "HELLO"), collected);
        // END for_to_uppercase
    }

    @Test
    public void imperativeMaxLength() {
// BEGIN imperativeMaxLength
List<Track> tracks = asList(new Track("Bakai", 524),
                            new Track("Violets for Your Furs", 378),
                            new Track("Time Was", 451));

Track shortestTrack = tracks.get(0);
for (Track track : tracks) {
    if (track.getLength() < shortestTrack.getLength()) {
        shortestTrack = track;
    }
}

assertEquals(tracks.get(1), shortestTrack);
// END imperativeMaxLength
    }

    @Test
    public void streamsMaxLength() {
// BEGIN streamsMaxLength
List<Track> tracks = asList(new Track("Bakai", 524),
                            new Track("Violets for Your Furs", 378),
                            new Track("Time Was", 451));

Track shortestTrack = tracks.stream()
                            .min(Comparator.comparing(track -> track.getLength()))
                            .get();

assertEquals(tracks.get(1), shortestTrack);
// END streamsMaxLength
    }

    @Test
    public void streamsAnyMatch() {
// BEGIN streamsAnyMatch
List<Track> tracksOnColtrane = asList(new Track("Bakai", 524),
                                      new Track("Violets for Your Furs", 378),
                                      new Track("Time Was", 451));

boolean matchLength = tracksOnColtrane.stream()
                                      .anyMatch(track -> track.getLength() > 500);
assertTrue(matchLength);
// END streamsAnyMatch
    }

    @Test
    public void imperativeAnyMatch() {
// BEGIN imperativeAnyMatch
List<Track> tracksOnColtrane = asList(new Track("Bakai", 524),
                                      new Track("Violets for Your Furs", 378),
                                      new Track("Time Was", 451));

boolean matchLength = false;
for(Track track : tracksOnColtrane) {
    if (track.getLength() > 500) {
        matchLength = true;
    }
}

assertTrue(matchLength);
// END imperativeAnyMatch
    }
    
    @Test
    public void sumUsingReduce() {
        // BEGIN count_using_reduce
int count = Stream.of(1, 2, 3)
                  .reduce(0, (acc, element) -> acc + element);

assertEquals(6, count);
        // END count_using_reduce
    }

    @Test
    public void expandedReduce() {
        // BEGIN expanded_reduce
    BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
    int count = accumulator.apply(
                    accumulator.apply(
                        accumulator.apply(0, 1),
                    2),
                3);
        // END expanded_reduce

        assertEquals(6, count);
    }

    @Test
    public void countUsingReduceFor() {
        // BEGIN count_using_reduce_for
int acc = 0;
for (Integer element : asList(1, 2, 3)) {
    acc = acc + element;
}
assertEquals(6, acc);
        // END count_using_reduce_for
    }

    @Test
    public void functionalStringsWithNumbers() {
        // BEGIN strings_numbers_filter
List<String> beginningWithNumbers
  = Stream.of("a", "1abc", "abc1")
          .filter(value -> isDigit(value.charAt(0)))
          .collect(toList());

assertEquals(asList("1abc"), beginningWithNumbers);
        // END strings_numbers_filter
    }

    @Test
    public void imperativeStringsWithNumbers() {
        // BEGIN strings_numbers_for
List<String> beginningWithNumbers = new ArrayList<>();
for(String value : asList("a", "1abc", "abc1")) {
    if (isDigit(value.charAt(0))) {
        beginningWithNumbers.add(value);
    }
}

assertEquals(asList("1abc"), beginningWithNumbers);
        // END strings_numbers_for
    }

    @Test
    public void flatMapCharacters() {
        // BEGIN flatmap_characters
List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                               .flatMap(numbers -> numbers.stream())
                               .collect(toList());

assertEquals(asList(1, 2, 3, 4), together);
        // END flatmap_characters
    }

}

