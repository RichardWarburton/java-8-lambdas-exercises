package com.insightfullogic.java8.examples.chapter8.command;

import java.util.ArrayList;
import java.util.List;

// BEGIN Macro
public class Macro {

    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Action::perform);
    }

}
// END Macro
