package com.foodshare.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.foodshare.controller.NGORegistrationEvent;

public class NGORegistrationGUI extends Frame {

    public TextField organizationName, email, mobile, address, password, confirmPassword;
    public Button register;

    public NGORegistrationGUI() {
        setTitle("FoodShare - NGO Registration");
        setSize(700, 500);
        setLayout(null);
        setBackground(new Color(255, 250, 230));

        Label title = new Label("FoodShare", Label.CENTER);
        title.setBounds(200, 30, 300, 40);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new Color(0, 100, 60));
        add(title);

        Label heading = new Label("NGO Registration", Label.CENTER);
        heading.setBounds(200, 75, 300, 35);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        add(heading);

        String[] labels = {"Organization Name:", "Email:", "Mobile Number:", "Address:", "Password:", "Confirm Password:"};
        TextField[] fields = new TextField[6];
        for (int i = 0; i < 6; i++) {
            Label lbl = new Label(labels[i]);
            lbl.setBounds(150, 125 + (i * 40), 150, 25);
            add(lbl);
            fields[i] = new TextField();
            fields[i].setBounds(310, 125 + (i * 40), 240, 25);
            if (i >= 4) fields[i].setEchoChar('*');
            add(fields[i]);
        }
        organizationName = fields[0]; email = fields[1]; mobile = fields[2]; address = fields[3]; password = fields[4]; confirmPassword = fields[5];

        register = new Button("Register");
        register.setBounds(250, 385, 200, 45);
        register.setFont(new Font("Arial", Font.BOLD, 18));
        register.setBackground(new Color(255, 110, 20));
        register.setForeground(Color.WHITE);
        add(register);

        NGORegistrationEvent event = new NGORegistrationEvent(this);
        register.addActionListener(event);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
