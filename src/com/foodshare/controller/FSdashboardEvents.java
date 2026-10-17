package com.foodshare.controller;

import java.awt.event.*;
import com.foodshare.view.*;
import com.foodshare.model.UserSession;

public class FSdashboardEvents implements ActionListener {

    private FSdashboardUI ui;

    public FSdashboardEvents(FSdashboardUI ui) {
        this.ui = ui;

        ui.donateFood.addActionListener(this);
        ui.availableFood.addActionListener(this);
        ui.myActivity.addActionListener(this);
        ui.profile.addActionListener(this);
        ui.logout.addActionListener(this);

        ui.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ui.frame.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ui.donateFood) {
            if ("NGO".equalsIgnoreCase(UserSession.getInstance().getRole())) new MyClaimsGUI();
            else new DonateFoodGUI();
        } else if (e.getSource() == ui.availableFood) {
            if ("Donor".equalsIgnoreCase(UserSession.getInstance().getRole())) {
                // Donors can inspect the live feed, but only NGOs can claim.
            }
            // Open full Available Food Feed Screen
            new AvailableFoodGUI();
        } else if (e.getSource() == ui.myActivity) {
            // Open full Activity Logs Screen
            new MyActivityGUI();
        } else if (e.getSource() == ui.profile) {
            // Open full Profile Screen
            FSprofileUI profileUI = new FSprofileUI();
            profileUI.createProfileUI();
            new FSprofileEvents(profileUI);
        } else if (e.getSource() == ui.logout) {
            ui.frame.dispose();
            UserSession.getInstance().clear();
            System.out.println("User logged out");
            new WelcomeGUI();
        }
    }
}
