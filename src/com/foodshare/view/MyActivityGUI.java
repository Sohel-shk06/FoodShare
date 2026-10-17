package com.foodshare.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import com.foodshare.controller.MyActivityEvent;
import com.foodshare.dao.ActivityDAO;
import com.foodshare.model.ActivityPOJO;
import com.foodshare.model.UserSession;

/**
 * Full Pure Java AWT Screen displaying User Activities & Logs
 */
public class MyActivityGUI extends Frame {

    public java.awt.List activityList;
    public Button closeButton;

    public MyActivityGUI() {
        setTitle("FoodShare - My Activity Logs");
        setSize(650, 450);
        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(250, 247, 235));

        Label header = new Label("MY AUDIT LOGS & REDISTRIBUTION ACTIVITY", Label.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        header.setForeground(new Color(32, 82, 55));
        add(header, BorderLayout.NORTH);

        activityList = new java.awt.List(12);
        activityList.setFont(new Font("Monospaced", Font.PLAIN, 13));

        ActivityDAO dao = new ActivityDAO();
        List<ActivityPOJO> list = dao.getRecentActivities(UserSession.getInstance().getEmail());
        for (ActivityPOJO act : list) {
            activityList.add("[" + act.getActionType() + "] " + act.getDescription() + (act.getTimestamp() == null ? "" : " | " + act.getTimestamp()));
        }
        add(activityList, BorderLayout.CENTER);

        Panel bottom = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        closeButton = new Button("Close Window");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        bottom.add(closeButton);
        add(bottom, BorderLayout.SOUTH);

        MyActivityEvent event = new MyActivityEvent(this);
        closeButton.addActionListener(event);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
