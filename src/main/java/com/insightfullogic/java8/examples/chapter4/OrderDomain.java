package com.insightfullogic.java8.examples.chapter4;


import com.insightfullogic.java8.examples.chapter1.Album;

import java.util.List;
import java.util.function.ToLongFunction;

public class OrderDomain extends Order {

    public OrderDomain(List<Album> albums) {
        super(albums);
    }

// BEGIN body
public long countFeature(ToLongFunction<Album> function) {
    return albums.stream()
            .mapToLong(function)
            .sum();
}

public long countTracks() {
    return countFeature(album -> album.getTracks().count());
}

public long countRunningTime() {
    return countFeature(album -> album.getTracks()
                                      .mapToLong(track -> track.getLength())
                                      .sum());
}

public long countMusicians() {
    return countFeature(album -> album.getMusicians().count());
}
// END body

}
