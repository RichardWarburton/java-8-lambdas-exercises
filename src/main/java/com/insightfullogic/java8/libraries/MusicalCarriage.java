package com.insightfullogic.java8.libraries;

// BEGIN body
public class MusicalCarriage
        implements Carriage, Jukebox {

    @Override
    public String rock() {
        return Carriage.super.rock();
    }

}
// END body
