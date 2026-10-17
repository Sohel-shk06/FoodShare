package com.foodshare.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 100% Pure Java AWT Modal Dialog (Zero Swing)
 */
public class MessageDialog extends Dialog implements ActionListener {

    private Button okButton;

    public MessageDialog(Frame parent, String title, String message) {
        super(parent, title, true);
        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(255, 250, 230));

        Label msgLabel = new Label(message, Label.CENTER);
        msgLabel.setFont(new Font("Arial", Font.BOLD, 14));
        msgLabel.setForeground(new Color(0, 100, 60));
        add(msgLabel, BorderLayout.CENTER);

        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 12));
        okButton = new Button("OK");
        okButton.setFont(new Font("Arial", Font.BOLD, 14));
        okButton.setBackground(new Color(0, 110, 70));
        okButton.setForeground(Color.WHITE);
        okButton.setPreferredSize(new Dimension(80, 32));
        okButton.addActionListener(this);
        buttonPanel.add(okButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(400, 160);
        setLocationRelativeTo(parent);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            dispose();
        }
    }
}
