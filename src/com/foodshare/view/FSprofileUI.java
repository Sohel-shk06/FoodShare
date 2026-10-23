package com.foodshare.view;

import java.awt.*;
import com.foodshare.model.UserSession;

public class FSprofileUI {

    // =========================================
    // FRAME AND BUTTON DECLARATIONS
    // =========================================

    public Frame profileFrame;
    public Button backButton;

    // =========================================
    // CREATE PROFILE UI
    // =========================================

    public void createProfileUI() {

        // MAIN FRAME
        profileFrame = new Frame("FoodShare - My Profile");
        profileFrame.setSize(600, 500);
        profileFrame.setBackground(new Color(250, 248, 235));
        profileFrame.setLayout(new BorderLayout());

        UserSession user = UserSession.getInstance();

        // =========================================
        // TITLE SECTION
        // =========================================

        Label title = new Label("MY PROFILE", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(new Color(32, 82, 55));

        Panel titlePanel = new Panel(new BorderLayout());
        titlePanel.setBackground(new Color(250, 248, 235));
        titlePanel.add(title, BorderLayout.CENTER);

        profileFrame.add(titlePanel, BorderLayout.NORTH);

        // =========================================
        // CENTER PANEL
        // =========================================

        Panel centerPanel = new Panel(new GridLayout(2, 1, 0, 0));

        // =========================================
        // TOP SECTION: YOU AND USER TYPE
        // =========================================

        Panel donorPanel = new Panel(new GridLayout(3, 1, 5, 5));
        donorPanel.setBackground(new Color(250, 248, 235));

        // YOU label with yellow background
        Label youLabel = new Label("YOU", Label.CENTER);
        youLabel.setFont(new Font("Arial", Font.BOLD, 20));
        youLabel.setForeground(new Color(32, 82, 55));
        youLabel.setBackground(new Color(245, 220, 145));

        // Donor or NGO label
        String role = user.getRole() == null ? "" : user.getRole();

        Label kindLabel = new Label(
            role.equalsIgnoreCase("NGO") ? "VERIFIED NGO" : "KIND DONOR",
            Label.CENTER
        );
        kindLabel.setFont(new Font("Arial", Font.BOLD, 20));
        kindLabel.setForeground(new Color(32, 82, 55));

        // FoodShare User label
        Label userType = new Label("FoodShare User", Label.CENTER);
        userType.setFont(new Font("Arial", Font.PLAIN, 16));
        userType.setForeground(Color.BLACK);

        donorPanel.add(youLabel);
        donorPanel.add(kindLabel);
        donorPanel.add(userType);

        // =========================================
        // USER DETAILS SECTION
        // =========================================

        Panel detailsPanel = new Panel(new GridLayout(4, 1, 5, 5));
        detailsPanel.setBackground(new Color(232, 232, 208));

        Label name = new Label(
            "Name : " + safeText(user.getName()),
            Label.CENTER
        );

        Label email = new Label(
            "Email : " + safeText(user.getEmail()),
            Label.CENTER
        );

        Label roleLabel = new Label(
            "Role : " + safeText(user.getRole()),
            Label.CENTER
        );

        Label address = new Label(
            "Address : " + safeText(user.getAddress()),
            Label.CENTER
        );

        Font detailsFont = new Font("Arial", Font.PLAIN, 16);

        name.setFont(detailsFont);
        email.setFont(detailsFont);
        roleLabel.setFont(detailsFont);
        address.setFont(detailsFont);

        detailsPanel.add(name);
        detailsPanel.add(email);
        detailsPanel.add(roleLabel);
        detailsPanel.add(address);

        // Add both sections to the center
        centerPanel.add(donorPanel);
        centerPanel.add(detailsPanel);

        profileFrame.add(centerPanel, BorderLayout.CENTER);

        // =========================================
        // BOTTOM SECTION: BACK BUTTON
        // =========================================

        Panel bottomPanel = new Panel(
            new FlowLayout(FlowLayout.CENTER, 20, 10)
        );
        bottomPanel.setBackground(new Color(250, 248, 235));

        backButton = new Button("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 15));
        backButton.setBackground(new Color(245, 220, 145));
        backButton.setForeground(new Color(32, 82, 55));

        bottomPanel.add(backButton);

        profileFrame.add(bottomPanel, BorderLayout.SOUTH);

        // =========================================
        // DISPLAY PROFILE WINDOW
        // =========================================

        profileFrame.setLocationRelativeTo(null);
        profileFrame.setVisible(true);
    }

    // =========================================
    // HANDLE NULL VALUES SAFELY
    // =========================================

    private String safeText(String value) {
        return value == null || value.trim().isEmpty()
            ? "Not provided"
            : value;
    }
}