package com.foodshare.model;

/**
 * Session state holding the currently logged-in user details
 */
public class UserSession {

    private static UserSession instance;

    private String name;
    private String email;
    private String role; // "Donor" or "NGO"
    private String address;
    private String mobile;

    private UserSession() {
        // Defaults to initial Kind Donor
        this.name = "Mahek Bhatt";
        this.email = "mahekbhatt502@gmail.com";
        this.role = "Donor";
        this.address = "Central District, City";
        this.mobile = "9876543210";
    }

    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUser(String name, String email, String role, String address, String mobile) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.address = address;
        this.mobile = mobile;
    }

    public void clear() {
        this.name = "Guest User";
        this.email = "";
        this.role = "Guest";
        this.address = "";
        this.mobile = "";
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getAddress() { return address; }
    public String getMobile() { return mobile; }
}
