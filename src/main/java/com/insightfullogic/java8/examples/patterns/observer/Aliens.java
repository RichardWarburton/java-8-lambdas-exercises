package com.insightfullogic.java8.examples.patterns.observer;

// BEGIN Aliens
public class Aliens implements LandingObserver {

    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("They're distracted, lets invade earth!");
        }
    }

}
// END Aliens
