package com.insightfullogic.java8.examples.concurrency;

import com.insightfullogic.java8.examples.music.Album;

public interface AlbumLookup {
    Album lookupByName(String albumName);
}
