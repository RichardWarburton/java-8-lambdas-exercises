package com.insightfullogic.java8.exercises.chapter2;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Question2Test {

    @Test
    public void exampleInB() {
        String formatted = Question2.formatter.get().format(new Date(0));
        assertEquals("01-Jan-1970", formatted);
    }

}
