package com.insightfullogic.java8.concurrency;

import com.insightfullogic.java8.duplicates.BiFunction;
import com.insightfullogic.java8.music.Album;
import com.insightfullogic.java8.music.Artist;
import com.insightfullogic.java8.music.SampleData;
import com.insightfullogic.java8.music.Track;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class AlbumLookupTest {

    interface AlbumLookupFactory extends BiFunction<List<Track>, List<Artist>, AlbumLookup> {

    }

    @Test
    public void albumLookedUp() {
        Album album = SampleData.aLoveSupreme;
        List<Track> trackList = album.getTrackList();
        List<Artist> musicianList = album.getMusicianList();

        AlbumLookupFactory completable = CompletableAlbumLookup::new;
        AlbumLookupFactory future = FutureAlbumLookup::new;

        Stream.of(completable, future)
              .forEach(factory -> {
 AlbumLookup lookup = factory.apply(trackList, musicianList);
                  System.out.println("Testing: " + lookup.getClass().getSimpleName());
                  Album result = lookup.lookupByName(album.getName());

                  assertEquals(trackList, result.getTrackList());
                  assertEquals(musicianList, result.getMusicianList());
              });
    }

}
