package com.insightfullogic.java8.examples.chapter4;

import com.insightfullogic.java8.examples.music.SampleData;
import org.junit.Test;

public class PrimitivesTest {

    @Test
    public void albumStatistics() {
        Primitives.printTrackLengthStatistics(SampleData.aLoveSupreme);
    }

}
