package com.insightfullogic.java8.answers.chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StringExercises {

    // Question 6
    public static int countLowercaseLetters(String string) {
        if (Objects.isNull(string)) return 0;
        return (int) string.chars()
                           .filter(Character::isLowerCase)
                           .count();
    }

    // Question 7
    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream()
                      .max(Comparator.comparingInt(StringExercises::countLowercaseLetters));
    }

}
