package com.insightfullogic.java8.examples.chapter9;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.Track;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAlbumLookup implements AlbumLookup {

    private static final ExecutorService service = Executors.newFixedThreadPool(2);

    private final List<Track> tracks;
    private final List<Artist> artists;

    public FutureAlbumLookup(List<Track> tracks, List<Artist> artists) {
        this.tracks = tracks;
        this.artists = artists;
    }

    // BEGIN lookupByName
@Override
public Album lookupByName(String albumName) {
    Future<Credentials> trackLogin = loginTo("track"); // <1>
    Future<Credentials> artistLogin = loginTo("artist");

    try {
        Future<List<Track>> tracks = lookupTracks(albumName, trackLogin.get()); // <2>
        Future<List<Artist>> artists = lookupArtists(albumName, artistLogin.get());

        return new Album(albumName, tracks.get(), artists.get()); // <3>
    } catch (InterruptedException | ExecutionException e) {
        throw new AlbumLookupException(e.getCause()); // <4>
    }
}
    // END lookupByName

    // ----------------- FAKE LOOKUP METHODS -----------------
    //         Represent API lookup on external services

    private Future<List<Artist>> lookupArtists(String albumName, Credentials credentials) {
        return service.submit(() -> {
            fakeWaitingForExternalWebService();
            return artists;
        });
    }

    private Future<List<Track>> lookupTracks(String albumName, Credentials credentials) {
        return service.submit(() -> {
            return tracks;
        });
    }

    private Future<Credentials> loginTo(String serviceName) {
        return service.submit(() -> {
            if ("track".equals(serviceName)) {
                fakeWaitingForExternalWebService();
            }
            return new Credentials();
        });
    }

    private void fakeWaitingForExternalWebService() throws InterruptedException {
        Thread.sleep(1000);
    }

}
