package com.insightfullogic.java8.concurrency;

import com.insightfullogic.java8.music.Album;

public interface AlbumLookup {
    Album lookupByName(String albumName);
}
