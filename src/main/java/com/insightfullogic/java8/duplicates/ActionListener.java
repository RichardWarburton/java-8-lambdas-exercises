package com.insightfullogic.java8.duplicates;

import java.awt.event.ActionEvent;
import java.util.EventListener;

// BEGIN body
public interface ActionListener extends EventListener {
    public void actionPerformed(ActionEvent event);
}
// END body
