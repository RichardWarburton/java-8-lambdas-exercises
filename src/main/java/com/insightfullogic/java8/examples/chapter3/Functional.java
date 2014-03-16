package com.insightfullogic.java8.examples.chapter3;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Functional {

    private JButton button = new JButton();

    // BEGIN field_assignment
    private ActionEvent lastEvent;

    private void registerHandler() {
        button.addActionListener((ActionEvent event) -> {
            this.lastEvent = event;
        });
    }
    // END field_assignment


}
