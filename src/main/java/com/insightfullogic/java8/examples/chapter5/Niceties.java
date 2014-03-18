package com.insightfullogic.java8.examples.chapter5;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Niceties {

    abstract class ArtistService {

        protected Map<String, Artist> artistCache = new HashMap<>();

        public abstract Artist getArtist(String name);

        protected Artist readArtistFromDB(String name) {
            return new Artist(name, "UK");
        }
    }

    class OldArtistService extends ArtistService {
        // BEGIN ARTIST_CACHE_OLD
public Artist getArtist(String name) {
    Artist artist = artistCache.get(name);
    if (artist == null) {
        artist = readArtistFromDB(name);
        artistCache.put(name, artist);
    }
    return artist;
}
        // END ARTIST_CACHE_OLD
    }

    class Java8ArtistService extends ArtistService {
        // BEGIN ARTIST_CACHE_COMPUTE
public Artist getArtist(String name) {
    return artistCache.computeIfAbsent(name, this::readArtistFromDB);
}
        // END ARTIST_CACHE_COMPUTE
    }


    class ImperativeCount {

        public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> albumsByArtist) {
            // BEGIN COUNT_ALBUMS_VALUES_UGLY
Map<Artist, Integer>  countOfAlbums = new HashMap<>();
for(Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
    Artist artist = entry.getKey();
    List<Album> albums = entry.getValue();
    countOfAlbums.put(artist, albums.size());
}
            // END COUNT_ALBUMS_VALUES_UGLY
            return countOfAlbums;
        }
    }

    class Java8Count {
        public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> albumsByArtist) {
            // BEGIN COUNT_ALBUMS_VALUES_FOREACH
Map<Artist, Integer>  countOfAlbums = new HashMap<>();
albumsByArtist.forEach((artist, albums) -> {
    countOfAlbums.put(artist, albums.size());
});
            // END COUNT_ALBUMS_VALUES_FOREACH
            return countOfAlbums;
        }
    }


}
