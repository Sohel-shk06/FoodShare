package com.foodshare.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.foodshare.view.MyActivityGUI;

public class MyActivityEvent implements ActionListener {

    private MyActivityGUI gui;

    public MyActivityEvent(MyActivityGUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.closeButton) {
            gui.dispose();
        }
    }
}
