package com.insightfullogic.java8.answers.chapter3;

import com.insightfullogic.java8.answers.chapter3.StringExercises;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StringExercisesTest {

    @Test
    public void noLowercaseLettersInAnEmptyString() {
        assertEquals(0, com.insightfullogic.java8.answers.chapter3.StringExercises.countLowercaseLetters(""));
    }

    @Test
    public void countsLowercaseLetterExample() {
        assertEquals(3, com.insightfullogic.java8.answers.chapter3.StringExercises.countLowercaseLetters("aBcDeF"));
    }

    @Test
    public void suppoertsNoLowercaseLetters() {
        assertEquals(0, com.insightfullogic.java8.answers.chapter3.StringExercises.countLowercaseLetters("ABCDEF"));
    }

    @Test
    public void noStringReturnedForEmptyList() {
        assertFalse(com.insightfullogic.java8.answers.chapter3.StringExercises.mostLowercaseString(Collections.<String>emptyList()).isPresent());
    }

    @Test
    public void findsMostLowercaseString() {
        Optional<String> result = StringExercises.mostLowercaseString(Arrays.asList("a", "abc", "ABCde"));
        assertEquals(Optional.of("abc"), result);
    }

}
