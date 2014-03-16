package com.insightfullogic.java8.examples.chapter7;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestingTest {

    // BEGIN to_uppercase
@Test
public void multipleWordsToUppercase() {
    List<String> input = Arrays.asList("a", "b", "hello");
    List<String> result = Testing.allToUpperCase(input);
    assertEquals(asList("A", "B", "HELLO"), result);
}
    // END to_uppercase

    // BEGIN twoLetterStringConvertedToUppercaseLambdas
@Test
public void twoLetterStringConvertedToUppercaseLambdas() {
    List<String> input = Arrays.asList("ab");
    List<String> result = Testing.elementFirstToUpperCaseLambdas(input);
    assertEquals(asList("Ab"), result);
}
    // END twoLetterStringConvertedToUppercaseLambdas

    // BEGIN twoLetterStringConvertedToUppercase
@Test
public void twoLetterStringConvertedToUppercase() {
    String input = "ab";
    String result = Testing.firstToUppercase(input);
    assertEquals("Ab", result);
}
    // END twoLetterStringConvertedToUppercase

    private List<Integer> otherList = Arrays.asList(1, 2, 3);

    @Test
    public void mockitoLambdas() {
        // BEGIN mockito_lambdas
List<String> list = mock(List.class);

when(list.size()).thenAnswer(inv -> otherList.size());

assertEquals(3, list.size());
        // END mockito_lambdas
    }

}
