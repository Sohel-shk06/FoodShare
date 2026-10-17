package com.foodshare;
import com.foodshare.database.DBConnection;
import com.foodshare.view.WelcomeGUI;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
public class Main {
 public static void main(String[] args) {
  System.out.println("FoodShare - Supabase PostgreSQL edition");
  try { DBConnection.initializeDatabase(); System.out.println("[DB] Connected to Supabase; schema verified."); }
  catch(Exception e) {
   System.err.println("[DB ERROR] "+e.getMessage());
   System.err.println("Set SUPABASE_JDBC_URL, SUPABASE_DB_USER and SUPABASE_DB_PASSWORD, then restart.");
   JOptionPane.showMessageDialog(null,"Could not connect to Supabase. Check the SUPABASE_JDBC_URL, SUPABASE_DB_USER and SUPABASE_DB_PASSWORD environment variables and internet access.\n\n"+e.getMessage(),"FoodShare Database Connection Error",JOptionPane.ERROR_MESSAGE);
   return;
  }
  EventQueue.invokeLater(WelcomeGUI::new);
 }
}
