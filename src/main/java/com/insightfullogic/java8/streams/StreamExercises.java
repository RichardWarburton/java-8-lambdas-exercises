package com.insightfullogic.java8.streams;

import com.insightfullogic.java8.music.Album;
import com.insightfullogic.java8.music.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamExercises {

    // Q3
    public static int countBandMembersExternal(List<Artist> artists) {
        // BEGIN COUNT_MEMBERS_EXTERNAL
    int totalMembers = 0;
    for (Artist artist : artists) {
        Stream<Artist> members = artist.getMembers();
        totalMembers += members.count();
    }
        // END COUNT_MEMBERS_EXTERNAL

        return totalMembers;
    }

    // Q3
    public static int countBandMembersInternal(List<Artist> artists) {
        // NB: readers haven't learnt about primitives yet, so can't use the sum() method
        return artists.stream()
                       .map(artist -> artist.getMembers().count())
                       .reduce(0L, Long::sum)
                       .intValue();
    }

    // Q1a
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, Integer::sum);
    }

    // Q1b
    public static List<String> formattedArtists(Stream<Artist> artists) {
        return artists.map(artist -> artist.getName() + ": " + artist.getNationality())
                      .collect(toList());
    }

    // Q1c
    public static List<Album> onlyEps(Stream<Album> albums) {
        return albums.filter(album -> album.getTracks().count() <= 3)
                     .collect(toList());
    }

    // map f = foldr ((:) . f) []
    // Advanced Exercise
    public static <T, R> List<R> map(Stream<T> stream, Function<T, R> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, value) -> {
            acc.add(mapper.apply(value));
            return acc;
        }, (left, right) -> {
            ArrayList<R> result = new ArrayList<>();
            result.addAll(left);
            result.addAll(right);
            return result;
        });
    }

}
