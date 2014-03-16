package com.insightfullogic.java8.examples.chapter5;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EncounterOrderTest {

    @Test
    public void listToStream() {
        // BEGIN LIST_TO_STREAM
    List<Integer> numbers = asList(1, 2, 3, 4);

    List<Integer> sameOrder = numbers.stream()
                                     .collect(toList());
    assertEquals(numbers, sameOrder);
        // END LIST_TO_STREAM
    }

    // NB: to actually get this to fail you need to reverse the order of the numbers.
    @Ignore
    @Test
    public void hashSetToStream() {
        // BEGIN HASHSET_TO_STREAM
    Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));

    List<Integer> sameOrder = numbers.stream()
                                     .collect(toList());

    // This may not pass
    assertEquals(asList(4, 3, 2, 1), sameOrder);
        // END HASHSET_TO_STREAM
    }

    @Test
    public void hashSetToStreamSorted() {
        // BEGIN HASHSET_TO_STREAM_SORTED
    Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));

    List<Integer> sameOrder = numbers.stream()
                                     .sorted()
                                     .collect(toList());

    assertEquals(asList(1, 2, 3, 4), sameOrder);
        // END HASHSET_TO_STREAM_SORTED
    }

    @Test
    public void toStreamMapped() {
        // BEGIN TO_STREAM_MAPPED
    List<Integer> numbers = asList(1, 2, 3, 4);

    List<Integer> stillOrdered = numbers.stream()
                                        .map(x -> x + 1)
                                        .collect(toList());

    // Reliable encounter ordering
    assertEquals(asList(2, 3, 4, 5), stillOrdered);

    Set<Integer> unordered = new HashSet<>(numbers);

    List<Integer> stillUnordered = unordered.stream()
                                            .map(x -> x + 1)
                                            .collect(toList());

    // Can't assume encounter ordering
    assertThat(stillUnordered, hasItem(2));
    assertThat(stillUnordered, hasItem(3));
    assertThat(stillUnordered, hasItem(4));
    assertThat(stillUnordered, hasItem(5));
        // END TO_STREAM_MAPPED
    }

}
