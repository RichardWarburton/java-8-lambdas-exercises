package com.insightfullogic.java8.examples.chapter8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.insightfullogic.java8.examples.chapter8.SingleResponsibilityPrinciple.*;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SingleResponsibilityPrincipleTest {

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{   {new ImperativeRefactoredPrimeCounter()},
                                            {new ImperativeSingleMethodPrimeCounter()},
                                            {new FunctionalPrimeCounter()},
                                            {new ParallelFunctionalPrimeCounter()}};
        return Arrays.asList(data);
    }

    private final PrimeCounter primeCounter;

    public SingleResponsibilityPrincipleTest(PrimeCounter primeCounter) {
        this.primeCounter = primeCounter;
    }

    @Test
    public void countsPrimesTo10() {
        assertEquals(5, primeCounter.countPrimes(10));
        assertEquals(9, primeCounter.countPrimes(20));
    }

    @Test
    public void countsPrimesTo20() {
        assertEquals(9, primeCounter.countPrimes(20));
    }

    @Test
    public void countsPrimesTo30() {
        assertEquals(11, primeCounter.countPrimes(30));
    }

}

