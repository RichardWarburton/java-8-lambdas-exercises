package com.insightfullogic.java8.libraries;

// BEGIN body
public class OverridingParent extends ParentImpl {

    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }

}
// END body
