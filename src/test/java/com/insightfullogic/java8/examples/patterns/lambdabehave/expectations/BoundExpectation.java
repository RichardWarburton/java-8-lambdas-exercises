package com.insightfullogic.java8.examples.patterns.lambdabehave.expectations;

import static org.junit.Assert.assertEquals;

public class BoundExpectation {

    private final Object objectUnderTest;

    public BoundExpectation(Object value) {
        this.objectUnderTest = value;
    }
    
    public void isEqualTo(Object expected) {
        assertEquals(expected, objectUnderTest);
    }

}
