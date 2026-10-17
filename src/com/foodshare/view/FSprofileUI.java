package com.foodshare.view;

import java.awt.*;
import com.foodshare.model.UserSession;

public class FSprofileUI {

    public Frame profileFrame;
    public Button backButton;

    public void createProfileUI() {
        profileFrame = new Frame("FoodShare - My Profile");
        profileFrame.setSize(600, 500);
        profileFrame.setBackground(new Color(250, 248, 235));
        profileFrame.setLayout(new BorderLayout(15, 15));

        UserSession user = UserSession.getInstance();

        Label title = new Label("MY PROFILE", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(new Color(32, 82, 55));
        profileFrame.add(title, BorderLayout.NORTH);

        Panel centerPanel = new Panel(new GridLayout(2, 1, 10, 10));

        // Top Badge
        Panel donorPanel = new Panel(new GridLayout(3, 1, 5, 5));
        donorPanel.setBackground(new Color(250, 248, 235));

        Label sym = new Label("★", Label.CENTER);
        sym.setFont(new Font("Dialog", Font.BOLD, 40));
        sym.setForeground(new Color(220, 50, 50));

        Label kindDonor = new Label(user.getRole().equalsIgnoreCase("NGO") ? "VERIFIED NGO" : "KIND DONOR", Label.CENTER);
        kindDonor.setFont(new Font("Arial", Font.BOLD, 20));
        kindDonor.setForeground(new Color(32, 82, 55));

        Label userType = new Label("Active Database Member", Label.CENTER);
        userType.setFont(new Font("Arial", Font.PLAIN, 15));

        donorPanel.add(sym);
        donorPanel.add(kindDonor);
        donorPanel.add(userType);

        // Details Panel
        Panel detailsPanel = new Panel(new GridLayout(4, 1, 5, 5));
        detailsPanel.setBackground(new Color(232, 232, 208));

        Label name = new Label("Name     :  " + user.getName(), Label.CENTER);
        Label email = new Label("Email    :  " + user.getEmail(), Label.CENTER);
        Label role = new Label("Role     :  " + user.getRole(), Label.CENTER);
        Label address = new Label("Address  :  " + user.getAddress(), Label.CENTER);

        name.setFont(new Font("Arial", Font.PLAIN, 16));
        email.setFont(new Font("Arial", Font.PLAIN, 16));
        role.setFont(new Font("Arial", Font.PLAIN, 16));
        address.setFont(new Font("Arial", Font.PLAIN, 16));

        detailsPanel.add(name);
        detailsPanel.add(email);
        detailsPanel.add(role);
        detailsPanel.add(address);

        centerPanel.add(donorPanel);
        centerPanel.add(detailsPanel);

        profileFrame.add(centerPanel, BorderLayout.CENTER);

        Panel bottomPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        backButton = new Button("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 15));
        backButton.setBackground(new Color(245, 220, 145));
        backButton.setForeground(new Color(32, 82, 55));
        bottomPanel.add(backButton);

        profileFrame.add(bottomPanel, BorderLayout.SOUTH);
        profileFrame.setLocationRelativeTo(null);
        profileFrame.setVisible(true);
    }
}
