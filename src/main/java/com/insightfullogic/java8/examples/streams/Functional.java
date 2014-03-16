package com.insightfullogic.java8.examples.streams;

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
