package com.insightfullogic.java8.answers.chapter6;

import com.insightfullogic.java8.answers.chapter6.SerialToParallel;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SerialToParallelTest {

    @Test
    public void testSerialToParallel() {
        IntStream range = IntStream.range(0, 100);
        assertEquals(328350, SerialToParallel.sumOfSquares(range));
    }

}
