package com.foodshare.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import com.foodshare.model.DonationPOJO;
import com.foodshare.service.DonationService;
import com.foodshare.view.AvailableFoodGUI;
import com.foodshare.view.MessageDialog;

/**
 * Controller for AvailableFoodGUI
 */
public class AvailableFoodEvent implements ActionListener, ItemListener {

    private AvailableFoodGUI gui;
    private DonationService service = new DonationService();

    public AvailableFoodEvent(AvailableFoodGUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.claimButton) {
            int selectedIndex = gui.foodList.getSelectedIndex();
            if (selectedIndex < 0 || selectedIndex >= gui.donations.size()) {
                new MessageDialog(gui, "No Selection", "Please select a food donation item from the list.");
                return;
            }

            DonationPOJO selected = gui.donations.get(selectedIndex);
            boolean ok = service.claimFoodItem(selected.getId(), selected.getTitle());
            if (ok) {
                new MessageDialog(gui, "Pickup Confirmed", "You claimed: " + selected.getTitle() + "! Pick up at: " + selected.getPickupAddress());
                gui.loadDonations();
            } else {
                new MessageDialog(gui, "Claim Error", "Could not claim this item.");
            }
        } else if (e.getSource() == gui.refreshButton) {
            gui.loadDonations();
            new MessageDialog(gui, "Refreshed", "Donation list reloaded from the database.");
        } else if (e.getSource() == gui.closeButton) {
            gui.dispose();
        }
    }

    public void itemStateChanged(ItemEvent e) {
        int idx = gui.foodList.getSelectedIndex();
        if (idx >= 0 && idx < gui.donations.size()) {
            DonationPOJO d = gui.donations.get(idx);
            gui.detailsLabel.setText("Item: " + d.getTitle() + " | Portions: " + d.getPortions() + " | Donor: " + d.getDonorName() + " | Pickup: " + d.getPickupAddress());
        }
    }
}
