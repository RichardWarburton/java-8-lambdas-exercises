package com.insightfullogic.java8.examples.chapter5;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.List;
import java.util.stream.Collectors;

public class StringExamples {

    public static String formatArtists(List<Artist> artists) {
        // BEGIN collectors_joining
String result =
    artists.stream()
              .map(Artist::getName)
              .collect(Collectors.joining(", ", "[", "]"));
        // END collectors_joining
        return result;
    }

    public static String formatArtistsForLoop(List<Artist> artists) {
        // BEGIN for_loop
StringBuilder builder = new StringBuilder("[");
for (Artist  artist : artists) {
    if (builder.length() > 1)
        builder.append(", ");

    String name = artist.getName();
    builder.append(name);
}
builder.append("]");
String result = builder.toString();
        // END for_loop
        return result;
    }

    public static String formatArtistsRefactor1(List<Artist> artists) {
        // BEGIN refactor_1
StringBuilder builder = new StringBuilder("[");
artists.stream()
       .map(Artist::getName)
       .forEach(name -> {
           if (builder.length() > 1)
               builder.append(", ");

           builder.append(name);
       });
builder.append("]");
String result = builder.toString();
        // END refactor_1
        return result;
    }

    public static String formatArtistsRefactor2(List<Artist> artists) {
        // BEGIN refactor_2
StringBuilder reduced =
    artists.stream()
           .map(Artist::getName)
           .reduce(new StringBuilder(), (builder, name) -> {
                   if (builder.length() > 0)
                       builder.append(", ");

                   builder.append(name);
                   return builder;
               }, (left, right) -> left.append(right));

reduced.insert(0, "[");
reduced.append("]");
String result = reduced.toString();
       // END refactor_2
       return result;
    }

    public static String formatArtistsRefactor3(List<Artist> artists) {
        // BEGIN refactor_3
StringCombiner combined =
        artists.stream()
               .map(Artist::getName)
               .reduce(new StringCombiner(", ", "[", "]"),
                       StringCombiner::add,
                       StringCombiner::merge);

String result = combined.toString();
        // END refactor_3
        return result;
    }

    public static String formatArtistsRefactor4(List<Artist> artists) {
        // BEGIN refactor_4
String result =
    artists.stream()
            .map(Artist::getName)
            .reduce(new StringCombiner(", ", "[", "]"),
                    StringCombiner::add,
                    StringCombiner::merge)
            .toString();
        // END refactor_4
        return result;
    }

    public static String formatArtistsRefactor5(List<Artist> artists) {
        // BEGIN refactor_5
String result =
    artists.stream()
           .map(Artist::getName)
           .collect(new StringCollector(", ", "[", "]"));
        // END refactor_5
        return result;
    }

    public static String formatArtistsReducing(List<Artist> artists) {
        // BEGIN reducing
String result =
        artists.stream()
                .map(Artist::getName)
                .collect(Collectors.reducing(
                    new StringCombiner(", ", "[", "]"),
                    name -> new StringCombiner(", ", "[", "]").add(name),
                    StringCombiner::merge))
                .toString();
        // END reducing
        return result;
    }

    /*.reduce(,
    ,
    StringCombiner::merge)
            .toString()*/

}
