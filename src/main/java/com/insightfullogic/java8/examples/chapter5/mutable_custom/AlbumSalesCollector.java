package com.insightfullogic.java8.examples.chapter5.mutable_custom;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class AlbumSalesCollector implements Collector<AlbumSale, AlbumSalesReport, AlbumSalesReport> {

    private static final Set<Characteristics> characteristics = new HashSet<>();
    static {
        characteristics.add(Characteristics.UNORDERED);
        characteristics.add(Characteristics.IDENTITY_FINISH);
    }

    @Override
    public Supplier<AlbumSalesReport> supplier() {
        return AlbumSalesReport::new;
    }

    @Override
    public BiConsumer<AlbumSalesReport, AlbumSale> accumulator() {
        return (report, album) -> report.acknowledgeSale(album);
    }

    @Override
    public BinaryOperator<AlbumSalesReport> combiner() {
        return (left, right) -> left.merge(right);
    }

    @Override
    public Function<AlbumSalesReport, AlbumSalesReport> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

}
