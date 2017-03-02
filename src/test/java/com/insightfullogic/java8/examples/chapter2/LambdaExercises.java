package com.insightfullogic.java8.examples.chapter2;

import org.junit.Test;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class LambdaExercises {

    @Test
    public void _1a() {
        assertTrue("Shown in the next chapter", true);
    }

    @Test
    public void _1b() {
        // If you were to model each operation on a calculator as a function.
        Function<Double, Double> negate = (x) -> -1 * x;
        Function<Double, Double> square = (x) -> x * x;
        Function<Double, Double> percent = (x) -> 100 * x;
    }

    @Test
    public void _1c() {
        Function<Integer, Integer> one = x -> x + 1;
        // 2 isn't
        Function<Integer, Boolean> three = x -> x == 1;
    }

    @Test
    public void _2a() {
        assertTrue("ThreadLocal.withInitial", true);
    }

    @Test
    public void _2b() {
        ThreadLocal<DateFormat> threadSafeFormatter = ThreadLocal.withInitial(() -> DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK));
        DateFormat formatter = threadSafeFormatter.get();
        assertEquals("01-Jan-1970", formatter.format(new Date(0)));
    }

    @Test
    public void _3a() {
        // yes
        Runnable helloWorld = () -> System.out.println("hello world");
    }

    @Test
    public void _3b() {
        // Yes
        JButton button = new JButton();
        button.addActionListener(event -> System.out.println(event.getActionCommand()));
    }

    @Test
    public void _3c() {
        // No
        // check(x -> x > 5);
    }

    private boolean check(Predicate<Integer> predicate) {
        System.out.println("wat?");
        return true;
    }

    interface IntPred {
        boolean test(Integer value);
    }

    private boolean check(IntPred predicate) {
        return true;
    }

}
