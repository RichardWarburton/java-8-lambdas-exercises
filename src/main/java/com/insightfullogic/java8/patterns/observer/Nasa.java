package com.insightfullogic.java8.patterns.observer;

import java.util.Observable;
import java.util.Observer;

// BEGIN Nasa
public class Nasa implements LandingObserver {
    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("We made it!");
        }
    }
}
// END Nasa
