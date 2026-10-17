package com.foodshare.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.foodshare.controller.DonorLoginEvent;

public class DonorLoginGUI extends Frame {

    public TextField email;
    public TextField password;
    public Button login;
    public Button back;
    public Label registerText;

    public DonorLoginGUI() {
        setTitle("FoodShare - Donor Login");
        setSize(700, 500);
        setLayout(null);
        setBackground(new Color(255, 250, 230));

        Label title = new Label("FoodShare", Label.CENTER);
        title.setBounds(200, 50, 300, 45);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(new Color(0, 100, 60));
        add(title);

        Label heading = new Label("Donor Login", Label.CENTER);
        heading.setBounds(200, 110, 300, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        add(heading);

        Label emailLabel = new Label("Email / Mobile:");
        emailLabel.setBounds(170, 180, 150, 30);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(emailLabel);

        email = new TextField();
        email.setBounds(330, 180, 220, 30);
        add(email);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setBounds(170, 230, 150, 30);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(passwordLabel);

        password = new TextField();
        password.setBounds(330, 230, 220, 30);
        password.setEchoChar('*');
        add(password);

        login = new Button("Login");
        login.setBounds(220, 300, 260, 45);
        login.setFont(new Font("Arial", Font.BOLD, 18));
        login.setBackground(new Color(0, 110, 70));
        login.setForeground(Color.WHITE);
        add(login);

        registerText = new Label("Don't have an account? Register here", Label.CENTER);
        registerText.setBounds(200, 355, 300, 30);
        registerText.setFont(new Font("Arial", Font.PLAIN, 14));
        registerText.setForeground(new Color(0, 100, 160));
        registerText.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(registerText);

        back = new Button("Back");
        back.setBounds(285, 400, 130, 40);
        back.setFont(new Font("Arial", Font.BOLD, 16));
        add(back);

        DonorLoginEvent event = new DonorLoginEvent(this);
        login.addActionListener(event);
        registerText.addMouseListener(event);
        back.addActionListener(event);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
