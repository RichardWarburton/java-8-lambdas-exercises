package com.insightfullogic.java8.performance;

import java.util.stream.IntStream;

import static java.lang.System.currentTimeMillis;

public class TwinsExample {

    public static void main(String[] args) {
        // compare(10);
        // compare(10000);
        compare(100000);
        // 17985
        // 200000
    }

    private static void compare(int upTo) {
        long time = currentTimeMillis();
        System.out.println(new Imperative().countPrimes(upTo));
        System.out.println(currentTimeMillis() - time);
        time = currentTimeMillis();
        System.out.println(new Imperative2().countPrimes(upTo));
        System.out.println(currentTimeMillis() - time);
        time = currentTimeMillis();
        System.out.println(new Functional().countPrimes(upTo));
        System.out.println(currentTimeMillis() - time);
        time = currentTimeMillis();
    }

    static class Imperative {
        int countPrimes(int upTo) {
            int tally = 0;
            for (int i = 1; i < upTo; i++) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                    }
                }
                if (isPrime) {
                    tally++;
                }
            }
            return tally;
        }
    }

    static class Imperative2 {
        int countPrimes(int upTo) {
            int tally = 0;
            for (int i = 1; i < upTo; i++) {
                if (isPrime(i)) {
                    tally++;
                }
            }
            return tally;
        }

        private boolean isPrime(int number) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Functional {
        long countPrimes(int upTo) {
            return IntStream.range(1, upTo)
                            .parallel()
                            .filter(this::isPrime)
                            .count();
        }

        private boolean isPrime(int number) {
            return IntStream.range(2, number)
                            .allMatch(x -> (number % x) != 0);
        }
    }

}
