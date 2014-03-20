package com.insightfullogic.java8.answers.chapter5;

import com.insightfullogic.java8.answers.chapter5.GroupingBy;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GroupingByTest {

    @Test
    public void stringsByLength() {
        com.insightfullogic.java8.answers.chapter5.GroupingBy<String, Integer> stringIntegerGroupingBy = new GroupingBy<>(String::length);
        Map<Integer,List<String>> results = Stream.of("a", "b", "cc", "dd")
                                                  .collect(stringIntegerGroupingBy);

        System.out.println(results);

        assertEquals(2, results.size());
        assertEquals(asList("a", "b"), results.get(1));
        assertEquals(asList("cc", "dd"), results.get(2));
    }

}
