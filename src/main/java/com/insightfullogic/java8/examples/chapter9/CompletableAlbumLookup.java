package com.insightfullogic.java8.examples.chapter9;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.Track;

import java.util.List;
import java.util.concurrent.*;

public class CompletableAlbumLookup implements AlbumLookup {

    private static final ExecutorService service = Executors.newFixedThreadPool(4);

    private final List<Track> tracks;
    private final List<Artist> artists;

    public CompletableAlbumLookup(List<Track> tracks, List<Artist> artists) {
        this.tracks = tracks;
        this.artists = artists;
    }

// BEGIN lookupByName
public Album lookupByName(String albumName) {
    CompletableFuture<List<Artist>> artistLookup
        = loginTo("artist")
         .thenCompose(artistLogin -> lookupArtists(albumName, artistLogin));  // <1>
         		 
    return loginTo("track")
          .thenCompose(trackLogin -> lookupTracks(albumName, trackLogin)) // <2>
          .thenCombine(artistLookup, (tracks, artists)
              -> new Album(albumName, tracks, artists)) // <3>
          .join(); // <4>
}
// END lookupByName

    // Variables Exists to satisfy code sample below
    private Track track;
    private Artist artist;

    // BEGIN lookupTrack
CompletableFuture<Track> lookupTrack(String id) {
    return CompletableFuture.supplyAsync(() -> {
        // Some expensive work is done here <1>
        // ...
        return track; // <2>
    }, service); // <3>
}
    // END lookupTrack

    // BEGIN createFuture
CompletableFuture<Artist> createFuture(String id) {
    CompletableFuture<Artist> future = new CompletableFuture<>();
    startJob(future);
    return future;
}
    // END createFuture

    private void startJob(CompletableFuture<Artist> future) {
        // BEGIN complete
future.complete(artist);
        // END complete
    }

    private void processExceptionally(CompletableFuture<Album> future, String name) {
        // BEGIN completeExceptionally
future.completeExceptionally(new AlbumLookupException("Unable to find " + name));
        // END completeExceptionally
    }

    // ----------------- FAKE LOOKUP METHODS -----------------
    //         Represent API lookup on external services

    private CompletableFuture<List<Artist>> lookupArtists(String albumName, Credentials credentials) {
        return CompletableFuture.completedFuture(artists);
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private CompletableFuture<List<Track>> lookupTracks(String albumName, Credentials credentials) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return tracks;
        }, service);
    }

    private CompletableFuture<Credentials> loginTo(String serviceName) {
        return CompletableFuture.supplyAsync(() -> {
            if ("artist".equals(serviceName)) {
                sleep(1000);
            }
            return new Credentials();
        }, service);
    }

}
