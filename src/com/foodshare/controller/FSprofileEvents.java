package com.foodshare.controller;

import java.awt.event.*;
import com.foodshare.view.FSprofileUI;

public class FSprofileEvents implements ActionListener {

    private FSprofileUI ui;

    public FSprofileEvents(FSprofileUI ui) {
        this.ui = ui;
        ui.backButton.addActionListener(this);

        ui.profileFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ui.profileFrame.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ui.backButton) {
            ui.profileFrame.dispose();
        }
    }
}
