package com.insightfullogic.java8.examples.patterns.strategy;

import java.io.IOException;
import java.io.OutputStream;

// BEGIN CompressionStrategy
public interface CompressionStrategy {

    public OutputStream compress(OutputStream data) throws IOException;

}
// END CompressionStrategy
