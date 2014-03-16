package com.insightfullogic.java8.examples.chapter8.command;

// BEGIN Open
public class Open implements Action {

    private final Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
// END Open
