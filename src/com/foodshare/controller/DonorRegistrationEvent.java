package com.foodshare.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.foodshare.dao.DonorDAO;
import com.foodshare.model.DonorRegistrationPOJO;
import com.foodshare.view.*;

public class DonorRegistrationEvent implements ActionListener {

    private DonorRegistrationGUI gui;
    private DonorDAO donorDAO = new DonorDAO();

    public DonorRegistrationEvent(DonorRegistrationGUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.register) {
            String name = gui.name.getText().trim();
            String email = gui.email.getText().trim();
            String mobile = gui.mobile.getText().trim();
            String address = gui.address.getText().trim();
            String password = gui.password.getText();
            String confirm = gui.confirmPassword.getText();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                new MessageDialog(gui, "Incomplete Form", "Please fill in all required fields.");
                return;
            }
            if (!password.equals(confirm)) {
                new MessageDialog(gui, "Password Mismatch", "Password and Confirm Password must match.");
                return;
            }

            DonorRegistrationPOJO donor = new DonorRegistrationPOJO();
            donor.setName(name);
            donor.setEmail(email);
            donor.setMobile(mobile);
            donor.setAddress(address);
            donor.setPassword(password);

            boolean ok = donorDAO.registerDonor(donor);
            if (ok) {
                new MessageDialog(gui, "Success", "Donor registered in database! You may now login.");
                gui.dispose();
                new DonorLoginGUI();
            } else {
                new MessageDialog(gui, "Database Error", "Registration failed. Email might already exist.");
            }
        }
    }
}
