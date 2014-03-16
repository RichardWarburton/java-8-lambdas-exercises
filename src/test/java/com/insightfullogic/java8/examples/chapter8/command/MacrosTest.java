package com.insightfullogic.java8.examples.chapter8.command;

import org.junit.Test;

public class MacrosTest {

    @Test
    public void classBasedCommand() {
        MockEditor editor = new MockEditor();

// BEGIN classBasedCommand
Macro macro = new Macro();
macro.record(new Open(editor));
macro.record(new Save(editor));
macro.record(new Close(editor));
macro.run();
// END classBasedCommand

        editor.check();
    }

    @Test
    public void lambdaBasedCommand() {
        MockEditor editor = new MockEditor();

// BEGIN lambdaBasedCommand
Macro macro = new Macro();
macro.record(() -> editor.open());
macro.record(() -> editor.save());
macro.record(() -> editor.close());
macro.run();
// END lambdaBasedCommand

        editor.check();
    }

    @Test
    public void referenceBasedCommand() {
        MockEditor editor = new MockEditor();

// BEGIN referenceBasedCommand
Macro macro = new Macro();
macro.record(editor::open);
macro.record(editor::save);
macro.record(editor::close);
macro.run();
// END referenceBasedCommand

        editor.check();
    }

}
