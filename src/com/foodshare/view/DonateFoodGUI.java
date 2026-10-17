package com.foodshare.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.foodshare.controller.DonateFoodEvent;
import com.foodshare.model.UserSession;

/**
 * Full Pure Java AWT Screen to Submit Food Donations
 */
public class DonateFoodGUI extends Frame {

    public TextField titleField;
    public Choice categoryChoice;
    public TextField portionsField;
    public TextField expiryField;
    public TextField addressField;
    public TextField dietaryField;
    public Button submitButton;
    public Button cancelButton;

    public DonateFoodGUI() {
        setTitle("FoodShare - Post Food Donation (DB Insert)");
        setSize(650, 520);
        setLayout(null);
        setBackground(new Color(255, 250, 230));

        Label heading = new Label("POST SURPLUS FOOD DONATION", Label.CENTER);
        heading.setBounds(100, 40, 450, 35);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setForeground(new Color(0, 100, 60));
        add(heading);

        // Food Title
        Label titleLbl = new Label("Food Item Name:");
        titleLbl.setBounds(90, 95, 160, 25);
        add(titleLbl);
        titleField = new TextField("Fresh Vegetable Biryani & Raita");
        titleField.setBounds(260, 95, 290, 25);
        add(titleField);

        // Category Choice
        Label catLbl = new Label("Category:");
        catLbl.setBounds(90, 140, 160, 25);
        add(catLbl);
        categoryChoice = new Choice();
        categoryChoice.add("Cooked Meals");
        categoryChoice.add("Bakery & Bread");
        categoryChoice.add("Fresh Produce");
        categoryChoice.add("Packaged Foods");
        categoryChoice.setBounds(260, 140, 290, 25);
        add(categoryChoice);

        // Portions
        Label portLbl = new Label("Portions / Quantity:");
        portLbl.setBounds(90, 185, 160, 25);
        add(portLbl);
        portionsField = new TextField("25");
        portionsField.setBounds(260, 185, 290, 25);
        add(portionsField);

        // Expiry Hours
        Label expLbl = new Label("Safe Within (Hours):");
        expLbl.setBounds(90, 230, 160, 25);
        add(expLbl);
        expiryField = new TextField("5");
        expiryField.setBounds(260, 230, 290, 25);
        add(expiryField);

        // Pickup Address
        Label addrLbl = new Label("Pickup Address:");
        addrLbl.setBounds(90, 275, 160, 25);
        add(addrLbl);
        addressField = new TextField(UserSession.getInstance().getAddress());
        addressField.setBounds(260, 275, 290, 25);
        add(addressField);

        // Dietary
        Label dietLbl = new Label("Dietary Notes:");
        dietLbl.setBounds(90, 320, 160, 25);
        add(dietLbl);
        dietaryField = new TextField("Vegetarian, Freshly Made");
        dietaryField.setBounds(260, 320, 290, 25);
        add(dietaryField);

        // Buttons
        submitButton = new Button("Submit to Database");
        submitButton.setBounds(180, 390, 180, 45);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(new Color(0, 110, 70));
        submitButton.setForeground(Color.WHITE);
        add(submitButton);

        cancelButton = new Button("Cancel");
        cancelButton.setBounds(380, 390, 110, 45);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 15));
        add(cancelButton);

        DonateFoodEvent event = new DonateFoodEvent(this);
        submitButton.addActionListener(event);
        cancelButton.addActionListener(event);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
