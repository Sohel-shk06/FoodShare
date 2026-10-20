
package com.foodshare.view;

import java.awt.*;
import com.foodshare.model.UserSession;

public class FSprofileUI {

    public Frame profileFrame;
    public Button backButton;

    public void createProfileUI() {

        // Main Frame
        profileFrame = new Frame("FoodShare - My Profile");
        profileFrame.setSize(600, 500);
        profileFrame.setBackground(new Color(250, 248, 235));
        profileFrame.setLayout(new BorderLayout(15, 15));

        // Get logged-in user details
        UserSession user = UserSession.getInstance();

        // ================= TITLE =================

        Label title = new Label("MY PROFILE", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(new Color(32, 82, 55));

        profileFrame.add(title, BorderLayout.NORTH);

        // ================= CENTER PANEL =================

        Panel centerPanel = new Panel(
            new GridLayout(2, 1, 10, 10)
        );

        // ================= DONOR SECTION =================

        Panel donorPanel = new Panel(
            new GridLayout(3, 1, 5, 5)
        );

        donorPanel.setBackground(new Color(250, 248, 235));

        // User Badge
        Label sym = new Label("YOU", Label.CENTER);
        sym.setFont(new Font("Arial", Font.BOLD, 20));
        sym.setForeground(new Color(32, 82, 55));
        sym.setBackground(new Color(245, 220, 145));

        // Role-based Badge
        Label kindDonor = new Label(
            user.getRole().equalsIgnoreCase("NGO")
                ? "VERIFIED NGO"
                : "KIND DONOR",
            Label.CENTER
        );

        kindDonor.setFont(new Font("Arial", Font.BOLD, 20));
        kindDonor.setForeground(new Color(32, 82, 55));

        // User Type
        Label userType = new Label(
            "FoodShare User",
            Label.CENTER
        );

        userType.setFont(new Font("Arial", Font.PLAIN, 15));

        donorPanel.add(sym);
        donorPanel.add(kindDonor);
        donorPanel.add(userType);

        // ================= USER DETAILS =================

        Panel detailsPanel = new Panel(
            new GridLayout(4, 1, 5, 5)
        );

        detailsPanel.setBackground(new Color(232, 232, 208));

        Label name = new Label(
            "Name : " + user.getName(),
            Label.CENTER
        );

        Label email = new Label(
            "Email : " + user.getEmail(),
            Label.CENTER
        );

        Label role = new Label(
            "Role : " + user.getRole(),
            Label.CENTER
        );

        Label address = new Label(
            "Address : " + user.getAddress(),
            Label.CENTER
        );

        Font detailsFont = new Font(
            "Arial",
            Font.PLAIN,
            16
        );

        name.setFont(detailsFont);
        email.setFont(detailsFont);
        role.setFont(detailsFont);
        address.setFont(detailsFont);

        detailsPanel.add(name);
        detailsPanel.add(email);
        detailsPanel.add(role);
        detailsPanel.add(address);

        // Add sections to center
        centerPanel.add(donorPanel);
        centerPanel.add(detailsPanel);

        profileFrame.add(centerPanel, BorderLayout.CENTER);

        // ================= BACK BUTTON =================

        Panel bottomPanel = new Panel(
            new FlowLayout(FlowLayout.CENTER, 20, 10)
        );

        backButton = new Button("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 15));
        backButton.setBackground(new Color(231, 198, 110));
        backButton.setForeground(new Color(32, 82, 55));

        bottomPanel.add(backButton);

        profileFrame.add(bottomPanel, BorderLayout.SOUTH);

        // ================= SHOW FRAME =================

        profileFrame.setLocationRelativeTo(null);
        profileFrame.setVisible(true);
    }
}
