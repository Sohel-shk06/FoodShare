package com.foodshare.view;

import java.awt.*;
import com.foodshare.dao.DonationDAO;
import com.foodshare.model.UserSession;

public class FSdashboardUI {

    public Frame frame;
    public Button donateFood, availableFood, myActivity, profile, logout, logoButton;
    public Label donationsLabel, mealsLabel, peopleLabel;

    public void createUI() {
        frame = new Frame("FoodShare - " + ("NGO".equalsIgnoreCase(UserSession.getInstance().getRole()) ? "NGO Dashboard" : "Donor Dashboard"));
        frame.setSize(1000, 650);
        frame.setBackground(new Color(250, 247, 235));
        frame.setLayout(new BorderLayout());

        UserSession session = UserSession.getInstance();
        DonationDAO dao = new DonationDAO();
        int[] stats = dao.getImpactStats();

        // HEADER
        Panel headerPanel = new Panel(new BorderLayout(25, 5));
        headerPanel.setBackground(new Color(32, 82, 55));
        headerPanel.setPreferredSize(new Dimension(0, 80));

        Label title = new Label("  FOODSHARE");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.WHITE);

        Panel welcomePanel = new Panel(new GridLayout(2, 1));
        welcomePanel.setBackground(new Color(32, 82, 55));

        Label welcome = new Label("Welcome, " + session.getName() + " (" + session.getRole() + ")!");
        welcome.setFont(new Font("Arial", Font.BOLD, 22));
        welcome.setForeground(new Color(245, 220, 145));

        Label message = new Label("Together we can eliminate food waste via database tracking.");
        message.setFont(new Font("Arial", Font.PLAIN, 15));
        message.setForeground(Color.WHITE);

        welcomePanel.add(welcome);
        welcomePanel.add(message);

        Panel rightHeader = new Panel(new FlowLayout(FlowLayout.RIGHT, 12, 20));
        rightHeader.setBackground(new Color(32, 82, 55));

        logout = new Button("Logout");
        logout.setFont(new Font("Arial", Font.BOLD, 12));
        logout.setBackground(new Color(245, 224, 208));
        logout.setForeground(new Color(100, 55, 40));

        logoButton = new Button("FS");
        logoButton.setFont(new Font("Arial", Font.BOLD, 18));
        logoButton.setBackground(new Color(245, 220, 145));
        logoButton.setForeground(new Color(32, 82, 55));

        rightHeader.add(logout);
        rightHeader.add(logoButton);

        headerPanel.add(title, BorderLayout.WEST);
        headerPanel.add(welcomePanel, BorderLayout.CENTER);
        headerPanel.add(rightHeader, BorderLayout.EAST);

        // MAIN CONTENT
        Panel mainPanel = new Panel(new BorderLayout(25, 10));
        mainPanel.setBackground(new Color(250, 247, 235));

        // LEFT SECTION (Impact + Contact)
        Panel leftPanel = new Panel(new BorderLayout(10, 15));
        leftPanel.setBackground(new Color(250, 247, 235));
        leftPanel.setPreferredSize(new Dimension(270, 0));

        // IMPACT PANEL (Live Database Counters)
        Panel impactPanel = new Panel(new GridLayout(4, 1, 5, 5));
        impactPanel.setBackground(new Color(232, 232, 208));

        Label impactTitle = new Label("LIVE DB IMPACT", Label.CENTER);
        impactTitle.setFont(new Font("Arial", Font.BOLD, 17));
        impactTitle.setForeground(new Color(32, 82, 55));

        donationsLabel = new Label(stats[0] + " Active Donations", Label.CENTER);
        mealsLabel = new Label(stats[1] + " Meals Shared", Label.CENTER);
        peopleLabel = new Label(stats[2] + " People Fed", Label.CENTER);

        impactPanel.add(impactTitle);
        impactPanel.add(donationsLabel);
        impactPanel.add(mealsLabel);
        impactPanel.add(peopleLabel);

        leftPanel.add(impactPanel, BorderLayout.CENTER);

        // CONTACT PANEL
        Panel contactPanel = new Panel(new GridLayout(3, 1, 2, 2));
        contactPanel.setBackground(new Color(245, 224, 208));
        contactPanel.setPreferredSize(new Dimension(270, 95));

        Label contactTitle = new Label("Contact & DB Info", Label.CENTER);
        contactTitle.setFont(new Font("Arial", Font.BOLD, 15));
        contactTitle.setForeground(new Color(110, 70, 50));

        Label foodShareEmail = new Label("foodshare@gmail.com", Label.CENTER);
        Label mahekEmail = new Label("mahekbhatt502@gmail.com", Label.CENTER);

        contactPanel.add(contactTitle);
        contactPanel.add(foodShareEmail);
        contactPanel.add(mahekEmail);

        leftPanel.add(contactPanel, BorderLayout.SOUTH);

        // ACTION BUTTONS GRID (2x2)
        Panel buttonHolder = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 5));
        buttonHolder.setBackground(new Color(250, 247, 235));

        Panel buttonPanel = new Panel(new GridLayout(2, 2, 18, 18));
        buttonPanel.setBackground(new Color(250, 247, 235));
        buttonPanel.setPreferredSize(new Dimension(600, 410));

        donateFood = new Button("Donate Food (DB Entry)");
        donateFood.setFont(new Font("Arial", Font.BOLD, 17));
        donateFood.setBackground(new Color(220, 235, 215));
        donateFood.setForeground(new Color(32, 82, 55));

        availableFood = new Button("Available Food (Live Feed)");
        availableFood.setFont(new Font("Arial", Font.BOLD, 17));
        availableFood.setBackground(new Color(248, 218, 200));
        availableFood.setForeground(new Color(110, 60, 40));

        myActivity = new Button("My Activity (Audit Log)");
        myActivity.setFont(new Font("Arial", Font.BOLD, 17));
        myActivity.setBackground(new Color(245, 220, 145));
        myActivity.setForeground(new Color(80, 65, 25));

        profile = new Button("Profile (DB Record)");
        profile.setFont(new Font("Arial", Font.BOLD, 17));
        profile.setBackground(new Color(200, 205, 155));
        profile.setForeground(new Color(55, 70, 35));

        if ("NGO".equalsIgnoreCase(session.getRole())) {
            donateFood.setLabel("My Claimed Pickups");
            availableFood.setLabel("Browse & Claim Food");
            buttonPanel.add(availableFood);
            buttonPanel.add(donateFood);
            buttonPanel.add(myActivity);
            buttonPanel.add(profile);
        } else {
            availableFood.setLabel("Browse Available Food");
            buttonPanel.add(donateFood);
            buttonPanel.add(myActivity);
            buttonPanel.add(profile);
            buttonPanel.add(availableFood);
        }

        buttonHolder.add(buttonPanel);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(buttonHolder, BorderLayout.CENTER);

        Panel dashboardPanel = new Panel(new BorderLayout(15, 15));
        dashboardPanel.setBackground(new Color(250, 247, 235));
        dashboardPanel.setPreferredSize(new Dimension(930, 560));

        dashboardPanel.add(headerPanel, BorderLayout.NORTH);
        dashboardPanel.add(mainPanel, BorderLayout.CENTER);

        Panel outerPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 25, 25));
        outerPanel.setBackground(new Color(250, 247, 235));
        outerPanel.add(dashboardPanel);

        frame.add(outerPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
