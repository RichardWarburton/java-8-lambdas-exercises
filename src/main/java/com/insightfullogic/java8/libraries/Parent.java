package com.insightfullogic.java8.libraries;

// BEGIN body
public interface Parent {

    public void message(String body);

    public default void welcome() {
        message("Parent: Hi!");
    }

    public String getLastMessage();

}
// END body
