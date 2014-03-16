package com.insightfullogic.java8.examples.chapter5.mutable_custom;

public class AlbumSalesReport {

    public AlbumSalesReport() {

    }

    public AlbumSalesReport(AlbumSale album) {
        this();
        acknowledgeSale(album);
    }

    public void acknowledgeSale(AlbumSale album) {

    }

    public AlbumSalesReport merge(AlbumSalesReport right) {
        return null;
    }

}
