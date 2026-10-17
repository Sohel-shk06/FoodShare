package com.foodshare.model;

/**
 * POJO for Donor Login credentials
 */
public class DonorLoginPOJO {
    private String email;
    private String password;

    public DonorLoginPOJO() {}

    public DonorLoginPOJO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }
}
