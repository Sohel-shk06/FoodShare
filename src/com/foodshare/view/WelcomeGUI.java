package com.foodshare.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import com.foodshare.controller.WelcomeEvent;

public class WelcomeGUI extends Frame {

    public Button donor;
    public Button ngo;

    public WelcomeGUI() {
        setTitle("FoodShare");
        setSize(700, 500);
        setLayout(null);
        setBackground(new Color(255, 250, 230));

        String logoPath = "resources/food_logo.png";
        if (!new File(logoPath).exists()) logoPath = "food_logo.png";
        Image logo = Toolkit.getDefaultToolkit().getImage(logoPath);
        Canvas canvas = new Canvas() {
            public void paint(Graphics g) {
                if (logo != null) g.drawImage(logo, 0, 0, 100, 70, this);
            }
        };
        canvas.setBounds(290, 50, 100, 70);
        add(canvas);

        Label title = new Label("FoodShare", Label.CENTER);
        title.setBounds(190, 125, 300, 45);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(new Color(0, 100, 60));
        add(title);

        Label tagline = new Label("Share Food, Share Smiles", Label.CENTER);
        tagline.setBounds(190, 170, 300, 30);
        tagline.setFont(new Font("Arial", Font.PLAIN, 18));
        tagline.setForeground(new Color(0, 100, 60));
        add(tagline);

        donor = new Button("Donor");
        donor.setBounds(190, 230, 300, 50);
        donor.setFont(new Font("Arial", Font.BOLD, 20));
        donor.setBackground(new Color(0, 110, 70));
        donor.setForeground(Color.WHITE);
        add(donor);

        ngo = new Button("NGO");
        ngo.setBounds(190, 310, 300, 50);
        ngo.setFont(new Font("Arial", Font.BOLD, 20));
        ngo.setBackground(new Color(255, 110, 20));
        ngo.setForeground(Color.WHITE);
        add(ngo);

        WelcomeEvent event = new WelcomeEvent(this);
        donor.addActionListener(event);
        ngo.addActionListener(event);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
