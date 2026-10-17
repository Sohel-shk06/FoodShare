package com.foodshare.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.foodshare.service.DonationService;
import com.foodshare.view.DonateFoodGUI;
import com.foodshare.view.MessageDialog;

/**
 * Controller for DonateFoodGUI
 */
public class DonateFoodEvent implements ActionListener {

    private DonateFoodGUI gui;
    private DonationService service = new DonationService();

    public DonateFoodEvent(DonateFoodGUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.submitButton) {
            String title = gui.titleField.getText().trim();
            String category = gui.categoryChoice.getSelectedItem();
            String portionsStr = gui.portionsField.getText().trim();
            String expiryStr = gui.expiryField.getText().trim();
            String address = gui.addressField.getText().trim();
            String dietary = gui.dietaryField.getText().trim();

            if (title.isEmpty() || portionsStr.isEmpty()) {
                new MessageDialog(gui, "Validation Error", "Food title and portions are required.");
                return;
            }

            int portions = 10;
            int expiryHours = 6;
            try {
                portions = Integer.parseInt(portionsStr);
                expiryHours = Integer.parseInt(expiryStr);
            } catch (NumberFormatException ex) {
                new MessageDialog(gui, "Invalid Number", "Portions and hours must be valid integers.");
                return;
            }

            boolean ok = service.createDonation(title, category, portions, address, expiryHours, dietary);
            if (ok) {
                new MessageDialog(gui, "Success", "Donation recorded in DB! Available for NGOs to claim.");
                gui.dispose();
            } else {
                new MessageDialog(gui, "Database Error", "Failed to insert donation into database.");
            }
        } else if (e.getSource() == gui.cancelButton) {
            gui.dispose();
        }
    }
}
