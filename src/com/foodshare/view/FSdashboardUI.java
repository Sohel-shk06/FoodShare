
package com.foodshare.view;

import java.awt.*;
import com.foodshare.dao.DonationDAO;
import com.foodshare.model.UserSession;

public class FSdashboardUI {

    // ================= FRAME =================

    public Frame frame;

    // ================= BUTTONS =================

    public Button donateFood;
    public Button availableFood;
    public Button myActivity;
    public Button profile;
    public Button logout;
    public Button logoButton;

    // ================= IMPACT LABELS =================

    public Label donationsLabel;
    public Label mealsLabel;
    public Label peopleLabel;

    // ================= HELPER: CREATE LABEL =================

    public Label createLabel(
            String text,
            int fontStyle,
            int fontSize,
            Color foreground,
            int alignment) {

        Label label = new Label(text, alignment);
        label.setFont(new Font("Arial", fontStyle, fontSize));
        label.setForeground(foreground);

        return label;
    }

    // ================= HELPER: CREATE BUTTON =================

    public Button createButton(
            String text,
            int fontSize,
            Color background,
            Color foreground) {

        Button button = new Button(text);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));
        button.setBackground(background);
        button.setForeground(foreground);

        return button;
    }

    // ================= CREATE UI =================

    public void createUI() {

        UserSession session = UserSession.getInstance();

        String userRole = session.getRole();
        boolean isNGO = "NGO".equalsIgnoreCase(userRole);

        // ================= MAIN FRAME =================

        frame = new Frame(
            "FoodShare - " +
            (isNGO ? "NGO Dashboard" : "Donor Dashboard")
        );

        frame.setSize(1000, 650);
        frame.setBackground(new Color(250, 247, 235));
        frame.setLayout(new BorderLayout());

        // Fetch live database statistics
        DonationDAO dao = new DonationDAO();
        int[] stats = dao.getImpactStats();

        // ================= HEADER =================

        Panel headerPanel = new Panel(
            new BorderLayout(25, 5)
        );

        headerPanel.setBackground(new Color(32, 82, 55));
        headerPanel.setPreferredSize(new Dimension(0, 80));

        Label title = createLabel(
            "FOODSHARE",
            Font.BOLD,
            25,
            Color.WHITE,
            Label.LEFT
        );

        // ================= WELCOME SECTION =================

        Panel welcomePanel = new Panel(
            new GridLayout(2, 1)
        );

        welcomePanel.setBackground(new Color(32, 82, 55));

        Label welcome = createLabel(
            "Welcome, " + session.getName() + " (" + userRole + ")!",
            Font.BOLD,
            22,
            new Color(245, 220, 145),
            Label.LEFT
        );

        Label message = createLabel(
            "Together we can reduce food waste.",
            Font.PLAIN,
            15,
            Color.WHITE,
            Label.LEFT
        );

        welcomePanel.add(welcome);
        welcomePanel.add(message);

        // ================= RIGHT HEADER =================

        Panel rightHeader = new Panel(
            new FlowLayout(FlowLayout.RIGHT, 12, 20)
        );

        rightHeader.setBackground(new Color(32, 82, 55));

        logout = createButton(
            "Logout",
            12,
            new Color(240, 210, 190),
            new Color(100, 45, 30)
        );

        logoButton = createButton(
            "FS",
            18,
            new Color(245, 220, 145),
            new Color(32, 82, 55)
        );

        rightHeader.add(logout);
        rightHeader.add(logoButton);

        headerPanel.add(title, BorderLayout.WEST);
        headerPanel.add(welcomePanel, BorderLayout.CENTER);
        headerPanel.add(rightHeader, BorderLayout.EAST);

        // ================= MAIN CONTENT =================

        Panel mainPanel = new Panel(
            new BorderLayout(25, 10)
        );

        mainPanel.setBackground(new Color(250, 247, 235));

        // ================= LEFT SECTION =================

        Panel leftPanel = new Panel(
            new BorderLayout(10, 15)
        );

        leftPanel.setBackground(new Color(250, 247, 235));
        leftPanel.setPreferredSize(new Dimension(270, 0));

        // ================= IMPACT PANEL =================

        Panel impactPanel = new Panel(
            new GridLayout(4, 1, 5, 5)
        );

        impactPanel.setBackground(new Color(232, 232, 208));

        Label impactTitle = createLabel(
            "LIVE DB IMPACT",
            Font.BOLD,
            17,
            new Color(32, 82, 55),
            Label.CENTER
        );

        donationsLabel = createLabel(
            stats[0] + " Active Donations",
            Font.BOLD,
            15,
            new Color(55, 65, 50),
            Label.CENTER
        );

        mealsLabel = createLabel(
            stats[1] + " Meals Shared",
            Font.BOLD,
            15,
            new Color(55, 65, 50),
            Label.CENTER
        );

        peopleLabel = createLabel(
            stats[2] + " People Fed",
            Font.BOLD,
            15,
            new Color(55, 65, 50),
            Label.CENTER
        );

        impactPanel.add(impactTitle);
        impactPanel.add(donationsLabel);
        impactPanel.add(mealsLabel);
        impactPanel.add(peopleLabel);

        leftPanel.add(impactPanel, BorderLayout.CENTER);

        // ================= CONTACT PANEL =================

        Panel contactPanel = new Panel(
            new GridLayout(3, 1, 2, 2)
        );

        contactPanel.setBackground(new Color(245, 224, 208));
        contactPanel.setPreferredSize(new Dimension(270, 95));

        Label contactTitle = createLabel(
            "Contact Us",
            Font.BOLD,
            15,
            new Color(110, 55, 35),
            Label.CENTER
        );

        Label foodShareEmail = createLabel(
            "foodshare@gmail.com",
            Font.PLAIN,
            13,
            new Color(55, 45, 40),
            Label.CENTER
        );

        Label mahekEmail = createLabel(
            "mahekbhatt502@gmail.com",
            Font.PLAIN,
            13,
            new Color(55, 45, 40),
            Label.CENTER
        );

        contactPanel.add(contactTitle);
        contactPanel.add(foodShareEmail);
        contactPanel.add(mahekEmail);

        leftPanel.add(contactPanel, BorderLayout.SOUTH);

        // ================= ACTION BUTTONS =================

        Panel buttonHolder = new Panel(
            new FlowLayout(FlowLayout.CENTER, 0, 5)
        );

        buttonHolder.setBackground(new Color(250, 247, 235));

        Panel buttonPanel = new Panel(
            new GridLayout(2, 2, 18, 18)
        );

        buttonPanel.setBackground(new Color(250, 247, 235));
        buttonPanel.setPreferredSize(new Dimension(600, 410));

        // Donate / NGO Pickups
        donateFood = createButton(
            isNGO ? "My Claimed Pickups" : "Donate Food (DB Entry)",
            17,
            new Color(220, 235, 215),
            new Color(32, 82, 55)
        );

        // Browse / Claim Food
        availableFood = createButton(
            isNGO ? "Browse & Claim Food" : "Browse Available Food",
            17,
            new Color(248, 218, 200),
            new Color(110, 60, 40)
        );

        myActivity = createButton(
            "My Activity (Audit Log)",
            17,
            new Color(245, 220, 145),
            new Color(80, 65, 25)
        );

        profile = createButton(
            "Profile (DB Record)",
            17,
            new Color(200, 205, 155),
            new Color(55, 70, 35)
        );

        // Preserve role-specific button order
        if (isNGO) {
            buttonPanel.add(availableFood);
            buttonPanel.add(donateFood);
            buttonPanel.add(myActivity);
            buttonPanel.add(profile);
        } else {
            buttonPanel.add(donateFood);
            buttonPanel.add(myActivity);
            buttonPanel.add(profile);
            buttonPanel.add(availableFood);
        }

        buttonHolder.add(buttonPanel);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(buttonHolder, BorderLayout.CENTER);

        // ================= DASHBOARD PANEL =================

        Panel dashboardPanel = new Panel(
            new BorderLayout(15, 15)
        );

        dashboardPanel.setBackground(new Color(250, 247, 235));
        dashboardPanel.setPreferredSize(new Dimension(930, 560));

        dashboardPanel.add(headerPanel, BorderLayout.NORTH);
        dashboardPanel.add(mainPanel, BorderLayout.CENTER);

        // ================= OUTER PANEL =================

        Panel outerPanel = new Panel(
            new FlowLayout(FlowLayout.CENTER, 25, 25)
        );

        outerPanel.setBackground(new Color(250, 247, 235));
        outerPanel.add(dashboardPanel);

        frame.add(outerPanel, BorderLayout.CENTER);

        // ================= SHOW FRAME =================

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
