package com.insightfullogic.java8.examples.chapter4;


import com.insightfullogic.java8.examples.chapter1.Album;

import java.util.List;

public class OrderStreams extends Order {

    public OrderStreams(List<Album> albums) {
        super(albums);
    }

    // BEGIN body
public long countRunningTime() {
    return albums.stream()
            .mapToLong(album -> album.getTracks()
                                     .mapToLong(track -> track.getLength())
                                     .sum())
            .sum();
}

public long countMusicians() {
    return albums.stream()
            .mapToLong(album -> album.getMusicians().count())
            .sum();
}

public long countTracks() {
    return albums.stream()
            .mapToLong(album -> album.getTracks().count())
            .sum();
}
    // END body

}
