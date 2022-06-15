package com.insightfullogic.java8.answers.chapter2;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Question2Test {

    @Test
    public void exampleInB() {
        assertEquals("15-Jun-2022", Question2.getFormat().get().format(new Date()));
    }

}
