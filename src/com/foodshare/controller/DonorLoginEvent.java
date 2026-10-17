package com.foodshare.controller;

import java.awt.event.*;
import com.foodshare.service.AuthService;
import com.foodshare.view.*;

public class DonorLoginEvent implements ActionListener, MouseListener {

    private DonorLoginGUI gui;
    private AuthService authService = new AuthService();

    public DonorLoginEvent(DonorLoginGUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.login) {
            String email = gui.email.getText().trim();
            String password = gui.password.getText();

            if (email.isEmpty() || password.isEmpty()) {
                new MessageDialog(gui, "Missing Details", "Please enter your email/mobile and password.");
                return;
            }

            boolean authenticated = authService.loginDonor(email, password);
            if (authenticated) {
                gui.dispose();
                FSdashboardUI dashboard = new FSdashboardUI();
                dashboard.createUI();
                new FSdashboardEvents(dashboard);
            } else {
                new MessageDialog(gui, "Login Failed", "Invalid donor credentials. Please register or re-check.");
            }
        } else if (e.getSource() == gui.back) {
            gui.dispose();
            new WelcomeGUI();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == gui.registerText) {
            gui.dispose();
            new DonorRegistrationGUI();
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
