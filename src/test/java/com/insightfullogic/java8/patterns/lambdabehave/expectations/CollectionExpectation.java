package com.insightfullogic.java8.patterns.lambdabehave.expectations;

import junit.framework.Assert;

import java.util.Collection;

import static junit.framework.Assert.assertTrue;

public class CollectionExpectation extends BoundExpectation {

    private final Collection<?> objectUnderTest;

    public CollectionExpectation(Collection<?> objectUnderTest) {
        super(objectUnderTest);
        this.objectUnderTest = objectUnderTest;
    }

    public void isEmpty() {
        assertTrue(objectUnderTest.isEmpty());
    }

}
