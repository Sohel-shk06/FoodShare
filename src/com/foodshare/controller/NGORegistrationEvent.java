package com.foodshare.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.foodshare.dao.NgoDAO;
import com.foodshare.model.NGORegistrationPOJO;
import com.foodshare.view.*;

public class NGORegistrationEvent implements ActionListener {

    private NGORegistrationGUI gui;
    private NgoDAO ngoDAO = new NgoDAO();

    public NGORegistrationEvent(NGORegistrationGUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.register) {
            String orgName = gui.organizationName.getText().trim();
            String email = gui.email.getText().trim();
            String mobile = gui.mobile.getText().trim();
            String address = gui.address.getText().trim();
            String password = gui.password.getText();
            String confirm = gui.confirmPassword.getText();

            if (orgName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                new MessageDialog(gui, "Incomplete Form", "Please fill in all organization details.");
                return;
            }
            if (!password.equals(confirm)) {
                new MessageDialog(gui, "Password Mismatch", "Passwords do not match.");
                return;
            }

            NGORegistrationPOJO ngo = new NGORegistrationPOJO();
            ngo.setOrganizationName(orgName);
            ngo.setEmail(email);
            ngo.setMobile(mobile);
            ngo.setAddress(address);
            ngo.setPassword(password);

            boolean ok = ngoDAO.registerNgo(ngo);
            if (ok) {
                new MessageDialog(gui, "Success", "NGO registered in database! You may now login.");
                gui.dispose();
                new NGOLoginGUI();
            } else {
                new MessageDialog(gui, "Database Error", "Registration failed. Email might already exist.");
            }
        }
    }
}
