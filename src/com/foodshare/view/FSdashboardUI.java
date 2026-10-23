package com.foodshare.view;

import java.awt.*;

import com.foodshare.dao.DonationDAO;
import com.foodshare.model.UserSession;

import com.foodshare.controller.FSdashboardEvents;




public class FSdashboardUI {

    // =========================================
    // FRAME
    // =========================================

   
  public Frame frame;


    // =========================================
    // BUTTON DECLARATIONS
    // =========================================


public Button donateFood;
public Button availableFood;
public Button myActivity;
public Button profile;
public Button logout;
public Button logoButton;


    public static void main(String[] args) {

        FSdashboardUI ui = new FSdashboardUI();

        ui.createUI();

        new FSdashboardEvents(ui);

        // Show frame after registering events
        ui.frame.setVisible(true);
    }


    // =========================================
    // HELPER METHOD: CREATE LABEL
    // =========================================

    public Label createLabel(
            String text,
            int fontStyle,
            int fontSize,
            Color foreground,
            int alignment) {

        Label label = new Label(text, alignment);

        label.setFont(
                new Font("Arial", fontStyle, fontSize)
        );

        label.setForeground(foreground);

        return label;
    }


    // =========================================
    // HELPER METHOD: CREATE BUTTON
    // =========================================

    public Button createButton(
            String text,
            int fontSize,
            Color background,
            Color foreground) {

        Button button = new Button(text);

        button.setFont(
                new Font("Arial", Font.BOLD, fontSize)
        );

        button.setBackground(background);
        button.setForeground(foreground);

        return button;
    }


    // =========================================
    // CREATE UI
    // =========================================

    public void createUI() {

        // =========================================
        // MAIN FRAME
        // =========================================

        frame = new Frame("FoodShare Dashboard");

        frame.setSize(1000, 650);

        frame.setBackground(
                new Color(250, 247, 235)
        );

        frame.setLayout(
                new BorderLayout()
        );


        // =========================================
        // HEADER (panel)
        // =========================================

        Panel headerPanel = new Panel();

        headerPanel.setBackground(
                new Color(32, 82, 55)
        );

        headerPanel.setLayout(
                new BorderLayout(25, 5)
        );

        headerPanel.setPreferredSize(
                new Dimension(0, 80)
        );


        // =========================================
        // FOODSHARE TITLE
        // =========================================

        Label title = createLabel(
                "FOODSHARE",
                Font.BOLD,
                25,
                Color.WHITE,
                Label.LEFT
        );


        // =========================================
        // WELCOME SECTION
        // =========================================

        Panel welcomePanel = new Panel();

        welcomePanel.setBackground(
                new Color(32, 82, 55)
        );

        welcomePanel.setLayout(
                new GridLayout(2, 1)
        );


        //welcome user---> 1st row

        Label welcome = createLabel(
                "Welcome, User!",
                Font.BOLD,
                26,
                new Color(245, 220, 145),
                Label.LEFT
        );


        //together we can reduce food waste ----> 2nd row

        Label message = createLabel(
                "Together we can reduce food waste.",
                Font.PLAIN,
                16,
                Color.WHITE,
                Label.LEFT
        );


        // putting the rows' label content in its place

        welcomePanel.add(welcome);
        welcomePanel.add(message);


        // =========================================
        // RIGHT HEADER SECTION (right controls --> logout,FS)
        // =========================================

        Panel rightHeader = new Panel();

        rightHeader.setBackground(
                new Color(32, 82, 55)
        );

        rightHeader.setLayout(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        10,
                        20
                )
        );


        // LOGOUT BUTTON

        logout = createButton(
                "Logout",
                12,
                new Color(240, 210, 190),
                new Color(100, 45, 30)
        );


        // LOGO PLACEHOLDER

        logoButton = createButton(
                "FS",
                20,
                new Color(240, 211, 132),
                new Color(32, 82, 55)
        );


        rightHeader.add(logout);
        rightHeader.add(logoButton);


        // ADD HEADER COMPONENTS

        headerPanel.add(
                title,
                BorderLayout.WEST
        );

        headerPanel.add(
                welcomePanel,
                BorderLayout.CENTER
        );

        headerPanel.add(
                rightHeader,
                BorderLayout.EAST
        );


        // --------------------------------------------------
        // --------------------------------------------------


        // =========================================
        // MAIN CONTENT
        // =========================================

        Panel mainPanel = new Panel();

        mainPanel.setBackground(
                new Color(250, 247, 235)
        );

        mainPanel.setLayout(
                new BorderLayout(25, 10)
        );


        // =========================================
        // LEFT SECTION
        // =========================================

        Panel leftPanel = new Panel();

        leftPanel.setBackground(
                new Color(250, 247, 235)
        );

        leftPanel.setLayout(
                new BorderLayout(10, 15)
        );

        leftPanel.setPreferredSize(
                new Dimension(270, 0)
        );


        // =========================================
        // FOODSHARE IMPACT
        // =========================================

        Panel impactPanel = new Panel();

        impactPanel.setBackground(
                new Color(232, 232, 208)
        );

        impactPanel.setLayout(
                new GridLayout(
                        4,
                        1,
                        5,
                        5
                )
        );


        // creating labels

        Label impactTitle = createLabel(
                "FOODSHARE IMPACT",
                Font.BOLD,
                17,
                new Color(32, 82, 55),
                Label.CENTER
        );


        Label donations = createLabel(
                "12 Donations",
                Font.BOLD,
                15,
                new Color(55, 65, 50),
                Label.CENTER
        );


        Label meals = createLabel(
                "38 Meals Shared",
                Font.BOLD,
                15,
                new Color(55, 65, 50),
                Label.CENTER
        );


        Label people = createLabel(
                "7 People Helped",
                Font.BOLD,
                15,
                new Color(55, 65, 50),
                Label.CENTER
        );


        impactPanel.add(impactTitle);
        impactPanel.add(donations);
        impactPanel.add(meals);
        impactPanel.add(people);


        leftPanel.add(
                impactPanel,
                BorderLayout.CENTER
        );


        // =========================================
        // CONTACT PANEL
        // =========================================

        Panel contactPanel = new Panel();

        contactPanel.setBackground(
                new Color(240, 205, 183)
        );

        contactPanel.setLayout(
                new GridLayout(
                        3,
                        1,
                        2,
                        2
                )
        );

        contactPanel.setPreferredSize(
                new Dimension(270, 95)
        );


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


        leftPanel.add(
                contactPanel,
                BorderLayout.SOUTH
        );


        // -------------------------------------------------------------------
        // -------------------------------------------------------------------


        // =========================================
        // BUTTON HOLDER
        // =========================================

        Panel buttonHolder = new Panel();

        buttonHolder.setBackground(
                new Color(250, 247, 235)
        );

        buttonHolder.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        0,
                        5
                )
        );


        // =========================================
        // BUTTON GRID
        // =========================================

        Panel buttonPanel = new Panel();

        buttonPanel.setBackground(
                new Color(250, 247, 235)
        );

        buttonPanel.setLayout(
                new GridLayout(
                        2,
                        2,
                        18,
                        18
                )
        );

        buttonPanel.setPreferredSize(
                new Dimension(600, 410)
        );


        // =========================================
        // DONATE FOOD
        // =========================================

        donateFood = createButton(
                "Donate Food",
                18,
                new Color(177, 204, 176),
                new Color(32, 75, 48)
        );


        // =========================================
        // AVAILABLE FOOD
        // =========================================

        availableFood = createButton(
                "Available Food",
                18,
                new Color(232, 184, 155),
                new Color(100, 48, 30)
        );


        // =========================================
        // MY ACTIVITY
        // =========================================

        myActivity = createButton(
                "My Activity",
                18,
                new Color(231, 198, 110),
                new Color(75, 53, 15)
        );


        // =========================================
        // PROFILE
        // =========================================

        profile = createButton(
                "Profile",
                18,
                new Color(184, 196, 143),
                new Color(38, 59, 32)
        );


        // ADD BUTTONS

        buttonPanel.add(donateFood);
        buttonPanel.add(availableFood);
        buttonPanel.add(myActivity);
        buttonPanel.add(profile);


        buttonHolder.add(buttonPanel);


        // -------------------------------------------------------------------
        // -------------------------------------------------------------------


        // =========================================
        // ADD MAIN SECTIONS
        // =========================================

        mainPanel.add(
                leftPanel,
                BorderLayout.WEST
        );

        mainPanel.add(
                buttonHolder,
                BorderLayout.CENTER
        );


        // =========================================
        // DASHBOARD PANEL
        // =========================================

        Panel dashboardPanel = new Panel();

        dashboardPanel.setBackground(
                new Color(250, 247, 235)
        );

        dashboardPanel.setLayout(
                new BorderLayout(15, 15)
        );

        dashboardPanel.setPreferredSize(
                new Dimension(930, 560)
        );


        dashboardPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        dashboardPanel.add(
                mainPanel,
                BorderLayout.CENTER
        );


        // =========================================
        // OUTER SPACE
        // =========================================

        Panel outerPanel = new Panel();

        outerPanel.setBackground(
                new Color(250, 247, 235)
        );

        outerPanel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        25,
                        25
                )
        );

        outerPanel.add(
                dashboardPanel
        );


        frame.add(
                outerPanel,
                BorderLayout.CENTER
        );


        // =========================================
        // SHOW FRAME
        // =========================================

        // The frame is displayed in main() after
        // FSdashboardEvents has registered listeners.
         frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}