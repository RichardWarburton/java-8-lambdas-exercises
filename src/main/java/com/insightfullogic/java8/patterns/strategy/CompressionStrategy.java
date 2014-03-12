package com.insightfullogic.java8.patterns.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

// BEGIN CompressionStrategy
public interface CompressionStrategy {

    public OutputStream compress(OutputStream data) throws IOException;

}
// END CompressionStrategy
