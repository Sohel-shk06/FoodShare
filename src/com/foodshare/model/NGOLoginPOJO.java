package com.foodshare.model;

/**
 * POJO for NGO Login credentials
 */
public class NGOLoginPOJO {
    private String email;
    private String password;

    public NGOLoginPOJO() {}

    public NGOLoginPOJO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }
}
