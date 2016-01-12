package com.insightfullogic.java8.exercises.chapter2;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class Question2Test {

    @Test
    public void exampleInB() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String formatted = Question2.formatter.get().getFormat().format(cal.getTime());
        assertEquals("01-Jan-1970", formatted);
    }

}
