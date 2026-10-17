package com.foodshare.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.foodshare.view.DonorLoginGUI;
import com.foodshare.view.NGOLoginGUI;
import com.foodshare.view.WelcomeGUI;

public class WelcomeEvent implements ActionListener {

    private WelcomeGUI gui;

    public WelcomeEvent(WelcomeGUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.donor) {
            gui.dispose();
            new DonorLoginGUI();
        } else if (e.getSource() == gui.ngo) {
            gui.dispose();
            new NGOLoginGUI();
        }
    }
}
