package com.insightfullogic.java8.examples.chapter5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCombinerTest {
    private StringCombiner combiner;

    @Before
    public void before() {
        this.combiner = new StringCombiner(", ", "[", "]");

        combiner.add("A").add("B").add("C").add("D");
    }

    @Test
    public void add() throws Exception {
        assertEquals("[A, B, C, D]", combiner.toString());
    }

    @Test
    public void mergeWithOther() throws Exception {
        StringCombiner other = new StringCombiner(", ", "[", "]");

        other.add("E").add("F").add("G");

        this.combiner.merge(other);

        assertEquals("[A, B, C, D, E, F, G]", this.combiner.toString());
    }

    @Test
    public void mergeWithEmpty() {
        this.combiner.merge(new StringCombiner(", ", "[", "]"));

        assertEquals("[A, B, C, D]", this.combiner.toString());
    }

    @Test
    public void mergeSelf() throws Exception {
        assertEquals("[A, B, C, D]", this.combiner.merge(this.combiner).toString());
    }

    @Test
    public void twiceCallToString() throws Exception {
        assertEquals("[A, B, C, D]", this.combiner.toString());
        assertEquals("[A, B, C, D]", this.combiner.toString());
    }
}