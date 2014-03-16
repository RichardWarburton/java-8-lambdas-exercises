package com.insightfullogic.java8.examples.chapter4;

// BEGIN body
public interface Parent {

    public void message(String body);

    public default void welcome() {
        message("Parent: Hi!");
    }

    public String getLastMessage();

}
// END body
