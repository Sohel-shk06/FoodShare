package com.foodshare.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import com.foodshare.controller.AvailableFoodEvent;
import com.foodshare.dao.DonationDAO;
import com.foodshare.model.DonationPOJO;
import com.foodshare.model.UserSession;

/**
 * Full Pure Java AWT Screen displaying Live Available Donations from DB
 */
public class AvailableFoodGUI extends Frame {

    public List<DonationPOJO> donations;
    public java.awt.List foodList;
    public Button claimButton;
    public Button refreshButton;
    public Button closeButton;
    public Label detailsLabel;

    public AvailableFoodGUI() {
        setTitle("FoodShare - Live Available Food (Database Feed)");
        setSize(750, 520);
        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(250, 247, 235));

        // Header
        Label header = new Label("AVAILABLE FOOD FEED (REAL-TIME DATABASE)", Label.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setForeground(new Color(32, 82, 55));
        add(header, BorderLayout.NORTH);

        // Center Panel: List + Details
        Panel centerPanel = new Panel(new GridLayout(1, 2, 10, 10));

        foodList = new java.awt.List(10, false);
        foodList.setFont(new Font("Monospaced", Font.PLAIN, 13));
        centerPanel.add(foodList);

        Panel detailPanel = new Panel(new BorderLayout(10, 10));
        detailPanel.setBackground(new Color(232, 232, 208));

        Label detailTitle = new Label("Donation Details", Label.CENTER);
        detailTitle.setFont(new Font("Arial", Font.BOLD, 16));
        detailPanel.add(detailTitle, BorderLayout.NORTH);

        detailsLabel = new Label("Select an item from the list to view pickup details.");
        detailsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detailPanel.add(detailsLabel, BorderLayout.CENTER);

        centerPanel.add(detailPanel);
        add(centerPanel, BorderLayout.CENTER);

        // South Actions
        Panel actionPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 12));

        claimButton = new Button("Claim Selected Food for NGO");
        claimButton.setFont(new Font("Arial", Font.BOLD, 15));
        claimButton.setBackground(new Color(255, 110, 20));
        claimButton.setForeground(Color.WHITE);
        if (!"NGO".equalsIgnoreCase(UserSession.getInstance().getRole())) {
            claimButton.setEnabled(false);
            claimButton.setLabel("NGO Login Required to Claim");
        }

        refreshButton = new Button("Refresh DB");
        refreshButton.setFont(new Font("Arial", Font.BOLD, 14));

        closeButton = new Button("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));

        actionPanel.add(claimButton);
        actionPanel.add(refreshButton);
        actionPanel.add(closeButton);
        add(actionPanel, BorderLayout.SOUTH);

        AvailableFoodEvent event = new AvailableFoodEvent(this);
        claimButton.addActionListener(event);
        refreshButton.addActionListener(event);
        closeButton.addActionListener(event);
        foodList.addItemListener(event);

        loadDonations();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void loadDonations() {
        foodList.removeAll();
        DonationDAO dao = new DonationDAO();
        donations = dao.getAvailableDonations();
        for (DonationPOJO d : donations) {
            foodList.add(d.getPortions() + "x " + d.getTitle() + " [" + d.getCategory() + "]");
        }
        if (donations.isEmpty()) {
            foodList.add("(No available donations at this moment)");
        }
    }
}
