package com.insightfullogic.java8.codepad;

import java.time.LocalDateTime;
import java.util.Date;

public class CodePad {

    public static void main(String[] args) {
        /*Function<Album, String> getter = Album::getName;
        System.out.println(getter.getClass().getCanonicalName());
        System.out.println(ArrayExamples.asList(getter.getClass().getAnnotations()));
        System.out.println(getter.getClass().getSimpleName());*/
        //ToIntFunction<String> lengthOfString = String::length;
        //Comparator<String> comparator = comparing(String::length);

//        List<String> sorted = Stream.of("a", "aa", "aaa")
//                                    .sorted(comparator)
//                                    .collect(Collectors.toList());
//        System.out.println(sorted);

        /*Stream.of(Month.values())
              .map(month -> LocalDate.now()
                                     .with(month)
                                     .with(lastDayOfMonth()))
              .forEach(date -> System.out.println(date.getDayOfWeek()));*/

        //Date date = new Date();
        //date.toInstant();


        System.out.println(new Date());
        // System.out.println(LocalDate.from(new Date().toInstant()));
        System.out.println(LocalDateTime.from(new Date().toInstant()));
    }


}
