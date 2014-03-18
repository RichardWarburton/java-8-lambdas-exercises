package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Refactor {

    public static interface LongTrackFinder {
        public Set<String> findLongTracks(List<Album> albums);
    }

    public static class Step0 implements LongTrackFinder {
// BEGIN findLongTracks_0
public Set<String> findLongTracks(List<Album> albums) {
    Set<String> trackNames = new HashSet<>();
    for(Album album : albums) {
        for (Track track : album.getTrackList()) {
            if (track.getLength() > 60) {
                String name = track.getName();
                trackNames.add(name);
            }
        }
    }
    return trackNames;
}
// END findLongTracks_0
    }

    public static class Step1 implements LongTrackFinder {
// BEGIN findLongTracks_1
public Set<String> findLongTracks(List<Album> albums) {
    Set<String> trackNames = new HashSet<>();
    albums.stream()
          .forEach(album -> {
              album.getTracks()
                   .forEach(track -> {
                       if (track.getLength() > 60) {
                           String name = track.getName();
                           trackNames.add(name);
                       }
                   });
          });
    return trackNames;
}
// END findLongTracks_1
    }

    public static class Step2 implements LongTrackFinder {
// BEGIN findLongTracks_2
public Set<String> findLongTracks(List<Album> albums) {
    Set<String> trackNames = new HashSet<>();
    albums.stream()
          .forEach(album -> {
              album.getTracks()
                   .filter(track -> track.getLength() > 60)
                   .map(track -> track.getName())
                   .forEach(name -> trackNames.add(name));
          });
    return trackNames;
}
// END findLongTracks_2
    }

    public static class Step3 implements LongTrackFinder {
// BEGIN findLongTracks_3
public Set<String> findLongTracks(List<Album> albums) {
    Set<String> trackNames = new HashSet<>();

    albums.stream()
          .flatMap(album -> album.getTracks())
          .filter(track -> track.getLength() > 60)
          .map(track -> track.getName())
          .forEach(name -> trackNames.add(name));

    return trackNames;
}
// END findLongTracks_3
    }

    public static class Step4 implements LongTrackFinder {
// BEGIN findLongTracks_4
public Set<String> findLongTracks(List<Album> albums) {
    return albums.stream()
                 .flatMap(album -> album.getTracks())
                 .filter(track -> track.getLength() > 60)
                 .map(track -> track.getName())
                 .collect(toSet());
}
// END findLongTracks_4
    }

}
