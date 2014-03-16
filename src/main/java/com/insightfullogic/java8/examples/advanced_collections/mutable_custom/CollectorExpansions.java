package com.insightfullogic.java8.examples.advanced_collections.mutable_custom;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorExpansions {

    public static final Collector<AlbumSale, ?, AlbumSalesReport>
            reportingAlbumSales() {
        return Collectors.reducing(new AlbumSalesReport(), album -> new AlbumSalesReport(album), (left, right) -> left.merge(right));
    }

}
