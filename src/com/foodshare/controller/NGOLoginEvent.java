package com.foodshare.controller;

import java.awt.event.*;
import com.foodshare.service.AuthService;
import com.foodshare.view.*;

public class NGOLoginEvent implements ActionListener, MouseListener {

    private NGOLoginGUI gui;
    private AuthService authService = new AuthService();

    public NGOLoginEvent(NGOLoginGUI gui) {
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

            boolean ok = authService.loginNgo(email, password);
            if (ok) {
                if (ok) {
                    FSdashboardUI dashboard = new FSdashboardUI();
                    dashboard.createUI();
                    new FSdashboardEvents(dashboard);
                    gui.dispose();
                }
            } else {
                new MessageDialog(gui, "Login Failed",
                        "Invalid NGO credentials. Please register first.");
            }
        } else if (e.getSource() == gui.back) {
            gui.dispose();
            new WelcomeGUI();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == gui.registerText) {
            gui.dispose();
            new NGORegistrationGUI();
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
