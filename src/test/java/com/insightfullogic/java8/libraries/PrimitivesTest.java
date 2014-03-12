package com.insightfullogic.java8.libraries;

import com.insightfullogic.java8.music.SampleData;
import org.junit.Test;

import java.util.IntSummaryStatistics;

public class PrimitivesTest {

    @Test
    public void albumStatistics() {
        Primitives.printTrackLengthStatistics(SampleData.aLoveSupreme);
    }

}
