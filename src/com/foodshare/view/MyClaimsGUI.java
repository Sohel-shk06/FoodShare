package com.foodshare.view;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import com.foodshare.dao.DonationDAO;
import com.foodshare.model.DonationPOJO;
import com.foodshare.model.UserSession;

/** Shows claimed donations belonging only to the currently signed-in NGO. */
public class MyClaimsGUI extends Frame {
    public MyClaimsGUI() {
        super("FoodShare - My Claimed Pickups");
        setSize(760, 460); setLayout(new BorderLayout(12,12)); setBackground(new Color(250,247,235));
        Label title=new Label("MY CLAIMED FOOD PICKUPS",Label.CENTER); title.setFont(new Font("Arial",Font.BOLD,20)); title.setForeground(new Color(32,82,55)); add(title,BorderLayout.NORTH);
        java.awt.List rows=new java.awt.List(14); rows.setFont(new Font("Monospaced",Font.PLAIN,13));
        List<DonationPOJO> claims=new DonationDAO().getClaimsForNgo(UserSession.getInstance().getEmail());
        for(DonationPOJO d:claims) rows.add(d.getPortions()+"x "+d.getTitle()+" | Donor: "+d.getDonorName()+" | Pickup: "+d.getPickupAddress());
        if(claims.isEmpty()) rows.add("No claimed pickups yet."); add(rows,BorderLayout.CENTER);
        Button close=new Button("Close"); Panel bottom=new Panel(); bottom.add(close); add(bottom,BorderLayout.SOUTH); close.addActionListener(e->dispose());
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){dispose();}}); setLocationRelativeTo(null); setVisible(true);
    }
}
